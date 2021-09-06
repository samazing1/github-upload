package LinkedInventoryManagement;


//Samuel Osezua SOO190000


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * MenuListOperations: This class should contain all the MenuList.dat file read, write
 * and update operations.
 */
public class MenuListOperations {

    //TODO Add methods to read, write and update MenuList.dat

    public static int scount = 1;
    public static int count = 1;




    public static MenuList readFile(User users) throws IOException {

        MenuList mainMenu = new MenuList("Welcome to my store");
        MenuList cstMenu = new MenuList("Welcome to my store");

        boolean flag = true;
        String[] line;
        String val;

        String file = "C:\\Users\\HP\\IdeaProjects\\LinkedInventoryManagement\\MenuList.dat";
        BufferedReader fin = new BufferedReader(new FileReader(file));

        ProductCatalog productList = new ProductCatalog();
        //read the Menu list file

        while ((val = fin.readLine()) != null) {

            line = val.split(", ");


            //dynamically create the command
            Command dynamicCommand = Command.CreateCommandDynamically(productList, users, line[2]);


            //If the user is a non manager.
            if (users.isManager() == false && Main.bool(line[1]) == false) {
                MenuItem cstList = new MenuItem(dynamicCommand, scount, line[0], Main.bool(line[1]));
                cstMenu.AddMenuItem(cstList);
                flag = false;
                scount++;
            }


            // 2= command, 0 = description 1 = bool flag
            MenuItem list = new MenuItem(dynamicCommand, count, line[0], Main.bool(line[1]));
            mainMenu.AddMenuItem(list);
            count++;
        }


        if(flag)
        {
            return mainMenu;
        }
        else
            return cstMenu;


    }

}