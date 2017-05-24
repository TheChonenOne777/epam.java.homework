package unit2.task5;


import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Subject java = new Subject(Subject.SubjectName.JAVA);
        Subject math = new Subject(Subject.SubjectName.MATH);
        Subject english = new Subject(Subject.SubjectName.ENGLISH);

        Student john = new Student("John");
        Student jess = new Student("Jess");
        Student monika = new Student("Monika");

        System.out.println("John: " + john + "\nJess: " + jess + "\nMonika: " + monika);
        System.out.println();

        john.addToGroup(java);
        john.addToGroup(math);
        jess.addToGroup(java);

        java.assignMark(john, new Mark<Double>(5.3));
        java.assignMark(john, new Mark<Double>(3.5));
        java.assignMark(john, new Mark<Double>(4.5));
        math.assignMark(john, new Mark<Integer>(4));
        math.assignMark(john, new Mark<Integer>(5));
        java.assignMark(jess, new Mark<Double>(4.5));
        java.assignMark(jess, new Mark<Double>(3.8));
        java.assignMark(jess, new Mark<Double>(7.1));

        System.out.println(john);

        System.out.println();

//        System.out.println(java);

        System.out.println();

        System.out.println(math);

        john.removeFromGroup(java);
//        java.removeStudent(john);

        System.out.println("john removed");

        System.out.println(john);

        System.out.println();

        System.out.println(java);

        System.out.println("Average mark for Jess in Java course: " + jess.getAverageOfSubjectMarks(java));

    }

}
