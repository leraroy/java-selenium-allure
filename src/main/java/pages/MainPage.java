package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

import static common.Config.URLs.BASE_URL;

public class MainPage extends BasePage {

    private final By listNavigationButton=By.cssSelector("li[class*='level0']>a");
    private final By promoBanner=By.cssSelector(".blocks-promo span[class*='button']");
    private final By listIcon=By.cssSelector(".blocks-promo span[class*='icon']");
    private final By subscribeBtn=By.cssSelector("[title='Subscribe']");
    private final By emailInput=By.cssSelector("label [type='email']");

    private final By title=By.cssSelector("h1>span");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get(BASE_URL);
    }

    @Step("Click on promo button")
    public void clickPromoButton(){
        driver.findElement(promoBanner).click();
    }

    @Step("Get list icons")
    public List<WebElement> listIcons(){
        return driver.findElements(listIcon);
    }

    @Step("Get list navigation button")
    public List<WebElement> listNavButton(){
        return driver.findElements(listNavigationButton);
    }

    @Step("Get text title")
    public String getTextTitle(){
        return driver.findElement(title).getText();
    }

    @Step("Click on navigation button and get titles new pages")
    public List<String> clickListNavButtonAndGetTextTitle(){
        int size=listNavButton().size();
        List<String> result=new ArrayList<>();
        for (int i=0; i<size; i++){
            listNavButton().get(i).click();
            result.add(getTextTitle());
            driver.navigate().back();
        }
        return result;
    }

    @Step("Click on icons on banners and get titles new pages")
    public List<String> clickListIconAndGetTextTitle(){
        int size=listIcons().size();
        List<String> result=new ArrayList<>();
        for (int i=0; i<size; i++){
            listIcons().get(i).click();
            result.add(getTextTitle());
            driver.navigate().back();
        }
        return result;
    }

    @Step("Subscribe")
    public void subscribe(String email) throws InterruptedException {
        driver.findElement(emailInput).sendKeys(email);
        Thread.sleep(300);
        driver.findElement(subscribeBtn).click();
    }

}
