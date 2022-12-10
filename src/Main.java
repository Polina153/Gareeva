import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<File> files;

    public static void main(String[] args) {
        listOfFiles("1", files);
    }
    public static void listOfFiles(String directoryName, List<File> files) {
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        if (fList != null) {
            for (File file : fList) {
                if (file.isFile()) {
                    if (files == null) {
                        files = new ArrayList<File>();
                        files.add(file);
                    } else {
                        files.add(file);
                    }
                } else if (file.isDirectory()) {
                    listOfFiles(file.getAbsolutePath(), files);
                }
            }
        }
        for(File f: fList){
            System.out.println(f.getName());
        }
    }
        /*System.out.println(directory.exists());
        System.out.println(directory.isDirectory());
        File[] files = directory.listFiles();
        if(files != null){
        for (File file : files) {
            System.out.println(file.getName());
            if (file.isDirectory()) {

               *//* File[] filesLevel2 = file.listFiles();
                for (File file1 : filesLevel2) {
                    System.out.println(file1.getName());
                    System.out.println(file1.length());
                }*//*
            } else {
                *//*System.out.println(file.length());*//*
            }
        }*/
}