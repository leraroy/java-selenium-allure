package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

import static common.Config.BROWSER;
import static common.Config.IMPLICITLY_WAIT;

public class CommonActions {

    public static WebDriver createDriver(){
        WebDriver driver=null;

        switch (BROWSER){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;
            case "chromeHeadless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--headless");
                driver=new ChromeDriver(options);
                break;
            case "firefoxHeadless":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options_f=new FirefoxOptions();
                options_f.addArguments("--headless");
                driver=new FirefoxDriver(options_f);
                break;
            default:
                System.out.println("Incorrect browser name"+BROWSER);
        }
        driver.manage().window().maximize();
        driver.manage()
                .timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
        return  driver;
    }
}
