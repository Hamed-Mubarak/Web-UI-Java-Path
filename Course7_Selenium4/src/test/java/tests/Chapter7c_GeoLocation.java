package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Chapter7c_GeoLocation {

    ChromeDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void mockGeoLocationCdpCommand(){
        Map coordinates = new HashMap()
        {{
            put("latitude", 29.9888489);
            put("longitude", 31.3062551);
            put("accuracy", 1);
        }};
        // open Chrome dev tools documentation and search with Geolocation
        driver.executeCdpCommand(
                "Emulation.setGeolocationOverride", coordinates );
        driver.get("https://where-am-i.org/");
    }

    @Test
    public void mockGeoLocationDevTools(){
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(Optional.of(29.9888489),Optional.of(31.3062551),Optional.of(1)));
        driver.get("https://where-am-i.org/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
