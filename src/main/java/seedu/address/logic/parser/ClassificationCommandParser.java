package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.ClassificationCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.NameContainsClassificationPredicate;

/**
 * Parses input classifications and creates a new ClassificationCommand object
 */
public class ClassificationCommandParser implements Parser<ClassificationCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ClassificationCommand
     * and returns an ClassificationCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ClassificationCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ClassificationCommand.MESSAGE_USAGE));
        }

        String[] classificationKeywords = trimmedArgs.split("\\s+");

        return new ClassificationCommand(
                new NameContainsClassificationPredicate(Arrays.asList(classificationKeywords)));
    }

}
