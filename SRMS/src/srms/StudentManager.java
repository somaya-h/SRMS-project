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
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found in the system.");
            return;
        }
        System.out.println("\n=== All Students ===");
        System.out.println("Total students: " + students.size());
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }
         //add method
    public void addStudent(Student s) throws DuplicateIDException , IllegalArgumentException{
        if (s == null){
            throw new IllegalArgumentException("Student obj is null !");
        }
        if (s.getStudentId()<=0 ){
            throw new IllegalArgumentException("Student ID must be a positive number !");
        }
        if (s.getName() == null || s.getName().trim().isEmpty()){
            throw new IllegalArgumentException("Student Name cannot be empty !");
        }
         if (s.getGpa() < 0.0 || s.getGpa() > 5.0) {
        throw new IllegalArgumentException("GPA must be between 0.0 and 5.0!");
    }
         if (s.getYear() <= 1990) {
        throw new IllegalArgumentException("Year must be after 1990!");
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
  
       if (newStudent.getGpa() < 0.0 || newStudent.getGpa() > 5.0) {
        throw new IllegalArgumentException("GPA must be between 0.0 and 5.0");
    }
       if (newStudent.getYear() <= 1970) {
       throw new IllegalArgumentException("Year must be after 1990 !");
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
    if (students == null || students.isEmpty()) {
        throw new IllegalArgumentException("No student to sort!");
    }
    for (int i = 0; i < students.size()-1; i++) {
        for (int j = 0; j < students.size()-i -1; j++) {
            if(students.get(j).getGpa() < students.get(j+1).getGpa() ){
            Student temp = students.get(j);
            students.set(j , students.get(j+1));
            students.set(j + 1 , temp);} } }}} 
    

 