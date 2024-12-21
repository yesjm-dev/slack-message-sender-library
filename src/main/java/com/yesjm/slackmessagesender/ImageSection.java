package com.yesjm.slackmessagesender;

public class ImageSection implements SlackSectionComponent {
    private final String text;
    private final String imageUrl;
    private final String altText;


    public ImageSection(String text, String imageUrl, String altText) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("text cannot be null or empty");
        }
        if (imageUrl == null || imageUrl.isEmpty()) {
            throw new IllegalArgumentException("imageUrl cannot be null or empty");
        }
        if (altText == null || altText.isEmpty()) {
            throw new IllegalArgumentException("altText cannot be null or empty");
        }
        this.text = text;
        this.imageUrl = imageUrl;
        this.altText = altText;
    }

    @Override
    public String build() {
        return "{" +
                "\"type\":\"section\"," +
                "\"text\":{" +
                "\"type\":\"mrkdwn\"," +
                "\"text\":\"" + text + "\"" +
                "}," +
                "\"accessory\":{" +
                "\"type\":\"image\"," +
                "\"image_url\":\"" + imageUrl + "\"," +
                "\"alt_text\":\"" + altText + "\"}" +
                "}";
    }
}
