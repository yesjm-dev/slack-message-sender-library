package com.yesjm.slackmessagesender;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class SlackServiceTest {

    private final Slack slack = mock(Slack.class);
    private final WebhookResponse webhookResponse = mock(WebhookResponse.class);
    private final SlackService slackService = new SlackService(slack);

    @Test
    void 슬랙메시지_전송_성공() throws Exception {
        // given
        String url = "https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX";
        Payload payload = mock(Payload.class);

        when(slack.send(eq(url), eq(payload))).thenReturn(webhookResponse);
        doReturn(200).when(webhookResponse).getCode();

        // when
        slackService.sendSlackMessage(url, payload);

        // then
        verify(slack, times(1)).send(eq(url), eq(payload));
        verify(webhookResponse, atLeastOnce()).getCode();
    }

    @Test
    void 슬랙메시지_전송_실패_응답코드_200이_아니면_RuntimeException() throws Exception {
        // given
        String url = "https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX";
        Payload payload = mock(Payload.class);

        when(slack.send(eq(url), eq(payload))).thenReturn(webhookResponse);
        when(webhookResponse.getCode()).thenReturn(500);
        when(webhookResponse.getBody()).thenReturn("Internal Server Error");

        // when & then
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> slackService.sendSlackMessage(url, payload)
        );
        assertEquals("Failed to send Slack message. Response code: 500, Body: Internal Server Error", exception.getMessage());
    }

    @Test
    void 슬랙메시지_전송_실패_IO_오류_발생하면_RuntimeException() throws Exception {
        // given
        String url = "https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX";
        Payload payload = mock(Payload.class);

        when(slack.send(eq(url), eq(payload))).thenThrow(new IOException("Network error"));

        // when & then
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> slackService.sendSlackMessage(url, payload)
        );
        assertEquals("Slack message failed due to an I/O error.", exception.getMessage());
    }
}
