package LinkedInventoryManagement;


//Samuel Osezua SOO190000

/**
 * MenuList
 */
public class MenuList {

    InventoryLinkedList<MenuItem> menuItemList = new InventoryLinkedList<>();


    public MenuList(String menuHeader)
    {

    }

    public void AddMenuItem(MenuItem menuItem)
    {
        menuItemList.add(menuItem);
    }


    public void StartMenu(User user)
    {

        //TODO Display menu items based on user type, prompt user for command, execute selected command.
        int count = 1;
        for (int i = 0; i <menuItemList.getLength(); i++ ){
            System.out.println(menuItemList.getNodeVal(i).getId()+"- "+ menuItemList.getNodeVal(i).getDescription());
            count++;
        }
        System.out.println(String.format("%d- %s",count,"Exit"));
    }

    public MenuItem getMenuItemById (int pos){

        return menuItemList.getNodeVal(pos-1);

    }


}