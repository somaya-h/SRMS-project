package srms;
import java.util.ArrayList;

       //DuplicateIDException class
class DuplicateIDException extends Exception {
    public DuplicateIDException(String msg) {
        super(msg);
    }
}
public class StudentMangager {
    
    private ArrayList<Student> students;
    
    public StudentMangager(){
        students = new ArrayList<>();
    }
         //add method
    public void addstudent(Student s) throws DuplicateIDException , IllegalArgumentException{
        if (s == null){
            throw new IllegalArgumentException("Student obj is null !");
        }
        if (s.getstudentID()<=0 ){
            throw new IllegalArgumentException("Student ID must be a positive number !");
        }
        if (s.getname() == null || s.getname().trim().isEmpty()){
            throw new IllegalArgumentException("Student Name cannot be empty !");
        }
        for(Student st : students){
            if(st.getstudentID() == s.getstudentID()){
              throw new DuplicateIDException("ID is already exists: "+ s.getstudentID());
            }
        }
        students.add(s);}
    
          //remove method
    public void removeStudent(int id) throws Exception {
    for (Student s : students) {
        if (s.getStudentID() == id) {
            students.remove(s); 
            return;  
        }
    }
    throw new Exception("Student with ID " + id + " not found!");
}
    
}
