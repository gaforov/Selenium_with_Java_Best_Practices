package exerciseTests;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NestedFramesTests extends BaseTests {

    @Test
    public void testNestedFramesText() {
        var framesPage = homePage.clickFrames();
        var nestedFramesPage = framesPage.clickNestFrames();
        String leftText = nestedFramesPage.getTextLeftFrame();
        String bottomText = nestedFramesPage.getTextBottomFrame();

        assertEquals(leftText,"LEFT","Left frame text is incorrect");
        assertEquals(bottomText,"BOTTOM", "Bottom frame text is incorrect");

    }
}
