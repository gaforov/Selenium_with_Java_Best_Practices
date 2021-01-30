package pages.exercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    private WebDriver driver;
    private By nestedFrames = By.linkText("Nested Frames");

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public NestedFramesPage clickNestFrames() {
        driver.findElement(nestedFrames).click();
        return new NestedFramesPage(driver);
    }


}
