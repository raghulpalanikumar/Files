import java.util.ArrayList;
import java.util.Scanner;

// 🧩 Class 1: Student — blueprint for creating student objects
class Student {
    private String name;
    private int age;
    private String grade;

    // Constructor
    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getter methods
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGrade() { return grade; }

    // Display method
    public void display() {
        System.out.println("Name: " + name + " | Age: " + age + " | Grade: " + grade);
    }
}

// 🧩 Class 2: StudentManager — manages a list of students
class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String name, int age, String grade) {
        students.add(new Student(name, age, grade));
        System.out.println("✅ Student added successfully!");
    }

    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            s.display();
        }
    }

    public void removeStudent(String name) {
        boolean found = false;
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                students.remove(s);
                System.out.println("🗑️ Student removed successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Student not found!");
        }
    }
}

// 🧩 Class 3: Main — CLI interface
public class StudentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        System.out.println("===== SIMPLE STUDENT MANAGEMENT SYSTEM =====");

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();
                    manager.addStudent(name, age, grade);
                    break;

                case 2:
                    manager.showAllStudents();
                    break;

                case 3:
                    System.out.print("Enter student name to remove: ");
                    String removeName = sc.nextLine();
                    manager.removeStudent(removeName);
                    break;

                case 4:
                    System.out.println("👋 Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("❗ Invalid choice. Try again!");
            }
        }
    }
}
