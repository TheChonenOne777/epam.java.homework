package unit5;


import java.util.Scanner;

public class FileManagerMain {

    public static void main(String[] args) {

        FileManager fm = new FileManager();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to file manager, my dear user!");
        System.out.println("You can walk through catalogs, work with files and folders.");
        System.out.println("show - view all files and folders in current directory"); //add flags for folders and files
        System.out.println("goto path - move to specified path");
        System.out.println("open - start working with a file");
        System.out.println("delete item - delete specific item");
        System.out.println("to exit type exit");

        String input = scanner.nextLine();

        while(!"exit".equals(input)){

            input = scanner.nextLine();

            switch (input){
                case("show"):

                    break;

                case("goto"):
                    break;

                case("open"):
                    break;

                case("delete"):

                    break;

                default:
                case("help"):
                    System.out.println("show - view all files and folders in current directory"); //add flags for folders and files
                    System.out.println("goto path - move to specified path");
                    System.out.println("open - start working with a file");
                    System.out.println("delete item - delete specific item");
                    System.out.println("to exit type exit");
                    break;
            }

        }

    }

}

