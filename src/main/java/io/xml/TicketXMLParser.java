/**
 * This class represents a TicketXMLParser object that is used to parse an XML file containing a collection of tickets.
 * It extends the abstract class TicketXMLWorker.
 */

package io.xml;

import collectionManagement.CollectionManager;
import exceptions.XMLTroubleException;
import structureClasses.Ticket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.Set;

public class TicketXMLParser extends TicketXMLWorker {
    /**
     * Constructor for the TicketXMLParser class.
     *
     * @param path the path to the XML file containing the collection of tickets
     */
    public TicketXMLParser(String path) {
        super(path);
    }

    /**
     * Method used to parse the XML file and return the set of tickets contained in it.
     *
     * @return the set of tickets contained in the XML file
     * @throws FileNotFoundException if the XML file cannot be found at the specified path
     * @throws XMLTroubleException   if there is an error parsing the XML file
     */
    public Set<Ticket> parse() throws FileNotFoundException, XMLTroubleException {
        try {
            FileInputStream in = new FileInputStream(path);
            Reader reader = new InputStreamReader(in);
            JAXBContext context = JAXBContext.newInstance(CollectionManager.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            CollectionManager collection = (CollectionManager) unmarshaller.unmarshal(reader);
            Ticket.setLastId(0L);

            for (Ticket ticket : collection.getCollection()) {
                ticket.setId(Ticket.getLastId() + 1);
                Ticket.increaseId();
                ticket.setCreationDate(LocalDate.now());
            }
            return collection.getCollection();
        } catch (JAXBException e) {
            throw new XMLTroubleException("Some troubles with xml file, please fix it");
        }

    }
}
