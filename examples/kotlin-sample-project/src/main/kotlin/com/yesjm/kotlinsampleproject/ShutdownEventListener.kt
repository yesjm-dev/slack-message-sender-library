package com.yesjm.kotlinsampleproject

import com.yesjm.slackmessagesender.Section
import com.yesjm.slackmessagesender.SlackPayload
import com.yesjm.slackmessagesender.SlackService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextClosedEvent
import org.springframework.stereotype.Component

@Component
class ShutdownEventListener : ApplicationListener<ContextClosedEvent> {
    @Value("\${slack.webhookUrl}")
    lateinit var webhookUrl: String

    private val slackService = SlackService()

    override fun onApplicationEvent(event: ContextClosedEvent) {
        val payload = SlackPayload.builder()
            .addSection(
                Section.builder()
                    .text("Oops !")
                    .build()
            )
            .addSection(
                Section.builder()
                    .text("\uD83D\uDEA8 애플리케이션이 종료되었습니다 ! \uD83D\uDEA8")
                    .image("https://picsum.photos/id/237/200/300", " \uD83D\uDEA8 \uD83D\uDEA8")
                    .build()
            )
            .addSection(
                Section.builder()
                    .text("\uD83D\uDEA8 비정상 종료인지 확인하세요 ! \uD83D\uDEA8")
                    .button("https://example.com", "확인하러 가기")
                    .build()
            )
            .build()

        slackService.sendSlackMessage(webhookUrl, payload)
    }
}