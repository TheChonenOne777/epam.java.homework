package unit4.task4;


import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class SerializationMain {

    public static void main(String[] args) {

        MoviesCollection moviesCollection = new MoviesCollection();

        File file = new File("movieCollection.txt");
        checkFile(file);

        if(file.exists()){
            moviesCollection = deserializeMovieCollection(file);
        } else {
            addTestMovies(moviesCollection);
        }

        moviesCollection = ConsoleAction.action(moviesCollection);


        serializeMovieCollection(moviesCollection, file);

    }


    private static void serializeMovieCollection(MoviesCollection moviesCollection, File file) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){

            oos.writeObject(moviesCollection);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addTestMovies(MoviesCollection mc) {
        Actor actor1 = new Actor("Robert", 23, 4, 1969);
        Actor actor2 = new Actor("Bradley", 13, 5, 1988);
        Actor actor3 = new Actor("Emma", 29, 3, 1992);
        Movie movie1 = new Movie("Who is who", 95);
        Movie movie2 = new Movie("Act of nothing", 121);

        movie1.addActor(actor1);
        movie1.addActor(actor2);
        movie2.addActor(actor1);
        movie2.addActor(actor3);

        mc.addMovie(movie1);
        mc.addMovie(movie2);
    }

    private static void checkFile(File file) {
        if(file.exists() && !file.canRead()){
            throw new IllegalArgumentException("File is corrupted " + file);
        }
    }

    private static MoviesCollection deserializeMovieCollection(File file) {

        MoviesCollection mc = new MoviesCollection();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){

            mc = (MoviesCollection) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return mc;
    }

}
