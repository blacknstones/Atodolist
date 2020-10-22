package sdaproject;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class is the main class which runs the application.
 *
 * @author Yanwei Zhu
 * @version 2020-10-20
 *
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
                        menu.showListOption();
                        todolist.showList();
                        menu.enterToReturn();
                        break;

                    case 2:
                        menu.addTaskMenu();
                        todolist.addTask();
                        menu.enterToReturn();

                        break;

                    case 3:
                        // display the current todolist
                        todolist.printAll();
                        // Select task from user input
                        int taskIndex = todolist.selectTaskFromInput();
                        // Edit task
                        menu.editTaskOption();
                        todolist.editTask(taskIndex);
                        break;

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

