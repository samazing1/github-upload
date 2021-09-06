package LinkedInventoryManagement;

//Samuel Osezua SOO190000

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) throws IOException {


        User users = new User();

        //read the user data into the linked list
        UsersOperations.readFile();


        //prompt the user for username and password
        System.out.println("Enter Username: ");
        String name = ScannerFactory.GetScannerInstance().nextLine();

        System.out.println("Enter Password: ");
        String pwrd = ScannerFactory.GetScannerInstance().nextLine();

        //set the present running user
        users = SecurityOperations.AuthenticateUser(name, pwrd);

        //if the user can not be validated
        if (users == null) {
            System.out.println("User could not be authenticated");
        } else {

            //read the inventory operations file
            InventoryOperations.readFile();


            MenuList mainMenu = new MenuList("Welcome to my store");


            //read the menulist file and return the right menu based on the logged on user
            mainMenu = MenuListOperations.readFile(users);


            //define variables
            int value, ans;

            //set the exit number, depending on the available menu options
            if (users.isManager() == true) {
                value = MenuListOperations.count;
            } else
                value = MenuListOperations.scount;

            //welcome the user
            System.out.println("Welcome " + users.getUsername());

            do {

                //display the menu based on the logged on user
                mainMenu.StartMenu(users);

                ans = ScannerFactory.GetScannerInstance().nextInt();

                if (ans == value) {

                } else

                    mainMenu.getMenuItemById(ans).Execute();


            } while (value != ans);



            //Close the Scanner at the end of your program as follows.
            ScannerFactory.CloseScannerInstance();


        }


        }

        //Method that returns true or false based on what is in the file

         public static Boolean bool (String value){
          if (value.compareTo("true") == 0) {
            return true;
        } else
            return false;
    }

}