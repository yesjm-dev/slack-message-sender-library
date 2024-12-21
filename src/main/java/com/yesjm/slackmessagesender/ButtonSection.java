package com.yesjm.slackmessagesender;

import java.net.URL;

public class ButtonSection implements SlackSectionComponent {
    private final String buttonUrl;
    private final String buttonText;
    private final String text;

    public ButtonSection(String text, String buttonUrl, String buttonText) {
        if (!isValidUrl(buttonUrl)) {
            throw new IllegalArgumentException("Invalid URL: " + buttonUrl);
        }
        if (buttonText == null || buttonText.isEmpty()) {
            throw new IllegalArgumentException("Button text cannot be null or empty");
        }
        this.text = text;
        this.buttonUrl = buttonUrl;
        this.buttonText = buttonText;
    }

    @Override
    public String build() {
        return "{" +
                "\"type\":\"section\"" +
                ",\"text\":{" +
                "\"type\":\"mrkdwn\"," +
                "\"text\":\"" + text + "\"" +
                "}," +
                "\"accessory\":{" +
                "\"type\":\"button\"" +
                ",\"text\":{" +
                "\"type\":\"plain_text\"," +
                "\"text\":\"" + buttonText + "\"}," +
                "\"url\":\"" + buttonUrl + "\"}" +
                "}";
    }

    private static boolean isValidUrl(String url) {
        try {
            new URL(url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
