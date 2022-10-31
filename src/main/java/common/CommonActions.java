package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static common.Config.BROWSER;
import static common.Config.IMPLICITLY_WAIT;

public class CommonActions {

    public static WebDriver createDriver(){
        WebDriver driver=null;

        switch (BROWSER){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
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
