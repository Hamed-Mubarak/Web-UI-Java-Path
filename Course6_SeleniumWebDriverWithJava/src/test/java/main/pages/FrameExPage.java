package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameExPage {

    private WebDriver driver;

    public FrameExPage(WebDriver driver){ this.driver = driver;}

    public NestedFramesPage clickOnNestedFrames() {
        clickLink("Nested Frames");
        return new NestedFramesPage(driver);
    }

    public void clickLink (String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
}
