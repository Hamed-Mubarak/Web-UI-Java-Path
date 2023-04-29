package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Chapter7b_ConsoleLogs {

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
    public void viewBrowserConsoleLogs(){
        // Get The DevTools
        DevTools devTools = driver.getDevTools();
        // createSession to take the control of dev tools panel to the browser
        devTools.createSession();
        /**
         * send(Log.enable()) send
         * send()-> allows us to interact with devtools it accepts nuilt in commands and commands as a paramater
         * Log-> it represents some kind of model of the cpd domain
         * enable()-> is a command to listen to the logs
         */
        devTools.send(Log.enable());
        // entryAdded is an event
        // hypens (--) it's purpose to separate the entries
        devTools.addListener(Log.entryAdded(), logEntry ->  {
            System.out.println("----------");
            System.out.println("level: " + logEntry.getLevel());
            System.out.println("Text: " + logEntry.getText());
            System.out.println("BrokeUrl: " + logEntry.getUrl());
        });
        // Load the AUT
            driver.get("https://the-internet.herokuapp.com/broken_images");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
