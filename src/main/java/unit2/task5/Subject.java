package unit2.task5;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Subject {

    MATH,
    ENGLISH,
    JAVA;

    private Map<Student, List<Mark>> marks;

    Subject() {
        this.marks = new HashMap<>();
    }

    public Map<Student, List<Mark>> getMarks() {
        return marks;
    }

    public void setMarks(Map<Student, List<Mark>> marks) {
        this.marks = marks;
    }

    public void assignMark(Student student, Mark mark){
        for(Map.Entry<Student, List<Mark>> studentMarks : marks.entrySet()){
            if(studentMarks.getKey().equals(student)){
                studentMarks.getValue().add(mark);
            }
        }
    }

}
