package Javaproject;

import java.io.File;
import java.io.IOException;

public class ListOfFiles {

    public static void listOfFiles1(File dirpath) {

        File[] files = dirpath.listFiles();

        if (files == null) return;

        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else {
                listOfFiles1(file);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        File file = new File(".");
        listOfFiles1(file);
    }
}