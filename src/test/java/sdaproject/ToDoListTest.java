package sdaproject;

import org.junit.jupiter.api.*;


/**
 * Test class for ToDoList.
 *
 * @author Yanwei Zhu
 * @Version 2020-10-16
 */

public class ToDoListTest {

    @Test
    void sortByProjectTest() {
        ToDoList todo = new ToDoList();
        Task t1 = new Task("laundry", "life", "2020-11-11");
        Task t2 = new Task("water plants", "life", "2020-12-12");
        todo.addNewTask(t1);
        todo.addNewTask(t1);
        todo.displayByProject();
    }
    }





}