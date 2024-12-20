package com.yesjm.slackmessagesender;

import com.slack.api.model.block.SectionBlock;
import com.slack.api.webhook.Payload;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SlackPayloadTest {

    @Test
    void 섹션을_하나_추가하면_블록에_하나의_섹션이_추가된다() {
        // given
        SlackPayload.Builder builder = SlackPayload.builder();
        SectionBlock section = Section.builder()
                .text("text")
                .build();

        // when
        builder.addSection(section);
        SlackPayload slackPayload = builder.build();
        Payload payload = slackPayload.toPayload();

        // then
        assertNotNull(payload);
        assertEquals(1, payload.getBlocks().size());
    }

    @Test
    void 여러_섹션을_추가하면_블록에_모든_섹션이_추가된다() {
        // given
        SlackPayload.Builder builder = SlackPayload.builder();
        SectionBlock section = Section.builder()
                .text("text")
                .build();

        // when
        builder.addSection(section);
        builder.addSection(section);
        builder.addSection(section);
        SlackPayload slackPayload = builder.build();
        Payload payload = slackPayload.toPayload();

        // then
        assertNotNull(payload);
        assertEquals(3, payload.getBlocks().size());
    }
}