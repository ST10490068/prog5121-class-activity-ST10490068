/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progformative1;

/**
 *
 * @author lab_services_student
 */
public class usersessions {
       private static boolean loggedIn = false;
       private static String currentUser;

    public static void login() {
      loggedIn = true;
    }

    public static boolean isLoggedIn() {
      return loggedIn;
    }
     public static void logout() {
        loggedIn = false;
        currentUser = null;
    }

    public static String getCurrentUser() {
        return currentUser;
    }
}

    

