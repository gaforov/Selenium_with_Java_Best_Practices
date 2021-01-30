package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class DymanicExample1Page {
    private final WebDriver driver;
    private final By startButton = By.xpath("//div[@id='start']/button");
    private final By loadingIndicator = By.id("loading");
    private final By loadedText = By.id("finish");

    public DymanicExample1Page(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method used for: Wait until "loading..." message disappears.
     */
    public void clickStart() {
        driver.findElement(startButton).click();
//        WebDriverWait wait = new WebDriverWait(driver,5);
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));

        //This is same as line 27-28 above, fluent wait used instead of explicit wait.
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
    }

    public String getLoadedText() {
        return driver.findElement(loadedText).getText();
    }

}
