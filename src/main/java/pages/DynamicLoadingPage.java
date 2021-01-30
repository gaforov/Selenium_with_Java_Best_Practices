package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;
    private By linkExample1 = By.xpath("//a[contains(text(),'Example 1')]");
    private By linkExample2 = By.xpath("//a[contains(text(),'Example 2')]");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DymanicExample1Page clickExample1() {
        driver.findElement(linkExample1).click();
        return new DymanicExample1Page(driver);
    }

    public DymanicExample2Page clickExample2() {
        driver.findElement(linkExample2).click();
        return new DymanicExample2Page(driver);
    }

    public DymanicExample2Page rightClickOnExample2Link() {
        driver.findElement(linkExample2).sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
        return new DymanicExample2Page(driver);
    }

}
