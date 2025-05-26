/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progformative1;

 import java.util.Scanner;

 

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        user.login();
        System.out.println("Welcome to QuickChat!");

        int option = 0;
        while (option != 3) {
            System.out.println("1. Send Message");
            System.out.println("2. Show recent messages (Coming Soon)");
            System.out.println("3. Quit");
            System.out.print("Choose: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    if (!user.isLoggedIn()) {
                        System.out.println("Please login first.");
                        break;
                    }

                    System.out.print("Enter recipient cell number: ");
                    String recipient = scanner.nextLine();

                    if (!MessageService.checkRecipientCell(recipient)) {
                        System.out.println("Cell phone number is incorrectly formatted or missing international code. Try again.");
                        break;
                    }

                    System.out.print("Enter message (max 250 characters): ");
                    String content = scanner.nextLine();

                    if (!MessageService.isValidLength(content)) {
                        System.out.println("Message exceeds 250 characters, please reduce size.");
                        break;
                    }

                    System.out.println("1. Send");
                    System.out.println("2. Discard");
                    System.out.println("3. Store to send later");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 1) {
                        MessageService.storeMessage(recipient, content);
                        System.out.println("Message sent.");
                    } else if (choice == 3) {
                        MessageService.storeMessage(recipient, content);
                        MessageService.saveMessagesToJson("messages.json");
                        System.out.println("Message saved to JSON.");
                    } else {
                        System.out.println("Message discarded.");
                    }

                    break;

                case 2:
                    System.out.println("Coming Soon.");
                    break;

                case 3:
                    System.out.println("Goodbye.");
                    break;
            }
        }

        scanner.close();
    }
}

    

