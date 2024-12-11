package com.yesjm.slackmessagesender;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.composition.BlockCompositions;

public class TextSection {

    public static class Builder {
        private String text;

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public SectionBlock build() {
            return Blocks.section(it ->
                    it.text(BlockCompositions.markdownText(this.text))
            );
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}