/**
 * @author Nguyen Thi Ha Giang - S3914108
 */

import java.util.ArrayList;

public class Crossword extends Puzzle {
    private String[] hints;
    public Crossword() {
    }
    public Crossword(String name, int level, int point, ArrayList<UserModel> usersList, String[] hints) {
        super(name, level, point, usersList);
        this.hints = hints;
    }

    public void setHints(String[] hints) {
        this.hints = hints;
    }

    public String[] getHints() {
        return hints;
    }

    public void displayBoard() {
        System.out.println("-----------Crossword Game-------------");
    }



}
