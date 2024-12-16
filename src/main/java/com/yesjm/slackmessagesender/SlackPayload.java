package com.yesjm.slackmessagesender;

import com.slack.api.model.block.LayoutBlock;
import com.slack.api.webhook.Payload;

import java.util.ArrayList;
import java.util.List;

public class SlackPayload {

    public static class Builder {
        private List<LayoutBlock> blocks;

        public Builder addSection(LayoutBlock block) {
            if (this.blocks == null) {
                this.blocks = new ArrayList<>();
            }
            this.blocks.add(block);
            return this;
        }

        public Payload build() {
            return Payload
                    .builder()
                    .blocks(blocks)
                    .build();

        }
    }

    public static Builder builder() {
        return new Builder();
    }
}