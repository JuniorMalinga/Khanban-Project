# Khanban-Project
This project can be described as an interactive task management application named **EasyKanban**, which helps users to manage tasks efficiently:

### EasyKanban

**EasyKanban** is a simple and interactive task management application built using Java and Swing for the graphical user interface. This application allows users to add, view, search, and manage tasks, providing a straightforward way to keep track of various tasks and their statuses.

#### Features

- **Add Tasks**: Create new tasks with details such as task name, description, developer information, status, and estimated duration.
- **View Reports**: Display all tasks with their details in a comprehensive report.
- **Search Tasks**:
  - By Task Name: Find specific tasks by their names.
  - By Developer: View tasks assigned to a particular developer.
- **Manage Tasks**:
  - Delete tasks by their name.
  - Display tasks with a specific status (e.g., 'Done').
  - Identify the task with the longest duration.

#### Getting Started

To run the application, make sure you have Java installed. You can compile and run the project using any Java IDE or from the command line.

**Using an IDE**:
1. Clone the repository to your local machine.
2. Import the project into your IDE.
3. Run the `Khanban` class.

**Using the Command Line**:
1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/easykanban.git
    ```
2. Navigate to the project directory:
    ```sh
    cd easykanban
    ```
3. Compile the project:
    ```sh
    javac -d bin src/easykhanban/*.java src/management/*.java
    ```
4. Run the application:
    ```sh
    java -cp bin easykhanban.Khanban
    ```

#### Project Structure

- `src/easykhanban/Khanban.java`: Main class containing the application logic.
- `src/easykhanban/Task.java`: Class representing a task.
- `src/management/AccountManager.java`: Placeholder for account management logic.
- `src/management/UserInterface.java`: Placeholder for user interface management.

#### Contributions

Contributions are welcome! Please fork the repository and submit pull requests.

#### License

This project is licensed under the MIT License.
