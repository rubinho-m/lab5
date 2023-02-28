/**
 * The ClearCommand class implements the execute method of the Command interface
 * to delete all elements from the collection.
 * Extends CommandTemplate class, which implements the Command interface
 * and provides access to the CollectionManager instance.
 */

package commands;

import collectionManagement.CollectionManager;

public class ClearCommand extends CommandTemplate implements Command{
    public ClearCommand(CollectionManager collectionManager){
        super(collectionManager);
    }
    @Override
    public void execute() {
        getCollectionManager().getCollection().clear();
        System.out.println("Now collection is empty");
    }
}
