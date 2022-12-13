import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static private List<File> files;

    public static void main(String[] args) {
        listOfFiles("1", files);
        readFiles();
        }

    private static void readFiles() {
        String[] texts;
        for (File file:files){
            System.out.println();
            System.out.println(file.getName());
            try(Reader reader = new InputStreamReader(new FileInputStream(file))){
                char[] array = new char[128];
                int count = reader.read(array);
                StringBuilder result = new StringBuilder();
                while (count > 0) {
                result.append(new String(array, 0, count));
                count = reader.read(array);
                }
                texts = result.toString().split(" /n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for(String a: texts){
                System.out.print(a);
            }
        }
    }

    public static void listOfFiles(String directoryName, List<File> files) {
        File directory = new File(directoryName);
        if(directory.exists()) {
            File[] fList = directory.listFiles();
            if (fList != null) {
                for (File file : fList) {
                    if (file.isFile()) {
                        if (files == null) {
                            setFiles(new ArrayList<>());
                            getFiles().add(file);
                        } else {
                            getFiles().add(file);
                        }
                    } else if (file.isDirectory()) {
                        listOfFiles(file.getAbsolutePath(), getFiles());
                    }
                }
            }
            assert fList != null;
            for (File f : fList) {
                System.out.println(f.getName());
            }
        } else {
            System.out.println("Sorry, wrong name of directory!");
        }
    }
    public static List<File> getFiles() {
        return files;
    }

    public static void setFiles(List<File> files) {
        Main.files = files;
    }

}