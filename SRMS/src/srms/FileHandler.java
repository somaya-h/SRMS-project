package srms;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public void saveToFile(ArrayList<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Student s : students) {
                writer.println(
                        s.getStudentId() + "," +
                        s.getName() + "," +
                        s.getGpa() + "," +
                        s.getDepartment() + "," +
                        s.getYear()
                );
            }
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    public void loadFromFile(StudentManager manager) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                int studentId = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                double gpa = Double.parseDouble(data[2].trim());
                String department = data[3].trim();
                int year = Integer.parseInt(data[4].trim());

                Student s = new Student(studentId, name, gpa, department, year);
                manager. addStudent(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        } catch (Exception e) {
            System.out.println("Invalid data");
        }
    }
}

