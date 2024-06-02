package test_management; 

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import management.AccountManager;
import management.UserInterface;
import utils.Format;

public class Tester {

    // Testing if a username is correctly formatted
    @Test
    public void testUsernameCorrectlyFormatted() {
        assertTrue(Format.checkUsernameComplexity("Kyl_1"));
    }

    // Testing if a username is incorrectly formatted
    @Test
    public void testUsernameIncorrectlyFormatted() {
        assertFalse(Format.checkUsernameComplexity("Kyle!!!!!!!"));
    }

    // Testing if a password meets complexity requirements
    @Test
    public void testPasswordMeetsComplexityRequirements() {
        assertTrue(Format.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    // Testing if a password does not meet complexity requirements
    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {
        assertFalse(Format.checkPasswordComplexity("password"));
    }

    // Testing if login is successful
    @Test
    public void testLoginSuccessful() {
        AccountManager accountManager = new AccountManager();
        
        // Registering a user
        accountManager.registerUser("Darth", "Vader", "Ep_", "myPass@123");
        
        // Creating a user interface
        UserInterface userInterface = new UserInterface(accountManager);
        
        // Attempting login
        assertTrue(accountManager.loginUser("Ep_", "myPass@123"));
    }

    // Testing if login fails
    @Test
    public void testLoginFailed() {
        AccountManager accountManager = new AccountManager();
        UserInterface userInterface = new UserInterface(accountManager);
        
        // Attempting login with invalid credentials
        assertFalse(accountManager.loginUser("invalidUsername", "invalidPassword"));
    }

    // Testing if username is correctly inserted during registration
    @Test
    public void testUsernameCorrectlyInserted() {
        AccountManager accountManager = new AccountManager();
        
        // Attempting user registration
        assertTrue(accountManager.registerUser("Darth", "Vader", "Ep_", "myPass@123"));
    }

    // Testing if username is incorrectly inserted during registration
    @Test
    public void testUsernameIncorrectlyInserted() {
        AccountManager accountManager = new AccountManager();
        
        // Attempting user registration with an invalid username
        assertFalse(accountManager.registerUser("Darth", "Vader", "invalidUsername", "validPassword"));
    }

    // Testing if password meets complexity requirements during registration
    @Test
    public void testPasswordMeetsComplexityRequirementsInRegistration() {
        AccountManager accountManager = new AccountManager();
        
        // Attempting user registration with a complex password
        assertTrue(accountManager.registerUser("Darth", "Vader", "Ep_", "Ch&&sec@ke99!"));
    }

    // Testing if password does not meet complexity requirements during registration
    @Test
    public void testPasswordDoesNotMeetComplexityRequirementsInRegistration() {
        AccountManager accountManager = new AccountManager();
        
        // Attempting user registration with a weak password
        assertFalse(accountManager.registerUser("Darth", "Vader", "validUsername", "password"));
    }
}

