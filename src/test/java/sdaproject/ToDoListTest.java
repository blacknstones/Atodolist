package sdaproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test class for ToDoList.
 * Methods that requires user input are not tested in this class.
 *
 * @author Yanwei Zhu
 * @Version 2020-10-25
 */

public class ToDoListTest {

    @Test
    void addTaskTest() {
        ToDoList todo = new ToDoList();
        Task t1 = new Task("test1", "project5", "2020-11-03");
        Task t2 = new Task("test2", "project1", "2020-11-05");
        Task t3 = new Task("test3", "project4", "2020-11-06");
        Task t4 = new Task("test4", "project6", "2020-11-02");
        Task t5 = new Task("test5", "project2", "2020-11-04");
        Task t6 = new Task("test6", "project3", "2020-11-01");
        todo.addTask(t1);
        todo.addTask(t2);
        todo.addTask(t3);
        todo.addTask(t4);
        todo.addTask(t5);
        todo.addTask(t6);

        int result = todo.getTaskList().size();
        assertEquals(result, 6);
    }
    @Test
    void sortByProjectTest() {
        ToDoList todo = new ToDoList();
        Task t1 = new Task("test1", "project5", "2020-11-03");
        Task t2 = new Task("test2", "project1", "2020-11-05");
        Task t3 = new Task("test3", "project4", "2020-11-06");
        Task t4 = new Task("test4", "project6", "2020-11-02");
        Task t5 = new Task("test5", "project2", "2020-11-04");
        Task t6 = new Task("test6", "project3", "2020-11-01");
        todo.addTask(t1);
        todo.addTask(t2);
        todo.addTask(t3);
        todo.addTask(t4);
        todo.addTask(t5);
        todo.addTask(t6);
        todo.sortByProject();
        ArrayList<Task> list = todo.getTaskList();
        int[] sortedIndex = {list.indexOf(t1), list.indexOf(t2),list.indexOf(t3),
                            list.indexOf(t4), list.indexOf(t5), list.indexOf(t6)};
        int[] expectedIndex = {4, 0, 3, 5, 1, 2};
        assertArrayEquals(sortedIndex, expectedIndex);
    }

    @Test
    void sortByDateTest() {
        ToDoList todo = new ToDoList();
        Task t1 = new Task("test1", "project5", "2020-11-03");
        Task t2 = new Task("test2", "project1", "2020-11-05");
        Task t3 = new Task("test3", "project4", "2020-11-06");
        Task t4 = new Task("test4", "project6", "2020-11-02");
        Task t5 = new Task("test5", "project2", "2020-11-04");
        Task t6 = new Task("test6", "project3", "2020-11-01");
        todo.addTask(t1);
        todo.addTask(t2);
        todo.addTask(t3);
        todo.addTask(t4);
        todo.addTask(t5);
        todo.addTask(t6);

        todo.sortByDate();
        ArrayList<Task> list = todo.getTaskList();
        int[] sortedIndex = {list.indexOf(t1), list.indexOf(t2),list.indexOf(t3),
                list.indexOf(t4), list.indexOf(t5), list.indexOf(t6)};
        int[] expectedIndex = {2, 4, 5, 1, 3, 0};
        assertArrayEquals(sortedIndex, expectedIndex);
    }

    @Test
    void removeTaskTest() {
        ToDoList todo = new ToDoList();
        Task t1 = new Task("test1", "project5", "2020-11-03");
        Task t2 = new Task("test2", "project1", "2020-11-05");
        Task t3 = new Task("test3", "project4", "2020-11-06");
        Task t4 = new Task("test4", "project6", "2020-11-02");
        Task t5 = new Task("test5", "project2", "2020-11-04");
        Task t6 = new Task("test6", "project3", "2020-11-01");
        todo.addTask(t1);
        todo.addTask(t2);
        todo.addTask(t3);
        todo.addTask(t4);
        todo.addTask(t5);
        todo.addTask(t6);

        todo.removeTask(3);
        ArrayList<Task> list = todo.getTaskList();
        int result = list.indexOf(t4);
        assertEquals(result, -1);
    }

    @Test
    void getCorrectToDoCount() {
        ToDoList todo = new ToDoList();
        Task t1 = new Task("test1", "project5", "2020-11-03");
        Task t2 = new Task("test2", "project1", "2020-11-05");
        Task t3 = new Task("test3", "project4", "2020-11-06");
        Task t4 = new Task("test4", "project6", "2020-11-02");
        Task t5 = new Task("test5", "project2", "2020-11-04");
        Task t6 = new Task("test6", "project3", "2020-11-01");
        todo.addTask(t1);
        todo.addTask(t2);
        todo.addTask(t3);
        todo.addTask(t4);
        todo.addTask(t5);
        todo.addTask(t6);
        t1.markAsDone();
        t2.markAsDone();

        int result = todo.getToDoCount();
        assertEquals(result, 4);

    }

    @Test
    void getCorrectDoneCount() {
        ToDoList todo = new ToDoList();
        Task t1 = new Task("test1", "project5", "2020-11-03");
        Task t2 = new Task("test2", "project1", "2020-11-05");
        Task t3 = new Task("test3", "project4", "2020-11-06");
        Task t4 = new Task("test4", "project6", "2020-11-02");
        Task t5 = new Task("test5", "project2", "2020-11-04");
        Task t6 = new Task("test6", "project3", "2020-11-01");
        todo.addTask(t1);
        todo.addTask(t2);
        todo.addTask(t3);
        todo.addTask(t4);
        todo.addTask(t5);
        todo.addTask(t6);
        t1.markAsDone();
        t2.markAsDone();

        int result = todo.getDoneCount();
        assertEquals(result, 2);

    }

}





