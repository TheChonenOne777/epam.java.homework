package unit5;


import java.io.File;
import java.util.Scanner;

public class FileManagerMain {

    public static void main(String[] args) {

        FileManager fm = new FileManager();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to file manager, my dear user!");
        System.out.println("You can walk through catalogs, work with files and folders.");
        System.out.println("show [all/files/folders] - view all elements or files or folders in current directory");
        System.out.println("goto path - move to specified path");
        System.out.println("open - start working with a file");
        System.out.println("delete item - delete specific item");
        System.out.println("to exit type exit");

        String input = scanner.nextLine();

        while(!"exit".equals(input)){

            input = scanner.nextLine();
            int indexOfSpace = input.indexOf(' ');
            String command = input.substring(0, indexOfSpace);
            String argument = input.substring(indexOfSpace, input.length());

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

                case("open"):

                    break;

                case("delete"):
                    
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

