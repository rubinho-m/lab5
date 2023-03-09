/**
 * The Main class is the entry point of the application. It initializes the collection manager, parses the XML file
 * containing the initial collection, and sets the path of the XML file. It also sets up a command executor with the
 * collection manager and a command parser. The program then enters a loop where it reads commands from the standard
 * input using the command parser and executes them using the command executor. If an exception is thrown during
 * command execution, the exception message is printed to the console.
 */

import collectionManagement.CollectionManager;
import collectionManagement.CommandExecutor;
import exceptions.XMLTroubleException;
import io.commandParsing.CommandParser;
import io.xml.TicketXMLParser;

import javax.xml.bind.UnmarshalException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Main {
    /**
     * The main method is the entry point of the application.
     *
     * @param args command line arguments. The first argument should be the path to the XML file containing the initial collection.
     * @throws IOException         if there is an error reading the XML file.
     * @throws XMLTroubleException if there is an error parsing the XML file.
     */
    public static void main(String[] args) throws IOException, XMLTroubleException, UnmarshalException {
        try {
            CollectionManager collectionManager = new CollectionManager();
            TicketXMLParser xmlParser = new TicketXMLParser(args[0]);
            collectionManager.setCollection(xmlParser.parse());
            collectionManager.setPath(args[0]);

            Scanner scanner = new Scanner(System.in);
            CommandExecutor commandExecutor = new CommandExecutor();
            commandExecutor.setCommands(collectionManager);
            CommandParser commandParser = new CommandParser();

            while (true) {
                try {
                    commandExecutor.execute(commandParser.readCommand(scanner, false), scanner, false);
                } catch (NoSuchElementException e) {
                    break;
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (XMLTroubleException e){
            System.exit(1);
        }


    }

}