package unit4.task4;


import java.io.Serializable;
import java.util.Objects;

public class Actor implements Serializable{

    private String name;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    public Actor() { }

    public Actor(String name) {
        this.name = name;
    }

    public Actor(String name, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return name +", born: " + dayOfBirth + "/" + monthOfBirth + "/" + yearOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return dayOfBirth == actor.dayOfBirth &&
                monthOfBirth == actor.monthOfBirth &&
                yearOfBirth == actor.yearOfBirth &&
                Objects.equals(name, actor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dayOfBirth, monthOfBirth, yearOfBirth);
    }
}
