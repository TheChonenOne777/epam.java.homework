package unit2.task5;


import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    Subject sbj;
    Student jess;
    Student john;

    @Before
    public void setUp(){
        sbj = new Subject(Subject.SubjectName.JAVA);
        jess = new Student("Jess");
        john = new Student("John");
    }

    @Test
    public void testAddStudentToGroupFrist(){
        Set<Student> students = new HashSet<>();
        Set<Subject> subjects = new HashSet<>();
        students.add(jess);
        subjects.add(sbj);

        jess.addToGroup(sbj);

        assertEquals(jess.getMarks().keySet(), subjects);
        assertEquals(sbj.getMarks().keySet(), students);
    }

    @Test
    public void testAddMoreStudentsToGroup(){
        Set<Student> students = new HashSet<>();
        Set<Subject> subjects = new HashSet<>();
        subjects.add(sbj);
        students.add(jess);
        students.add(john);

        jess.addToGroup(sbj);
        john.addToGroup(sbj);

        assertEquals(sbj.getMarks().keySet(), students);
        assertEquals(jess.getMarks().keySet(), subjects);
        assertEquals(john.getMarks().keySet(), subjects);
    }

    @Test
    public void testRemoveStudentFromGroup(){
        Set<Student> students = new HashSet<>();
        Set<Subject> subjects = new HashSet<>();
        jess.addToGroup(sbj);
        jess.removeFromGroup(sbj);
//        sbj.removeStudent(jess);

        assertEquals(subjects, jess.getMarks().keySet());
        assertEquals(students, sbj.getMarks().keySet());
    }

    @Test
    public void testAssignMarkToStudent(){
        jess.addToGroup(sbj);
        sbj.assignMark(jess, new Mark<Double>(5.3));
        Mark<Double> mark = new Mark<>(5.3);

        for(Map.Entry<Student, List<Mark>> pair : sbj.getMarks().entrySet()){
            if(pair.getKey().equals(jess)){
                assert (pair.getValue().contains(mark));
            }
        }
        for(Map.Entry<Subject, List<Mark>> pair : jess.getMarks().entrySet()){
            if(pair.getKey().equals(sbj)){
                assert (pair.getValue().contains(mark));
            }
        }
    }

    @Test
    public void testAssignSeveralMarksToStudent(){
        jess.addToGroup(sbj);
        sbj.assignMark(jess, new Mark<Double>(5.3));
        sbj.assignMark(jess, new Mark<Double>(5.1));
        sbj.assignMark(jess, new Mark<Double>(4.8));
        Mark<Double> mark1 = new Mark<>(5.3);
        Mark<Double> mark2 = new Mark<>(5.1);
        Mark<Double> mark3 = new Mark<>(4.8);

        for(Map.Entry<Student, List<Mark>> pair : sbj.getMarks().entrySet()){
            if(pair.getKey().equals(jess)){
                assert (pair.getValue().contains(mark1));
                assert (pair.getValue().contains(mark2));
                assert (pair.getValue().contains(mark3));
            }
        }
        for(Map.Entry<Subject, List<Mark>> pair : jess.getMarks().entrySet()){
            if(pair.getKey().equals(sbj)){
                assert (pair.getValue().contains(mark1));
                assert (pair.getValue().contains(mark2));
                assert (pair.getValue().contains(mark3));
            }
        }
    }

    @Test
    public void testRemoveStudentFromGroupWithMarks(){
        jess.addToGroup(sbj);
        sbj.assignMark(jess, new Mark<Double>(5.3));
        sbj.assignMark(jess, new Mark<Double>(5.5));
        sbj.assignMark(jess, new Mark<Double>(3.2));
        jess.removeFromGroup(sbj);

        Assert.assertNull(jess.getMarks().get(sbj));
        Assert.assertNull(sbj.getMarks().get(jess));
    }




}
