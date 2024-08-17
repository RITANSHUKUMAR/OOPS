package shanu;

import java.util.*;

class STUDENT {
    // Member variables
    private String sname;
    private int[] marks_array;
    private int total;
    private double avg;

    // Constructor to assign initial values

    // Method to display STUDENT object
    public void display() {
        System.out.println("Student Name: " + sname);
        System.out.println("Marks: ");
        for (int mark : marks_array) 
            System.out.print(mark + "\t");
        
        System.out.println();
        System.out.println("Total: " + total);
        System.out.println("Average: " + avg);
    }

    // Method to compute total and average marks
    public void compute() {
        total = 0;
        for (int mark : marks_array)
            total += mark;
        
        avg = (double)total / marks_array.length;
    }

    // Method to assign initial values
    public void assign(String sname, int[] marks_array) {
        this.sname = sname;
        this.marks_array = marks_array;
    }

    // Method to format student name
    public void formatStudentName() {
        String[] words = sname.split(" ");
        sname = "";
        for (String word : words) {
            sname += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
        }
        sname = sname.trim(); // Remove trailing space
    }

    // Method to generate email
    public String generateEmail() {
        String[] words = sname.split(" ");
        String email = "";
        for (String word : words) {
            email += word.substring(0, 1).toLowerCase();
        }
        email += "@student.example.com";
        return email;
    }

    // Method to extract initials
    public String extractInitials() {
        String[] words = sname.split(" ");
        String initials = "";
        for (String word : words) {
            initials += word.substring(0, 1).toUpperCase();
        }
        return initials;
    }

    // Method to remove whitespace
    public void removeWhitespace() {
        sname = sname.replace(" ", "");
    }

    // Method to check if student name contains a particular substring
    public boolean containsSubstring(String substring) {
        return sname.contains(substring);
    }
}

public class L3Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<STUDENT> students = new ArrayList<>();
        
        while (true) {
            System.out.print("Enter student name (or 'quit' to stop): ");
            String str = sc.nextLine();
            if (str.equalsIgnoreCase("quit")) {
                break;
            }
            int n = sc.nextInt();
            int marks[] = new int[n];
            for (int i = 0; i < n; i++) {
                marks[i] = sc.nextInt();
            }
            STUDENT s1 = new STUDENT();
            s1.assign(str, marks);
            students.add(s1);
        }
        
        for (STUDENT student : students) {
            student.compute();
            student.display();
            System.out.println("Initials: " + student.extractInitials());
            student.removeWhitespace();
            System.out.println("Name without whitespace: " + student.sname);
            System.out.print("Enter a substring to search: ");
            String substring = sc.next();
            if (student.containsSubstring(substring)) {
                System.out.println("Student name contains the substring");
            } else {
                System.out.println("Student name does not contain the substring");
            }
            System.out.println();
        }
        
        // Sort the students alphabetically
        Collections.sort(students, new Comparator<STUDENT>() {
            @Override
            public int compare(STUDENT s1, STUDENT s2) {
                return s1.sname.compareTo(s2.sname);
            }
        });
        
        System.out.println("Sorted list of students:");
        for (STUDENT student : students) {
            student.display();
        }
    }
}