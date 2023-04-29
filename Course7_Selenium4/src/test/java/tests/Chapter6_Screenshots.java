package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Chapter6_Screenshots {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://applitools.com");
    }

    @Test
    public void takeWebElementScreenshot() throws IOException {
        WebElement nextGenerationPlatform = driver.findElement(By.cssSelector("#post-8 h1"));
        File source = nextGenerationPlatform.getScreenshotAs(OutputType.FILE);
        File destination = new File(
                "resources/screenshots/Next Generation Platform.png");
        FileHandler.copy(source,destination);
    }

    @Test
    public void takeWebElementPageSectionScreenshot() throws IOException {
        WebElement aplitoolsPageSection = driver.findElement(By.cssSelector("#post-8>header"));
        File source = aplitoolsPageSection.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File(
                "resources/screenshots/Page Section Screenshot.png"));
    }

    @Test
    public void takeFullPageScreenshot() throws IOException {
        // cast the driver to be firefox driver as it's the only driver supports full page screenshot
        // it can not be cast as chrome options is passed so we have de setup firefox driver
        File source = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileHandler.copy(source, new File("resources/screenshots/Full Page Screenshot.png"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
