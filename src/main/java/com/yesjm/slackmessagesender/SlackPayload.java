package com.yesjm.slackmessagesender;

import com.slack.api.model.block.LayoutBlock;
import com.slack.api.webhook.Payload;

import java.util.ArrayList;
import java.util.List;

public class SlackPayload {
    private final List<LayoutBlock> blocks;

    private SlackPayload(List<LayoutBlock> blocks) {
        this.blocks = blocks;
    }

    public static Builder builder() {
        return new Builder();
    }

    Payload toPayload() {
        return Payload.builder()
                .blocks(blocks)
                .build();
    }

    public static class Builder {
        private final List<LayoutBlock> blocks = new ArrayList<>();

        public Builder addSection(LayoutBlock block) {
            if (block == null) {
                throw new IllegalArgumentException("LayoutBlock cannot be null");
            }
            blocks.add(block);
            return this;
        }

        public SlackPayload build() {
            return new SlackPayload(blocks);
        }
    }
}