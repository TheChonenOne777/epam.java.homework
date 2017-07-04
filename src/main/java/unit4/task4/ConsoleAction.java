package unit4.task4;


import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ConsoleAction {

    public static MoviesCollection action(MoviesCollection mc){

        //TODO: add while loops to guarantee strict behavior

        Scanner scanner = new Scanner(System.in);
        String input = "";

        System.out.println("Hello, my dear user!");
        printGuide();

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
                        int length = scanner.nextInt();
                        if(mc.addMovie(new Movie(movieName, length))){
                            System.out.println("Movie successfully added.");
                        } else {
                            System.out.println("Movie already exists");
                        }
                    } else if("actor".equals(input)){
                        System.out.println("What movie number would you like to add an actor to?");
                        printMovies(mc);
                        int movieNumber = scanner.nextInt() - 1;
                        System.out.println("Actor name?");
                        input = scanner.nextLine();
                        String actorName = scanner.nextLine();
                        System.out.println("Actor date of birth?");
                        String actorBirth = scanner.nextLine();
                        if(mc.getMovies().get(movieNumber).addActor(new Actor(actorName, actorBirth))){
                            System.out.println("Actor successfully added");
                        } else {
                            System.out.println("Actor already exists");
                        }
                    }
                    break;

                case("show"):
                    System.out.println(mc);
                    break;

                case("remove"):
                    System.out.println("Remove movie or actor?");
                    input = scanner.nextLine();
                    if("movie".equals(input)){
                        printMovies(mc);
                        System.out.println("Type a movie number you would like to remove");
                        mc.removeMovie(scanner.nextInt() - 1);
                    } else if("actor".equals(input)){
                        printMovies(mc);
                        System.out.println("Type a movie number you would like to remove an actor from");
                        int movieNumber = scanner.nextInt();
                        for(Actor actor : mc.getMovies().get(movieNumber).getCast()){
                            System.out.println((mc.getMovies().get(movieNumber).getCast().indexOf(actor) + 1) + ". " + actor);
                        }
                        System.out.println("Type a number of actor you would like to remove");
                        mc.getMovies().get(movieNumber).removeActor(scanner.nextInt() - 1);
                    }
                    break;

                default:
                case("help"):
                    printGuide();
                    break;
            }

        }

        return mc;
    }

    private static void printGuide() {
        System.out.println("To add movie or actor, type add");
        System.out.println("To remove movie or actor, type remove");
        System.out.println("To view all movies, type show");
    }

    private static void printMovies(MoviesCollection mc) {
        for(Movie movie : mc.getMovies()){
            System.out.println((mc.getMovies().indexOf(movie) + 1) + ". " + movie);
        }
    }

}
