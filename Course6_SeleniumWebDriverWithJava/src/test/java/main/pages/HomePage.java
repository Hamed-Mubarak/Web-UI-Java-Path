package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver ;
    }

    public LoginPage clickOnFormAuthentication(){
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropDownPage clickOnDropDown() {
        clickLink("Dropdown");
        return new DropDownPage(driver);
    }

    public HoversPage clickOnHovers() {
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickOnKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public AlertsPage clickJavaScriptAlerts(){
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public FileUploadPage clickFileUpload(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public ContextMenuPage clickContextMenu(){
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public FramePage clickFrame(){
        clickLink("WYSIWYG Editor");
        return new FramePage(driver);
    }

    public FrameExPage clickFrameEx(){
        clickLink("Frames");
        return new FrameExPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public LargeAndDeepDomPage clickLargeAndDeepDOM(){
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(driver);
    }

    public InfiniteScrollPage clickInfiniteScroll(){
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }

    public MultipleWindowPage clickMultipleWindows(){
        clickLink("Multiple Windows");
        return new MultipleWindowPage(driver);
    }

    public void clickLink (String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
}
