/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progformative1;




public class Message {
    private String id;
    private String recipientCell;
    private String content;
    private String messageHash;
    private String flag; 

    public Message(String id, String recipientCell, String content, String messageHash) {
        this.id = id;
        this.recipientCell = recipientCell;
        this.content = content;
        this.messageHash = messageHash;
        this.flag = flag;
    }

    public String getId() { return id; }
    public String getRecipientCell() { return recipientCell; }
    public String getContent() { return content; }
    public String getMessageHash() { return messageHash; }
    public String getFlag() { return flag; }
    
    
    
  @Override
    public String toString() {
       return "Hash: " + messageHash + "\nRecipient: " + recipientCell + "\nMessage: " + content;
    }
}



