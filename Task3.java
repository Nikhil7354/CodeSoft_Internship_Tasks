import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    private List<Student> students;
    private Scanner scanner;

    public Task3() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("----- Student Management System -----");
            System.out.println("1. Add a new student");
            System.out.println("2. Edit student information");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayStudents();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    private void addStudent() {
        System.out.println("----- Add a New Student -----");
        System.out.print("Enter the student's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the student's ID: ");
        String id = scanner.nextLine();

        Student student = new Student(name, id);
        students.add(student);

        System.out.println("Student added successfully.");
    }

    private void editStudent() {
        System.out.println("----- Edit Student Information -----");
        System.out.print("Enter the student's ID: ");
        String id = scanner.nextLine();

        Student student = findStudentByID(id);
        if (student != null) {
            System.out.print("Enter the new name: ");
            String newName = scanner.nextLine();
            student.setName(newName);

            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private void searchStudent() {
        System.out.println("----- Search for a Student -----");
        System.out.print("Enter the student's ID: ");
        String id = scanner.nextLine();

        Student student = findStudentByID(id);
        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private void displayStudents() {
        System.out.println("----- All Students -----");
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private Student findStudentByID(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Task3 system = new Task3();
        system.run();
    }
}

class Student {
    private String name;
    private String id;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id;
    }
}

