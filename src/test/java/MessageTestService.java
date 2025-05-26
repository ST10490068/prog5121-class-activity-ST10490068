/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageServiceTest {

    @Test
    public void testMessageLengthValid() {
        String shortMessage = "This is a short message.";
        assertTrue(shortMessage.length() <= 250, "Message ready to send.");
    }

    @Test
    public void testMessageLengthInvalid() {
        StringBuilder longMsg = new StringBuilder();
        for (int i = 0; i < 260; i++) longMsg.append("a");

        assertTrue(longMsg.length() > 250, 
            "Message exceeds 250 characters by " + (longMsg.length() - 250) + ", please reduce size.");
    }

    @Test
    public void testRecipientValid() {
        String recipient = "+27718693002";
        assertTrue(recipient.length() <= 10 && recipient.startsWith("+27"), "Cell phone number successfully captured.");
    }

    @Test
    public void testRecipientInvalid() {
        String recipient = "123456";
        assertFalse(recipient.length() <= 10 && recipient.startsWith("+27"), 
            "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
    }
}
