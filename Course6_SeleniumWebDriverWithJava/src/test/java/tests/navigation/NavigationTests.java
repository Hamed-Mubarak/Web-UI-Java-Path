package tests.navigation;

import main.pages.DynamicLoadingExample2Page;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTests;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigator(){
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().goForward();
        getWindowManager().refreshPage();
        getWindowManager().goTo("https://www.google.com");
    }

    @Test
    public void testSwitchToTab(){
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }

    @Test
    public void testWindowTabs(){
        DynamicLoadingExample2Page dynamicLoadingExample2Page = homePage.clickDynamicLoading().rightClickOnExample2Link();
        getWindowManager().switchToNewTab();
        Assert.assertTrue(dynamicLoadingExample2Page.isStartButtonDisplayed(), "Start button is not displayed");
    }
}
