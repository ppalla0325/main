package seedu.address.ui;

import static org.junit.Assert.assertEquals;
import static seedu.address.ui.CalendarWindow.CALENDAR_PAGE_URL;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;

import guitests.guihandles.CalendarWindowHandle;
import javafx.stage.Stage;

public class CalendarWindowTest extends GuiUnitTest {

    private CalendarWindow calendarWindow;
    private CalendarWindowHandle calendarWindowHandle;

    @Before
    public void setUp() throws Exception {
        guiRobot.interact(() -> calendarWindow = new CalendarWindow());
        Stage calendarWindowStage =
                FxToolkit.setupStage((stage) -> stage.setScene(calendarWindow.getRoot().getScene()));
        FxToolkit.showStage();
        calendarWindowHandle = new CalendarWindowHandle(calendarWindowStage);
    }

    @Test
    public void display() {
        String encodedUrl = null;

        try {
            encodedUrl = URLEncoder.encode(CALENDAR_PAGE_URL, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.err.println("Caught UnsupportedEncodingException: " + e.getMessage());
        }
        try {
            URL expectedCalendarPage = new URL(encodedUrl);
            assertEquals(expectedCalendarPage, calendarWindowHandle.getLoadedUrl());
        } catch (MalformedURLException e) {
            System.err.println("Caught MalformedURLException: " + e.getMessage());
        }
    }
}
