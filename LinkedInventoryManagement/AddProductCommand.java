package LinkedInventoryManagement;

//Samuel Osezua SOO190000


/**
 * AddCommand
 */
public class AddProductCommand extends Command {
    //TODO: add necessary fields/constructors to this class


    public AddProductCommand(ProductCatalog productCatalog, User loggedOnUser) {
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
        // TODO Add the code that will execute this command


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


        Product val = new Product(id, name, cost, quantity, margin);

        produt.AddUpdateProduct(val);

        System.out.println("Product added");

    }
}