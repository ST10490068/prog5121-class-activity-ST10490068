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
}
