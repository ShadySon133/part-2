package com.mycompany.part2;

import java.util.ArrayList;

public class Message {

    private static int totalMessages = 0;
    private static ArrayList<Message> sentMessages = new ArrayList<>();

    private int messageId;
    private String recipient;
    private String content;
    private String messageHash;

    public Message(int messageId, String recipient, String content) {
        this.messageId = messageId;
        this.recipient = recipient;
        this.content = content;
        this.messageHash = generateCustomHash(content);
    }

    
    private String generateCustomHash(String text) {
        if (text == null || text.trim().isEmpty()) {
            return "00:0:EMPTY";
        }
        
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
        if (cleanText.length() > 9) {
            cleanText = cleanText.substring(0, 9);
        }
        return "00:0:" + cleanText;
    }

    public String checkLength() {
        if (content.length() <= 250) {
            return "Message ready to send.";
        } else {
            int exceededBy = content.length() - 250;
            return "Message exceeds 250 characters by " + exceededBy + "; please reduce the size.";
        }
    }

    public String checkRecipientCell() {
        
        if (recipient.matches("^\\+27\\d{9}$")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public String getGeneratedIdMessage() {
        return "Message ID generated: " + messageId;
    }

   
    public String processMessageAction(int selection) {
        return switch (selection) {
            case 1 -> {
                sentMessages.add(this);
                totalMessages++;
                yield "Message successfully sent.";
            }
            case 2 -> "Press 0 to delete the message.";
            case 3 -> "Message successfully stored.";
            default -> "Invalid Action Selection.";
        };
    }

    public static int returnTotalMessages() { return totalMessages; }
    public int getMessageId() { return messageId; }
    public String getRecipient() { return recipient; }
    public String getContent() { return content; }
    public String getMessageHash() { return messageHash; }

    String sendMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}