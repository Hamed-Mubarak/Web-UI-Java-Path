package tests.frames;

import main.pages.NestedFramesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTests;

public class NestedFramesTests extends BaseTests {

    @Test
    public void testNestedFrames(){
        NestedFramesPage nestedFramesPage = homePage.clickFrameEx().clickOnNestedFrames();
        Assert.assertEquals(nestedFramesPage.getTextFromLeftFrame(), "LEFT", "invalid left frame");
        Assert.assertEquals(nestedFramesPage.getTextFromBottomFrame(), "BOTTOM", "Invalid bottom frame");
    }
}
