import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<Task> todolist;
    private Menu menu;
    private int toDoCount;
    private int doneCount;

    public ToDoList()
    {
        List<ToDoList> todolist = new ArrayList<>();
        menu = new Menu();

    }

    public void start()
    {
        menu.mainMenu(toDoCount, doneCount);
        //Scanner newScanner = new Scanner(System.in);
        //String option = newScanner.nextLine();
        //System.out.println("You entered option " + option);
    }


    public void addNewTask()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title = scan.nextLine();
        System.out.println("Enter project: ");
        String project = scan.nextLine();
        System.out.println("Enter due date (format: yyyy-mm-dd): ");
        String dateString = scan.nextLine();
        Task newTask = new Task(title, dateString, project);
        this.todolist.add(newTask);
    }


    public void removeTask()
    {

    }

    public void printAll()
    {
        todolist.forEach(task -> task.printDescription());
    }


    public void sortByDate()
    {
        List<String> dateArray = new ArrayList<>();
        
    }
}