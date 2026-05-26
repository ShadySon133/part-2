package com.mycompany.part2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    // 1. Character Length Check Tests
    @Test
    public void testMessageLength_Success() {
        Message msg = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Message ready to send.", msg.checkLength());
    }

    @Test
    public void testMessageLength_FailureExceeded() {
        String longContent = "A".repeat(255); // 5 characters over the limit
        Message msg = new Message(1, "+27718693002", longContent);
        
        String expectedMessage = "Message exceeds 250 characters by 5; please reduce the size.";
        assertEquals(expectedMessage, msg.checkLength());
    }

    // 2. Recipient Number Structural Validation Tests
    @Test
    public void testRecipientNumber_Success() {
        Message msg = new Message(1, "+27718693002", "Valid recipient test.");
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());
    }

    @Test
    public void testRecipientNumber_FailureInvalidFormat() {
        // Missing the international code prefix sign (+), or has wrong length digit count
        Message msg = new Message(1, "08575975889", "Invalid recipient test.");
        
        String expectedMessage = "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        assertEquals(expectedMessage, msg.checkRecipientCell());
    }

    // 3. Custom Custom Message Hash Template Output Test
    @Test
    public void testMessageHash_CreationSuccess() {
        // When inputting "Hi Mike, can you join us for dinner tonight?", letters become "HIMIKECAN..."
        // First 9 letters are "HIMIKECAN"
        Message msg = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("00:0:HIMIKECAN", msg.getMessageHash());
    }

    // 4. Message ID Assignment Generation Text Test
    @Test
    public void testMessageId_FormatGeneration() {
        Message msg = new Message(45, "+27718693002", "ID verification test.");
        assertEquals("Message ID generated: 45", msg.getGeneratedIdMessage());
    }

    // 5. User Selection Action Options State Path Tests
    @Test
    public void testMessageAction_SendSelection() {
        Message msg = new Message(1, "+27718693002", "Sample message body.");
        assertEquals("Message successfully sent.", msg.processMessageAction(1));
    }

    @Test
    public void testMessageAction_DisregardSelection() {
        Message msg = new Message(1, "+27718693002", "Sample message body.");
        assertEquals("Press 0 to delete the message.", msg.processMessageAction(2));
    }

    @Test
    public void testMessageAction_StoreSelection() {
        Message msg = new Message(1, "+27718693002", "Sample message body.");
        assertEquals("Message successfully stored.", msg.processMessageAction(3));
    }
}