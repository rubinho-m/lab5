/**
 * The RemoveByIdCommand class implements the execute method of the Command interface
 * to remove the element according to its id.
 * Extends CommandTemplate class, which implements the Command interface
 * and provides access to the CollectionManager instance.
 */

package commands;

import collectionManagement.CollectionManager;
import exceptions.EmptyCollectionException;
import structureClasses.Ticket;

public class RemoveByIdCommand extends CommandTemplate implements Command{
    public RemoveByIdCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() throws EmptyCollectionException {
        CollectionManager collectionManager = getCollectionManager();
        if (collectionManager.getCollection().size() == 0){
            throw new EmptyCollectionException();
        }
        for (Ticket ticketToRemove : collectionManager.getCollection()){
            if (ticketToRemove.getId() == Integer.parseInt(getArg())){
                collectionManager.getCollection().remove(ticketToRemove);
                break;
            }
        }
    }
}
