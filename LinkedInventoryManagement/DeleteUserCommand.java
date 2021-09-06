package LinkedInventoryManagement;

//Samuel Osezua SOO190000

import java.util.Scanner;

public class DeleteUserCommand extends Command {


    public DeleteUserCommand(ProductCatalog productCatalog, User loggedOnUser) {
        super(productCatalog, loggedOnUser);
    }

    @Override
    public void Execute() {


        ScannerFactory.GetScannerInstance().nextLine();
        System.out.println("Enter the Username to be removed: ");
        String Username = ScannerFactory.GetScannerInstance().nextLine();

        if (SecurityOperations.RemoveUser(Username))
        {
            System.out.println("User was removed");
        }

        else{
            System.out.println("User not found");
        }


    }
}
