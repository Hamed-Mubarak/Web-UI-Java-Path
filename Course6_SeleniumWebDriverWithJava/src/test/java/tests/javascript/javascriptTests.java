package tests.javascript;

import main.pages.InfiniteScrollPage;
import main.pages.LargeAndDeepDomPage;
import org.testng.annotations.Test;
import tests.base.BaseTests;

public class javascriptTests extends BaseTests {

    @Test
    public void testScrollToTable(){
        LargeAndDeepDomPage largeAndDeepDomPage = homePage.clickLargeAndDeepDOM();
        largeAndDeepDomPage.scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph(){
        InfiniteScrollPage infiniteScrollPage = homePage.clickInfiniteScroll();
        infiniteScrollPage.scrollToParagraph(5);
    }
}
