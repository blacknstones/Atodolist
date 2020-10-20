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
    private Scanner input;

    public Menu() {
        input = new Scanner(System.in);
    }
    /**
     * Display the welcome menu.
     * @param todoCount The number of to-do tasks.
     * @param doneCount The number of done tasks.
     */
    public static void welcomeMenu(int todoCount, int doneCount)
    {
        System.out.println("Welcome to Atodolist!");
        System.out.println("You have " + todoCount + " tasks todo and " + doneCount + " tasks are done!");
    }

    /**
     * Display the main option menu.
     */
    public int mainOptionMenu()
    {
        System.out.println("Please choose one of the following options:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");
        System.out.println("(5) Help");
        return input.nextInt();
    }

    /**
     * Display the help menu.
     */
    public static void helpMenu() {
        System.out.println("Enter the number of options and press Enter.");
        mainOptionMenu();
    }

    /**
     * Display the sub-options of Show List option.
     */
    public static void showListOption() {
        System.out.println("Show Task List by:");
        System.out.println("(1) Date");
        System.out.println("(2) project");
    }

    /**
     * Display the add Task menu.
     */
    public static void addTaskMenu() {
        System.out.println("Please enter details of the task you want to add to the list:");
    }


    /**
     * Display the edit task menu.
     */
    public static void editTaskMenu() {
        System.out.println("Please choose one of the following options:");
        System.out.println("(1) Update task");
        System.out.println("(2) Mark task as done");
        System.out.println("(3) Remove task");
        System.out.println("(4) Return to main menu");
    }



    public void markAsDoneSuccessMessage(Task task) {
        System.out.println("Your task:");
        task.printDetail();
        System.out.println("is now done! Good job!");
    }
    public void removeSuccessMessage(Task task) {
        System.out.println("Your task:");
        task.printDetail();
        System.out.println("is removed from the list.");
    }

    public void removeTaskMenu() {
        System.out.println("Your Task ");





    }

    public void QuitMenu()
    {

    }
}
