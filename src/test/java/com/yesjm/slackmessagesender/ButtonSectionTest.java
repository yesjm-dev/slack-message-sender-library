package com.yesjm.slackmessagesender;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ButtonSectionTest {

    @Test
    void ButtonSection_정상적으로_생성된다() {
        // given
        String text = "button section";
        String validUrl = "https://www.example.com";
        String buttonText = "Click Me";

        // when
        ButtonSection buttonSection = new ButtonSection(text, validUrl, buttonText);

        // then
        assertNotNull(buttonSection);
        System.out.println(buttonSection.build());
    }

    @Test
    void buttonUrl이_올바르지_않으면_IllegalArgumentException_발생한다() {
        // given
        String text = "button section";
        String invalidUrl = "htp://invalid-url";
        String buttonText = "Invalid Button";

        // when & then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ButtonSection(text, invalidUrl, buttonText)
        );
        assertEquals("Invalid URL: " + invalidUrl, exception.getMessage());
    }

    @Test
    void buttonText가_NULL이면_IllegalArgumentException_발생한다() {
        // given
        String text = "button section";
        String validUrl = "https://www.example.com";

        // when & then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ButtonSection(text, validUrl, null)
        );
        assertEquals("buttonText cannot be null or empty", exception.getMessage());
    }

}