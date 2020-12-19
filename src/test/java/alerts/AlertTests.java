package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AlertsPage;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {
//    AlertsPage alertsPage = homePage.clickJavaScriptAlerts(); // why resulting null?

    @Test
    public void testAcceptAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getResultText(),"You successfuly clicked an alert","Result message is incorrect");
    }

    @Test
    public void testGetTextFromAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.getAlertText();
        alertsPage.cancelAlert();
        assertEquals(text, "I am a JS Confirm", "Alert text is incorrect");
    }

    @Test
    public void testSetInputTextInAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text = "This is testing Alert!";
        alertsPage.setInputTextInAlert(text);
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getResultText(),"You entered: " + text,"Result text is incorrect");
    }
}
