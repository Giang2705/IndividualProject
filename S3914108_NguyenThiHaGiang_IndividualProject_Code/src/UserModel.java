/**
 * @author Nguyen Thi Ha Giang - S3914108
 */

public class UserModel {
    private String username;
    private Puzzle gameJoined;

    public UserModel() {

    }
    public UserModel(String username, Puzzle gameJoined) {
        this.username = username;
        this.gameJoined = gameJoined;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Puzzle getGameJoined() {
        return gameJoined;
    }

    public void setGameJoined(Puzzle gameJoined) {
        this.gameJoined = gameJoined;
    }

}
