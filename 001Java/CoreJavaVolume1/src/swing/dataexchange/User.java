package swing.dataexchange;

/**
 * User
 */
public class User {

    private String username;
    private char[] password;

    public User(String username, char[] password){
        this.username = username;
        this.password = password;
    }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * @return the password
     */
    public char[] getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(char[] password) {
        this.password = password;
    }
}