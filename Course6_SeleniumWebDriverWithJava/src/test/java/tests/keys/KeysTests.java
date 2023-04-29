package tests.keys;

import main.pages.KeyPressesPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTests;

public class KeysTests extends BaseTests {

    @Test
    public void testBackSpace(){
        KeyPressesPage keyPressesPage = homePage.clickOnKeyPresses();
        keyPressesPage.enterText("A" + Keys.BACK_SPACE);
        Assert.assertEquals(keyPressesPage.getResult(),"You entered: BACK_SPACE");
    }

    @Test
    public void testPrecent(){
        KeyPressesPage keyPressesPage = homePage.clickOnKeyPresses();
        keyPressesPage.enterPrecent();
    }


}
