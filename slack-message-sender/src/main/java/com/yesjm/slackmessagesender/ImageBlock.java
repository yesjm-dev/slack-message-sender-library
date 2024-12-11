package com.yesjm.slackmessagesender;

import com.slack.api.model.block.element.BlockElements;
import com.slack.api.model.block.element.ImageElement;

public class ImageBlock {
    private final String imageUrl;
    private final String altText;

    public ImageBlock(String imageUrl, String altText) {
        this.imageUrl = imageUrl;
        this.altText = altText;
    }

    public ImageElement toImageElement() {
        return BlockElements.image(i -> i
                .imageUrl(imageUrl)
                .altText(altText));
    }
}