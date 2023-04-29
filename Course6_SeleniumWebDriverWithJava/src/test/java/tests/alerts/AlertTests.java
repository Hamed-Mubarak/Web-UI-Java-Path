package tests.alerts;

import main.pages.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTests;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert() {

        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        Assert.assertEquals(alertsPage.alert_getText(),"I am a JS Alert", "incorrect alert message");
        alertsPage.alert_clickToAccept();
        Assert.assertEquals(alertsPage.getResult(), "You successfully clicked an alert", "Result is incorrect");
    }

    @Test
    public void testDismissAlert() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        Assert.assertEquals(alertsPage.alert_getText(),"I am a JS Confirm", "incorrect alert message");
        alertsPage.alert_clickToDismiss();
        Assert.assertEquals(alertsPage.getResult(), "You clicked: Cancel", "Result is incorrect");
    }

    @Test
    public void testConfirmPromptAlert_withText() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        String text = "Hamed";
        alertsPage.triggerPrompt();
        Assert.assertEquals(alertsPage.alert_getText(),"I am a JS prompt", "incorrect alert message");
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        Assert.assertEquals(alertsPage.getResult(), "You entered: " + text, "Result is incorrect");
    }

    @Test
    public void testConfirmPromptAlert_withoutText() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        String text = "";
        alertsPage.triggerPrompt();
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        Assert.assertEquals(alertsPage.getResult(), "You entered:" , "Result is incorrect");
    }

    @Test
    public void testDismissPromptAlert() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        String text = "Hamed";
        alertsPage.triggerPrompt();
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToDismiss();
        Assert.assertEquals(alertsPage.getResult(), "You entered: null", "Result is incorrect");
    }
}