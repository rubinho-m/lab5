/**
 * The CommandExecutor class is responsible for executing commands from the user input, either from the console or from a script file.
 * It stores the registered commands in a HashMap, and executes the command based on the input from the user.
 */

package collectionManagement;

import commands.*;
import exceptions.WrongScriptException;
import io.commandParsing.CollectionInput;
import structureClasses.Ticket;

import java.util.*;

public class CommandExecutor {
    private static final HashMap<String, Command> commandMap = new HashMap<>();
    private Set<String> paths = new HashSet<>();

    public Set<String> getPaths() {
        return paths;
    }

    public void clearPaths() {
        paths.clear();
    }

    public void addToPaths(String path) {
        paths.add(path);
    }

    public static HashMap<String, Command> getCommandMap() {
        return commandMap;
    }

    private final Set<String> collectionCommands = new HashSet<>() {{
        add("add");
        add("update");
        add("add_if_min");
        add("remove_greater");
    }};

    public void setCommands(CollectionManager collectionManager) {
        commandMap.put("save", new SaveCommand(collectionManager));
        commandMap.put("add", new AddCommand(collectionManager));
        commandMap.put("history", new HistoryCommand());
        commandMap.put("show", new ShowCommand(collectionManager));
        commandMap.put("info", new InfoCommand(collectionManager));
        commandMap.put("remove_by_id", new RemoveByIdCommand(collectionManager));
        commandMap.put("clear", new ClearCommand(collectionManager));
        commandMap.put("exit", new ExitCommand());
        commandMap.put("add_if_min", new AddIfMinCommand(collectionManager));
        commandMap.put("help", new HelpCommand());
        commandMap.put("update", new UpdateCommand(collectionManager));
        commandMap.put("remove_greater", new RemoveGreaterCommand(collectionManager));
        commandMap.put("min_by_price", new MinByPriceCommand(collectionManager));
        commandMap.put("filter_greater_than_price", new FilterGreaterThanPriceCommand(collectionManager));
        commandMap.put("print_field_descending_venue", new PrintFieldDescendingVenueCommand(collectionManager));
        commandMap.put("execute_script", new ExecuteScriptCommand(collectionManager, this));
    }

    public void execute(ArrayList<String> commandWithArgs, Scanner scanner, boolean isFile) throws Exception {

        try {
            Command command = commandMap.get(commandWithArgs.get(0));
            if (command == null) {
                throw new IllegalStateException("No command registered for " + commandWithArgs.get(0));
            }
            String arg = null; // ?????? ???????????? ?? ????????????????????
            if (commandWithArgs.size() > 1) {
                arg = commandWithArgs.get(1);
            }
            Ticket inputTicket = null; // ?????? ???????????? ?? ????????????????????
            if (collectionCommands.contains(commandWithArgs.get(0))) {
                CollectionInput collectionInput = new CollectionInput(scanner, isFile);
                inputTicket = collectionInput.getCollection();
            }
            command.setArg(arg);
            command.setTicket(inputTicket);
            HistoryManager.addToHistory(commandWithArgs.get(0));
            command.execute();
        } catch (WrongScriptException e) {
            System.out.println(e.getMessage());
        }
    }
}
