/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progformative1;



public class login {
    
    private String storedUsername;
    private String storedPassword;
    private String storedCellNumber;

    // Method to check username
    public Boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check password complexity 
    public Boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&  
               password.matches(".*\\d.*") &&    
               password.matches(".*[!@#$%^&*()].*");  
    }

    // Method to check if the phone number contains correct country code (+27)
    public Boolean checkCellPhoneNumber(String cellPhoneNumber) {
        return cellPhoneNumber.matches("^\\+27\\d{9,10}$");  
    }

    // Method to register user and return messages based on validations
    public String registerUser(String username, String password, String cellPhoneNumber) {
        // Check username
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        // Check password
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        // Check phone number
        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        //store the details (registration success)
        this.storedUsername = username;
        this.storedPassword = password;
        this.storedCellNumber = cellPhoneNumber;

        return "User successfully registered.";
    }

    // Method to check if login details match stored details
    public Boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    // Method to return login status message
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + username + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
}
