package unit2.task5;


import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject {

    public enum SubjectName {

        MATH("Math algorithms"),
        ENGLISH("English verbal"),
        JAVA("Java Core");

        private String name;

        SubjectName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    private Map<Student, List<Mark>> marks;

    SubjectName name;

    public Subject(){
        marks = new HashMap<>();
    }

    public Subject(SubjectName name) {
        this.marks = new HashMap<>();
        this.name = name;
    }

    public Map<Student, List<Mark>> getMarks() {
        return marks;
    }

    public void setMarks(Map<Student, List<Mark>> marks) {
        this.marks = marks;
    }

    public SubjectName getName() {
        return name;
    }

    public void setName(SubjectName name) {
        this.name = name;
    }

    public void assignMark(Student student, Mark mark){
        for(Map.Entry<Student, List<Mark>> studentMarks : marks.entrySet()){
            if(studentMarks.getKey().equals(student)){
                studentMarks.getValue().add(mark);
                student.getMarks().put(this, studentMarks.getValue());
            }
        }
    }

    public void removeStudent(Student student){
        student.getMarks().remove(this);
        marks.remove(student);
    }

    public String toStringListOfMarks(){
        StringBuilder output = new StringBuilder();
        for(Map.Entry<Student, List<Mark>> pair : marks.entrySet()){
            output.append("\n" + pair.getKey().getName() + ": ");
            for(Mark mark : pair.getValue()){
                output.append(mark + " | ");
            }
        }
        return output.toString();
    }

    @Override
    public String toString() {
        return this.name.getName() + ": " + toStringListOfMarks();
    }
}
