/**
 * CollectionManager is responsible for managing the Ticket collection.
 */

package collectionManagement;

import structureClasses.Ticket;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@XmlRootElement(name = "Ledger")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionManager {
    @XmlElementWrapper(name = "Tickets")
    @XmlElement(name = "Ticket")
    private Set<Ticket> tickets = new LinkedHashSet<>();

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        CollectionManager.path = path;
    }

    private static String path;

    public void setCollection(Set<Ticket> data) {
        tickets = data;
    }

    public Set<Ticket> getCollection() {
        return tickets;
    }

    public void addToCollection(Ticket ticket) {
        ticket.setId(Ticket.getLastId() + 1);
        if (ticket.getVenue() != null) {
            ticket.getVenue().setId((int) ticket.getId());
        }
        Ticket.increaseId();
        ticket.setCreationDate(LocalDate.now());
        tickets.add(ticket);
    }

    public Ticket getFirstElement() {
        return (Ticket) tickets.toArray()[0];
    }

    public void printCollection() {
        if (tickets.size() == 0) {
            System.out.println("Collection is empty" + "\n");
        } else {
            System.out.println("Collection:" + "\n");
        }
        for (Ticket ticket : tickets) {
            System.out.println(ticket + "\n" + "\n");
        }
    }


}
