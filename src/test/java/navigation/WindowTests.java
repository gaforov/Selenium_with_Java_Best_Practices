package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertTrue;

public class WindowTests extends BaseTests {

    @Test
    public void testOpenInNewWindow() throws InterruptedException {
        var dynamicLoadingPage = homePage.clickDynamicLoading().rightClickOnExample2Link();
        Thread.sleep(3000);
        getWindowManager().switchToNewTab();
        Thread.sleep(3000);

        assertTrue(dynamicLoadingPage.isStartButtonDisplayed(),"Start button is NOT displayed");


    }
}
