# Slack Message Sender Library

## 📜 프로젝트 개요

**Slack Message Sender Library**는 Slack의 Webhook을 통해 다양한 형식의 메시지를 손쉽게 전송할 수 있도록 도와주는 라이브러리입니다.
Slack의 [Block Kit](https://api.slack.com/block-kit) 을 쉽게 커스텀할 수 있도록 구성되어 있습니다.
이 라이브러리를 사용하면 Slack 채널에 **텍스트**, **버튼**, **이미지** 등 다양한 형태의 메시지를 **자동화**하여 전송할 수 있습니다.

개발자는 복잡한 Slack 메시지 형식을 신경 쓰지 않고 간편하게 메시지를 작성하고 전송할 수 있으며, 구성 요소들을 **유연하게 조합**하여 자신만의 메시지 형식을 쉽게 만들 수 있습니다.

---

## 🛠️ 주요 기능

### 1. 텍스트 메시지 전송
- **기본 텍스트** 메시지와 **마크다운(Markdown)** 형식을 지원하여 다양한 텍스트 스타일을 적용한 메시지를 전송할 수 있습니다.

### 2. 버튼 추가
- Slack 메시지에 **버튼**을 추가하여 사용자가 상호작용할 수 있는 UI를 제공합니다. 버튼 클릭 시 지정된 **URL**로 리다이렉션됩니다.

### 3. 이미지 추가
- 메시지에 **이미지**를 포함시킬 수 있어, 시각적인 요소를 강화하고 더 풍부한 콘텐츠를 전달할 수 있습니다.

### 4. Webhook 전송
- Slack의 **Webhook URL**을 사용하여 메시지를 Slack 채널로 직접 전송할 수 있습니다. 설정된 Webhook URL로 메시지를 손쉽게 전달합니다.

### 5. 빌더 패턴 지원
- **빌더 패턴**을 통해 직관적인 방식으로 메시지 구성 요소를 생성하고 관리할 수 있어, 확장성과 유연성을 제공합니다.

---

## 🚀 설치 방법
Gradle 사용하는 경우:
```
repositories {
    maven("https://jitpack.io")
}
dependencies {
    implementation 'com.yesjm:slack-message-sender-library:${tag}'
}
```

Maven 사용하는 경우:
```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.yesjm</groupId>
    <artifactId>slack-message-sender-library</artifactId>
    <version>${tag}</version>
</dependency>
```
## 💡Slack Webhook URL 설정
슬랙에서 메시지를 보내기 위해서는 Incoming Webhook을 설정해야 합니다. 

1. Slack에서 앱 추가:
    - Slack에서 Incoming Webhooks 앱을 검색하여 추가합니다.
2. Webhook URL 생성:
    - Slack에서 채널을 선택하고, Webhook URL을 생성합니다. 생성된 URL은 Slack으로 메시지를 전송하는 데 사용됩니다.
3. Webhook URL 복사:
    - 생성된 Webhook URL을 복사하여 코드에서 사용할 수 있도록 설정합니다.

## 🔧 사용 예시
```
SlackService slackService = new SlackService();
String webhookUrl = "https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX";

SlackPayload payload = SlackPayload.builder()
        .addSection(
            Section.builder()
                .text("Test Message")
                .button("https://example.com", "Click Me")
                .build()
        )
        .build();

slackService.sendSlackMessage(webhookUrl, payload);
```
![sample](https://github.com/user-attachments/assets/e1683a20-a8d9-46cb-9145-eebb7ff1cd02)

---
## 라이선스
이 프로젝트는 MIT License 하에 배포됩니다. 자세한 내용은 LICENSE 파일을 참조하세요.
