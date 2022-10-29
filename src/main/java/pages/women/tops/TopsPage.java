package pages.women.tops;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

import static common.Config.URLs.BASE_URL;

public class TopsPage extends BasePage {

    private final By listFilters=By.cssSelector("[class*='filter-options-item']");
    private final By listFiltersItem=By.xpath("//div[contains(@class, 'active') and @role='presentation']//a");
    private final By currentFilters=By.cssSelector(".items .filter-value");


    public TopsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open "+BASE_URL+"/women/tops-women.html")
    public void open(){
        open(BASE_URL+"/women/tops-women.html");
    }

    @Step("Click filter {0}")
    public void clickFilterByName(String nameFilter){
        driver.findElement(By.xpath("//div[contains(text(), '"+nameFilter+"')]")).click();
    }

    @Step("Click item filter {0}")
    public void clickFilterItemByText(String nameFilterItem){
        driver.findElement(By.xpath("//div[contains(@class, 'active')]//a[contains(text(),'"+nameFilterItem+"')]")).click();
    }

    @Step("Click item filter {0}")
    public void clickFilterItemByOption(String nameFilterItem){
        driver.findElement(By.xpath("//div[contains(@class, 'active')]//div[contains(@option-label,'"+nameFilterItem+"')]")).click();
    }

    @Step("Get list filters elements")
    public List<WebElement> listFilters(){
        return driver.findElements(listFilters);
    }

    @Step("Choose Shopping Options: name filter: {0}, name item{1}")
    public void chooseOptionShopByText(String nameFilter, String nameItem){
        clickFilterByName(nameFilter);
        clickFilterItemByText(nameItem);
    }

    @Step("Choose Shopping Options: name filter: {0}, name item{1}")
    public void chooseOptionShopByOption(String nameFilter, String nameItem){
        clickFilterByName(nameFilter);
        clickFilterItemByOption(nameItem);
    }

    @Step("Get text current filters")
    public List<String> getTextCurrentFilters(){
        List<String> result=new ArrayList<>();

        for (int i=0; i<driver.findElements(currentFilters).size(); i++){
            result.add(driver.findElements(currentFilters).get(i).getText());
        }
        return result;
    }

    @Step("Get name filters")
    public List<String> getNameFilters() {
        List<String> result=new ArrayList<>();

        for (int i=0; i<listFilters().size(); i++){
            result.add(listFilters().get(i).getText());
        }

        return result;
    }
}
