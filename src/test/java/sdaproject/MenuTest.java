public class MenuTest {

    public void mainMenu(int todoCount, int doneCount)
    {
        System.out.println("Welcome to Atodolist");
        System.out.println("You have " + todoCount + " tasks todo and " + doneCount + " tasks are done!");
        mainOption();
        System.out.println("(5) Help");
    }

    public void mainOption()
    {
        System.out.println("Please choose one of the following options:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, marks as done, remove)");
        System.out.println("(4) Save and Quit");
    }

    public void addTaskMenu()
    {

    }

    public void showListMenu()
    {

    }

    public void EditTaskMenu()
    {

    }

    public void QuitMenu()
    {

    }
}
