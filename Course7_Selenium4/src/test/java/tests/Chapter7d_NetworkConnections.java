package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

public class Chapter7d_NetworkConnections {

    ChromeDriver driver;
    DevTools devTools;

    @BeforeMethod
    public void  setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        devTools = driver.getDevTools();
    }

    @Test
    public void  enableSlowHamed(){
        devTools.createSession();
        devTools.send(Network.enable(
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(
                false,
                150,
                2500,
                2000,
                Optional.of(ConnectionType.CELLULAR3G)));
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println("Enable Slow Network: " + driver.getTitle());
    }

    @Test
    public void  doNotEnableHamed(){
        driver.get("https://RexJones2.com");
        System.out.println("Do Not Enable Slow Network: " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
