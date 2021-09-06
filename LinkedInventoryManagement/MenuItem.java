package LinkedInventoryManagement;


//Samuel Osezua SOO190000
/**
 * MenuItem
 */
public class MenuItem implements Comparable<MenuItem>
{
    //TODO Add data fields, constructors and methods as needed. Class must implement Comparable to compare two menu items.
    private String description;
    private int id;
    private Command menuItemCommand;
    private boolean flag = false;

    public MenuItem(Command command,
                    int optionNumber,
                    String description,
                    Boolean isRestricted)
    {

        this.id = optionNumber;
        this.description = description;
        this.flag = isRestricted;
        this.menuItemCommand = command;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public  String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    //get isManager
    public boolean isFlag() {
        return flag;
    }

    public void Execute(){

        this.menuItemCommand.Execute();
    }

    @Override
    public int compareTo(MenuItem menuItemToCompare) {
        // TODO Auto-generated method stub
        return 0;
    }

}