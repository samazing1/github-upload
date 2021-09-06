package LinkedInventoryManagement;

//Samuel Osezua SOO190000

public class DisplayInventoryCommand extends Command {

    public DisplayInventoryCommand(ProductCatalog productCatalog, User loggedOnUser) {
        super(productCatalog, loggedOnUser);
    }

    @Override
    public void Execute() {

        System.out.println(produt.PrintInventoryList());
    }
}
