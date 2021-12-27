package control;

import java.util.HashMap;

public class CommandDictionary {

    private final HashMap<String, Command> commandMap = new HashMap<>();

    public Command get(String action) {
        return commandMap.get(action);
    }

    public void register(String action, Command command) {
        commandMap.put(action, command);
    }
}
