package com.yesjm.slackmessagesender;

import com.slack.api.model.block.element.BlockElements;
import com.slack.api.model.block.element.ImageElement;

public class ImageBlock {
    public static ImageElement createImageBlock(String imageUrl, String text) {
        return BlockElements.image(i -> i
                .imageUrl(imageUrl)
                .altText(text)
        );
    }
}
