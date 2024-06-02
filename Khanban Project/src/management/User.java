//Defining a class to represent a user
package management;

public class User {
 // Private fields to store user information
 private String username;
 private String password;
 private String firstName;
 private String lastName;

 // Constructor to initialize user object with provided information
 public User(String firstName, String lastName, String username, String password) {
     this.firstName = firstName;
     this.lastName = lastName;
     this.username = username;
     this.password = password;
 }
 
    public void printUser() {
		System.out.println
		(
		   username + " " +
		   password + " " +
	       firstName + " " +
	       lastName + "\n" 
   );
}
 
 // Getter method to retrieve the username
 public String getUsername() {
     return username;
 }

 // Getter method to retrieve the password
 public String getPassword() {
     return password;
 }

 // Getter method to retrieve the first name
 public String getFirstName() {
     return firstName;
 }

 // Getter method to retrieve the last name
 public String getLastName() {
     return lastName;
 }


}

