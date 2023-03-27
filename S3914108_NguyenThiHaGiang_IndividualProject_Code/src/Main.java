import java.util.Scanner;

/**
 * @author Nguyen Thi Ha Giang - S3914108
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------------------------- Online Shopping ----------------------------------------");
        System.out.println("| 1. Don't have an account? Register.                                                           |");
        System.out.println("| 2. Login (Already had an account).                                                            |");
        System.out.println("| 3. Exit.                                                                                      |");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.print("Please choose 1 of 3 options above (input a number 1, 2 or 3): ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                System.out.println("Thank you for joining our system!");
                break;
        }
    }
}