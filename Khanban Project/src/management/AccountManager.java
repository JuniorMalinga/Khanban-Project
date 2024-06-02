package management;

import utils.Format;

public class AccountManager {
    private User[] users;
    private int userCount;
    private static final int MAX_USERS = 100;

    public AccountManager() {
        this.users = new User[MAX_USERS];
        this.userCount = 0;
    }
    
       public boolean registerUser(String firstName, String lastName, String username, String password) {
        if (userCount < MAX_USERS) {
            if (Format.checkUsernameComplexity(username) && Format.checkPasswordComplexity(password)) {
                users[userCount] = new User(firstName, lastName, username, password);
                userCount++;

                return true; // Registration successful
            } else {
                return false; // Registration failed due to invalid username or password complexity
            }
        } else {
            return false; // Registration failed due to user limit reached
        }
    }
       public boolean userExists(String username) {
           for (int i = 0; i < userCount; i++) {
               if (users[i].getUsername().equals(username)) {
                   return true; // User exists
               }
           }
           return false; // User does not exist
       }
   
    public boolean loginUser(String username, String password) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUsername().equals(username) && users[i].getPassword().equals(password)) {
                return true; // Login successful
            }
        }
        return false; // Login failed
    }

    public String returnLoginStatus(boolean loginStatus) {
        return loginStatus ? "Login successful" : "Login failed";
    }
    
    //new code 
    public User getUserByUsername(String username) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUsername().equals(username)) {
                return users[i];
            }
        }
        return null; // User not found
    }


	
}

