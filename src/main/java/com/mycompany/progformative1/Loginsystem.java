/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progformative1;
  import java.util.Scanner;
  import java.util.regex.*;

public class Loginsystem {
      public static void main(String[] args) {
        // Create a scanner object for input
          Scanner scanner = new Scanner(System.in);

        // Step 1: Register user with username, password, and cell phone number
          System.out.print("Enter your username (e.g., user_name): ");
          String username = scanner.nextLine();
          System.out.print("Enter your password: ");
          String password = scanner.nextLine();
          System.out.print("Enter your South African cell phone number (e.g., +27831234567): ");
          String cellNumber = scanner.nextLine();

        // Validate username
        if (!isValidUsername(username)) {
              System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
            return;
        } else {
              System.out.println("Username successfully captured.");
        }

        // Validate password
        if (!isValidPassword(password)) {
              System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            return;
        } else {
              System.out.println("Password successfully captured.");
        }

        // Validate cell phone number
        if (!isValidCellNumber(cellNumber)) {
              System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            return;
        } else {
              System.out.println("Cell phone number successfully added.");
        }

        // Step 2: Login using the same credentials
          System.out.println("\nLOGIN:");
          System.out.print("Enter your username: ");
          String loginUsername = scanner.nextLine();
          System.out.print("Enter your password: ");
          String loginPassword = scanner.nextLine();

        if (loginUsername.equals(username) && loginPassword.equals(password)) {
            System.out.println("Welcome, " + username + ", it is great to see you again.");
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }

    }

    // Username validation method
    public static boolean isValidUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Password validation method
    public static boolean isValidPassword(String password) {
        return password.length() >= 8 && 
                password.matches(".*[A-Z].*") && 
                password.matches(".*\\d.*") && 
                password.matches(".*[!@#$%^&*()].*");
    }

    // Cell phone number validation method
    public static boolean isValidCellNumber(String cell) {
        return Pattern.matches("^\\+27\\d{9,10}$", cell);
    }
    
}
