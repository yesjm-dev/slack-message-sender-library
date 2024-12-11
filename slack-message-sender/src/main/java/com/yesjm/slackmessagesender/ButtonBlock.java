package com.yesjm.slackmessagesender;

import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElements;
import com.slack.api.model.block.element.ButtonElement;

public class ButtonBlock {
    public static ButtonElement createButtonBlock(String buttonUrl, String text) {
        return BlockElements.button(i -> i
                .url(buttonUrl)
                .text(BlockCompositions.plainText(text))
                .actionId("button")
        );
    }
}
