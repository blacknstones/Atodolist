package sdaproject;

import java.util.Scanner;

/**
 * This class is part of the "Atodolist" application.
 * "Atodolist" is a text-based to-do list tracker
 * that runs on the command line.
 *
 * This class displays the menu to guide user to perform actions.
 *
 * @author Yanwei Zhu
 * @version 2020.10.20
 */

public class Menu {
    /**
     * Display the welcome menu.
     * @param todoCount The number of to-do tasks.
     * @param doneCount The number of done tasks.
     */
    public static void welcomeMenu(int todoCount, int doneCount) {
        System.out.println("Welcome to Atodolist!");
        System.out.println("You have " + todoCount + " tasks todo and " + doneCount + " tasks are done!" + "\n");
    }

    /**
     * Display the main option menu.
     */
    public static void mainOptionMenu() {
        System.out.println("Please choose one of the following options [Enter 1-5]:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");
        System.out.println("(5) Help\n>> ");
    }

    /**
     * Display the sub-options of Show List option.
     */
    public static void showListOption() {
        System.out.println("Show Task List by:");
        System.out.println("(1) Date");
        System.out.println("(2) project\n>> ");
    }

    /**
     * Display the add Task menu.
     */
    public static void addTaskMenu() {
        System.out.println("Enter details of the task you want to add to the list");
    }

    /**
     * Display the edit task menu.
     */

    public static void editTaskOption() {
        System.out.println("Please choose one of the following options:");
        System.out.println("(1) Update task");
        System.out.println("(2) Mark task as done");
        System.out.println("(3) Remove task");
        System.out.println("(4) Return to main menu");
    }

    /**
     * This method pauses the program and waits for the user to press enter
     */
    public static void enterToReturn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press Enter to return to main menu");
        sc.nextLine();
    }

    public static void quitMenu()
    {
        System.out.println("All changes are saved. Good bye!");
    }




}
