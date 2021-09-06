package LinkedInventoryManagement;

//Samuel Osezua SOO190000

import java.util.Scanner;

public class UpdateProductCommand extends Command {
    public UpdateProductCommand(ProductCatalog productCatalog, User loggedOnUser) {
        super(productCatalog, loggedOnUser);
    }

    @Override
    public void Execute() {
        System.out.println("Type in the new product information here: ");


        System.out.println("Enter the Product id: ");
        int id = ScannerFactory.GetScannerInstance().nextInt();
        System.out.println("Enter the Product Name: ");
        ScannerFactory.GetScannerInstance().nextLine();
        String name = ScannerFactory.GetScannerInstance().nextLine();
        System.out.println("Enter the cost: ");
        double cost = ScannerFactory.GetScannerInstance().nextDouble();
        System.out.println("Enter the Quantity: ");
        int quantity = ScannerFactory.GetScannerInstance().nextInt();
        System.out.println("Enter the margin");
        int margin = ScannerFactory.GetScannerInstance().nextInt();


        Product val = new Product(id,name,cost,quantity,margin);



        if (produt.FindProduct(name)==true)
        {
            System.out.println("Product Updated");
        }
        else
        {
            System.out.println("Product was not found so it was added ");
        }
        produt.AddUpdateProduct(val);

    }
}
