package com.yesjm.slackmessagesender;

import com.slack.api.model.block.element.ButtonElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ButtonBlockTest {

    @Test
    void validButtonUrlShouldCreateButtonBlock() {
        // given
        String validUrl = "https://www.example.com";
        String buttonText = "Click Me";

        // when
        ButtonBlock buttonBlock = new ButtonBlock(validUrl, buttonText);

        // then
        assertNotNull(buttonBlock);
        assertEquals(validUrl, buttonBlock.toButtonElement().getUrl());
        assertEquals(buttonText, buttonBlock.toButtonElement().getText().getText());
    }

    @Test
    void invalidButtonUrlShouldThrowException() {
        // given
        String invalidUrl = "htp://invalid-url";
        String buttonText = "Invalid Button";

        // when & then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ButtonBlock(invalidUrl, buttonText)
        );
        assertEquals("Invalid URL provided: " + invalidUrl, exception.getMessage());
    }

    @Test
    void toButtonElementShouldReturnProperButtonElement() {
        // given
        String validUrl = "https://www.example.com";
        String buttonText = "Click Here";

        // when
        ButtonBlock buttonBlock = new ButtonBlock(validUrl, buttonText);
        ButtonElement buttonElement = buttonBlock.toButtonElement();

        // then
        assertNotNull(buttonElement);
        assertEquals(validUrl, buttonElement.getUrl());
        assertEquals("Click Here", buttonElement.getText().getText());
        assertEquals("button", buttonElement.getActionId());
    }
}