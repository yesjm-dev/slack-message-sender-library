package com.yesjm.slackmessagesender;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElement;

/**
 * Section builder class for creating Slack message sections.
 *
 * <p>Features:</p>
 * <ul>
 *     <li>Supports text, buttons, and images as section components.</li>
 *     <li>Includes validation for URLs and other inputs.</li>
 * </ul>
 *
 * <p>Usage:</p>
 * <pre>
 * Section section = Section.builder()
 *     .text("Hello Slack!")
 *     .button("https://example.com", "Click Me")
 *     //.image("https://example.com/image.png", "Example Image")
 *     .build();
 * </pre>
 */
public class Section {
    private String text;
    private BlockElement accessory;

    private Section(String text, BlockElement accessory) {
        this.text = text;
        this.accessory = accessory;
    }

    public String getText() {
        return text;
    }

    public BlockElement getAccessory() {
        return accessory;
    }

    public static class Builder {
        private String text;
        private BlockElement accessory;

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        /**
         * @param buttonUrl  the URL to navigate to when the button is clicked.
         *                   Must be a valid URL.
         * @param buttonText the text to display on the button.
         */
        public Builder button(String buttonUrl, String buttonText) {
            if (this.accessory != null) {
                throw new IllegalStateException("Accessory already added. Only one accessory is allowed per section.");
            }
            this.accessory = new ButtonBlock(buttonUrl, buttonText).toButtonElement();
            return this;
        }

        /**
         * @param imageUrl the URL of the image to display.
         *                 Must be a valid URL.
         * @param altText  the alternative text to display when the image cannot be loaded.
         */
        public Builder image(String imageUrl, String altText) {
            if (this.accessory != null) {
                throw new IllegalStateException("Accessory already added. Only one accessory is allowed per section.");
            }
            this.accessory = new ImageBlock(imageUrl, altText).toImageElement();
            return this;
        }

        public Section build() {
            if (this.text == null || this.text.isEmpty()) {
                throw new IllegalArgumentException("Text must be set before building the section.");
            }
            return new Section(this.text, this.accessory);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public SectionBlock toSectionBlock() {
        return Blocks.section(it ->
                it.text(BlockCompositions.markdownText(this.text))
                        .accessory(this.accessory)
        );
    }
}