package tests.frames;

import main.pages.FramePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTests;

public class FramesTests extends BaseTests {

    @Test
    public void testFrames() {
        FramePage framePage = homePage.clickFrame();
        framePage.clearTextArea();
        String text1= "hello ";
        String text2 = "world";
        framePage.setTextArea(text1);
        framePage.ClickOnIncreaseIndentButton();
        framePage.setTextArea(text2);
        Assert.assertEquals(framePage.getTextFormEditor(),text1+text2, "invalid editor text");


    }

}
