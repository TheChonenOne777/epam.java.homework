package unit4.task4;


import java.io.*;

public class SerializationMain {

    public static void main(String[] args) {

        MoviesCollection moviesCollection = new MoviesCollection();

        File file = new File("movieCollection.txt");
        checkFile(file);

        if(file.exists()){
//            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
//
//                moviesCollection = (MoviesCollection) ois.readObject();
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
            moviesCollection = deserializeMovieCollection(file);       //doesn't work, moviesCollection is empty

        } else {
            addTestMovies(moviesCollection);
        }

        System.out.println(moviesCollection);

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
        Actor actor1 = new Actor("Robert");
        Actor actor2 = new Actor("Bradley");
        Actor actor3 = new Actor("Emma");
        Movie movie1 = new Movie("Who is who");
        Movie movie2 = new Movie("Act of nothing");

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
