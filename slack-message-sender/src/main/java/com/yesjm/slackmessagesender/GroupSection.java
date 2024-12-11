package com.yesjm.slackmessagesender;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElement;

public class GroupSection {
    public static SectionBlock createSectionBlock(BlockElement block, String text) {

        return Blocks.section(it ->
                it.text(BlockCompositions.markdownText(text))
                        .accessory(block)
        );
    }
}
