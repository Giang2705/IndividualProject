import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------------Welcome to Puzzle Games------------------------------");
        System.out.println("|                                      MENU                                       |");
        System.out.println("|               1. Crossword Game                                                 |");
        System.out.println("|               2. Sudoku Game                                                    |");
        System.out.println("|               3. Trivia Game                                                    |");
        System.out.println("|               4. Support system (Guide to use application                       |");
        System.out.println("|               5. Exit                                                           |");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.print("Please choose 1 of 5 options: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        String choice = "";

        while (input != 5) {
            switch (input) {
                case 1:
                    choice = "crossword";
                    Puzzle puzzle = new Puzzle();
                    puzzle.display(choice);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    Support support = new Support();
                    support.guide();
                    break;
            }
            System.out.print("Please choose 1 of 5 options in the menu above: ");
            input = new Scanner(System.in).nextInt();
        }
        System.out.println("Thank you for enjoying the application!");
    }
}