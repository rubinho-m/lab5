/**
 * The CommandParser class is responsible for parsing commands from terminal or script.
 */

package io.commandParsing;

import java.util.*;

public class CommandParser {
    private boolean hasWrongCommand = true;
    private boolean hasWrongFormat = false;
    public ArrayList<String> readCommand(Scanner scanner, boolean isFile) throws Exception {
        if (!isFile) {
            System.out.println("Please, enter a command:");
        }
        String line = scanner.nextLine();
        ArrayList<String> lineArr = new ArrayList<>(Arrays.asList(line.split(" ")));
        hasWrongCommand = true;
        hasWrongFormat = false;
        handleCommand(lineArr);
        if (hasWrongCommand){
            throw new Exception("Нет такой команды");
        }
        if (hasWrongFormat){
            throw new Exception("Неправильный формат команды");
        }
        return lineArr;

    }

    public void handleCommand(ArrayList<String> line){
        Set<String> oneWordCommands = new HashSet<>(){{
            add("help");
            add("info");
            add("show");
            add("clear");
            add("save");
            add("exit");
            add("history");
            add("min_by_price");
            add("print_field_descending_venue");
        }};
        Set<String> argumentCommands = new HashSet<>(){{
            add("remove_by_id");
            add("update");
            add("execute_script");
            add("filter_greater_than_price");
        }};
        Set<String> collectionCommands = new HashSet<>(){{
            add("add");
            add("update");
            add("add_if_min");
            add("remove_greater");
        }};

        if ((line.size() == 1) && (oneWordCommands.contains(line.get(0)))){
            hasWrongCommand = false;
        } else if ((line.size() != 1) && (oneWordCommands.contains(line.get(0)))) {
            hasWrongFormat = true;
            hasWrongCommand = false;
        }
        if ((line.size() == 2) && (argumentCommands.contains(line.get(0)))) {
            hasWrongCommand = false;
        } else if ((line.size() != 2) && (argumentCommands.contains(line.get(0)))) {
            hasWrongFormat = true;
            hasWrongCommand = false;
        }
        if (collectionCommands.contains(line.get(0))){
            if ((argumentCommands.contains(line.get(0)))){
                if ((line.size() != 2)){
                    hasWrongFormat = true;
                }
            } else {
                if ((line.size() != 1)){
                    hasWrongFormat = true;
                }
            }
            hasWrongCommand = false;
        }
    }




}
