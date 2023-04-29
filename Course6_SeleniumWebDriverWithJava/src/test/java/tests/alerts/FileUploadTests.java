package tests.alerts;

import main.pages.FileUploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTests;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload(){
        FileUploadPage fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.uploadFile("E:/Hamed/Hamed/Work/4-Vodafone/Vodafone/Hamed.CV.pdf");
        Assert.assertEquals(fileUploadPage.getUploadedFiles(), "Hamed.CV.pdf", "invalid uploaded file name");
    }
}
