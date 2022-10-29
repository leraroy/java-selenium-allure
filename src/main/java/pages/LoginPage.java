package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import static common.Config.URLs.BASE_URL;

public class LoginPage extends BasePage {

    private final By emailField=By.id("email");
    private final By passwordField=By.id("pass");
    private final By signIn=By.name("send");
    private final By createAccountBtn=By.xpath("//div/a[@class='action create primary']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open "+BASE_URL+"/customer/account/login")
    public void open(){
        open(BASE_URL+"/customer/account/login");
    }

    @Step("Click on Sign in button")
    public void clickSignIn(){
        driver.findElement(signIn).click();
    }

    @Step("Login with username: {0}, password: {1}")
    public void login(String email, String password){
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        clickSignIn();
    }

    @Step("Click on Create Account button")
    public void clickCreateAccount(){
        driver.findElement(createAccountBtn).click();
    }

}
