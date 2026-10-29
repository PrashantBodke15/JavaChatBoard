package com.chatboard;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {

    private String username;
    private String text;
    private LocalDateTime timestamp;

    public Message(String username, String text) {
        this.username = username;
        this.text = text;
        this.timestamp = LocalDateTime.now();
    }

    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return "[" + timestamp.format(formatter) + "] "
                + username + ": " + text;
    }
} 