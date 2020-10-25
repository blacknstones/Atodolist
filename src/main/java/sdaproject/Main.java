package sdaproject;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class is part of the "Atodolist" application.
 * "Atodolist" is a text-based to-do-list tracker
 * that runs on the command line.
 *
 * This class runs the program and allow user to perform all functionalities.
 *
 * @author Yanwei Zhu
 * @version 2020.10.23
 */

public class Main {

    public static void main(String args[])
    {
        // SETUP
        Menu menu = new Menu();
        FileManager fileManager = new FileManager();
        // read from file and create a new ToDoList object
        ToDoList todolist = new ToDoList(fileManager.readFromFile());
        Scanner scanner = new Scanner(System.in);
        menu.welcomeMenu(todolist.getToDoCount(), todolist.getDoneCount());

        //initiate the starting menu option
        int menuOption = -1;

        try {
            // Run the program based on user input of options

            while (menuOption != 4) {
                menu.mainOptionMenu();
                // Get user input of option number and pass
                menuOption = scanner.nextInt();

                switch (menuOption) {
                    case 1:
                        todolist.showList();
                        menu.enterToReturn();
                        break;

                    case 2:
                        menu.addTaskMenu();
                        todolist.addTaskFromInput();
                        menu.enterToReturn();

                        break;

                    case 3:
                        // display the current todolist
                        todolist.printAll();
                        // Select task from user input
                        int taskIndex = todolist.selectTaskFromInput();
                        // Edit task
                        menu.editTaskMenu();
                        todolist.editTaskFromInput(taskIndex);
                        menu.enterToReturn();
                        break;

                    // break when any other values are inputted by user
                    default:
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("error" + e);
        }

        scanner.close();
        fileManager.writeToFile(todolist.getTaskList());
        menu.quitMenu();

    }
}

