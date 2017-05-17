package unit2.task5;


import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Subject java = Subject.JAVA;
        Subject math = Subject.MATH;
        Subject english = Subject.ENGLISH;

        Student john = new Student("John");
        Student jess = new Student("Jess");
        Student monika = new Student("Monika");

        System.out.println("John: " + john + "\nJess: " + jess + "\nMonika: " + monika);

    }

}
