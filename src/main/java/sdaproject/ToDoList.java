package sdaproject;
import java.util.Scanner;
import java.util.*;

/**
 * This class is part of the "Atodolist" application.
 * "Atodolist" is a text-based to-do-list tracker
 * that runs on the command line.
 * <p>
 * This class is the main component of the application:
 * it stores all tasks, and allows users to manipulate.
 *
 * @author Yanwei Zhu
 * @version 2020.10.16
 */

public class ToDoList {
    private ArrayList<Task> taskList;
    private int toDoCount;
    private int doneCount;

    /**
     * Create the initial ToDoList.
     */
    public ToDoList(ArrayList<Task> list) {
        taskList = list;
    }

    /**
     * Return the taskList.
     * @return Current taskList.
     */
    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    /**
     * Create a task from user input.
     * @return The task created by user.
     */
    public Task createTaskFromInput() {
        Scanner input = new Scanner(System.in);
        //try {
            System.out.print("Enter title >> ");
            String title = input.nextLine();

            System.out.print("Enter project >> ");
            String project = input.nextLine();

            System.out.print("Enter due date (format: yyyy-mm-dd) >> ");
            String dateString = input.nextLine();

            Task newTask = new Task(title, project, dateString);
        //input.close();
        return newTask;
    }

    /**
     * Select task from user input.
     * @return The index of the task selected by user.
     */
    public int selectTaskFromInput() {
        System.out.println("Enter the task number >>");
        Scanner input = new Scanner(System.in);
        int taskIndex = input.nextInt();
        if (taskIndex < 0 || taskIndex > taskList.size()) {
            throw new ArrayIndexOutOfBoundsException("The task doesn't exist, please try again!");
        }
        //input.close();
        return taskIndex;
    }

    /**
     * Update task information.
     * @param index The index of the task in tasklist to be updated.
     */
    public void updateTask(int index) {
        taskList.set(index, createTaskFromInput());
    }

    /**
     * Add new task to the tasklist.
     */
    public void addTask() {
        taskList.add(createTaskFromInput());
    }

    /**
     * Sort the taskList by project name of tasks.
     */
    protected void sortByProject() {
        Collections.sort(taskList, (t1, t2) -> {
            if (t1.getProject() == null || t2.getProject() == null)
                return 0;
            return t1.getProject().compareTo(t2.getProject());
        });
    }

    /**
     * Sort the taskList by due date of tasks in ascending order.
     */
    protected void sortByDate() {
        Collections.sort(taskList, (t1, t2) -> {
            if (t1.getDueDate() == null || t2.getDueDate() == null)
                return 0;
            return t1.getDueDate().compareTo(t2.getDueDate());
        });
    }

    /**
     * Print all tasks in the taskList with number in ascending order.
     */
    public void printAll() {
        System.out.println("Title    " + "Project   " + "Due Date   " + "status");
        int i = 0;
        for (Task task : taskList) {
            System.out.println("[" + (i + 1) + "]  " + task.getDescription());
            i++;
        }
    }

    /**
     * Take user input and display all tasks by project or date.
     */
    public void showList() {
        if (taskList.size() == 0) {
            System.out.println("Your list is empty.");
        } else {
            Scanner input = new Scanner(System.in);
            int sortBy = input.nextInt();

            switch (sortBy) {
                case 1:
                    sortByProject();
                    printAll();
                    break;
                case 2:
                    sortByDate();
                    printAll();
                    break;
                default:
                    break;
            }
            // input.close();
        }
    }


    /**
     * Allow the user to choose edit task options: update, mark as done, remove.
     * @param taskIndex The index of the task to be edited.
     */
    public void editTask(int taskIndex) {
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch (option) {

            // Update task
            case 1:
                updateTask(taskIndex);
                System.out.println("Your task is now up to date.");
                break;

            // Mark as done
            case 2:
                taskList.get(taskIndex).markAsDone();
                System.out.println("Your task is now done! Good job!");
                break;

            // Remove task
            case 3:
                removeTask(taskIndex);
                System.out.println("Your task is now removed from the list.");
                break;

            default:
                break;
        }
        //input.close();
    }

    /**
     * Remove a Task from the todolist by index.
     * @param index the index of the task in the todolist.
     */
    protected void removeTask(int index) {
        taskList.remove(index);
    }

    /**
     * Return the count of tasks that haven't been done by user.
     * @return The count of to-do tasks.
     */
    public int getToDoCount() {
        int count = 0;
        for (Task task : taskList) {
            if (task.getStatus() == false) {
                count++;
            }
        }
        return count;
    }

    /**
     * Return the count of tasks that have been done by user.
     * @return The count of done tasks.
     */
    public int getDoneCount() {
        int count = 0;
        for (Task task : taskList) {
            if (task.getStatus()) { //task.getStatus() == true
                count++;
            }
        }
        return count;
    }

    /**
     * Return the total count of tasks in tasklist.
     * @return The total count of tasks.
     */
    public int getTaskCount() {
        return taskList.size();
    }
}