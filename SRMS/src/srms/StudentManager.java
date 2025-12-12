package srms;
import java.util.ArrayList;

       //DuplicateIDException class//
class DuplicateIDException extends Exception {
    public DuplicateIDException(String msg) {
        super(msg);
    }
}
public class StudentManager {
    
    private final ArrayList<Student> students;

    public ArrayList<Student> getStudents() {
        return students;
    }
    
    public StudentManager(){
        students = new ArrayList<>();
    }
         //add method
    public void addstudent(Student s) throws DuplicateIDException , IllegalArgumentException{
        if (s == null){
            throw new IllegalArgumentException("Student obj is null !");
        }
        if (s.getStudentId()<=0 ){
            throw new IllegalArgumentException("Student ID must be a positive number !");
        }
        if (s.getName() == null || s.getName().trim().isEmpty()){
            throw new IllegalArgumentException("Student Name cannot be empty !");
        }
        for(Student st : students){
            if(st.getStudentId() == s.getStudentId()){
              throw new DuplicateIDException("ID is already exists: "+ s.getStudentId());
            }
        }
        students.add(s);}
    
          //remove method//
    public void removeStudent(int id) throws Exception {
    for (Student s : students) {
        if (s.getStudentId() == id) {
            students.remove(s); 
            return;  }}
    throw new Exception("Student with ID " + id + " not found !");
}
          //update method//
   public void updateStudent(int id, Student newStudent) throws Exception{
       if (newStudent == null || newStudent.getName() == null || newStudent.getName().trim().isEmpty() ){
           throw new IllegalArgumentException("New student cannot be null or name cannot be empty !");}
       
       if (newStudent.getDepartment() == null || newStudent.getDepartment().trim().isEmpty() ){
            throw new IllegalArgumentException("Department cannot be empty !");}
  
       if (newStudent.getGpa() < 0.0 || newStudent.getGpa() >= 5.0) {
        throw new IllegalArgumentException("GPA must be between 0.0 and 5.0");
    }
       if (newStudent.getYear() <= 2003) {
       throw new IllegalArgumentException("Year must be after 2003 !");
    }
       for (Student s : students) {
        if (s.getStudentId() == id) {
            s.setName(newStudent.getName());
            s.setGpa(newStudent.getGpa());
            s.setDepartment(newStudent.getDepartment());
            s.setYear(newStudent.getYear());
            return;}}
    throw new Exception("Student with ID " + id + "is not found!");
}
           //search method//
   public Student searchStudent(int id) throws Exception {
    for (Student s : students) {
        if (s.getStudentId() == id) {
            return s;
        }}
    throw new Exception("Student with ID " + id + "is not found!");
}
         //sortbyGPA method//
   public void sortBYGPA() {
    if (students == null ||students.isEmpty()) {
        throw new NullPointerException("Student list is null!");
    }
    if (students.isEmpty()) {
        throw new IllegalStateException("No students to sort!");
    }
    for (int i = 0; i < students.size(); i++) {
        for (int j = i + 1; j < students.size(); j++) {
            Student student1 = students.get(i);
            Student student2 = students.get(j);

            if (student1.getGpa() < student2.getGpa()) {
                students.set(i, student2);
                students.set(j, student1);
            }
        }
    }
}
   } 
    

 