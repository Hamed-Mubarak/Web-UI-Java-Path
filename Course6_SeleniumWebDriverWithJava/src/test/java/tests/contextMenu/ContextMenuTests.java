package tests.contextMenu;

import main.pages.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTests;

public class ContextMenuTests extends BaseTests {

    @Test
    public void TestContextMenu(){
        ContextMenuPage contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickOnContextBox();
        Assert.assertEquals(contextMenuPage.getAlertText(), "You selected a context menu", "Incorrect Alert message");
        contextMenuPage.alert_clickConfirm();
    }
}
