import base.BaseTest;

import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static util.ConfigReader.getEmail;
import static util.ConfigReader.getPassword;

@Epic("Tests")
@Feature("Login tests")
public class SignInTest extends BaseTest {

    @Before
    public void setup(){
        loginPage.open();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Description: Login with valid credentials")
    @Story("Login with valid credentials")
    public void loginWithValidCreds() throws IOException {
        loginPage.login(getEmail(),getPassword());
        assertEquals(accountPage.getTextTitle(), "My Account");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Description: Login with empty credentials")
    @Story("Login with empty credentials")
    public void loginWithEmptyCreds() throws InterruptedException {
        loginPage.clickSignIn();
        assertContains(basePage.getTextMessageAlert(), "A login and a password are required");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Description: Login with invalid credentials")
    @Story("Login with invalid credentials")
    public void loginWithInvalidCreds() throws InterruptedException {
        loginPage.login(randomData.getEmail(),randomData.getInvalidPassword());
        assertContains(basePage.getTextMessageAlert(), "The account sign-in was incorrect");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Description: Click on Create Account button, and show page Create Account")
    @Story("Click on Create Account button, and show page Create Account")
    public void clickCreateAccount(){
        loginPage.clickCreateAccount();
        toHaveUrl("account/create/");
    }

}
