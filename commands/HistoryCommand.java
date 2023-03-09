/**
 * The HistoryCommand class implements the execute method of the Command interface
 * to show history of input commands.
 * Extends CommandTemplate class, which implements the Command interface
 * and provides access to the CollectionManager instance.
 */

package commands;

import exceptions.EmptyHistoryException;

import java.util.Collections;
import java.util.List;

public class HistoryCommand extends CommandTemplate implements Command {
    public HistoryCommand() {

    }

    @Override
    public void execute() throws EmptyHistoryException {
        List<String> history = HistoryManager.getHistoryCommands();
        if (history.size() == 0){
            throw new EmptyHistoryException();
        }
        List<String> historyToPrint;
        Collections.reverse(history);
        if (history.size() >= 10) {
            historyToPrint = history.subList(0, 10);
        } else {
            historyToPrint = history;
        }
        for (String command: historyToPrint) {
            System.out.println(command);
        }
    }
}
