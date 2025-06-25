/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progformative1;

  import java.util.*;
  import java.util.regex.*;
  import java.util.concurrent.atomic.AtomicInteger;
  import java.io.*;
  import com.google.gson.Gson;
  import com.google.gson.GsonBuilder;

public class MessageService {
    private static final int MAX_LENGTH = 250;
   
  private static AtomicInteger messageCounter = new AtomicInteger(1);
    private static List<Message> messageList = new ArrayList<>();

    public static String generateMessageId() {
       return UUID.randomUUID().toString().substring(0, 10).toUpperCase();
    }

    public static boolean checkRecipientCell(String cell) {
       return cell != null && cell.matches("^\\+\\d{10,}$");
    }

    public static boolean isValidLength(String message) {
       return message.length() <= MAX_LENGTH;
    }

    public static String createMessageHash(String messageId, int number, String message) {
      String[] words = message.split("\\s+");
      String start = words.length > 0 ? words[0].toUpperCase() : "";
      String end = words.length > 1 ? words[words.length - 1].toUpperCase() : start;
      return String.format("%s:%d:%s%s", messageId, number, start, end);
    }

    public static int getTotalMessages() {
      return messageList.size();
    }

    public static void storeMessage(String recipient, String content) {
      String id = generateMessageId();
      int number = messageCounter.getAndIncrement();
      String hash = createMessageHash(id, number, content);
      Message msg = new Message(id, recipient, content, hash);
      messageList.add(msg);
    }

    public static List<Message> getAllMessages() {
      return messageList;
    }

    public static void saveMessagesToJson(String filename) {
       try (Writer writer = new FileWriter(filename)) {
          Gson gson = new GsonBuilder().setPrettyPrinting().create();
          gson.toJson(messageList, writer);
       } catch (IOException e) {
          e.printStackTrace();
        }
    }

    public static void printMessages() {
       for (Message m : messageList) {
          System.out.println("ID: " + m.getId());
          System.out.println("Recipient: " + m.getRecipientCell());
          System.out.println("Message: " + m.getContent());
          System.out.println("Hash: " + m.getMessageHash());
          System.out.println("------------");
        }
    }
    private final List<Message> sentMessages = new ArrayList<>();
    private final List<Message> storedMessages = new ArrayList<>();
      private final List<Message> disregardedMessages = new ArrayList<>();
      
      
      
 public void addMessage(String recipient, String content, String flag) {
     String messageID = generateMessageID();
     String hash = generateMessageHash(messageID, content);

    Message message = new Message(messageID, hash, recipient, content, flag);

    switch (flag.toLowerCase()) {
        case "sent":
           sentMessages.add(message);
          break;
        case "stored":
           storedMessages.add(message);
          break;
        case "disregard":
            
        case "disregarded":
           disregardedMessages.add(message);
          break;
        default:
          System.out.println("Invalid flag. Message not added.");
    }

  System.out.println("Message added:\n" + message);
}
 
    private int messageCounter = 1;

     private String generateMessageID() {
        return String.format("%010d", messageCounter++); // e.g. 0000000001
 }

     private String generateMessageHash(String messageID, String content) {
       String[] words = content.trim().split("\\s+");
       String first = words.length > 0 ? words[0] : "";
       String last = words.length > 1 ? words[words.length - 1] : first;
     return (messageID.substring(0, 2) + ":" + messageCounter + ":" + first + last).toUpperCase();
}
   
     public void searchByMessageID(String id) {
       for (Message msg : sentMessages) {
         if (msg.getMessageID().equals(id)) {
             System.out.println("Recipient: " + msg.getRecipient());
             System.out.println("Message: " + msg.getContent());
          return;
        }
    }
    System.out.println("Message ID not found.");
}  
    public void searchByRecipient(String recipient) {
      boolean found = false;
    for (Message msg : sentMessages) {
       if (msg.getRecipient().equals(recipient)) {
          System.out.println("\"" + msg.getContent() + "\"");
          found = true;
        }
    }
        if (!found) {
            System.out.println("No messages found for this recipient.");
    }
}
  public void deleteByMessageHash(String hash) {
        Iterator<Message> iterator = sentMessages.iterator();
    while (iterator.hasNext()) {
           Message msg = iterator.next();
        if (msg.getHash().equalsIgnoreCase(hash)) {
          iterator.remove();
          System.out.println("\"" + msg.getContent() + "\" successfully deleted.");
        return;
        }
    }
    System.out.println("Message hash not found.");
}
   public void displayReport() {
         System.out.println("----- SENT MESSAGES REPORT -----");

      if (sentMessages.isEmpty()) {
       System.out.println("No sent messages to display.");
       return;
    }

      for (Message msg : sentMessages) {
        System.out.println("Message Hash : " + msg.getHash());
        System.out.println("Recipient    : " + msg.getRecipient());
        System.out.println("Message      : " + msg.getContent());
        System.out.println("---------------------------------");
    }
}
   
   public void displayMessageReport() {
    if (sentMessages.isEmpty()) {
        System.out.println("No messages have been sent.");
        return;
    }

    System.out.println("Message Report:");
        for (String message : sentMessages) {
        int hash = message.hashCode();
           String[] parts = message.split(":", 2); // "Recipient:MessageContent"
        if (parts.length < 2) {
            System.out.println("Invalid message format.");
         continue;
        }

               String recipient = parts[0];
                  String content = parts[1];

               System.out.println("Hash: " + hash);
               System.out.println("Recipient: " + recipient);
               System.out.println("Message: " + content);
               System.out.println("-----");
    }
}

}
