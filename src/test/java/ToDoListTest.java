package SDAproject;

import org.junit.jupiter.api.*;


/**
 * Test class for ToDoList.
 *
 * @author Yanwei Zhu
 * @Version 2020-10-16
 */

public class ToDoListTest {

    @Test
    void sortByProjectTest {
        ToDoList todo = new ToDoList();
        Task t1 = new Task("laundry", "life", "2020-11-11");
        todo.addNewTask(t1);
    }
    }





}