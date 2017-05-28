package unit4.task4;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MoviesCollection implements Serializable{

    private List<Movie> movies;

    public MoviesCollection(){
        movies = new ArrayList<>();
    }

    public MoviesCollection(List<Movie> movies) {
        this();
        Set<Movie> uniqueMovies = new HashSet<>(movies);
        this.movies.addAll(uniqueMovies);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public boolean addMovie(Movie movie){
        return movies.contains(movie) ? false : movies.add(movie);
    }

    public void removeMovie(Movie movie){
        movies.remove(movie);
    }

    public void removeMovie(int i){
        movies.remove(i);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MoviesCollection:\n");
        for(Movie movie : movies){
            sb.append(movie).append('\n');
            sb.append("Cast:\n");
            for(Actor actor : movie.getCast()){
                sb.append(actor).append('\n');
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
