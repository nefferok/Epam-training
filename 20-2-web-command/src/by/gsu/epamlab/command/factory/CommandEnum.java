package by.gsu.epamlab.command.factory;

import by.gsu.epamlab.command.*;

import java.util.function.Supplier;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;

public enum CommandEnum {
    LOGIN(LoginCommand::new),
    REGISTRATION(RegistrationCommand::new),
    LOGOUT(LogoutCommand::new),
    MAIN(MainCommand::new),
    OPERATIONS(OperationCommand::new),
    ADD(AddCommand::new);

    private final Supplier<ActionCommand> command;

    CommandEnum(Supplier<ActionCommand> command) {
        this.command = command;
    }

    public static ActionCommand getCommand(String url) {
        return valueOf(url.replaceAll(REG_PATH, DEL).toUpperCase()).command.get();
    }
}