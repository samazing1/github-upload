package LinkedInventoryManagement;

//Samuel Osezua SOO190000

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * InventoryOperations: This class should contain all the Inventory.dat file read, write
 * and update operations.
 */
public class InventoryOperations {

    public static void readFile() throws IOException {


        String[] line;
        String val;

        //read the inventory.dat file
        String fileName = "C:\\Users\\HP\\IdeaProjects\\LinkedInventoryManagement\\Inventory.dat";
        BufferedReader in = new BufferedReader(new FileReader(fileName));


        //read file from Inventory List
        ProductCatalog productList = new ProductCatalog();
        while ((val = in.readLine()) != null) {

            line = val.split(", ");

            // 2 = command, 0 = description 1 = bool flag
            Product vel = new Product(Integer.parseInt(line[0]), (line[1]), Double.parseDouble(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]));

           productList.AddUpdateProduct(vel);




        }


    }

    public static void updateFile(){
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter("Inventory.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <ProductCatalog.ProductList.size ; i++) {
            Product print = ProductCatalog.ProductList.getNodeVal(i);
            try {
                myWriter.write(print.getId() + ", " + print.getName() + ", " + print.getCost() + ", " + print.getQuantity()+", "+ print.getMargin()+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        try {
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}