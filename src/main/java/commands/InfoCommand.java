/**
 * The InfoCommand class implements the execute method of the Command interface
 * to show information about collection.
 * Extends CommandTemplate class, which implements the Command interface
 * and provides access to the CollectionManager instance.
 */

package commands;

import collectionManagement.CollectionManager;

public class InfoCommand extends CommandTemplate implements Command {
    public InfoCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() {
        CollectionManager collection = getCollectionManager();
        System.out.println("Type of collection: Ticket" + "\n" +
                "creationDate: " + collection.getFirstElement().getCreationDate() + "\n" +
                "size of collection: " + collection.getCollection().size());
    }
}
