package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

import static common.Config.URLs.BASE_URL;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    // Personal information
    private final By firstName=By.id("firstname");
    private final By lastName=By.id("lastname");
    private final By newsletterBox=By.id("is_subscribed");

    //Sign in information
    private final By emailField=By.name("email");
    private final By passwordField=By.id("password");
    private final By passwordConfirmation=By.id("password-confirmation");

    private final By createAccountBtn=By.xpath("(//button[@type='submit'])[2]");
    private final By messageError=By.xpath("//div[contains(@id,'error')]");


    @Step("Open "+BASE_URL+"/customer/account/create/")
    public void open() {
        open(BASE_URL+"/customer/account/create/");
    }

    @Step("Click on Create Account button")
    public void clickCreateAccount(){
        driver.findElement(createAccountBtn).click();
    }

    @Step("Register with: firstname: {0}, lastname: {1}, email: {2}, password: {3}")
    public void register(String firstname, String lastname, String email, String password){
        driver.findElement(firstName).sendKeys(firstname);
        driver.findElement(lastName).sendKeys(lastname);
        driver.findElement(newsletterBox).click();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(passwordConfirmation).sendKeys(password);
        clickCreateAccount();
    }

    @Step("Get text error message")
    public List<String> getTextErrorMessage(){
        return getTextListElements(messageError);
    }
}
