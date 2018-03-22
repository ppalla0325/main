package systemtests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.ui.testutil.GuiTestAssert.assertListMatching;

import org.junit.Test;

import guitests.GuiRobot;
import guitests.guihandles.CalendarWindowHandle;
import seedu.address.logic.commands.CalendarCommand;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.SelectCommand;
import seedu.address.ui.BrowserPanel;
import seedu.address.ui.StatusBarFooter;
/**
 * A system test class for the calendar window. */
public class CalendarCommandSystemTest extends AddressBookSystemTest {
    private static final String ERROR_MESSAGE = "Error when testing calendar command.";

    private final GuiRobot guiRobot = new GuiRobot();

    @Test
    public void openCalendarWindow() {

        //use command box
        executeCommand(CalendarCommand.COMMAND_WORD);
        assertCalendarWindowOpen();

        // open calendar window and give it focus
        executeCommand(CalendarCommand.COMMAND_WORD);
        getMainWindowHandle().focus();

        // assert that while the calendar window is open the UI updates correctly for a command execution
        executeCommand(SelectCommand.COMMAND_WORD + " " + INDEX_FIRST_PERSON.getOneBased());
        assertEquals("", getCommandBox().getInput());
        assertCommandBoxShowsDefaultStyle();
        assertNotEquals(CalendarCommand.SHOWING_CALENDAR_MESSAGE, getResultDisplay().getText());
        assertNotEquals(BrowserPanel.DEFAULT_PAGE, getBrowserPanel().getLoadedUrl());
        assertListMatching(getPersonListPanel(), getModel().getFilteredPersonList());

        // assert that the status bar too is updated correctly while the calendar window is open
        // note: the select command tested above does not update the status bar
        executeCommand(DeleteCommand.COMMAND_WORD + " " + INDEX_FIRST_PERSON.getOneBased());
        assertNotEquals(StatusBarFooter.SYNC_STATUS_INITIAL, getStatusBarFooter().getSyncStatus());
    }

    /**
     * Asserts that the calendar window is open, and closes it after checking.
     */
    private void assertCalendarWindowOpen() {
        assertTrue(ERROR_MESSAGE, CalendarWindowHandle.isWindowPresent());
        guiRobot.pauseForHuman();

        new CalendarWindowHandle(guiRobot.getStage(CalendarWindowHandle.CALENDAR_WINDOW_TITLE)).close();
        getMainWindowHandle().focus();
    }

    /**
     * Asserts that the calendar window isn't open.
     */
    private void assertCalendarWindowNotOpen() {
        assertFalse(ERROR_MESSAGE, CalendarWindowHandle.isWindowPresent());
    }

}
