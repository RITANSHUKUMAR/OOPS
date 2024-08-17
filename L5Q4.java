import java.util.GregorianCalendar;
import java.util.Scanner;

class Student {
    private int registrationNumber;
    private String fullName;
    private GregorianCalendar dateOfJoining;
    private short semester;
    private float gpa;
    private float cgpa;
    private static int studentCount = 1;

    // Parameterized constructor
    public Student(String fullName, GregorianCalendar dateOfJoining, short semester, float gpa, float cgpa) {
        this.fullName = fullName;
        this.dateOfJoining = dateOfJoining;
        this.semester = semester;
        this.gpa = gpa;
        this.cgpa = cgpa;
        this.registrationNumber = generateRegistrationNumber(dateOfJoining);
        studentCount++;
    }

    // Method to generate registration number
    private int generateRegistrationNumber(GregorianCalendar dateOfJoining) {
        int year = dateOfJoining.get(GregorianCalendar.YEAR);
        return (year % 100) * 100 + studentCount;
    }

    // Method to display student record
    public void display() {
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Joining: " + dateOfJoining.getTime());
        System.out.println("Semester: " + semester);
        System.out.println("GPA: " + gpa);
        System.out.println("CGPA: " + cgpa);
        System.out.println();
    }

    // Method to sort student records by semester and CGPA
    public static void sortStudentsBySemesterAndCGPA(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].semester > students[j].semester) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                } else if (students[i].semester == students[j].semester) {
                    if (students[i].cgpa < students[j].cgpa) {
                        Student temp = students[i];
                        students[i] = students[j];
                        students[j] = temp;
                    }
                }
            }
        }
    }

    // Method to sort student records by name
    public static void sortStudentsByName(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].fullName.compareTo(students[j].fullName) > 0) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }
}

public class L5Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        // Create an array of student records
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");

            System.out.print("Enter full name: ");
            String fullName = scanner.nextLine();

            System.out.print("Enter year of joining: ");
            int year = scanner.nextInt();
            System.out.print("Enter month of joining (0-11): ");
            int month = scanner.nextInt();
            System.out.print("Enter day of joining: ");
            int day = scanner.nextInt();
            GregorianCalendar dateOfJoining = new GregorianCalendar(year, month, day);

            System.out.print("Enter semester: ");
            short semester = scanner.nextShort();

            System.out.print("Enter GPA: ");
            float gpa = scanner.nextFloat();

            System.out.print("Enter CGPA: ");
            float cgpa = scanner.nextFloat();

            scanner.nextLine(); // Consume newline left-over

            students[i] = new Student(fullName, dateOfJoining, semester, gpa, cgpa);
        }

        // Display original records
        System.out.println("Original Records:");
        for (Student student : students) {
            student.display();
        }

        // Sort and display records by semester and CGPA
        Student.sortStudentsBySemesterAndCGPA(students);
        System.out.println("Records sorted by semester and CGPA:");
        for (Student student : students) {
            student.display();
        }

        // Sort and display records by name
        Student.sortStudentsByName(students);
        System.out.println("Records sorted by name:");
        for (Student student : students) {
            student.display();
        }
    }
}