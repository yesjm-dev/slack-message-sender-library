package com.yesjm.slackmessagesender.adapter;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SlackClient {
    public static void postToSlack(String urlString, String payload) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            try (OutputStream os = connection.getOutputStream()) {
                os.write(payload.getBytes());
                os.flush();
            }

            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while sending Slack message", e);
        }
    }
}
