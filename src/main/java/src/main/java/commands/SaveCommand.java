/**
 * The SaveCommand class implements the execute method of the Command interface
 * to save the collection into file.
 * Extends CommandTemplate class, which implements the Command interface
 * and provides access to the CollectionManager instance.
 */

package commands;

import collectionManagement.CollectionManager;
import exceptions.XMLTroubleException;
import io.xml.TicketXMLWriter;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class SaveCommand extends CommandTemplate implements Command {

    public SaveCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() {
        try {
            TicketXMLWriter writer = new TicketXMLWriter(getCollectionManager().getPath());
            writer.save(getCollectionManager());
        } catch (XMLTroubleException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
