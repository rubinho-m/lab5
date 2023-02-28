/**
 * The PrintFieldDescendingCommand class implements the execute method of the Command interface
 * to show collection in sort of venues.
 * Extends CommandTemplate class, which implements the Command interface
 * and provides access to the CollectionManager instance.
 */

package commands;

import collectionManagement.CollectionManager;
import exceptions.EmptyCollectionException;
import structureClasses.Ticket;
import structureClasses.Venue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintFieldDescendingVenueCommand extends CommandTemplate implements Command{
    public PrintFieldDescendingVenueCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() throws EmptyCollectionException {
        List<Venue> venues = new ArrayList<>();
        if (getCollectionManager().getCollection().size() == 0){
            throw new EmptyCollectionException();
        }
        for (Ticket ticket: getCollectionManager().getCollection()){
            if (ticket.getVenue() != null){
                venues.add(ticket.getVenue());
            }
        }
        Collections.sort(venues);
        Collections.reverse(venues);
        for (Venue venue : venues){
            System.out.println(venue);
        }
    }
}
