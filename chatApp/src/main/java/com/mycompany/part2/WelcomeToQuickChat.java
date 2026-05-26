package com.mycompany.part2;

import java.util.Scanner;

public class WelcomeToQuickChat {

    public static void startChat() {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        
        System.out.println("Welcome to QuickChat.");

        while (choice != 3) {
            System.out.println("\n===== QUICK CHAT =====");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages"); 
            System.out.println("3. Quit");
            System.out.print("Choose option: ");

            try {
                choice = Integer.parseInt(input.nextLine()); 
            } catch (NumberFormatException e) {
                choice = 0; 
            }

            switch (choice) {
                case 1:
                    System.out.print("\nHow many messages do you want to send: ");
                    int numMessages = 0;
                    try {
                        numMessages = Integer.parseInt(input.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format.");
                        break;
                    }

                    for (int i = 0; i < numMessages; i++) {
                        System.out.println("\n===== MESSAGE " + (i + 1) + " =====");

                        System.out.print("Enter recipient number: ");
                        String recipient = input.nextLine();

                        System.out.print("Enter your message: ");
                        String content = input.nextLine();

                        Message message = new Message(i + 1, recipient, content);
                        String result = message.sendMessage();
                        System.out.println(result);
                        
                       
                        System.out.println("\n--- Message Details ---");
                        System.out.println("Message ID: " + message.getMessageId());
                        System.out.println("Message Hash: " + message.getMessageHash());
                        System.out.println("Recipient: " + message.getRecipient());
                        System.out.println("Message: " + message.getContent());
                    }

                   
                    System.out.println("\nTotal messages sent: " + Message.returnTotalMessages());
                    break;

                case 2:
                    
                    System.out.println("\nComing Soon.");
                    break;

                case 3:
                    System.out.println("\nThank you for using QuickChat.");
                    break;

                default:
                    System.out.println("\nInvalid option.");
            }
        }
    }
}