package hu.jusoft.gerevet.domain.model;

/**
 * Created by Regina Seres on 12/11/2015.
 */
public class User {
    private final String userName;
    private final String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
}
