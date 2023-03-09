/**
 * The RemoveGreaterCommand class implements the execute method of the Command interface
 * to remove all elements in collection which are bigger than argument.
 * Extends CommandTemplate class, which implements the Command interface
 * and provides access to the CollectionManager instance.
 */

package commands;

import collectionManagement.CollectionManager;
import exceptions.EmptyCollectionException;
import structureClasses.Ticket;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveGreaterCommand extends CommandTemplate implements Command{
    public RemoveGreaterCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() throws EmptyCollectionException {
        Set<Ticket> tickets = getCollectionManager().getCollection();
        if (tickets.size() == 0){
            throw new EmptyCollectionException();
        }
        Set<Ticket> removeTickets = new LinkedHashSet<>();
        for (Ticket ticket : tickets){
            if (ticket.compareTo(getTicket()) > 0){
                removeTickets.add(ticket);
            }
        }
        for (Ticket ticketToRemove : removeTickets){
            tickets.remove(ticketToRemove);
        }
    }
}
