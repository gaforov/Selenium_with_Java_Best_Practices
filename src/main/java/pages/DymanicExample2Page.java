package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DymanicExample2Page {
    private final WebDriver driver;
    private final By startButton = By.cssSelector("#start button");
    private final By loadedText = By.cssSelector("#finish h4");

    public DymanicExample2Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStart() {
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfElementLocated(loadedText));
        //visibilityOfElementLocated also works, but not visibilityOf
    }

    public String getLoadedText() {
        return driver.findElement(loadedText).getText();
    }

    public boolean isStartButtonDisplayed() {
        return driver.findElement(startButton).isDisplayed();
    }
}
