/**
 * The HistoryManager class represents a manager for command history.
 */

package commands;

import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    private static List<String> historyCommands = new ArrayList<>();

    public static List<String> getHistoryCommands() {
        return historyCommands;
    }

    public static void addToHistory(String command) {
        historyCommands.add(command);
    }
}
