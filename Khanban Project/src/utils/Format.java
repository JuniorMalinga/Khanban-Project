package utils;

public class Format {

	// array of special characters from which the user can choose to create a password
	private static char[] characters = new char[] {'!', '@', '#', '$', '%', '^', '&', '*', '.', '-', '+',  '_'};
	
	public static Boolean checkUsernameComplexity(String username) {
		// fill in the details for checking whether a username is correctly formatted
		 return username.length() <= 5 && username.contains("_");
		//return true; // currently all username formats are acceptable
	}
	
	public static Boolean checkPasswordComplexity(String password) {
		
		// Example Password:
		//
		// Pass*W0rd
		//
		// The above password contains (at least):
		//
		// 	- 1 Special Character
		//	- 1 Upper-Case Character
		//	- 1 Numeric Character
		//	- 8 Characters in Length
		//
		
		// Check if password is of the correct length
		if (password.length() < 8) {
			return false;
		}
		// Avoid regex using boolean flags !!!
		Boolean hasSpecialChar = false;
		Boolean hasNumericChar = false;
		Boolean hasUpperChar = false;
		
		// this loop iterates the password string only once,
		// but may have to iterate the entire character array above
		for (int i = 0; i < password.length(); i++) {
			char currentChar = password.charAt(i);
			if (contains(characters, currentChar)) {
				hasSpecialChar = true;
			}
			if (isNumeric(currentChar)) {
				hasNumericChar = true;
			}
			if (isUpper(currentChar)) {
				hasUpperChar = true;
			}
		}
		return (hasSpecialChar && hasNumericChar && hasUpperChar);
	}
	
	// function to check whether a character is contained in specified char array
	private static Boolean contains(char[] array_to_search, char character_to_find) {
		for (int i = 0; i < array_to_search.length; i++) {
			if (array_to_search[i] == character_to_find) {
				return true;
			}
		}
		return false;
	}
	
	public static Boolean isNumeric(char character) {
		return Character.isDigit(character);
	}
	
	public static Boolean isUpper(char character) {
		return Character.isUpperCase(character);
	}

	public static String printPasswordComplexityRules() {
	    String Passwordmessage = "Password Format Not Valid - Ensure the Following: \n\n" +
	                     "Password MUST Contain (At Least): \n" +
	                     "\t - 8 Characters in Length\n" +
	                     "\t - 1 Special Character\n" +
	                     "\t - 1 Numeric Character\n" +
	                     "\t - 1 Upper-Case Character\n\n";
	    return Passwordmessage;
	}
	
	public static String printUsernameComplexityRules() {
		// Inform the client how to format their username
		 String UsernameMessage = "Username Format Not Valid - Ensure the Following: \n\n" +
                                 "Username MUST Contain (At Least): \n" +
                                  "\t - 5 Characters in Length\n" +
                                  "\t - An Underscore\n\n";
		return UsernameMessage;
 
		}
	
}
