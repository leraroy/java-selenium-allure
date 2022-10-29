package women;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static data.DataForAssert.chooseFiltersTees;
import static data.DataForAssert.nameFiltersTopsPage;

@Epic("Tests")
@Feature("Women Tops tests")
public class TopsTest extends BaseTest {

    @Before
    public void setup(){
        topsPage.open();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Description: Check the correct filters name")
    @Story("Check the correct filters name")
    public void checkFiltersName() throws InterruptedException {
        Thread.sleep(2000);
        assertContainsList(topsPage.getNameFilters(), Arrays.asList(nameFiltersTopsPage));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Description: Choose filters and check the correct current filters")
    @Story("Choose filters and check the correct current filters")
    public void checkCurrentFilters() throws InterruptedException {
       Thread.sleep(2000);
       topsPage.chooseOptionShopByText(nameFiltersTopsPage[0], chooseFiltersTees[0]);
       topsPage.chooseOptionShopByOption(nameFiltersTopsPage[2], chooseFiltersTees[1]);
       topsPage.chooseOptionShopByOption(nameFiltersTopsPage[4], chooseFiltersTees[2]);
       topsPage.chooseOptionShopByText(nameFiltersTopsPage[5], chooseFiltersTees[3]);
       assertContainsList(topsPage.getTextCurrentFilters(), Arrays.asList(chooseFiltersTees));
    }
}
