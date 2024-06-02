package management;
// Importing necessary classes for user interface interaction
import javax.swing.JOptionPane;
import utils.Format;
import easykhanban.Khanban;

// Class representing the user interface of the application
public class UserInterface {
    // AccountManager instance to manage user accounts
    private AccountManager accountManager;

    // Constructor to initialize UserInterface with an AccountManager instance
    public UserInterface(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    // Method to start the user interface
    public void start() {
        // Variable to store user's choice
        int choice;
        do {
            // Displaying menu options and retrieving user's choice
            choice = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Create Account\n2. Login\n3. Exit"));
            // Switching based on user's choice
            switch (choice) {
                case 1:
                    createAccount(); // Invoking method to create a new account
                    break;
                case 2:
                    login(); // Invoking method to login
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Exiting program."); // Exiting the program
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again."); // Informing about invalid choice
            }
        } while (choice != 3);
    }  // Loop until user chooses to exit

    // Method to create a new account
    private void createAccount() {
        // Getting user's first name
        String firstName = getUserInput("Enter your Name:");
        // Getting user's last name
        String lastName = getUserInput("Enter your Surname:");
        
        // Getting user's desired username
        // An example of a username User_ 
        String username = getUserInput("Enter a username (no more than 5 characters with an underscore):");
        if (Format.checkUsernameComplexity(username)) { 
            JOptionPane.showMessageDialog(null, "Username captured successfully", "message", JOptionPane.PLAIN_MESSAGE);
        } else {
            // Informing user about incorrect username format and prompting for correct input
            JOptionPane.showMessageDialog(null, Format.printUsernameComplexityRules(), "message", JOptionPane.PLAIN_MESSAGE);
            while (!Format.checkUsernameComplexity(username)) {
                username = JOptionPane.showInputDialog(null, Format.printUsernameComplexityRules());
                JOptionPane.showMessageDialog(null, "Username captured successfully", "message", JOptionPane.PLAIN_MESSAGE);
            }
        } 
        
        // Getting user's desired password
        // An example of a password Fisherman@1
        String password = getUserInput("Enter a password (at least 8 characters with capital letter, number, and special character):");
        // Validating password complexity
        if (Format.checkPasswordComplexity(password)) { 
            JOptionPane.showMessageDialog(null, "Password captured successfully", "message", JOptionPane.PLAIN_MESSAGE);
        } else {
            // Informing user about incorrect password format and prompting for correct input
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", "message", JOptionPane.ERROR_MESSAGE);
            while (!Format.checkPasswordComplexity(password)) {
                password = JOptionPane.showInputDialog(null, Format.printPasswordComplexityRules());
                JOptionPane.showMessageDialog(null, "Password captured successfully", "message", JOptionPane.PLAIN_MESSAGE);
            }  
        }
        
        // Attempting to register the user with provided information
        boolean registrationStatus = accountManager.registerUser(firstName, lastName, username, password);
        if (registrationStatus) {
            JOptionPane.showMessageDialog(null, "Account created successfully!"); // Informing about successful account creation
        } else {
            JOptionPane.showMessageDialog(null, "Account creation failed. Please check your inputs."); // Informing about failed account creation
        }
    }

    // Method for user login
    @SuppressWarnings("static-access")
	private void login() {
        // Getting user's input for username
        String inputUsername = getUserInput("Enter your username:");
        
        // Check if the user exists
        if (!accountManager.userExists(inputUsername)) {
            JOptionPane.showMessageDialog(null, "No account found for the provided username. Please create an account before logging in.");
            return;
        }
        
        // Getting user's input for password
        String inputPassword = getUserInput("Enter your password:");

        // Attempting user login with provided credentials
        boolean loginStatus = accountManager.loginUser(inputUsername, inputPassword);
        if (loginStatus) {
            // If login successful, retrieving user information and displaying a welcome message
            User user = accountManager.getUserByUsername(inputUsername);
            JOptionPane.showMessageDialog(null, "Welcome " + user.getFirstName() + " " + user.getLastName() + ", login successful!");
            
            // Part 2: Create an instance of the Khanban class and initiate the Kanban system
            Khanban khanban = new Khanban();
            khanban.startKhanban();
        } else {
            // If login failed, informing user about incorrect credentials
            JOptionPane.showMessageDialog(null, "Incorrect password. Please try again.");
        }
    }
 
    // Method to get user input with a specified message
    private String getUserInput(String message) {
        return JOptionPane.showInputDialog(null, message); // Displaying a message and getting user input
    }
}
