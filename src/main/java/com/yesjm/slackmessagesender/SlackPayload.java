package com.yesjm.slackmessagesender;

import com.slack.api.model.block.LayoutBlock;
import com.slack.api.webhook.Payload;

import java.util.ArrayList;
import java.util.List;

public class SlackPayload {
    private List<LayoutBlock> blocks;

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

        public Builder addSection(Section section) {
            if (section == null) {
                throw new IllegalArgumentException("Section cannot be null");
            }
            blocks.add(section.toSectionBlock());
            return this;
        }

        public SlackPayload build() {
            return new SlackPayload(blocks);
        }
    }
}