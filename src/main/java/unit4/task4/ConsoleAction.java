package unit4.task4;


import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleAction {

    public static MoviesCollection action(MoviesCollection mc){

        Scanner scanner = new Scanner(System.in);
        String input = "";
        while(!"exit".equals(input)){

            input = scanner.nextLine();

            switch (input){
                case("add"):
                    System.out.println("Add a movie or an actor?");
                    input = scanner.nextLine();
                    if("movie".equals(input)){
                        System.out.println("Movie name?");
                        input = scanner.nextLine();
                        String movieName = input;
                        System.out.println("Movie length in minutes?");
                        input = scanner.nextLine();
                        int length = Integer.parseInt(input);
                        mc.addMovie(new Movie(movieName, length));
                        System.out.println("Movie successfully added.");
                    }
                    break;

                case("show"):
                    System.out.println(mc);
                    break;

                default:
                case("help"):
                    System.out.println("Hello, my dear user!");
                    break;
            }

        }

        return mc;
    }

}
