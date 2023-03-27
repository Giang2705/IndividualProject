/**
 * @author Nguyen Thi Ha Giang - S3914108
 */
public class Admin extends User{
//    Getter and Setter
    @Override
    public boolean isAdmin() {
        return true;
    }

    public boolean adminLogin(String username, String password) {
        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin123")){
            return true;
        }
        return false;
    }
}
