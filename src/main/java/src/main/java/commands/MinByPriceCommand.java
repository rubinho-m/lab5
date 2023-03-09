/**
 * The MinByPriceCommand class implements the execute method of the Command interface
 * to print the ticket which price is minimum.
 * Extends CommandTemplate class, which implements the Command interface
 * and provides access to the CollectionManager instance.
 */

package commands;

import collectionManagement.CollectionManager;
import exceptions.EmptyCollectionException;
import structureClasses.Ticket;

import java.util.*;

public class MinByPriceCommand extends CommandTemplate implements Command{
    public MinByPriceCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() throws EmptyCollectionException {
        Set<Ticket> tickets = getCollectionManager().getCollection();
        if (tickets.size() == 0){
            throw new EmptyCollectionException();
        }
        List<Double> prices = new ArrayList<>();
        Map<Double, Ticket> ticketMap = new HashMap<>();
        for (Ticket ticket : tickets){
            prices.add(ticket.getPrice());
            ticketMap.put(ticket.getPrice(), ticket);
        }
        Double minPrice = Collections.min(prices);
        Ticket ticketToPrint = ticketMap.get(minPrice);
        System.out.println(ticketToPrint);

    }
}
