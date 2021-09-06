package LinkedInventoryManagement;


//Samuel Osezua SOO190000
/**
 * ProductCatalog
 */
public class ProductCatalog {

    //TODO implement the ProductCatalog methods and fields. Add a collection to hold Product objects

    static InventoryLinkedList<Product> ProductList = new InventoryLinkedList<>();



    public ProductCatalog() {

    }



    //Add or update a product if already exists
    public Boolean AddUpdateProduct(Product product)
    {
        //if the product exists by name, update else add
        //write to file

        boolean flag = true;
        for (int i = 0; i <ProductList.size ; i++) {

            if (ProductList.getNodeVal(i).getName().compareTo(product.getName())==0)
            {
                ProductList.getNodeVal(i).setId(product.getId());
                ProductList.getNodeVal(i).setMargin(product.getMargin());
                ProductList.getNodeVal(i).setQuantity(product.getQuantity());
                ProductList.getNodeVal(i).setCost(product.getCost());
                InventoryOperations.updateFile();
                flag = false;
            }


        }

        if (flag)
        {

            ProductList.add(product);
            InventoryOperations.updateFile();
        }




        return flag;
    }


    public boolean RemoveProduct(int productId) {
        boolean isSuccess = false;

        for (int i = 0; i < ProductList.size; i++) {
            if (ProductList.getNodeVal(i).getId() == productId) {
                ProductList.remove(i);
                isSuccess = true;
                break;

            }
        }

        return isSuccess;
    }




    public boolean RemoveProduct(String value)
    {
        boolean isSuccess = false;

        for(int i =0; i < ProductList.size; i++) {

            if (ProductList.getNodeVal(i).getName().compareTo(value)==0)
            {
                ProductList.remove(i);
                isSuccess = true;
                break;
            }

        }

        if (isSuccess)
        {
            InventoryOperations.updateFile();
            return true;
        }
        else
            return false;
    }

    public  boolean FindProduct(int productId) {
        boolean isSuccess = false;

        for (int i = 0; i < ProductList.size; i++) {
            if (ProductList.getNodeVal(i).getId() == productId) {
                isSuccess = true;
                break;

            }
        }


        return isSuccess;
    }


    public boolean FindProduct(String value)
    {
        boolean isSuccess = false;

        for(int i =0; i < ProductList.size; i++) {

            if (ProductList.getNodeVal(i).getName().compareToIgnoreCase(value)==0)
            {
                isSuccess = true;
                break;
            }

        }

        if (isSuccess)
        {
            return true;
        }
        else
            return false;
    }

    public int nextVal(int productId){



        int index = 0;
        for (int i = 0; i <ProductList.size; i++) {

            if(ProductList.getNodeVal(i).getId() == productId)
            {
                index = i;

            }

        }

        index+=1;
        if (ProductList.getNode(index)==null)
        {
            System.out.println("End of the list");
            return 0;
        }
        else {
            Product print = ProductList.getNodeVal(index);


            double retailPrice = (print.getCost() + (print.getMargin() * print.getCost() / 100));
            String productInformation = (print.getId() + " " + print.getName() + " $" + print.getCost() + " " + print.getQuantity() + " $" + retailPrice);
            System.out.println(productInformation);


            return print.getId();
        }


    }


    public int preVal(int productId){



        int index = 0;
        for (int i = 0; i <ProductList.size; i++) {

            if(ProductList.getNodeVal(i).getId() == productId)
            {
                index = i;

            }

        }

        index-=1;
        if (ProductList.getNode(index)==null)
        {
            System.out.println("End of the list");
            return 0;
        }

        else if (index<0)
        {
            System.out.println("You can not go further back");
            return 0;
        }
        else {
            Product print = ProductList.getNodeVal(index);


            double retailPrice = (print.getCost() + (print.getMargin() * print.getCost() / 100));
            String productInformation = (print.getId() + " " + print.getName() + " $" + print.getCost() + " " + print.getQuantity() + " $" + retailPrice);
            System.out.println(productInformation);


            return print.getId();
        }


    }

    //Print information about a product including retail price (cost + (margin*cost/100))
    public String PrintProductInformation(int productId)
    {
        boolean flag = false;
        int index = 0;
        for (int i = 0; i <ProductList.size; i++) {

            if(ProductList.getNodeVal(i).getId() == productId)
            {
                index = i;
                flag = true;
            }

        }
        Product print = ProductList.getNodeVal(index);


        double retailPrice = (print.getCost()+(print.getMargin()*print.getCost()/100));
        String productInformation = (print.getId() + " " + print.getName() + " $" + print.getCost() + " " + print.getQuantity() + " $" +retailPrice);


        if(flag) {
            return productInformation;
        }
        else
            return "Product not found";

    }

    //Print all product information in the inventory
    public  String PrintInventoryList()
    {

        String productInformation = "";

        if(ProductList.size >= 0) {


            for (int i = 0; i < ProductList.size; i++) {
                Product print = ProductList.getNodeVal(i);

                //double retailPrice = (print.getCost() + (print.getMargin() * print.getCost() / 100));

                productInformation += (print.getId() + " " + print.getName() + " $" + print.getCost() + " " + print.getQuantity()+"\n");

                //StringBuilder inventoryInformation = new StringBuilder();
            }
            return productInformation;
        }

        else
            return "Nothing Present";
    }
}