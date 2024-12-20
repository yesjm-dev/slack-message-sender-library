package com.yesjm.sampleproject;

import com.yesjm.slackmessagesender.Section;
import com.yesjm.slackmessagesender.SlackPayload;
import com.yesjm.slackmessagesender.SlackService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleApplicationRunner implements ApplicationRunner {
    @Value("${slack.webhookUrl}")
    private String webhookUrl;

    SlackService slackService = new SlackService();

    @Override
    public void run(ApplicationArguments args) {
        SlackPayload payload = SlackPayload.builder()
                .addSection(Section.builder()
                        .text("\uD83D\uDE80 애플리케이션이 정상적으로 시작되었습니다! ")
                        .button("https://example.com", "자세히 보기")
                        .build()
                )
                .build();

        slackService.sendSlackMessage(webhookUrl, payload);
    }
}
