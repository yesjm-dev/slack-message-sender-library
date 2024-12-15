package com.yesjm.slackmessagesender;

import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElements;
import com.slack.api.model.block.element.ButtonElement;

import java.net.URL;

public class ButtonBlock {
    private final String buttonUrl;
    private final String buttonText;

    public ButtonBlock(String buttonUrl, String buttonText) {
        if (!isValidUrl(buttonUrl)) {
            throw new IllegalArgumentException("Invalid URL provided: " + buttonUrl);
        }
        this.buttonUrl = buttonUrl;
        this.buttonText = buttonText;
    }

    public ButtonElement toButtonElement() {
        return BlockElements.button(i -> i
                .url(buttonUrl)
                .text(BlockCompositions.plainText(buttonText))
                .actionId("button"));
    }

    public static boolean isValidUrl(String url) {
        try {
            new URL(url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}