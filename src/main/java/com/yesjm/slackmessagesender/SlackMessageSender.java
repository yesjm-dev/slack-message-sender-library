package com.yesjm.slackmessagesender;

import com.yesjm.slackmessagesender.adapter.SlackClient;

import java.net.URL;

abstract class SlackMessageSender {
    public final void sendMessage(String webhookUrl) {
        if (!isValidUrl(webhookUrl)) {
            throw new IllegalArgumentException("Invalid webhook URL");
        }
        String payload = createPayload();
        System.out.println("Sending payload: " + payload);
        SlackClient.postToSlack(webhookUrl, payload);
    }

    protected abstract String createPayload();

    private static boolean isValidUrl(String url) {
        try {
            new URL(url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}