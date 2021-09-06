package LinkedInventoryManagement;


//Samuel Osezua SOO190000

/**
 * This class represent a line in Inventory.dat file
 */
public class Product implements Comparable<Product>
{

    //TODO Add the following fields and a constructor to set the fields:
    private int Id; //(int, this is the unique product id)
    private String Name;
    private double Cost;
    private int Quantity;
    private int Margin; //(int as a percentage)

    public Product(int id, String name, double cost, int quantity, int margin)
    {

        this.Id = id;
        this.Name = name;
        this.Cost = cost;
        this.Quantity = quantity;
        this.Margin = margin;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public void setMargin(int margin) {
        Margin = margin;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getMargin() {

        return Margin;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getName() {
        return Name;
    }

    public double getCost() {
        return Cost;
    }


    public int getId() {
        return Id;
    }

    @Override
    public int compareTo(Product productToCompare) {
        // TODO compare the parameter object to the current instance of product
        return 0;
    }


}