package seedu.command;

import seedu.parser.JsonParser;

public class ShowCommand extends Command {

    public static final String COMMAND_NAME = "show";
    private final String SHOWTERM;

    public ShowCommand(String showTerm) {
        this.SHOWTERM = showTerm;
    }

    public void execute() {
        JsonParser.parseFetch(SHOWTERM);
    }
}
