package sdaproject;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private static String filename = "todolist.txt";

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
