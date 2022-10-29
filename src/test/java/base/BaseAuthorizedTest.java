package base;

import common.CommonActions;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;

import java.io.IOException;

import static util.ConfigReader.getEmail;
import static util.ConfigReader.getPassword;

public class BaseAuthorizedTest {
    WebDriver driver= CommonActions.createDriver();
    protected LoginPage loginPage =new LoginPage(driver);
    protected MainPage mainPage=new MainPage(driver);

    @Before
    public void setup() throws IOException {
        loginPage.login(getEmail(), getPassword());
    }

    public BaseTest baseTest(){
        return new BaseTest();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
