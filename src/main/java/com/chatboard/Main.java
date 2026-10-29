package com.chatboard;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ChatService chatService = new ChatService();

        System.out.println("=================================");
        System.out.println("       JAVA CHATBOARD");
        System.out.println("=================================");

        System.out.print("Enter your username: ");
        String username = scanner.nextLine().trim();

        if (username.isEmpty()) {
            System.out.println("Username cannot be empty.");
            scanner.close();
            return;
        }

        int choice;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Send Message");
            System.out.println("2. View All Messages");
            System.out.println("3. View My Messages");
            System.out.println("4. Exit");
            System.out.println("===========================");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {

                    case 1:
                        System.out.print("Enter your message: ");
                        String text = scanner.nextLine();

                        try {
                            chatService.sendMessage(username, text);
                        } catch (ChatException e) {
                            System.out.println(
                                    "Error: " + e.getMessage()
                            );
                        }
                        break;

                    case 2:
                        chatService.displayAllMessages();
                        break;

                    case 3:
                        chatService.displayUserMessages(username);
                        break;

                    case 4:
                        System.out.println("Exiting Chatboard. Goodbye!");
                        break;

                    default:
                        System.out.println(
                                "Invalid choice. Please try again."
                        );
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                choice = 0;
            }

        } while (choice != 4);

        scanner.close();
    }
}