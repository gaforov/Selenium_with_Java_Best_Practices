package pages.exercisePages;
/**
 * This page has one main frameset which has two frames inside (frame-top and frame-bottom). Frame-top has
 * frameset with three (child) frames inside (frame-left, frame-middle, frame-right)
 * You can directly visit frame-bottom, but to access frame-left-middle-right, first you need to switch to
 * frame-top then frame-left-middle-right.
 * To get back to main from inner frame(left-middle=right), you need to exit twice.
 * @return
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private String topFrame = "frame-top";
    private String leftFrame = "frame-left";
    private String bottomFrame = "frame-bottom";
    private By leftFrameText = By.xpath("//body[contains(text(), 'LEFT')]");
    private By bottomFrameText = By.xpath("//body[contains(text(), 'BOTTOM')]");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToTopFrame() {
        driver.switchTo().frame(topFrame);
    }

    public void switchToLeftFrame() {
        switchToTopFrame();
        driver.switchTo().frame(leftFrame);
    }

    public void switchToBottomFrame() {
        driver.switchTo().frame(bottomFrame);
    }

    public String getTextLeftFrame() {
        switchToLeftFrame();
        String text = driver.findElement(leftFrameText).getText();
        switchToMain(); //exit left to top(frame-left to frame-top)
        switchToMain(); // exit top to main(top frameset to main frameset)
        return text;
    }

    public String getTextBottomFrame() {
        switchToBottomFrame();
        String text = driver.findElement(bottomFrameText).getText();
        switchToMain();
        return text;
    }

    public void switchToMain() {
        driver.switchTo().parentFrame();
//        driver.switchTo().defaultContent();
    }
}
