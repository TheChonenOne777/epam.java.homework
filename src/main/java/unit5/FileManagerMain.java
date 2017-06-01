package unit5;


import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileManagerMain {

    public static void main(String[] args) {

        FileManager fm = new FileManager();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to file manager, my dear user!");
        System.out.println("You can walk through catalogs, work with files and folders.");
        System.out.println("show [all/files/folders] - view all elements or files or folders in current directory");
        System.out.println("goto path - move to specified path");
        System.out.println("back - move to previous catalog");
        System.out.println("open - start working with a file");
        System.out.println("delete item - delete specific item");
        System.out.println("to exit type exit");

        String input = scanner.nextLine();

        while(!"exit".equals(input)){

            input = scanner.nextLine();
            int indexOfSpace = input.indexOf(' ');
            String command = input.substring(0, indexOfSpace);
            String argument = input.substring(indexOfSpace + 1);

            switch (command){
                case("show"):
                    switch (argument){
                        case("all"):
                            showAll(fm);
                            break;

                        case("files"):
                            showFiles(fm);
                            break;

                        case("folders"):
                            showDirectories(fm);
                            break;

                        default:
                            System.out.println("cannot recognize argument " + argument);
                    }
                    break;

                case("goto"):
                    if(!fm.moveToDirectory(argument)){
                        System.out.println("cannot recognize argument " + argument);
                    }
                    break;

                case("back"):
                    if(!fm.moveBack()){
                        System.out.println("on the root already");
                    }
                    break;

                case("open"):
                    String[] fileNames = fm.getFileNames();
                    for (int i = 0; i < fileNames.length; i++) {
                        System.out.println(i + ". " + fileNames[i]);
                    }
                    System.out.println("Choose a file number to work with");
                    int numberOfFileToOpen = scanner.nextInt();
                    String fileName = fileNames[numberOfFileToOpen];
                    if(fm.checkFile(fileName)) {
                        System.out.println("All lines will be added to the file.");
                        System.out.println("/read - get current content of the file");
                        System.out.println("/exit - exit edit mode");
                        input = scanner.nextLine();
                        while(!"/exit".equals(input)){
                            input = scanner.nextLine();
                            if("/read".equals(input)){
                                readFileContent(fm);
                                break;
                            }
                            try {
                                fm.writeToFile(input);
                            } catch (IOException e) {
                                System.out.println("can't write to file");
                                e.printStackTrace();
                            }
                        }
                    } else {
                        System.out.println("File doesn't exist or it's not a file");
                    }
                    break;

                case("delete"):
                    String[] itemsNames = fm.getAllFileNames();
                    for (int i = 0; i < itemsNames.length; i++) {
                        System.out.println(i + ". " + itemsNames[i]);
                    }
                    System.out.println("What file would you like to delete? Type a number.");
                    int numberOfItemToBeDeleted = scanner.nextInt();
                    if(fm.delete(itemsNames[numberOfItemToBeDeleted])){
                        System.out.println("successfully deleted");
                    } else{
                        System.out.println("can't delete file");
                    }
                    break;

                default:
                case("help"):
                    System.out.println("show [all/files/folders] - view all elements or files or folders in current directory");
                    System.out.println("goto path - move to specified path");
                    System.out.println("open - start working with a file");
                    System.out.println("delete item - delete specific item");
                    System.out.println("to exit type exit");
                    break;
            }

        }

    }

    private static void readFileContent(FileManager fm) {
        try {
            for(String s : fm.getFileContent()){
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("can't read from file");
            e.printStackTrace();
        }
    }

    public static void showDirectories(FileManager fileManager){
        for (String f : fileManager.getFolderNames()) {
            System.out.println(f);
        }
    }

    public static void showFiles(FileManager fileManager){
        for (String f : fileManager.getFileNames()) {
            System.out.println(f);
        }
    }

    public static void showAll(FileManager fileManager){
        for (String f : fileManager.getAllFileNames()) {
            System.out.println(f);
        }
    }

}

