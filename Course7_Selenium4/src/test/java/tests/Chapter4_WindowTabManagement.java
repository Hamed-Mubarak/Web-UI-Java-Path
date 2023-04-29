package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Chapter4_WindowTabManagement {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        System.out.println("Title is : " + driver.getTitle());
    }

    @Test
    public void testNewWindowTab(){
        WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
        newWindow.get("https://magento.softwaretestingboard.com/sales/guest/form/");
        System.out.println("Title is : " + driver.getTitle());
    }

    @Test
    public void testWorkingOnBothWindowTabs(){
        driver.switchTo().newWindow((WindowType.TAB)).get("https://magento.softwaretestingboard.com/customer/account/create/");
        System.out.println("Title is : " + driver.getTitle());
        driver.findElement(By.id("firstname")).sendKeys("Hamed");
        driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
        // to get all specific alphanumeric window handles ids
        Set <String> allowWindowTabs = driver.getWindowHandles();
        // to iterate over the windows handles
        Iterator <String> iterator = allowWindowTabs.iterator();
        String mainFirstWindow = iterator.next();
        driver.switchTo().window(mainFirstWindow);
        driver.findElement(By.cssSelector("div.content-heading h2.title"));
        System.out.println("Title is : " + driver.getTitle());

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
