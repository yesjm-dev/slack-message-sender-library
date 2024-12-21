package com.yesjm.slackmessagesender;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ImageSectionTest {
    @Test
    void ImageSection_정상적으로_생성된다() {
        // given
        String validImageUrl = "https://example.com/image.png";
        String altText = "Example Image";

        // when
        ImageSection imageSection = new ImageSection("text", validImageUrl, altText);

        // then
        assertNotNull(imageSection);
        System.out.println(imageSection.build());
    }

    @Test
    void imageUrl_NULL이면_IllegalArgumentException_발생한다() {
        // given
        String imageUrl = null;

        // when & then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ImageSection("text", imageUrl, "Example Image")
        );
        assertEquals("imageUrl cannot be null or empty", exception.getMessage());
    }

    @Test
    void altText_NULL이면_IllegalArgumentException_발생한다() {
        // given
        String validImageUrl = "https://example.com/image.png";

        // when & then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ImageSection("text", validImageUrl, null)
        );
        assertEquals("altText cannot be null or empty", exception.getMessage());
    }
}