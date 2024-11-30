import java.util.ArrayList;
import java.util.Collections;

class Student {
    // Attributes
    String name;
    int studentId;
    ArrayList<Integer> grades;

    // Constructor
    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
        this.grades = new ArrayList<>();
    }

    // Method to add a grade
    public void addGrade(int grade) {
        grades.add(grade);
    }

    // Method to calculate average grade
    public double calculateAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / (double) grades.size();
    }

    // Method to find the highest grade
    public int findHighestGrade() {
        if (grades.isEmpty()) return -1;  // Indicates no grades available
        return Collections.max(grades);
    }

    // Method to find the lowest grade
    public int findLowestGrade() {
        if (grades.isEmpty()) return -1;  // Indicates no grades available
        return Collections.min(grades);
    }

    // Method to display grade report
    public void displayGradeReport() {
        System.out.println("Grade Report for Student: " + name);
        System.out.println("Student ID: " + studentId);
        System.out.println("Grades: " + grades);
        System.out.println("Average Grade: " + calculateAverageGrade());
        System.out.println("Highest Grade: " + findHighestGrade());
        System.out.println("Lowest Grade: " + findLowestGrade());
        System.out.println("-------------------------------------");
    }
}

public class StudentGradeManagementSystem {
    public static void main(String[] args) {
        // Create multiple Student objects and add grades
        Student student1 = new Student("John Doe", 101);
        student1.addGrade(85);
        student1.addGrade(90);
        student1.addGrade(78);

        Student student2 = new Student("Jane Smith", 102);
        student2.addGrade(92);
        student2.addGrade(88);
        student2.addGrade(79);
        student2.addGrade(95);

        Student student3 = new Student("Alice Johnson", 103);
        student3.addGrade(70);
        student3.addGrade(85);
        student3.addGrade(93);
        student3.addGrade(81);

        // Display grade reports for each student
        student1.displayGradeReport();
        student2.displayGradeReport();
        student3.displayGradeReport();
    }
}
