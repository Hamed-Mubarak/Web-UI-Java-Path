package tests.waits;

import main.pages.DynamicLoadingExample1Page;
import main.pages.DynamicLoadingExample2Page;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTests;

public class WaitTests extends BaseTests {

    @Test
    public void testWaitUntilHidden(){
        DynamicLoadingExample1Page dynamicLoadingExample1Page = homePage.clickDynamicLoading().clickExample1();
        dynamicLoadingExample1Page.clickStart();
        Assert.assertEquals(dynamicLoadingExample1Page.getLoadedText(),"Hello World!", "invalid text");
    }

    @Test
    public void testWaitTilVisibleElement(){
        DynamicLoadingExample2Page dynamicLoadingExample2Page = homePage.clickDynamicLoading().clickExample2();
        dynamicLoadingExample2Page.clickStart();
        Assert.assertEquals(dynamicLoadingExample2Page.getLoadedText(),"Hello World!", "invalid text");
    }

}
