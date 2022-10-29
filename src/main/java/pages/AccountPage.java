package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class AccountPage extends BasePage {

    private final By title=By.xpath("//h1/span");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getTextTitle(){
        return driver.findElement(title).getText();
    }
}
