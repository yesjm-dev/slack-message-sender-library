package com.yesjm.slackmessagesender;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.composition.BlockCompositions;

public class TextSection {
    public static SectionBlock createTextBlock(String text) {
        return Blocks.section(it ->
                it.text(BlockCompositions.markdownText(text))
        );
    }
}