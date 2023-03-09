/**
 * The HelpCommand class implements the execute method of the Command interface
 * to show help text.
 * Extends CommandTemplate class, which implements the Command interface
 * and provides access to the CollectionManager instance.
 */

package commands;

public class HelpCommand extends CommandTemplate implements Command{
    @Override
    public void execute() {
        System.out.println("Help on available commands: " + "\n" +
                "help: display help on available commands" + "\n" +
                "info: display collection information" + "\n" +
                "show: display all collection elements" + "\n" +
                "add: add the new element to collection" + "\n" +
                "update: update the value of collection element if its id equals entered" + "\n" +
                "remove_by_id: remove collection element according to id" + "\n" +
                "clear: clear collection" + "\n" +
                "save: save collection to file" + "\n" +
                "execute_script: execute commands from the file" + "\n" +
                "exit: exit the program" + "\n" +
                "add_if_min: add the new element to collection if it is lower than min of collection" + "\n" +
                "remove_greater: remove all collection elements which are greater than entered" + "\n" +
                "history: display 10 last commands" + "\n" +
                "min_by_price: display any collection element which is lower than entered" + "\n" +
                "filter_greater_than_price: display elements which have price greater than entered" + "\n" +
                "print_field_descending_venue: display all venue values in descending order");
    }
}
