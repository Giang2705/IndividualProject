/**
 * @author Nguyen Thi Ha Giang - S3914108
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    ArrayList<UserModel> listOfUsers = new ArrayList<>();

    public void addUser(){
        UserModel user = new UserModel();
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        user.setUsername(name);
        listOfUsers.add(user);

        displayGamesMenu(user.getUsername());
    }
    public void displayListOfUsers(){
        for (int i = 0; i < listOfUsers.size(); i++){
           System.out.println("User: " + listOfUsers.get(i).getUsername());
        }
    }
    public void displayMainMenu(){
        System.out.println("------------------------------Welcome to Puzzle Games------------------------------");
        System.out.println("|                                      MENU                                       |");
        System.out.println("|               1. New account                                                    |");
        System.out.println("|               2. Have an account yet                                            |");
        System.out.println("-----------------------------------------------------------------------------------");

        System.out.print("Please choose 1 of 2 options (input number from 1 to 2): ");

        String input = scanner.nextLine();
        if (input.equals("1")){
            addUser();

        } else if (input.equals("2")){
            displayListOfUsers();
        }
    }

    public void displayGamesMenu(String username){
        System.out.println("------------------------------Welcome " + username + "----------------------------------------");
        System.out.println("|                                   ALL GAMES                                     |");
        System.out.println("|               1. Crossword Game                                                 |");
        System.out.println("|               2. Sudoku Game                                                    |");
        System.out.println("|               3. Trivia Game                                                    |");
        System.out.println("|               4. Support system (Guide to use application                       |");
        System.out.println("|               5. Go to main menu                                                |");
        System.out.println("-----------------------------------------------------------------------------------");

        System.out.print("Please choose 1 of 5 options in the menu above (input number from 1 to 5): ");

        String input = new Scanner(System.in).nextLine();
        String choice = "";

        while (!input.equals("5")) {
            switch (input) {
                case "1":
                    choice = "crossword";
                    Puzzle puzzle = new Puzzle();
                    puzzle.display(choice);
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    Support support = new Support();
                    support.guide();
                    break;
            }
            System.out.print("Please choose 1 of 5 options in the menu above (input number from 1 to 5): ");
            input = new Scanner(System.in).nextLine();
        }

        System.out.println("Moving to main menu...");
        displayMainMenu();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.displayMainMenu();
    }
}