package com.yesjm.slackmessagesender;

import com.yesjm.slackmessagesender.adapter.SlackClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class SlackClientTest {

    @Test
    void testPostToSlack() {
        Mockito.mockStatic(SlackClient.class);

        doNothing().when(SlackClient.class);
        SlackClient.postToSlack(anyString(), anyString());

        SlackMessageSender sender = new SlackMessageSender() {
            protected String createPayload() {
                return new SlackPayloadBuilder()
                        .addComponent(new TextSection("Hello Slack!"))
                        .build();
            }
        };

        sender.sendMessage("https://hooks.slack.com/services/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");

        verify(SlackClient.class);
        SlackClient.postToSlack(anyString(), anyString());
    }
}