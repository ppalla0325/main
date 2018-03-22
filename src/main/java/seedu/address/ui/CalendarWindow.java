package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Controller for a Calendar Window.
 */
public class CalendarWindow extends UiPart<Stage> {

    public static final String CALENDAR_PAGE_URL =
            "https://accounts.google.com/ServiceLogin/identifier?service=cl&passive=1209600&osid=1&continue="
                    + "https%3A%2F%2Fcalendar.google.com%2Fcalendar%2Frender&followup=https%3A%2F%2Fcalendar"
                    + ".google.com%2Fcalendar%2Frender&scc=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

    private static final Logger logger = LogsCenter.getLogger(CalendarWindow.class);
    private static final String FXML = "CalendarWindow.fxml";

    @FXML
    private WebView browser;

    /**
     * Creates a new Calendar Window.
     *
     * @param root Stage to use as the root of the Calendar Window.
     */
    public CalendarWindow(Stage root) {
        super(FXML, root);

        browser.getEngine().load(CALENDAR_PAGE_URL);
    }

    /**
     * Creates a new Calendar Window.
     */
    public CalendarWindow() {
        this(new Stage());
    }

    /**
     * Shows the Calendar window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing Google Calendar window.");
        getRoot().show();
    }
}
