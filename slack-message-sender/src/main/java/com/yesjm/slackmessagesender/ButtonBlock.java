package com.yesjm.slackmessagesender;

import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElements;
import com.slack.api.model.block.element.ButtonElement;

public class ButtonBlock {
    private final String buttonUrl;
    private final String buttonText;

    public ButtonBlock(String buttonUrl, String buttonText) {
        this.buttonUrl = buttonUrl;
        this.buttonText = buttonText;
    }

    public ButtonElement toButtonElement() {
        return BlockElements.button(i -> i
                .url(buttonUrl)
                .text(BlockCompositions.plainText(buttonText))
                .actionId("button"));
    }
}