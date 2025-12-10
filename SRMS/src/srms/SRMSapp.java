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
            System.out.println("5. Show All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter name: ");
                    String name = input.nextLine();

                    System.out.print("Enter GPA: ");
                    double gpa = input.nextDouble();
                    input.nextLine();

                    System.out.print("Enter department: ");
                    String dept = input.nextLine();

                    System.out.print("Enter year: ");
                    int year = input.nextInt();

                    Student s = new Student(id, name, gpa, dept, year);
                    manager.addstudent(s);
                    break;

                case 2:
                    System.out.print("Enter ID to update: ");
                    int uid = input.nextInt();
                    manager.updateStudent(uid);
                    break;

                case 3:
                    System.out.print("Enter ID to remove: ");
                    int rid = input.nextInt();
                    manager.removeStudent(rid);
                    break;

                case 4:
                    System.out.print("Enter ID to search: ");
                    int sid = input.nextInt();
                    manager.searchStudent(sid);
                    break;

                case 5:
                    manager.showAllStudents();
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
