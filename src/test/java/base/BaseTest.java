package base;

import common.CommonActions;
import data.RandomData;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.LoginPage;
import pages.MainPage;
import pages.SignUpPage;
import pages.base.BasePage;
import pages.women.tops.TopsPage;

import java.util.List;

import static org.hamcrest.Matchers.equalToIgnoringCase;

public class BaseTest {
    WebDriver driver=CommonActions.createDriver();
    protected BasePage basePage=new BasePage(driver);
    protected MainPage mainPage=new MainPage(driver);
    protected SignUpPage signUpPage=new SignUpPage(driver);
    protected AccountPage accountPage=new AccountPage(driver);
    protected LoginPage loginPage=new LoginPage(driver);
    protected RandomData randomData=new RandomData();
    protected TopsPage topsPage=new TopsPage(driver);

    @Step("Verify: {0} equals {1}")
    public void assertEquals(String actual, String expected){
        Assert.assertEquals(expected, actual);
    }

    @Step("Verify: {0} contains {1}")
    public void assertContains(String actual, String expected){
        Assert.assertTrue(actual.contains(expected));
    }

    @Step("Verify: current url contains {1}")
    public void toHaveUrl(String expected){
        Assert.assertTrue(driver.getCurrentUrl().contains(expected));
    }

    @Step("Verify: {0} equals count {1}")
    public void assertEqualsCount(int actual, int expected){
        Assert.assertEquals(expected,actual);
    }

    @Step("Verify: {0} contains {1}")
        public void assertContains(List<String> actual, String  expected){
        Assert.assertTrue(actual.contains(expected));
    }

    @Step("Verify: {0} contains list {1}")
    public void assertContainsList(List<String> title,List<String> name){
        for(int i=0; i<name.size(); i++){
            Assert.assertThat(name.get(i), equalToIgnoringCase(title.get(i)));
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
