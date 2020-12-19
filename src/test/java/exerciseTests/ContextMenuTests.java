package exerciseTests;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testRightClickOnContextMenu() {
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickOnContextBox();
        String text = contextMenuPage.getPopUpText(); // read pop-up text
        contextMenuPage.acceptPopUp(); // click OK button
        assertEquals(text,"You selected a context menu","Popup text incorrect");
    }
}
