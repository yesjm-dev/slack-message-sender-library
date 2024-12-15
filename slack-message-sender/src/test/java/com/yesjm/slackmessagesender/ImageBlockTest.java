package com.yesjm.slackmessagesender;

import com.slack.api.model.block.element.ImageElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ImageBlockTest {
    @Test
    void ImageBlock_정상적으로_생성된다() {
        // given
        String validImageUrl = "https://example.com/image.png";
        String altText = "Example Image";

        // when
        ImageBlock imageBlock = new ImageBlock(validImageUrl, altText);
        ImageElement imageElement = imageBlock.toImageElement();

        // then
        assertNotNull(imageElement);
        assertEquals(validImageUrl, imageElement.getImageUrl());
        assertEquals(altText, imageElement.getAltText());
    }

    @Test
    void imageUrl_NULL이면_IllegalArgumentException_발생한다() {
        // given
        String imageUrl = null;

        // when & then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ImageBlock(imageUrl, "Example Image")
        );
        assertEquals("imageUrl cannot be null", exception.getMessage());
    }

    @Test
    void altText_NULL이면_IllegalArgumentException_발생한다() {
        // given
        String validImageUrl = "https://example.com/image.png";

        // when & then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ImageBlock(validImageUrl, null)
        );
        assertEquals("altText cannot be null", exception.getMessage());
    }
}