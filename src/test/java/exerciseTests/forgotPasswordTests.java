package exerciseTests;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class forgotPasswordTests extends BaseTests {

    @Test
    public void testRetrievePassword() {
        var forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.enterEmail("test@testemail.com");
        var emailSentPage = forgotPasswordPage.clickRetrievePassword();
        assertTrue(emailSentPage.emailSentMessageText().contains("Your e-mail's been sent!"),"Message text is incorrect");
    }
}
