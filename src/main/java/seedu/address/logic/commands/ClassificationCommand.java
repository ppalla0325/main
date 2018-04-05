package seedu.address.logic.commands;

import seedu.address.model.person.NameContainsClassificationPredicate;

/**
 * Finds and lists all persons in the Personal Trainer Pro application whose BodyMassIndexClassification matches
 * any of the given keywords.
 */
public class ClassificationCommand extends Command {

    public static final String COMMAND_WORD = "bmi";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose BMI classification matches "
            + "any of the specified keywords (case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " overweight";

    private final NameContainsClassificationPredicate predicate;

    public ClassificationCommand(NameContainsClassificationPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute() {
        model.updateFilteredPersonList(predicate);
        return new CommandResult(getMessageForPersonListShownSummary(model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ClassificationCommand // instanceof handles nulls
                && this.predicate.equals(((ClassificationCommand) other).predicate)); // state check
    }
}
