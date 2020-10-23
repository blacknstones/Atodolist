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
        System.out.println("You have " + todoCount + " tasks todo and " + doneCount + " tasks are done!" );
        System.out.println("--------------------------------------------");
    }

    /**
     * Display the main option menu.
     */
    public static void mainOptionMenu() {
        System.out.println("Please choose one of the following options [Enter 1-5]:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit\n>> ");
    }


    /**
     * Display the add Task menu.
     */
    public static void addTaskMenu() {
        System.out.println("Enter details of the task you want to add to the list:");
        System.out.println("------------------------------------------------------");
    }

    /**
     * Display the edit task menu.
     */
    public static void editTaskOption() {
        System.out.println("Please choose one of the following options:");
        System.out.println("(1) Update task");
        System.out.println("(2) Mark task as done");
        System.out.println("(3) Remove task");
        System.out.println("(4) Return to main menu\n>> ");
    }

    /**
     * Pauses the program and waits for the user to press enter
     */
    public static void enterToReturn() {
        Scanner sc = new Scanner(System.in);
        System.out.println(">> Press Enter to return to main menu");
        sc.nextLine();
    }

    /**
     * Display the quit menu.
     */
    public static void quitMenu()
    {
        System.out.println("All changes are saved. ");
        System.out.println("Thank you for using Atodolist. Good bye!");
    }


}
