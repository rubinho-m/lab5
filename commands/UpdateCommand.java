/**
 * The UpdateCommand class implements the execute method of the Command interface
 * to update the element in collection according to its id.
 * Extends CommandTemplate class, which implements the Command interface
 * and provides access to the CollectionManager instance.
 */

package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CommandExecutor;
import exceptions.EmptyCollectionException;
import structureClasses.Ticket;

import java.util.Set;

public class UpdateCommand extends CommandTemplate implements Command{
    public UpdateCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() throws EmptyCollectionException {
        CollectionManager collectionManager = getCollectionManager();
        Set<Ticket> tickets = collectionManager.getCollection();
        if (tickets.size() == 0){
            throw new EmptyCollectionException();
        }
        for (Ticket ticketToUpdate: tickets){
            if (ticketToUpdate.getId() == Integer.parseInt(getArg())){
                tickets.remove(ticketToUpdate);
                break;
            }
        }
        Ticket newTicket = getTicket();
        Long tmpId = Ticket.getLastId();
        Ticket.setLastId((long) Integer.parseInt(getArg()) - 1);
        collectionManager.addToCollection(newTicket);
        Ticket.setLastId(tmpId);
    }
}
