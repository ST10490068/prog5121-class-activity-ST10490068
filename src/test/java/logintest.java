/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.progformative1.login;

public class logintest {

    // Test for correctly formatted username
    @Test
    public void testCorrectUsernameFormat() {
        login login = new login();
           boolean result = login.checkUserName("kyl_1");
        assertTrue(result, "Username should be correctly formatted");
    }

    // Test for incorrectly formatted username (no underscore, or too long)
    @Test
    public void testIncorrectUsernameFormat() {
        login login = new login();
         boolean result = login.checkUserName("kyle!!!!!!!");
        assertFalse(result, "Username should be incorrectly formatted");
    }
    
    // Test for password meeting complexity requirements
    @Test
    public void testValidPassword() {
        login login = new login();
        boolean result = login.checkPasswordComplexity("Ch&&sec@ke99!");
        assertTrue(result, "Password should meet complexity requirements");
    }

    // Test for password failing complexity requirements
    @Test
    public void testInvalidPassword() {
        login login = new login();
        boolean result = login.checkPasswordComplexity("password");
        assertFalse(result, "Password should not meet complexity requirements");
    }

    // Test for correctly formatted cell phone number
    @Test
    public void testValidCellPhoneNumber() {
        login login = new login();
        boolean result = login.checkCellPhoneNumber("+27838968976");
        assertTrue(result, "Cell phone number should be correctly formatted");
    }

    // Test for incorrectly formatted cell phone number (missing international code)
    @Test
    public void testInvalidCellPhoneNumber() {
        login login = new login();
         boolean result = login.checkCellPhoneNumber("08966553");
        assertFalse(result, "Cell phone number should be incorrectly formatted");
    }
    
    // Test for successful login
    @Test
    public void testLoginSuccess() {
        login login = new login();
         login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        boolean result = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(result, "Login should be successful with correct username and password");
    }

    // Test for failed login (wrong username or password)
    @Test
    public void testLoginFailure() {
        login login = new login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        boolean result = login.loginUser("kyl_1", "wrongpassword");
        assertFalse(result, "Login should fail with incorrect username or password");
    }

    // Test for successful registration
    @Test
    public void testRegistrationSuccess() {
        login login = new login();
        String message = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("User successfully registered.", message);
    }

    // Test for registration failure (invalid username)
    @Test
    public void testRegistrationFailureUsername() {
       login login = new login();
        String message = login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", message);
    }

    // Test for registration failure (invalid password)
    @Test
    public void testRegistrationFailurePassword() {
       login login = new login();
        String message = login.registerUser("kyl_1", "password", "+27838968976");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", message);
    }

    // Test for registration failure (invalid cell phone number)
    @Test
    public void testRegistrationFailureCellPhone() {
        login login = new login();
        String message = login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553");
        assertEquals("Cell phone number incorrectly formatted or does not contain international code.", message);
    }
}

