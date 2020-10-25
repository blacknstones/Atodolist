package sdaproject;

import org.junit.jupiter.api.*;
import java.time.DateTimeException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test class for Task.
 *
 * @author Yanwei Zhu
 * @Version 2020-10-16
 */

public class TaskTest {

    /**
     * Test if getTitle() method returns correct title.
     */
    @Test
    void getTitleTest() {
        Task task = new Task("test1", "project1", "2020-11-01");
        String result = task.getTitle();
        assertEquals(result, "test1");
    }

    /**
     * Test if setTitle() method sets the title correctly.
     */
    @Test
    void setTitleTest() {
        Task task = new Task("test1", "project1", "2020-11-01");
        task.setTitle("test2");
        String result = task.getTitle();
        assertEquals(result, "test2");
    }

    /**
     * Test if getProject() method returns correct project name.
     */
    @Test
    void getProjectTest() {
        Task task = new Task("test1", "project1", "2020-11-01");
        String result = task.getProject();
        assertEquals(result, "project1");
    }

    /**
     * Test if setProject() method sets the project name correctly.
     */
    @Test
    void setProjectTest() {
        Task task = new Task("test1", "project1", "2020-11-01");
        task.setProject("project2");
        String result = task.getProject();
        assertEquals(result, "project2");
    }

    /**
     * Test if an exception is thrown when setting empty title to a task.
     */
    @Test
    void setEmptyTitle() {
        Task task = new Task("test1", "project1", "2020-11-01");
        boolean findError = false;
        try {
            task.setTitle("");
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            findError = true;
        }

        assertEquals(true, findError);
    }

    /**
     * Test if an exception is thrown when setting a passed date to a task.
     */
    @Test
    void setPassedDate() {
        Task task = new Task("test1", "project1", "2020-11-01");
        boolean findError = false;
        try {
            // Today is 2020-10-25
            task.setDueDate("2020-10-24");
            fail("Expected an DateTimeException to be thrown");
        } catch (DateTimeException e) {
            findError = true;
        }
        assertEquals(true, findError);
    }


}

