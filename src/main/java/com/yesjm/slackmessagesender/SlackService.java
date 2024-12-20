package com.yesjm.slackmessagesender;

import com.slack.api.Slack;
import com.slack.api.webhook.WebhookResponse;
import java.io.IOException;

public class SlackService {

    private final Slack slack;

    public SlackService(Slack slack) {
        this.slack = slack;
    }

    public SlackService() {
        this.slack = Slack.getInstance();
    }

    /**
     * Sends a message to Slack using the provided webhook URL and payload.
     *
     * @param url     The Slack webhook URL.
     * @param slackPayload The payload containing the message to send.
     */
    public void sendSlackMessage(String url, SlackPayload slackPayload) {
        try {
            WebhookResponse response = slack.send(url, slackPayload.toPayload());

            if (response.getCode() != 200) {
                throw new RuntimeException("Failed to send Slack message. Response code: "
                        + response.getCode() + ", Body: " + response.getBody());
            } else {
                System.out.println("Message sent successfully. Response code: " + response.getCode());
            }
        } catch (IOException e) {
            throw new RuntimeException("Slack message failed due to an I/O error.", e);
        }
    }
}