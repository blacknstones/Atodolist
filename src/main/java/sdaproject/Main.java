package sdaproject;

import com.sun.tools.javac.comp.Todo;

import java.util.Scanner;


/**
 * This class is the main class which runs the application.
 *
 * @author Yanwei Zhu
 * @version 2020-10-20
 *
 */

public class Main {
    private ToDoList todolist;
    private Menu menu;
    private FileManager fileManager;

    /**
     *
     */
    public void setUp() {
        todolist = new ToDoList();
        menu = new Menu();
        fileManager = new FileManager();
    }

    /**
     * start
     */
    public void run() {
        menu.welcomeMenu(todolist.getToDoCount(), todolist.getDoneCount());
        menu.mainOptionMenu();

        try {
            Scanner input = new Scanner(System.in);
            int menuOption = input.nextInt();

            switch (menuOption) {
                case 1:
                    menu.showListOption();
                    todolist.showList(input.nextInt());
                    break;

                case 2:
                    menu.addTaskMenu();
                    todolist.addTaskFromInput();
                    break;

                case 3:
                    todolist.printAll();
                    todolist.selectTaskFromInput();
                    menu.editTaskMenu();
                    int selected = todolist.selectTaskFromInput();
                    todolist.editTaskFromInput(selected);
                    //add success message here
                case 4:
                    fileManager.writeToFile(todolist.taskList);
                    menu.
                    break;
            }

        } catch(Exception e) {
            System.out.println("error");
        }
        }

    }

    public static void main(String args[])
    {


    }
}

