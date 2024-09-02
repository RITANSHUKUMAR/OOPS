import java.util.*;

class EMPLOYEE {
    String Ename;
    int Eid;
    double Basic;
    double DA;
    double Gross_Sal;
    double Net_Sal;

    // Method to read employee details
    void read() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        this.Ename = scanner.nextLine();
        System.out.print("Enter Employee ID: ");
        Eid = scanner.nextInt();
        System.out.print("Enter Basic Salary: ");
        Basic = scanner.nextDouble();
    }

    // Method to display employee details
    void display() {
        System.out.println("Employee Name: " + Ename);
        System.out.println("Employee ID: " + Eid);
        System.out.println("Basic Salary: " + Basic);
        System.out.println("DA: " + DA);
        System.out.println("Gross Salary: " + Gross_Sal);
        System.out.println("Net Salary: " + Net_Sal);
    }

    // Method to compute net salary
    void compute_net_sal() {
        DA = 0.52 * Basic;
        Gross_Sal = Basic + DA;
        Net_Sal = Gross_Sal - (0.30 * Gross_Sal);
    }

    // Method to format employee name
    void formatEmployeeName() {
        String[] words = Ename.split(" ");
        Ename = "";
        for (String word : words) {
            Ename += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
        }
        Ename = Ename.trim(); // Remove trailing space
    }

    // Method to generate email
    String generateEmail() {
        // Assuming the name is in "FirstName LastName" format
        String[] words = Ename.split(" ");
        String firstNameInitial = words[0].substring(0, 1).toLowerCase();
        String lastName = words[1].toLowerCase();
        String email = firstNameInitial + lastName + "@example.com";
        return email;
    }
}

public class L5Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        EMPLOYEE[] employees = new EMPLOYEE[N];

        for (int i = 0; i < N; i++) {
            employees[i] = new EMPLOYEE();
            System.out.println("Enter details of employee " + (i + 1) + ":");
            employees[i].read();
            employees[i].formatEmployeeName();
            employees[i].compute_net_sal();
            employees[i].display();
            System.out.println("Email: " + employees[i].generateEmail());
            System.out.println();
        }
    }
}
