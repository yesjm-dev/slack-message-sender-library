package com.yesjm.slackmessagesender;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlackPayloadBuilderTest {

    @Test
    void 페이로드에_ButtonUrl과_ButtonText가_포함되어_있다() {
        SlackPayloadBuilder builder = new SlackPayloadBuilder()
                .addComponent(new TextSection("Hello Slack!"))
                .addComponent(new ButtonSection("This is a button section", "https://example.com", "Click Me"));

        String payload = builder.build();

        assertTrue(payload.contains("\"text\":{\"type\":\"mrkdwn\",\"text\":\"Hello Slack!\"}"));
        assertTrue(payload.contains("\"type\":\"button\",\"text\":{\"type\":\"plain_text\",\"text\":\"Click Me\"}"));
        assertTrue(payload.contains("https://example.com"));
    }

    @Test
    void 페이로드에_ImageUrl과_AltText가_포함되어_있다() {
        SlackPayloadBuilder builder = new SlackPayloadBuilder()
                .addComponent(new TextSection("Image Section"))
                .addComponent(new ImageSection("This is a image section", "https://example.jpg", "cute cat"));

        String payload = builder.build();

        assertTrue(payload.contains("\"image_url\":\"https://example.jpg\""));
        assertTrue(payload.contains("\"alt_text\":\"cute cat\""));
    }
}