package com.polyteh.taxi.command;

import com.polyteh.taxi.command.admin.ChangeCarStatusCommand;
import com.polyteh.taxi.command.admin.GetCarsListCommand;
import com.polyteh.taxi.command.client.*;
import com.polyteh.taxi.command.common.*;
import com.polyteh.taxi.controller.FrontController;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.TreeMap;

/**
 * Command Container holds all commands and provides access to them.
 *
 * @author L. Antonyk
 * @see FrontController
 */
public class CommandContainer {
    private static final Logger LOGGER = Logger.getLogger(CommandContainer.class);

    private static Map<String, Command> commands = new TreeMap<>();

    static {
        //Common commands
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("noCommand", new NoCommand());
        commands.put("changeLanguage", new ChangeLanguageCommand());

        //Client commands
        commands.put("registration", new RegistrationCommand());
        commands.put("checkOrder", new CheckOrderCommand());
        commands.put("createOrder", new CreateOrderCommand());
        commands.put("analogOrder", new AnalogOrderCommand());
        commands.put("getCarInfo", new GetCarInfoCommand());
        commands.put("deleteOrder", new DeleteOrderCommand());

        //Admin commands
        commands.put("getOrdersList", new GetOrdersListCommand());
        commands.put("getCarsList", new GetCarsListCommand());
        commands.put("changeCarStatus", new ChangeCarStatusCommand());

        LOGGER.debug("Command container was successfully initialized");
        LOGGER.trace("Number of commands " + commands.size());
    }

    public static Command getCommand(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            LOGGER.trace("Command not found, name " + commandName);
            return commands.get("noCommand");
        }

        return commands.get(commandName);
    }

}
