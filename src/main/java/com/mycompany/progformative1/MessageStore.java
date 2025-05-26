/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progformative1;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;

public class MessageStore {
    public static void saveToJson(Message msg, String filename) {
        JSONObject json = new JSONObject();
        json.put("id", msg.getId());
        json.put("num", msg.getNum());
        json.put("recipient", msg.getRecipient());
        json.put("message", msg.getContent());
        json.put("hash", msg.getMessageHash());

        JSONArray messageArray = new JSONArray();

        try {
            // Load existing messages if file exists
            FileReader reader = new FileReader(filename);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            messageArray = (JSONArray) obj;
            reader.close();
        } catch (Exception e) {
            // File doesn't exist, continue
        }

        messageArray.add(json);

        try (FileWriter file = new FileWriter(filename)) {
            file.write(messageArray.toJSONString());
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}

