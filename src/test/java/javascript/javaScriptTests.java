package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

public class javaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable() {
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void testScrollToParagraph() {
        homePage.clickInfiniteScroll().scrollToParagraph(15);
    }
}
