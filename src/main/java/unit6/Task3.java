package unit6;


import java.util.ArrayList;
import java.util.List;

public class Task3 {

    class MedicalStaff{}
    class Doctor extends MedicalStaff{}
    class Nurse extends MedicalStaff{}
    class HeadDoctor extends Doctor{}

    public void test(){
        //Ok, ref type is same as object type
        Doctor doc = new Doctor();

        //Not ok, because Doctor extends MedicalStaff
        //Doctor doc2 = new MedicalStaff();

        //Ok, type of reference is parent of object type
        Doctor doc3 = new HeadDoctor();

        //Ok, Object is parent of all classes
        Object obj = new HeadDoctor();

        //Not ok, trying to assign parent type of object to its child type reference
        //HeadDoctor doc4 = new Object();

        //Not ok, Nurse is not a child of Doctor
        //Doctor doc5 = new Nurse();

        //Not ok, same thing as previous
        //Nurse nurse = new Doctor();

        //Ok, reference is Object type
        Object nurse2 = new Nurse();

        //Ok, ArrayList implements List
        List<Doctor> list = new ArrayList<Doctor>();

        /*
        Not ok, Objects in list must be same type to guarantee safety of types
        List<MedicalStaff> list2 = new ArrayList<Doctor>();
        List<Doctor> list3 = new ArrayList<MedicalStaff>();
        List<Object> list4 = new ArrayList<Doctor>();
         */

        //Ok, List and ArrayList has same types inside
        List<Object> list5 = new ArrayList<Object>();

    }

}
