import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = scanner.next();
        String output = addCommas(input);
        System.out.println("Input String : " + input);
        System.out.println("Output String : " + output);
    }

    public static String addCommas(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (!Character.isDigit(str.charAt(i))) {
                return "Invalid input. Please enter a number.";
            }
            sb.append(str.charAt(i));
            count++;
            if (count % 3 == 0 && i != 0) {
                sb.append(",");
            }
        }
        return sb.reverse().toString();
    }
}