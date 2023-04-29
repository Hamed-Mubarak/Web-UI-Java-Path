package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage {
    private WebDriver driver;
    private String editorFrameID = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By IncreaseIndentButton = By.cssSelector("button[title='Increase indent']");

    public FramePage(WebDriver driver) {this.driver=driver;}

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    private void switchToEditArea(){
        driver.switchTo().frame(editorFrameID);
    }
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
    public void ClickOnIncreaseIndentButton(){
        driver.findElement(IncreaseIndentButton).click();
    }
    public String getTextFormEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }


}
