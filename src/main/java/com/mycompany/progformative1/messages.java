/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progformative1;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class messages{
      private List<String> sentMessages = new ArrayList<>();

      public void sendMessage(String message) {
        sentMessages.add(message);
    }


    
    public String generateUniqueMessageId() {
           String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
           StringBuilder id = new StringBuilder();
           Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            id.append(characters.charAt(rand.nextInt(characters.length())));
        }
        return id.toString();
    }

    
    public boolean validateRecipient(String number) {
      return number.startsWith("+") && number.length() <= 10;
    }

   
    public boolean validateMessageLength(String message) {
      return message.length() <= 250;
    }

    
    public String generateMessageHash(String messageId, int messageNum, String message) {
        String[] words = message.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;
      return (messageId.substring(0, 2) + ":" + messageNum + ":" + firstWord + lastWord).toUpperCase();
    }

    public String sendMessage(String recipient, String message) {
        if (!validateRecipient(recipient)) {
            return "Invalid recipient number.";
       
       
          }

        if (!validateMessageLength(message)) {
            return "Please enter a message of less than 250 characters.";
          }

        String messageId = generateUniqueMessageId();
        messageCount++;
        String messageHash = generateMessageHash(messageId, messageCount, message);

        String fullMessage = "Message ID: " + messageId +
             "\nRecipient: " + recipient +
             "\nMessage: " + message +
             "\nHash: " + messageHash;

        sentMessages.add(fullMessage);
          return "Message sent\n" + fullMessage;
    }

    // For later: You’ll add JSON storage here
}
    

