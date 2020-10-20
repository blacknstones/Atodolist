package sdaproject;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static String filename = "todofile.obj";


    public void createFile() {
        try {
            File newFile = new File(filename);
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeToFile(ArrayList<Task> todolist) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter br = new BufferedWriter(fileWriter);

            for (Task task : todolist) {
                br.write(task.toString());
            }
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("File not found" + e);
        }
    }

    public void readFromFile(ArrayList<Task> todolist) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader br = new BufferedReader(fileReader);
            br.readLine();
            fileReader.close();
        }
        catch (IOException e) {
            System.out.println("File not found" + e);
        }
    }
}
