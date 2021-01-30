package navigation;

import base.BaseTests;
import org.testng.annotations.Test;


public class NavigationTests extends BaseTests {

    @Test
    public void testNavigation() {
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }

    @Test
    public void testSwitchToTab() {
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }
}
