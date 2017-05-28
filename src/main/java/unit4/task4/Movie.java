package unit4.task4;


import java.io.Serializable;
import java.util.*;

public class Movie implements Serializable {

    private String name;
    private int length;
    private List<Actor> cast;

    public Movie(){
        cast = new ArrayList<>();
    }

    public Movie(String name) {
        this();
        this.name = name;
    }

    public Movie(String name, int length) {
        this(name);
        this.length = length;
    }

    public Movie(String name, int length, List<Actor> cast) {
        this(name, length);
        this.length = length;
        Set<Actor> uniqueActors = new HashSet<>(cast);
        this.cast.addAll(uniqueActors);
    }

    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean addActor(Actor actor){
        return cast.contains(actor) ? false : cast.add(actor);
    }

    public void removeActor(Actor actor){
        cast.remove(actor);
    }

    public void removeActor(int i){
        cast.remove(i);
    }

    @Override
    public String toString() {
        return "\"" + getName() + "\", " + getLength() + " mins";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return length == movie.length &&
                Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length);
    }
}
