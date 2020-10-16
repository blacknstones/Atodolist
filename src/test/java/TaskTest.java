import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TaskTest {
    private String title;
    private LocalDate dueDate;
    private boolean isComplete;
    private String project;

    public TaskTest(String title, String dateString, String project)
    {
        this.setTitle(title);
        this.setDueDate(dateString);
        this.setProject(project);
        isComplete = false;
    }

    public void setTitle(String title)
    {
        //check if title input is empty
        if(title.trim().isEmpty()) {
            throw new IllegalArgumentException("You have to enter a title!");
        }
        this.title = title.trim();
    }

    public String getTitle()
    {
        return title;
    }


    public void setDueDate(String dateString)
    {
        //check there is date input
        if(dateString.trim().isEmpty()) {
            throw new IllegalStateException("You have to enter a date!");
        }

        //check date string format
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parsedDate = LocalDate.parse(dateString, formatter);
            this.dueDate = parsedDate;

        }
        catch (DateTimeParseException e)
        {
            System.out.println("The format of the date is invalid, please try again");
        }

        // check if date has passed
        if(dueDate.compareTo(LocalDate.now()) < 0){
            throw new DateTimeException("The time you entered has passed!");
        }

    }


    public LocalDate getDueDate()
    {
        return dueDate;
    }

    public void setProject(String project)
    {
        //check if title is legal
        if(project.trim().isEmpty()) {
            throw new IllegalStateException("You have to enter a project name!");
        }
        this.project = project.trim();
    }

    public String getProject()
    {
        return project;
    }


    public void markAsDone()
    {
        if (!isComplete)
            isComplete = true;
        // *** reconsider this printing method. is it necessary?
        else System.out.println("The task is already done!");
    }

    public void markAsUndone()
    {
            isComplete = false;
    }

    public boolean getStatus()
    {
        return this.isComplete;
    }

    public String getStatusString()
    {
        if(isComplete)
            return "Done";
        else return "ToDo";
    }

    public void printDescription()
    {
        System.out.println("Title: " + getTitle());
        System.out.println("Due Date: " + getDueDate());
        System.out.println("Project: " + getProject());
        System.out.println("Status: " + getStatusString());
    }

    public TaskTest createNewTask()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title = scan.nextLine();
        System.out.println("Enter project: ");
        String project = scan.nextLine();
        System.out.println("Enter due date (format: yyyy-mm-dd): ");
        String date = scan.nextLine();
        TaskTest newTask = new TaskTest(title,date,project);
        return newTask;
    }


}

