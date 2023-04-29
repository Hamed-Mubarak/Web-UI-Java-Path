package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Chapter3_RelativeLocators {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testRelativeLocator(){
        WebElement checkboxes = driver.findElement(By.linkText("Checkboxes"));
        WebElement challengingDom = driver.findElement(RelativeLocator.with(By.linkText("Challenging DOM")).above(checkboxes));
        System.out.println(challengingDom.getText());
        challengingDom.click();
    }

    @Test
    public void testListOfElements(){
        List<WebElement> allUserNames = driver.findElements(with(By.tagName("br")).below(By.id("login_credentials")));
        for(WebElement userName:allUserNames){
            System.out.println(userName.getText());
        }
    }
}
