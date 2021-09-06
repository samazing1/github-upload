package LinkedInventoryManagement;


//Samuel Osezua SOO190000

import java.lang.reflect.Constructor;


/**
 * Command
 */
public abstract class Command
{
    //TODO: add necessary fields/constructors to this class

    ProductCatalog produt = null;
    User Current = null;
    public Command(ProductCatalog productCatalog, User loggedOnUser)
    {
        this.produt = productCatalog;
        this.Current = loggedOnUser;

    }

    public static Command CreateCommandDynamically(ProductCatalog productCatalog, User user, String commandClassName)
    {
        Class<?>    concreteCommandClass    = null;
        Command     command                 = null;
        String      packageName             = "LinkedInventoryManagement";

        try
        {
            concreteCommandClass = Class.forName(packageName + "." + commandClassName);
            Constructor<?> con = concreteCommandClass.getConstructor(ProductCatalog.class, User.class);
            command = (Command)con.newInstance(productCatalog, user);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        return command;
    }

    //An abstract method that must be overriden in subclasses of class Command
    public abstract void Execute();


}