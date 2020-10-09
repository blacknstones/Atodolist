import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestClass {
/*
    @Test
    @DisplayName("Test 1")
    void etgflr(){
        System.out.println("This is a test");
    }

    @Test
    @DisplayName("Test 2")
    void pgkrjed(){
        System.out.println("This is a test");
    }

    @BeforeAll
    static void beforeAllMethods(){
        System.out.println("print before running other methods");
    }

    @AfterAll
    static void afterAllMethods(){
        System.out.println("print after running other methods");
    }

    @AfterEach
    void printBeforeEach(){
        System.out.println("print");
    }*/

    @Test
    void testTaskDate() {
        Task task = new Task("laundry", "2020-10-01", "life");
        LocalDate result = task.getDueDate();
        System.out.println(result);
        //assertEquals("2020-10-01", result);
    }





}
