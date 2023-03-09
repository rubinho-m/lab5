/**
 * The ExitCommand class implements the execute method of the Command interface
 * to exit the program.
 * Extends CommandTemplate class, which implements the Command interface
 * and provides access to the CollectionManager instance.
 */

package commands;


public class ExitCommand extends CommandTemplate implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }
}
