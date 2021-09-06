package LinkedInventoryManagement;

//Samuel Osezua SOO190000

import java.io.*;

/**
 * UsersOperations: This class should contain all the Users.dat file read, write
 * and update operations.
 */
public class UsersOperations {

    static InventoryLinkedList<User> UserList = new InventoryLinkedList<>();
    /*
    TODO: Add methods to read, write and update Users.dat
    open file
    get data
    close file
    return data to caller.
    */

    public static void readFile() throws IOException {
        String[] line;
        String val;

        //read user file
        String Userfile = "C:\\Users\\HP\\IdeaProjects\\LinkedInventoryManagement\\Users.dat";
        BufferedReader cin = null;

        //display exit if the user file is not found
        try {
            cin = new BufferedReader(new FileReader(Userfile));
        } catch (FileNotFoundException e) {
            System.out.println("1- Exit");
            System.exit(0);
        }


        //create user
        User users = new User();


        //set the values of the users
        while ((val = cin.readLine()) != null) {

            line = val.split(", ");


            // 0 = name 1 = lastname 2 = username 3 = password 4 = boolean
            users = new User(line[0], line[1], line[2], line[3], Main.bool(line[4]));
            users.setfName(line[0]);
            users.setlName(line[1]);
            SecurityOperations.AddNewUser(users);

        }
    }

        public static void updateFile (){
            FileWriter myWriter = null;
            try {
                myWriter = new FileWriter("Users.dat");
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i <UserList.size ; i++) {
                try {
                    myWriter.write(UserList.getNodeVal(i).getfName()+", "+ UserList.getNodeVal(i).getlName()+", "+UserList.getNodeVal(i).getUsername()+", "+SecurityOperations.GetPasswordHash(UserList.getNodeVal(i).getHashedPassword())+", "+UserList.getNodeVal(i).isManager()+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            try {
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }




