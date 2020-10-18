package sdaproject;
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
    private int toDoCount;
    private int doneCount;

    /**
     * Create the initial ToDoList.
     */
    public ToDoList() {
        List<ToDoList> todolist = new ArrayList<>();
    }

    /**
     * Create a new Task and return it.
     * The private access ensures that it can only be used within ToDoList class.
     * @param title The title of the task.
     * @param project The project name of the task.
     * @param dateString The date of the task as String.
     */
    protected Task createNewTask(String title, String project, String dateString) {
        Task newTask = new Task(title, project, dateString);
        return newTask;
    }

    /**
     * Add a new Task to the todolist.
     * @param newTask a new Task which has been created.
     */
    protected void addNewTask(Task newTask) {
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
        addNewTask(createNewTask(title, project, dateString));
    }


    /**
     * Remove a Task from the todolist by index.
     * @param index the index of the task in the todolist.
     */
    protected void removeTask(int index) {
        todolist.remove(index);
    }

    /**
     * Remove a Task from the todolist by user input.
     */
    public void removeTaskFromInput() {
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        int index = Integer.parseInt(number) - 1;
        removeTask(index);
        input.close();
    }

    public void editTask(Task task, String title, String project, String dateString) {
        task.setTitle(title);
        task.setProject(project);
        task.setDueDate(dateString);
    }

    public void editTaskFromInput() {
        System.out.println();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter title: ");
        String title = input.nextLine();
        System.out.println("Enter project: ");
        String project = input.nextLine();
        System.out.println("Enter due date (format: yyyy-mm-dd): ");
        String dateString = input.nextLine();
        input.close();



    }

    /**
     * Sort the todolist by project name of tasks.
     */
    protected void sortByProject() {
        Collections.sort(todolist, Task.ProjectComparator);
    }

    /**
     * Sort the todolist by due date of tasks in ascending order.
     */
    protected void sortByDate() {
        Collections.sort(todolist, Task.DateComparator);
    }

    /**
     * Print all tasks in the todolist with number in ascending order.
     */
    public void printAll() {
        int i = 0;
        for (Task task : todolist) {
            System.out.println("[" + (i + 1) + "]" + task.getDescription());
        }
    }

    /**
     * Display all tasks by project name in ascending order.
     */
    public void displayByProject() {
        sortByProject();
        printAll();
    }

    /**
     * Display all tasks by due date in ascending order.
     */
    public void displayByDate() {
        sortByDate();
        printAll();
    }


    /**
     * Set the count of tasks that haven't been done by user.
     */
    private void setToDoCount() {
        int count = 0;
        for (Task task : todolist) {
            if (task.getStatus() == false) {
                count++;
            }
        }
        this.toDoCount = count;
    }

    /**
     * Return the count of tasks that haven't been done by user.
     * @return The count of to-do tasks.
     */
    public int getToDoCount() {
        return toDoCount;
    }

    /**
     * Count the tasks that have been done by user.
     */
    private void setDoneCount() {
        int count = 0;
        for (Task task : todolist) {
            if (task.getStatus() == true) {
                count++;
            }
        }
        this.doneCount = count;
    }

    /**
     * Return the count of tasks that have been done by user.
     * @return The count of done tasks.
     */
    public int getDoneCount() {
        return doneCount;
    }


}