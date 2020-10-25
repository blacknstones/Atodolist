package sdaproject;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Formatter;

/**
 * This class is part of the "Atodolist" application.
 * "Atodolist" is a text-based to-do list tracker
 * that runs on the command line.
 *
 * This class is the main component of a ToDoList.
 * A Task contains title, project, due date, and completion status.
 * It implements Serializable interface so it can be sorted.
 *
 * @author Yanwei Zhu
 * @version 2020.10.16
 */

public class Task implements Serializable {
    private String title;
    private String project;
    private LocalDate dueDate;
    private boolean isComplete;


    /**
     * Create a task with title, date and project.
     * When a new task is created, the completion status is false by default,
     * indicating that it hasn't been completed by the user.
     * @param title The title of the task
     * @param project The project name of the task
     * @param dateString The due date of the task
     */
    public Task(String title, String project, String dateString) {
        this.setTitle(title);
        this.setProject(project);
        this.setDueDate(dateString);
        isComplete = false;
    }

    public Task() {
        isComplete = false;
    }
    /**
     * Define the title of a Task.
     * @param title The title of the task.
     */
    public void setTitle(String title) {
        //check if title input is empty
        if(title.trim().isEmpty()) {
            throw new IllegalArgumentException("You have to enter a title!");
        }
        this.title = title.trim();
    }

    /**
     * Return the title of a Task.
     * @return the title of the task.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Take a String input of project and set the project name of a Task.
     * @param project The project name of the task.
     */
    public void setProject(String project) {
        //check if title is legal
        if(project.trim().isEmpty()) {
            throw new IllegalStateException("You have to enter a project name!");
        }
        this.project = project.trim();
    }

    /**
     * Return the project name of a Task.
     * @return The project name of the task.
     */
    public String getProject() {
        return project;
    }

    /**
     * Take a String input of date, convert it to LocalDate,
     * and set the due date of a Task.
     * @param dateString a String in the format of date.
     */
    public void setDueDate(String dateString) {
        //check if date String is empty
        if(dateString.trim().isEmpty()) {
            throw new IllegalArgumentException("You have to enter a date!");
        }

        //check date string format
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parsedDate = LocalDate.parse(dateString, formatter);
            this.dueDate = parsedDate;

        }
        catch (DateTimeParseException e)
        {
            System.out.println("The format of the date is invalid, please try again.\n");
        }

        // check if date has passed the current time
        if(dueDate.compareTo(LocalDate.now()) < 0){
            throw new DateTimeException("The time you entered has passed, please try again.\n");
        }
    }

    /**
     * Return the due date of a Task.
     * @return The due date of a Task.
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Change the completion status as true.
     */
    public void markAsDone() {
        if (!isComplete) {
            isComplete = true;
        }
        // *** reconsider this printing method. is it necessary?
        else System.out.println("The task is already done!\n");
    }


    /**
     * Return the completion status of a Task.
     * @return Completion status: true or false.
     */
    public boolean getStatus() {
        return this.isComplete;
    }

    /**
     * Return the completion status of a Task as String.
     * @return Completion status: "Done", "Undone".
     */
    public String getStatusString() {
        if(isComplete)
            return "Done";
        else return "ToDo";
    }

    public void printDetail() {
        System.out.println("\nYour task:\n");

        String format = "%-20s %-15s %-12s %-8s %n";
        System.out.printf(format, "Title", "Project", "Due Date", "Status");
        System.out.println("--------------------------------------------------------");
        System.out.printf(format, getTitle(), getProject(),
                                         getDueDate(), getStatusString());
    }

    @Override
    public String toString() {
        return ("title=" + title + " project=" + project + " dueDate=" + dueDate + " iscomplete=" + isComplete);
    }

}

