package srms;

import java.util.Scanner;

public class SRMSapp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Show Student sorted by gpa");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
            case 1 -> {
                try {
                    System.out.print("Enter ID: ");
                    int id = input.nextInt();
                    input.nextLine();
                    
                    System.out.print("Enter name: ");
                    String name = input.nextLine();
             
                    
                    System.out.print("Enter GPA: ");
                    String gpastr = input.nextLine();
                    gpastr = gpastr.replace(',', '.').replace(',', '.');
                    double gpa = Double.parseDouble(gpastr);
             
                    
                    System.out.print("Enter department: ");
                    String dept = input.nextLine();
                    
                    System.out.print("Enter year: ");
                    int year = input.nextInt();
                    Student s = new Student(id, name, gpa, dept, year);
                    input.nextLine();
                    manager.addStudent(s);
                    System.out.println("Student added successfully!");
                    manager.displayAllStudents(); 
                } catch (DuplicateIDException | IllegalArgumentException e) {
                    input.nextLine();
                    System.out.println(e.getMessage());}
                }
                 
                case 2 -> {
                    try {
                        System.out.print("Enter ID to update: ");
                        int uid = input.nextInt();
                        input.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = input.nextLine();
                        System.out.print("Enter new GPA: ");
                        String gpastr = input.nextLine();
                        gpastr = gpastr.replace(',', '.').replace(',', '.');
                        double newGpa = Double.parseDouble(gpastr);
                        input.nextLine();
                        System.out.print("Enter new department: ");
                        String newDept = input.nextLine();
                        System.out.print("Enter new year: ");
                        int newYear = input.nextInt();
                        Student newStudent = new Student(uid, newName, newGpa, newDept, newYear);
                        manager.updateStudent(uid, newStudent);
                        System.out.println("Student updated successfully!");
                        manager.displayAllStudents(); 
                    } catch (Exception e) {
                        System.out.println(e.getMessage()); }
                }
                 
                case 3 -> {
                    try {
                        System.out.print("Enter ID to remove: ");
                        int rid = input.nextInt();
                        manager.removeStudent(rid);
                        System.out.println("Student removed successfully!");
                        manager.displayAllStudents(); 
                    } catch (Exception e) {
                        System.out.println(e.getMessage());}
                }

                case 4 -> {
                    try {
                        System.out.print("Enter Student ID to search: ");
                        int sid = input.nextInt();
                        Student found = manager.searchStudent(sid);
                        System.out.println("Student Found:");
                        System.out.println("ID: " + found.getStudentId());
                        System.out.println("Name: " + found.getName());
                        System.out.println("GPA: " + found.getGpa());
                        System.out.println("Department: " + found.getDepartment());
                        System.out.println("Year: " + found.getYear());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());}
                }

                case 5 -> {
                    try {
                    if (manager.getStudents().isEmpty()) {
                    System.out.println(" No students to sort!");
                    break;}
                    manager.sortBYGPA();
                    System.out.println(" Students sorted by GPA successfully.");
                    manager.displayAllStudents(); 
                    } catch (IllegalStateException e) {
                    System.out.println(" Error: " + e.getMessage());}}

                case 6 -> {
                    System.out.println("Goodbye!");
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
