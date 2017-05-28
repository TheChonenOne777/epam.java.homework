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
        this(name);
        setMonthOfBirth(monthOfBirth);
        setDayOfBirth(dayOfBirth);
        this.yearOfBirth = yearOfBirth;
    }

    public Actor(String name, String birthDate){
        this(name);
        String[] arr = birthDate.split("[/.-]");
        setMonthOfBirth(Integer.parseInt(arr[1]));
        setDayOfBirth(Integer.parseInt(arr[0]));
        this.yearOfBirth = Integer.parseInt(arr[2]);
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
        int m = getMonthOfBirth();
        if(m == 2) {
            if (dayOfBirth <= 28) this.dayOfBirth = dayOfBirth;
        } else if((m <= 7 && m % 2 == 0) || (m > 7 && m % 2 != 0)){
            if(dayOfBirth <= 30) this.dayOfBirth = dayOfBirth;
        } else {
            if(dayOfBirth <= 31) this.dayOfBirth = dayOfBirth;
        }
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        if(monthOfBirth > 0 && monthOfBirth <= 12) {
            this.monthOfBirth = monthOfBirth;
        }
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
