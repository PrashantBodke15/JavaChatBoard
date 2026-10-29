package com.chatboard;

import java.util.ArrayList;
import java.util.List;

public class ChatService {

    private final List<Message> messages = new ArrayList<>();

    public void sendMessage(String username, String text)
            throws ChatException {

        if (username == null || username.trim().isEmpty()) {
            throw new ChatException("Username cannot be empty.");
        }

        if (text == null || text.trim().isEmpty()) {
            throw new ChatException("Message cannot be empty.");
        }

        Message message = new Message(
                username.trim(),
                text.trim()
        );

        messages.add(message);

        System.out.println("Message sent successfully!");
    }

    public void displayAllMessages() {

        if (messages.isEmpty()) {
            System.out.println("No messages available.");
            return;
        }

        System.out.println("\n========== CHATBOARD ==========");

        for (Message message : messages) {
            System.out.println(message);
        }

        System.out.println("================================");
    }

    public void displayUserMessages(String username) {

        boolean found = false;

        for (Message message : messages) {
            if (message.getUsername()
                    .equalsIgnoreCase(username.trim())) {

                System.out.println(message);
                found = true;
            }
        }

        if (!found) {
            System.out.println(
                    "No messages found for user: " + username
            );
        }
    }
}