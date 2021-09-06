package LinkedInventoryManagement;

//Samuel Osezua SOO190000

import java.util.Scanner;

public class ChangePasswordCommand extends Command {


    public ChangePasswordCommand(ProductCatalog productCatalog, User loggedOnUser) {
        super(productCatalog, loggedOnUser);
    }

    @Override
    public void Execute() {


        ScannerFactory.GetScannerInstance().nextLine();
        System.out.println("Enter user name:");
        String username = ScannerFactory.GetScannerInstance().nextLine();
        System.out.println("Enter Password:");
        String password = ScannerFactory.GetScannerInstance().nextLine();
        System.out.println("Enter new Password:");
        String newPassword = ScannerFactory.GetScannerInstance().nextLine();


        boolean flag = SecurityOperations.ChangePassword(username,password,newPassword);
        if(flag)
        {
            System.out.println("Password changed");
        }
        else
            System.out.println("Username/password incorrect");
    }
}
