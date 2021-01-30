package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr"; //instead of WebElement we can also use String, iFrame accepts it.
    private By textArea = By.id("tinymce");
    private By increaseIndentButton = By.xpath("//button[@title='Increase indent']");

    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void increaseIndention() {
        driver.findElement(increaseIndentButton).click();
    }

    public void clearTextArea() {
        switchToEditArea();
//        driver.findElement(textArea).sendKeys(Keys.CLEAR);
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text) {
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public String getTextFromEditor() {
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }


    public void switchToEditArea() {
        driver.switchTo().frame(editorIframeId); // alternatively, you can switch by iFrame index or WebElement as well.
    }

    public void switchToMainArea() {
        driver.switchTo().parentFrame();
    }
}
