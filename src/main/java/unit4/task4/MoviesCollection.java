package unit4.task4;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class MoviesCollection implements Serializable{

    private Set<Movie> movies;

    public MoviesCollection(){
        movies = new HashSet<>();
    }

    public MoviesCollection(Set<Movie> movies) {
        this();
        this.movies = movies;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public void removeMovie(Movie movie){
        movies.remove(movie);
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
