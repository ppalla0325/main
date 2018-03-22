package seedu.address.model.person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.address.testutil.Assert;


public class HeightTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> new Height(null));
    }

    @Test
    public void constructor_invalidHeight_throwsIllegalArgumentException() {
        String invalidHeight = "";
        Assert.assertThrows(IllegalArgumentException.class, () -> new Height(invalidHeight));
    }

    @Test
    public void isValidHeight() {
        // null height
        Assert.assertThrows(NullPointerException.class, () -> Height.isValidHeight(null));

        // invalid height
        assertFalse(Height.isValidHeight("")); // empty string
        assertFalse(Height.isValidHeight(" ")); // spaces only
        assertFalse(Height.isValidHeight("height")); // non-numeric
        assertFalse(Height.isValidHeight("9p.2")); // alphabets within digits
        assertFalse(Height.isValidHeight("9 3")); // spaces within digits

        // valid height numbers
        assertTrue(Height.isValidHeight("91.1")); // exactly 3 numbers
        assertTrue(Height.isValidHeight("95"));
        assertTrue(Height.isValidHeight("205")); // tall height
    }
}
