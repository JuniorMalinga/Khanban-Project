//Importing the necessary classes
package management;

//Main class responsible for starting the application
public class Main {
 // Main method, entry point of the application
 public static void main(String[] args) {
     // Creating an instance of the AccountManager class to manage user accounts
     AccountManager accountManager = new AccountManager();
     // Creating an instance of the UserInterface class to interact with users
     UserInterface ui = new UserInterface(accountManager);
     // Starting the user interface
     ui.start(); 
     
  }
}
