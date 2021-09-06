package LinkedInventoryManagement;

//Samuel Osezua SOO190000

import java.util.Scanner;

public class DisplayProductCommand extends Command {


    public DisplayProductCommand(ProductCatalog productCatalog, User loggedOnUser) {
        super(productCatalog, loggedOnUser);


    }

    @Override
    public void Execute() {


        System.out.println("Enter product ID: ");
        int value = ScannerFactory.GetScannerInstance().nextInt();


        System.out.println(produt.PrintProductInformation(value));

        if (produt.PrintProductInformation(value).compareToIgnoreCase("Product not found") == 0) {

        } else {

            System.out.println("Type “Next” or “Previous” to display next/previous product, press enter to return: ");

            do {


                String ans = ScannerFactory.GetScannerInstance().nextLine();


                if (ans.compareToIgnoreCase("next") == 0) {
                    value = produt.nextVal(value);
                } else if (ans.compareToIgnoreCase("previous") == 0) {
                    value = produt.preVal(value);
                }


            } while (value != 0);
        }
    }
}
