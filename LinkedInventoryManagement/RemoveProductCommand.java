package LinkedInventoryManagement;

//Samuel Osezua SOO190000

import java.util.Scanner;

public class RemoveProductCommand extends Command {

    public RemoveProductCommand(ProductCatalog productCatalog, User loggedOnUser) {
        super(productCatalog, loggedOnUser);
    }

    @Override
    public void Execute() {



        ScannerFactory.GetScannerInstance().nextLine();
        System.out.print("Product to remove by name: ");
        String remove = ScannerFactory.GetScannerInstance().nextLine();

        produt.RemoveProduct(remove);


        System.out.println("Product removed");



    }
}
