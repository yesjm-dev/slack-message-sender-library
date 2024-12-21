package com.yesjm.slackmessagesender;

public class TextSection implements SlackSectionComponent {

    private final String text;

    public TextSection(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty");
        }
        this.text = text;
    }

    @Override
    public String build() {
        return "{" +
                "\"type\":\"section\"," +
                "\"text\":{" +
                "\"type\":\"mrkdwn\"," +
                "\"text\":\"" + text + "\"}" +
                "}";
    }
}
