package unit2.task5;

import java.util.*;

public class Student {

    private String name;
    private int id;
    private static int idCounter = 0;
    private Map<Subject, List<Mark>> marks;

    public Student(){
        id = ++idCounter;
        marks = new HashMap<>();
    }

    public Student(String name){
        id = ++idCounter;
        this.name = name;
        marks = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Map<Subject, List<Mark>> getMarks() {
        return marks;
    }

    public void setMarks(Map<Subject, List<Mark>> marks) {
        this.marks = marks;
    }

    /**
     * Retruns a list of Marks for this student for particular subject.
     * @param sbj - subject to be inspected for this student
     * @return - List of marks of particular subject of this student
     */
    public List<Mark> getMarksOfSubject(Subject sbj){
        List<Mark> markList = new ArrayList<>();

        for(Map.Entry<Subject, List<Mark>> markInSubject : marks.entrySet()){
            if(markInSubject.getKey() == sbj){
                markList = markInSubject.getValue();
            }
        }

        return markList;
    }

    public void addToGroup(Subject sbj){
        marks.put(sbj, this.getMarksOfSubject(sbj));
        sbj.getMarks().put(this, this.getMarksOfSubject(sbj));
    }

    public void removeFromGroup(Subject sbj){
        marks.remove(sbj);
        sbj.getMarks().remove(this);
    }



    public String toStringListOfMarks(){
        StringBuilder output = new StringBuilder();
        for(Map.Entry<Subject, List<Mark>> pair : marks.entrySet()){
            output.append("\n" + pair.getKey().getName().getName() + ": ");
            for(Mark mark : pair.getValue()){
                output.append(mark + " | ");
            }
        }
        return output.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(marks, student.marks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, marks);
    }

    @Override
    public String toString() {
        return "ID: " + id
                + "; Name: " + name
                + "; Marks: " + toStringListOfMarks();
    }
}
