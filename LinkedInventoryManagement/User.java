package LinkedInventoryManagement;

//Samuel Osezua SOO190000

/**
 * User
 */
public class User implements Comparable<User> {
    //TODO: add necessary fields to your program
    private String username;
    private String hashedPassword;
    private String fName;
    private String lName;
    private boolean isManager;



    public User(){

    }


    public User(String username, String hashedPassword, boolean isManager)
    {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.isManager = isManager;

    }

    public User(String firstName, String lastName, String username, String hashedPassword, boolean isManager)
    {
        this.fName = firstName;
        this.lName = lastName;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.isManager = isManager;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }


    public boolean isManager() {
        return isManager;
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }
}