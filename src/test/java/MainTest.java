import base.BaseTest;
import data.RandomData;
import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static data.DataForAssert.nameTitleAfterClickIcons;
import static data.DataForAssert.nameTitleAfterClickNavBtn;

@Epic("Tests")
@Feature("Main page tests")
public class MainTest extends BaseTest {

    @Before
    public void setup(){
        mainPage.open();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Description: Click on icons on banners and check correct title new pages")
    @Story("Click on icons on banners and check correct title new pages")
    public void checkCorrectIcons() {
        List<String> title=mainPage.clickListIconAndGetTextTitle();
        assertContainsList(title, Arrays.asList(nameTitleAfterClickIcons));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Description: Click on navigation button and check correct title new pages")
    @Story("Click on navigation button and check correct title new pages")
    public void checkCorrectNavButtons() {
        List<String> title=mainPage.clickListNavButtonAndGetTextTitle();
        assertContainsList(title, Arrays.asList(nameTitleAfterClickNavBtn));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Description: Empty email for subscribe")
    @Story("Empty email for subscribe")
    public void validEmailSubscribe() throws InterruptedException {
        mainPage.subscribe(randomData.getEmail());
        assertEquals(basePage.getTextMessageAlert(), "Thank you for your subscription.");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Description: Click on icon on main banner and check correct title new page")
    @Story("Click on icon on banner and check correct title new page")
    public void checkCorrectMainBanner() {
        mainPage.clickPromoButton();
        assertContains(mainPage.getTextTitle(), "New Luma Yoga Collection");
    }
}
