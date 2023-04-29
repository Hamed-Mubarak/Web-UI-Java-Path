package tests.login;

import main.pages.LoginPage;
import main.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTests;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickOnFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickOnLoginButton();
        Assert.assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"),
                "Alert text is incorrect");
    }
}
