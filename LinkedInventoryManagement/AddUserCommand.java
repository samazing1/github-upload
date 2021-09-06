package LinkedInventoryManagement;

//Samuel Osezua SOO190000

import java.io.IOException;
import java.util.Scanner;

public class AddUserCommand extends Command {


    public AddUserCommand(ProductCatalog productCatalog, User loggedOnUser) {
        super(productCatalog, loggedOnUser);
    }

    @Override
    public void Execute() {



        ScannerFactory.GetScannerInstance().nextLine();
        System.out.println("Enter first name");
        String fname = ScannerFactory.GetScannerInstance().nextLine();
        System.out.println("Enter Last name:");
        String lname = ScannerFactory.GetScannerInstance().nextLine();
        System.out.println("Enter Username: ");
        String username = ScannerFactory.GetScannerInstance().nextLine();
        System.out.println("Enter Hashed Password: ");
        String pwrd = ScannerFactory.GetScannerInstance().nextLine();


        User newUser = new User(fname,lname,username,pwrd,true);

        SecurityOperations.AddNewUser(newUser);


        System.out.println("Add user command");
        //super.UserList.add(eps);


    }
}
