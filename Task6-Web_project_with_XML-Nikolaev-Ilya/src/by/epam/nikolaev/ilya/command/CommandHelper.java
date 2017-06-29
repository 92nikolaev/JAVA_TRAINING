package by.epam.nikolaev.ilya.command;

import java.util.HashMap;
import java.util.Map;

import by.epam.nikolaev.ilya.command.imp.DeviceDOMParserCommand;
import by.epam.nikolaev.ilya.command.imp.DeviceSAXParserCommand;
import by.epam.nikolaev.ilya.command.imp.DeviceStAXParserCommand;

public class CommandHelper {
	private static CommandHelper instance;
	private Map<String,Command> commands = new HashMap<String, Command>();
	
	private CommandHelper() {
		commands.put("showSAX", new DeviceSAXParserCommand());
		commands.put("showStAX", new DeviceStAXParserCommand());
		commands.put("showDOM", new DeviceDOMParserCommand());
		
	}
	
	
	public static CommandHelper getInstance(){
		if (instance == null) {
			instance = new CommandHelper();
		}
		return instance;
	}
	public Command getCommand(String commandName) {
		Command command;
		command = commands.get(commandName);
		if (command != null) {
			return command;
		} else {
			return command;
		}
	}
	

}
