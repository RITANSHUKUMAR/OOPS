import java.util.*;

class STUDENT {
   
    String sname;
     int[] marks_array;
     int total;
     double avg;

  

    public void display() {
        System.out.println("Student Name: " + sname);
        System.out.println("Marks: ");
        for (int mark : marks_array)
            System.out.print(mark + "\t");

        System.out.println();
        System.out.println("Total: " + total);
        System.out.println("Average: " + avg);
    }

    
    public void compute() {
        total = 0;
        for (int mark : marks_array)
            total += mark;

        avg = (double) total / marks_array.length;
    }

   
    public void assign(String sname, int[] marks_array) {
        this.sname = sname;
        this.marks_array = marks_array;
    }

    // Method to extract initials from the student's name
    public String extractInitials() {
        String[] parts = sname.split(" ");
        StringBuilder initials = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                initials.append(part.charAt(0));
            }
        }
        return initials.toString().toUpperCase();
    }

    // Method to remove whitespace from the student's name
    public String removeWhitespace() {
        return sname.replaceAll("\\s", "");
    }

    // Static method to find and display student names containing a particular substring
    public static void displayNamesContaining(STUDENT[] students, String substring) {
        System.out.println("Students containing substring \"" + substring + "\":");
        for (STUDENT student : students) {
            if (student.sname.contains(substring)) {
                System.out.println(student.sname);
            }
        }
    }

    // Static method to sort students alphabetically by their names
    public static void sortAlphabetically(STUDENT[] students) {
        Arrays.sort(students, (s1, s2) -> s1.sname.compareTo(s2.sname));
    }
}



public class L5Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of students:");
        int numStudents = sc.nextInt();
        sc.nextLine(); // Consume newline

        STUDENT[] students = new STUDENT[numStudents];

        // Example of adding students
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter student name:");
            String name = sc.nextLine();
            System.out.println("Enter number of subjects:");
            int n = sc.nextInt();
            int[] marks = new int[n];
            System.out.println("Enter marks:");
            for (int j = 0; j < n; j++) {
                marks[j] = sc.nextInt();
            }
            sc.nextLine(); // Consume newline
            
            STUDENT student = new STUDENT();
            student.assign(name, marks);
            student.compute();
            students[i] = student;
        }

        // Example usage of new methods
        for (STUDENT student : students) {
            System.out.println("Initials of " + student.sname + ": " + student.extractInitials());
            System.out.println("Name without whitespace: " + student.removeWhitespace());
        }

        System.out.println("Enter substring to filter student names:");
        String substring = sc.nextLine();
        STUDENT.displayNamesContaining(students, substring);

        STUDENT.sortAlphabetically(students);
        System.out.println("Students sorted alphabetically:");
        for (STUDENT student : students) {
            student.display();
        }

        sc.close();
    }
}
