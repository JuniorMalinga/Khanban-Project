# EasyKanban

EasyKanban is a simple and interactive task management application built using Java and Swing for the graphical user interface. This application allows users to add, view, search, and manage tasks, providing a straightforward way to keep track of various tasks and their statuses.

## Features

- **User Authentication**:
  - Basic Login System: Secure login system for authorized access.
  - User Profiles: Personal profiles for managing information and task history.

- **Task Management**:
  - Add Tasks: Create tasks with details like name, description, developer info, status, and duration.
  - View Reports: Comprehensive report displaying all tasks and their details.
  - Search Tasks:
    - By Task Name: Find specific tasks by name.
    - By Developer: View tasks assigned to a particular developer.
  - Manage Tasks:
    - Delete tasks by name.
    - Display tasks with a specific status (e.g., 'Done').
    - Identify the task with the longest duration.

## Getting Started

To run the application, make sure you have Java installed. You can compile and run the project using any Java IDE or from the command line.

### Using an IDE:

1. Clone the repository to your local machine.
2. Import the project into your IDE.
3. Run the `Main` class.

### Using the Command Line:

1. Clone the repository:
    ```sh
    git clone https://github.com/JuniorMalinga/Khanban-Project.git
    ```
2. Navigate to the project directory:
    ```sh
    cd main
    ```
3. Compile the project:
    ```sh
    javac -d bin src/main/*.java src/management/*.java
    ```
4. Run the application:
    ```sh
    java -cp bin main.main
    ```

## Project Structure

- `src/easykhanban/Khanban.java`: Main class containing the application logic.
- `src/easykhanban/Task.java`: Class representing a task.
- `src/management/AccountManager.java`: Placeholder for account management logic.
- `src/management/UserInterface.java`: Placeholder for user interface management.

## Contributions

Contributions are welcome! Please fork the repository and submit pull requests. Feel free to suggest enhancements or report issues.

## License

This project is licensed under the [MIT License](LICENSE).
