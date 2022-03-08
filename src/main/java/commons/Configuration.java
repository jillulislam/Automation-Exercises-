package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Configuration {

 public static WebDriver driver;


    public static void browser() {

        String browser = "Chrome";

        if (browser == "Chrome") {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser == "Firefox") {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser == "Edge") {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeClass
    public static void openBrowser(){
        browser();
    }

//    @AfterClass
//    public static void closeBrowser(){
//        driver.close();
//    }
}

