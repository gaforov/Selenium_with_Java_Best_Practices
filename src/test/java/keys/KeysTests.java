package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTests {

    @Test
    public void testBackspace() {
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPage.getResult(), "You entered: BACK_SPACE", "Backspace not pressed");
    }

    //@Test
    public void testPi() {
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterPi();
        assertEquals(keyPage.getResult(), "π = 3.14", "Incorrect symbol entered");
    }


}
