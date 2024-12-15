package com.yesjm.slackmessagesender;

import com.slack.api.model.block.SectionBlock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SectionTest {
    @Test
    void 텍스트_없이_빌드하면_IllegalArgumentException_발생한다() {
        // given
        Section.Builder builder = Section.builder();

        // when & then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                builder::build
        );
        assertEquals("Text must be set before building the section.", exception.getMessage());
    }

    @Test
    void 텍스트를_추가하면_정상적으로_빌드된다() {
        // given
        String text = "This is a section text.";

        // when
        SectionBlock section = Section.builder().text(text).build();

        // then
        assertNotNull(section);
        assertEquals(text, section.getText().getText());
    }

    @Test
    void 버튼을_추가하면_정상적으로_빌드된다() {
        // given
        String text = "text";
        String buttonUrl = "https://example.com";
        String buttonText = "Click Me";

        // when
        SectionBlock section = Section.builder()
                .text(text)
                .button(buttonUrl, buttonText)
                .build();

        // then
        assertNotNull(section);
        assertEquals(text, section.getText().getText());
        assertNotNull(section.getAccessory());
    }

    @Test
    void 이미지_추가시_정상적으로_빌드된다() {
        // given
        String text = "This is a section with an image.";
        String imageUrl = "https://example.com/image.png";
        String altText = "Example Image";

        // when
        SectionBlock section = Section.builder()
                .text(text)
                .image(imageUrl, altText)
                .build();

        // then
        assertNotNull(section);
        assertEquals(text, section.getText().getText());
        assertNotNull(section.getAccessory());
    }

    @Test
    void 버튼과_이미지를_동시에_추가하면_IllegalStateException_발생한다() {
        // given
        String text = "This is a section with both button and image.";
        String buttonUrl = "https://example.com";
        String buttonText = "Click Me";
        String imageUrl = "https://example.com/image.png";
        String altText = "Example Image";

        Section.Builder builder = Section.builder()
                .text(text)
                .button(buttonUrl, buttonText)
                ;

        // when & then
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> builder.image(imageUrl, altText)
        );
        assertEquals("Accessory already added. Only one accessory is allowed per section.", exception.getMessage());
    }

    @Test
    void 이미지를_추가하고_버튼을_추가하면_IllegalStateException_발생한다() {
        // given
        String text = "This is a section with image first, then button.";
        String buttonUrl = "https://example.com";
        String buttonText = "Click Me";
        String imageUrl = "https://example.com/image.png";
        String altText = "Example Image";

        Section.Builder builder = Section.builder()
                .text(text)
                .image(imageUrl, altText);

        // when & then
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> builder.button(buttonUrl, buttonText)
        );
        assertEquals("Accessory already added. Only one accessory is allowed per section.", exception.getMessage());
    }
}