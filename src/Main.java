import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static private List<File> files;
    static private List<File> textFiles;


    public static void main(String[] args) {
        System.out.println("List of all files in directory 1: ");
        listOfFiles("1", files);
        System.out.println();
        System.out.println("Text files are: ");
        //filterFiles("1", getFilteredFiles());
        filteredFiles(files);
        readFiles(getTextFiles());
    }

    static void filteredFiles(List<File> files) {
        List<File> filteredFiles = new ArrayList<>();
        for (File f : files) {
            if (f.getName().endsWith(".txt")) {
                System.out.println(f.getName());
                filteredFiles.add(f);
            }
            setTextFiles(filteredFiles);
        }

    }

    static void filterFiles(String directoryName, List<File> filteredFiles) {
        /*if (fileFromDir.getName().endsWith(".txt")) {
            getTextFiles() textFiles.add(fileFromDir);
            setTextFiles(textFiles);
            *//*
         *//**//* directory.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File file, String s) {
                    return s.endsWith(".txt");
                }
            });*//**//*
            List<File> textFiles = List.of(Objects.requireNonNull(directory.listFiles()));
            setTextFiles(textFiles);*//*
        }*/

       /* File directory = new File(directoryName);
        if (directory.exists()) {
            File[] fList = directory.listFiles();
            if (fList != null) {
                for (File file : fList) {
                    if (file.isFile()) {
                        if (filteredFiles == null) {
                            setFilteredFiles(new ArrayList<>());
                            getFilteredFiles().add(file);
                        } else {
                            getFilteredFiles().add(file);
                        }

                    } else if (file.isDirectory()) {
                        filterFiles(file.getAbsolutePath(), getFilteredFiles());
                    }
                }
            }
            assert fList != null;
            for (File f : fList) {
                if (f.getName().endsWith(".txt")) {
                    getTextFiles().add(f);
                    setTextFiles(textFiles);
                }
            }
        } else {
            System.out.println("Sorry, wrong name of directory!");
        }*/
    }

    static void readFiles(List<File> listToRead) {
        String[] texts;
        for (File file : listToRead) {
            System.out.println();
            System.out.println(file.getName());
            try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
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
            System.out.println("Text from text files: ");
            for (String a : texts) {
                System.out.print(a);
            }
        }
    }

    static void listOfFiles(String directoryName, List<File> files) {
        File directory = new File(directoryName);
        if (directory.exists()) {
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

    static List<File> getFiles() {
        return files;
    }

    static void setFiles(List<File> files) {
        Main.files = files;
    }

    static List<File> getTextFiles() {
        return textFiles;
    }

    static void setTextFiles(List<File> textFiles) {
        Main.textFiles = textFiles;
    }
}