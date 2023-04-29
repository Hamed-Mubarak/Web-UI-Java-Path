package tests.base;

import com.google.common.io.Files;
import main.pages.HomePage;
import main.utils.CookieManager;
import main.utils.EventReporter;
import main.utils.WindowManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("disable-infobars");
        //options.setHeadless(true);
        driver = new EventFiringWebDriver(new ChromeDriver(options));
        driver.register(new EventReporter());
        goHome();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterMethod
    //ITestResult is a package found from TestNG to record the result of failed tests
    public void recordFailure(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus())
        {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            // Files from google.common.io
            Files.move(screenshot, new File(
                    "resources/screenshots/" + result.getName() + ".png"));
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    public CookieManager getCookieManager(){
        return new CookieManager(driver);
    }
}
