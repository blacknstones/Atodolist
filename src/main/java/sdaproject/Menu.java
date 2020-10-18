package sdaproject;


import java.util.Scanner;

/**
 * This class is part of the "Atodolist" application.
 * "Atodolist" is a text-based to-do list tracker
 * that runs on the command line.
 *
 * This class displays the menu and guide user to perform actions.
 *
 * @author Yanwei Zhu
 * @version 2020.10.16
 */

public class Menu {
    private Scanner scanner;


    public void welcomeMenu(int todoCount, int doneCount)
    {
        System.out.println("Welcome to Atodolist!");
        System.out.println("You have " + todoCount + " tasks todo and " + doneCount + " tasks are done!");
        mainOptionMenu();
        System.out.println("(5) Help");
    }

    public void mainOptionMenu()
    {
        System.out.println("Please choose one of the following options:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");
        System.out.println("(5) Help");
    }

    public void helpMenu() {
        System.out.println("Enter the number ");
    }

    public void showListOptionMenu() {
        System.out.println("Show Task List by:");
        System.out.println("(1) Date");
        System.out.println("(2) project");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch (option) {
            case 1:

        }

    }


    public void addTaskMenu() {
        System.out.println("Please enter details of the task you want to add to the list:");

    }
    public void editTaskMenu() {

    }

    public void removeTaskMenu() {
        System.out.println("Please choose the task number to remove:");
    }

    public void QuitMenu()
    {

    }
}
