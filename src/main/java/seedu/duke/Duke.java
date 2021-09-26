package seedu.duke;

import seedu.command.Command;
import seedu.command.ShowCommand;

import java.util.Locale;
import java.util.Scanner;

public class Duke {

    public static boolean isRunning = true;
    public static Scanner in = new Scanner(System.in);

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        System.out.println("Hello " + in.nextLine());
        run();
    }


    public static void run() {

        while (isRunning) {
            String input = in.nextLine();
            String[] splitInputs = input.split(" ");
            if (splitInputs[0].trim().equalsIgnoreCase(ShowCommand.COMMAND_NAME)) {
                Command command = new ShowCommand(splitInputs[1].trim().toUpperCase(Locale.ROOT));
                command.execute();
            }
        }
    }


}
