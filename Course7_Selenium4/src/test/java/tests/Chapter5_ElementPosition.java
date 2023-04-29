package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Chapter5_ElementPosition {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://testautomationu.applitools.com/learningpaths.html");
    }

    @Test
    public void getPositionDimension(){
        WebElement logoTAU = driver.findElement(
                By.xpath("//div[@id='app']//header/a/img"));
        Rectangle rectTAULogo = logoTAU.getRect();
        System.out.println("X: " + rectTAULogo.getX());
        System.out.println("Y: " + rectTAULogo.getY());
        System.out.println("Width: " + rectTAULogo.getWidth());
        System.out.println("Height: " + rectTAULogo.getHeight());
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
