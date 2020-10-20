package sdaproject;

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
    public ArrayList<Task> taskList;
    private ArrayList<Task> taskList;
    private int toDoCount;
    private int doneCount;
    private Scanner input;

    /**
     * Create the initial ToDoList.
     */
    public ToDoList() {
        todolist = new ArrayList<>();
    }


    /**
     * Add a new Task to the todolist from user input.
     */
    public void addTaskFromInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title = input.nextLine();
        System.out.println("Enter project: ");
        String project = input.nextLine();
        System.out.println("Enter due date (format: yyyy-mm-dd): ");
        String dateString = input.nextLine();
        input.close();
        Task newTask = new Task(title, project, dateString);
        taskList.add(newTask);
        System.out.println("Your task:");
        newTask.printDetail();
        System.out.println("is added to the list.");
    }



    private void updateTask(Task task, String title, String project, String dateString) {
        task.setTitle(title);
        task.setProject(project);
        task.setDueDate(dateString);
    }

    public void updateTaskFromInput(int taskIndex) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new title: ");
        String title = input.nextLine();
        System.out.println("Enter new project: ");
        String project = input.nextLine();
        System.out.println("Enter new due date (format: yyyy-mm-dd): ");
        String dateString = input.nextLine();
        input.close();
        updateTask(taskList.get(taskIndex), title, project, dateString);
        System.out.println("Your task:");
        taskList.get(taskIndex).printDetail();
        System.out.println("is now up to date.");


    }

    /**
     * Sort the todolist by project name of tasks.
     */
    protected void sortByProject() {
        Collections.sort(taskList, (t1, t2) -> {
            if (t1.getProject() == null || t2.getProject() == null)
                return 0;
            return t1.getProject().compareTo(t2.getProject());
        });
    }

    /**
     * Sort the todolist by due date of tasks in ascending order.
     */
    protected void sortByDate() {
        Collections.sort(taskList, (t1, t2) -> {
            if (t1.getDueDate() == null || t2.getDueDate() == null)
                return 0;
            return t1.getDueDate().compareTo(t2.getDueDate());
        });
    }

    /**
     * Print all tasks in the todolist with number in ascending order.
     */
    public void printAll() {
        int i = 0;
        for (Task task : taskList) {
            System.out.println("[" + (i + 1) + "]" + task.getDescription());
            i++;
        }
    }

    /**
     * Display all tasks by project name in ascending order.
     */
    public void showList(int sortBy) {
        if (sortBy == 1) {
            sortByProject();
            printAll();
        }

        if (sortBy == 2) {
            sortByDate();
            printAll();
        }
    }

    /**
     * Select the task to edit by user input.
     * @return The index of the selected task in todolist.
     */
    public int selectTaskFromInput() {
        Scanner input = new Scanner(System.in);
        int taskNumber = input.nextInt();
        if (taskNumber < 1 || taskNumber > this.taskList.size()) {
            throw new ArrayIndexOutOfBoundsException("the task number doesn't exist. please enter a valid number!");
        }
        int taskIndex = taskNumber - 1;
        return taskIndex;
    }

    public void editTaskFromInput(int taskIndex) {
        Scanner input = new Scanner(System.in);
        int editOption = input.nextInt();
        switch (editOption) {
            case 1:
                updateTaskFromInput(taskIndex);
                break;
            case 2:
                taskList.get(taskIndex).markAsDone();
                break;
            case 3:
                removeTask(taskIndex);
                break;
        }
    }

    public

    /**
     * Remove a Task from the todolist by index.
     * @param index the index of the task in the todolist.
     */
    protected void removeTask(int index) {
        todolist.remove(index);
    }

    /**
     * Set the count of tasks that haven't been done by user.
     */
    private void setToDoCount() {
        int count = 0;
        for (Task task : taskList) {
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
        for (Task task : taskList) {
            if (task.getStatus() == true) {
                count++;
            }
        }
        doneCount = count;
    }

    /**
     * Return the count of tasks that have been done by user.
     * @return The count of done tasks.
     */
    public int getDoneCount() {
        return doneCount;
    }




}