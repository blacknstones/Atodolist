package SDAproject;

import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * This class is part of the "Atodolist" application.
 * "Atodolist" is a text-based to-do list tracker
 * that runs on the command line.
 * <p>
 * This class is the main component of the application:
 * it stores all tasks, and allows users to manipulate.
 *
 * @author Yanwei Zhu
 * @version 2020.10.16
 */

public class ToDoList {
    private ArrayList<Task> todolist;
    private Menu menu;
    private int toDoCount;
    private int doneCount;

    /**
     * Create the initial ToDoList.
     */
    public ToDoList() {
        List<ToDoList> todolist = new ArrayList<>();
        menu = new Menu();
    }

    /**
     * Create a new Task and return it.
     * The private access ensures that it can only be used within ToDoList class.
     * @param title The title of the task.
     * @param project The project name of the task.
     * @param dateString The date of the task as String.
     */
    private Task createNewTask(String title, String project, String dateString) {
        Task newTask = new Task(title, project, dateString);
        return newTask;
    }

    /**
     * Add a new Task to the todolist.
     * @param newTask a new Task which has been created.
     */
    public void addNewTask(Task newTask) {
        this.todolist.add(newTask);
    }

    /**
     * Add a new Task to the todolist from user input.
     */
    public void addNewTaskFromInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title = input.nextLine();
        System.out.println("Enter project: ");
        String project = input.nextLine();
        System.out.println("Enter due date (format: yyyy-mm-dd): ");
        String dateString = input.nextLine();
        input.close();
        addNewTask(createNewTask(title, project, dateString);
    }


    /**
     * Remove a Task from the todolist by index.
     * @param index the index of the task in the todolist.
     */
    public void removeTask(int index) {
        todolist.remove(index);
    }

    /**
     * Remove a Task from the todolist by user input.
     */
    public void removeTaskFromInput() {
        System.out.println("Please choose the task number to remove:");
        printAll();
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        int index = Integer.parseInt(number) - 1;
        removeTask(index);
    }

    /**
     * Print all tasks in the todolist with number.
     */
    public void printAll() {
        int i = 0;
        for (Task task : todolist) {
            System.out.println("[" + (i + 1) + "]" + task.getDescription());
        }
    }

    /**
     * Sort the todolist by project name of tasks.
     */
    public void sortByProject() {
        Collections.sort(todolist, Task.ProjectComparator);
    }

    /**
     * Sort the todolist by due date of tasks.
     */
    public void sortByDate() {
        Collections.sort(todolist, Task.DateComparator);
    }


}