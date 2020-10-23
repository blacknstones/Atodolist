package sdaproject;

import java.io.*;
import java.util.ArrayList;

/**
 * This class is part of the "Atodolist" application.
 * "Atodolist" is a text-based to-do-list tracker
 * that runs on the command line.
 *
 * This class writes the taskList into a file, and read it when the program restarts.
 *
 * @author Yanwei Zhu
 * @version 2020.10.23
 */
public class FileManager {

    private static String filename = "todolist.txt";

    /**
     * Write the taskList to a file to store it.
     * @param list The current taskList.
     */
    public void writeToFile(ArrayList<Task> list) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(list);
            output.close();
            file.close();
        }
        catch(IOException e) {
            System.out.println("File not found " +  e);
        }
    }

    /**
     * Read from file when program restarts.
     * @return The taskList stored in the file.
     */
    public ArrayList<Task> readFromFile() {
        ArrayList<Task> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream stream = new ObjectInputStream(file);
            list = (ArrayList<Task>) stream.readObject();
            stream.close();
            file.close();
        }
        catch(IOException  e)
        {
            System.out.println("File not found " +  e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("problems inside the file " + e);
        }
        return list;
    }
}
