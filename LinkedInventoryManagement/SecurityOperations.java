package LinkedInventoryManagement;

//Samuel Osezua SOO190000


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * InventoryManagementSecurity
 */
public class SecurityOperations
{
    //TODO Add data fields, constructors and methods as needed. Consider implementing Comparable for the User class.


    public static User AuthenticateUser(String username, String password)
    {
        //open up the user file
        User authenticatedUser = null;
        int count = 0;
        boolean found = false;

        if((username.compareToIgnoreCase("admin") == 0) &&
                (GetPasswordHash(password).compareToIgnoreCase("58c536ed8facc2c2a293a18a48e3e120") == 0))
        {

            authenticatedUser = new User(username, GetPasswordHash(password), true);
        }
        else
        {


            for (int i = 0; i < UsersOperations.UserList.size; i++) {

                if((username.compareTo(UsersOperations.UserList.getNodeVal(i).getUsername())==0)&&(password.compareToIgnoreCase(UsersOperations.UserList.getNodeVal(i).getHashedPassword())==0))
                {
                    count =i;
                    found = true;
                    break;
                }
            }


            if(found)
            {
                authenticatedUser = new User(username, GetPasswordHash(password), UsersOperations.UserList.getNodeVal(count).isManager());
            }



        }

        return authenticatedUser; //Change the return value based on authentication result


    }

    public static boolean AddNewUser(User newUser) {


        //hash password and save to Users.dat

        boolean flag = true;
        for (int i = 0; i <UsersOperations.UserList.size ; i++) {

            if(newUser.equals(UsersOperations.UserList.getNodeVal(i)))
            {
                flag = false;
            }

        }

        if(flag)
        {
            UsersOperations.UserList.add(newUser);
            UsersOperations.updateFile();
        }


        return true;
    }

    public static boolean RemoveUser(String userName) {

        //remove username from Users.dat
        boolean flag = false;
        for (int i = 0; i < UsersOperations.UserList.size; i++) {
            if (UsersOperations.UserList.getNodeVal(i).getUsername().compareToIgnoreCase(userName) == 0) {
                UsersOperations.UserList.remove(i);
                flag = true;
            }
        }

        UsersOperations.updateFile();

        return flag;
    }

    public static boolean ChangePassword(String username, String currentPassword, String newPassword) {

        //change the password, hash it and then write to file

        boolean flag = false;
        for (int i = 0; i < UsersOperations.UserList.size; i++) {
            if ((UsersOperations.UserList.getNodeVal(i).getUsername().compareToIgnoreCase(username) == 0) && (UsersOperations.UserList.getNodeVal(i).getHashedPassword().compareToIgnoreCase(currentPassword) == 0)) {

                UsersOperations.UserList.getNodeVal(i).setHashedPassword(GetPasswordHash(newPassword));
                flag = true;
            }


        }

        UsersOperations.updateFile();

        return flag;
    }

    public static String GetPasswordHash(String password)
    {
        String generatedPassword = null;

        try
        {
            byte[] salt = new byte[] {12, -12, 65, 61,
                    2, -6, -90, 12,
                    4, -7, -87, 2,
                    34, -102, 3, 115};

            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Add password bytes to digest
            md.update(salt);
            // Get the hash's bytes
            byte[] bytes = md.digest(password.getBytes());
            // This bytes[] has bytes in decimal format;
            // Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        return generatedPassword;
    }
}