package pages.exercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;
    private By forgotPasswordField = By.id("email");
    private By retrievePasswordButton = By.cssSelector("#form_submit i");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(forgotPasswordField).sendKeys(email);
    }

    public EmailSentPage clickRetrievePassword() {
        driver.findElement(retrievePasswordButton).click();
        return new EmailSentPage(driver);
    }

}
