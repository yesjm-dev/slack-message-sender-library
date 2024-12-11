package com.yesjm.slackmessagesender;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElement;

public class Section {

    private Section(Builder builder) {
        String text = builder.text;
        BlockElement accessory = builder.accessory;
    }

    public static class Builder {
        private String text;
        private BlockElement accessory;

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder button(String buttonUrl, String buttonText) {
            this.accessory = new ButtonBlock(buttonUrl, buttonText).toButtonElement();
            return this;
        }

        public Builder image(String imageUrl, String altText) {
            this.accessory = new ImageBlock(imageUrl, altText).toImageElement();
            return this;
        }

        public SectionBlock build() {
            return Blocks.section(it ->
                    it.text(BlockCompositions.markdownText(this.text))
                            .accessory(this.accessory)
            );
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}