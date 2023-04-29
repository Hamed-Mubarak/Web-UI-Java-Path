package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private String topFrame = "frame-top";
    private String bottomFrame = "frame-bottom";
    private String leftFrame = "frame-left";
    private By body = By.tagName("body");

    public NestedFramesPage(WebDriver driver){this.driver=driver;}

    public void switchToTopFrame(){driver.switchTo().frame(topFrame);}
    public void switchToBottomFrame(){driver.switchTo().frame(bottomFrame);}
    public void switchToMainFrame(){driver.switchTo().parentFrame();}
    public void switchToLeftFrame(){
        switchToTopFrame();
        driver.switchTo().frame(leftFrame);
    }
    public String getTextFromLeftFrame(){
        switchToLeftFrame();
        String text = driver.findElement(body).getText();
        switchToMainFrame();
        switchToMainFrame();
        return text;
    }
    public String getTextFromBottomFrame(){
        switchToBottomFrame();
        String text = driver.findElement(body).getText();
        switchToMainFrame();
        return text;
    }

}
