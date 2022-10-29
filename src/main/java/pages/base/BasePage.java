package pages.base;

import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static common.Config.EXPLICITLY_WAIT;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    private final By messageError=By.xpath("//div[contains(@id,'error')]");
    private final By messageAlert=By.cssSelector("[role='alert']>div>div");

    public void open(String url){
        driver.get(url);
    }

    public List<String> getTextListElements(By byElements){
        List<WebElement> elements=driver.findElements(byElements);
        List<String> result=new ArrayList<>();
        for (WebElement el:
                elements) {
            result.add(el.getText());
        }
        return result;
    }

    public void waitVisibleElement(WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(EXPLICITLY_WAIT))
                .until(ExpectedConditions.visibilityOfAllElements(element));
    }

    @Step("Get text error message")
    public List<String> getTextMessageError(){
        waitVisibleElement(driver.findElement(messageError));
        return getTextListElements(messageError);
    }

    @Step("Get text alert message")
    public String getTextMessageAlert() throws InterruptedException {
        Thread.sleep(200);
        return driver.findElement(messageAlert).getText();
    }



}
