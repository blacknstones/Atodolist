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

    /**
     * Create the initial ToDoList.
     */
    public ToDoList(ArrayList<Task> list) {
        this.taskList = list;
    }

    /**
     * Initiate an empty ToDoList.
     */
    public ToDoList() {
        this.taskList = new ArrayList<>();
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
        Task newTask = new Task();
        while (true) {
            try {
                System.out.print("Enter title >> ");
                String title = input.nextLine();
                newTask.setTitle(title);

                System.out.print("Enter project >> ");
                String project = input.nextLine();
                newTask.setProject(project);

                System.out.print("Enter due date (format: yyyy-mm-dd) >> ");
                String dateString = input.nextLine();
                newTask.setDueDate(dateString);

            } catch (Exception e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return newTask;
    }

    /**
     * Select task from user input.
     * @return The index of the task selected by user.
     */
    public int selectTaskFromInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the task number >>");
        int taskNumber = input.nextInt();
        int taskIndex = taskNumber - 1;
        if (taskIndex < 0 || taskIndex > taskList.size()) {
            throw new ArrayIndexOutOfBoundsException("The task doesn't exist, please try again.\n");
        }
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
    public void addTaskFromInput() {
        Task task = createTaskFromInput();
        taskList.add(task);
        task.printDetail();
        System.out.println(" has been added to the list.\n");
    }

    public void addTask(Task task) {
        taskList.add(task);
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
     * This method is only called when the list is not empty.
     */
    public void printAll() {
        String format = "%-10s %-20s %-15s %-12s %-8s %n";
        System.out.printf(format, "Number", "Title", "Project", "Due Date", "Status");
        System.out.println("-------------------------------------------------------------------");
        for (Task task : taskList) {
            System.out.printf(format,"["+ (taskList.indexOf(task)+1) +"]",
                    task.getTitle(), task.getProject(),
                    task.getDueDate(), task.getStatusString());
        }
        System.out.println("");
    }

    /**
     * Take user input and display all tasks by project or date.
     */
    public void showList() {
        if (taskList.isEmpty()) {
            System.out.println("Your list is empty.\n");
            return;
        } else {
            System.out.println("Show Task List by:");
            System.out.println("(1) Date");
            System.out.println("(2) project\n>> ");
            Scanner input = new Scanner(System.in);
            int sortBy = input.nextInt();

            switch (sortBy) {
                case 1:
                    sortByDate();
                    printAll();
                    break;
                case 2:
                    sortByProject();
                    printAll();
                    break;
                default:
                    break;
            }
        }
    }


    /**
     * Allow the user to choose edit task options: update, mark as done, remove.
     * @param taskIndex The index of the task to be edited.
     */
    public void editTaskFromInput(int taskIndex) {
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch (option) {

            // Update task
            case 1:
                updateTask(taskIndex);
                taskList.get(taskIndex).printDetail();
                System.out.println("is now up to date.\n");
                break;

            // Mark as done
            case 2:
                taskList.get(taskIndex).markAsDone();
                taskList.get(taskIndex).printDetail();
                System.out.println("is now done! Good job!\n");
                break;

            // Remove task
            case 3:

                removeTask(taskIndex);
                System.out.println("Your task is now removed from the list.\n");
                break;

            default:
                break;
        }
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



}