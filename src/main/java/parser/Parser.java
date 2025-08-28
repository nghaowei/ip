package parser;


import command.*;
import exception.GenieweenieException;


/**
 * Parses user input into commands.
 */
public class Parser {


    /**
     * Parses user input.
     *
     * @param fullCommand full user input
     * @return Command object
     * @throws GenieweenieException if command is invalid
     */
    public static Command parse(String fullCommand) throws GenieweenieException {
        String[] parts = fullCommand.split(" ", 2);
        String commandWord = parts[0];


        switch (commandWord) {
            case "bye":
                return new ExitCommand();
            case "add":
                return new AddCommand(parts[1]);
            default:
                throw new GenieweenieException("Unknown command: " + commandWord);
        }
    }
}