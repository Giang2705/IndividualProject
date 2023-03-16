import java.util.ArrayList;

public class Puzzle {
    private String name;
    private int level;
    private int point;
    private ArrayList<UserModel> usersList;

    public Puzzle() {

    }

    public Puzzle(String name, int level, int point, ArrayList<UserModel> usersList) {
        this.name = name;
        this.level = level;
        this.point = point;
        this.usersList = usersList;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public ArrayList<UserModel> getUsersList() {
        return usersList;
    }

    public void setUsersList(ArrayList<UserModel> usersList) {
        this.usersList = usersList;
    }

    public void display(String choice) {
        if (choice.toLowerCase().equals("crossword")){
            Crossword crossword = new Crossword();
            crossword.displayBoard();
        }
    }

    public void updateState (String action) {

    }

    public boolean isEndState() {

        return false;
    }
}
