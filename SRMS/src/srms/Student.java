package srms;

//student class//

public class Student {
    private int studentId;
    private String name;
    private double gpa;
    private String department;
    private int year;

    public Student() {}

    public Student(int studentId, String name, double gpa, String department, int year) {
        this.studentId = studentId;
        this.name = name;
        this.gpa = gpa;
        this.department = department;
        this.year = year;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "ID: " + studentId +
               ", Name: " + name +
               ", GPA: " + gpa +
               ", Department: " + department +
               ", Year: " + year;
    }
}

