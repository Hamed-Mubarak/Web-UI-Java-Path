package tests.hovers;

import main.pages.HoversPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTests;

public class HoversTests extends BaseTests {

    @Test
    public void testHoverUser1(){
        HoversPage hoversPage = homePage.clickOnHovers();
        HoversPage.FigureCaption caption = hoversPage.hoverOverFigure(1);
        Assert.assertTrue(caption.isCaptionDisplayed(),"Caption is not displayed");
        Assert.assertEquals(caption.getTitle(),"name: user1", "incorrect caption title");
        Assert.assertEquals(caption.getLinkText(),"View profile","incorrect caption link text");
        Assert.assertTrue(caption.getLink().endsWith("/users/1"),"incorrect link");
    }
}
