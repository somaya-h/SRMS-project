
package srms;
import java.util.ArrayList;


public class ReportGenerator {
private StudentManager manager;

    public ReportGenerator(StudentManager manager) {
        this.manager = manager;
    }

    public void generateReportByGPA(){
    ArrayList<Student> list = manager.getStudents();
    
        System.out.println("GPA report");
        
        for(Student s : list){
            System.out.println("ID:" + s.getStudentId() +
            "Name:" + s.getName() +
                    "GPA:" + s.getGpa() );
        }
    }
    public void generateReportByDepartment(String dept){
    ArrayList<Student> list = manager.getStudents();
        System.out.println("Department report:" + dept);
        
        for(Student s : list){
            if(s.getDepartment().equalsIgnoreCase(dept)){
            System.out.println("ID:" + s.getStudentId() +
            "Name:" + s.getName() +
                    "GPA:" + s.getGpa() );}
        }
     
    }
    public void generateReportByYear(int year){
     ArrayList<Student> list = manager.getStudents();
        System.out.println("Year report:" + year);
        
         for(Student s : list){
            if(s.getYear() == year){
            System.out.println("ID:" + s.getStudentId() +
            "Name:" + s.getName() +
                    "GPA:" + s.getGpa() );}
        }
     
    }
    
    }
    

