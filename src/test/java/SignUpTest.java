import base.BaseTest;
import data.RandomData;
import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;

@Epic("Tests")
@Feature("Create account tests")
public class SignUpTest extends BaseTest {

    @Before
    public void setup(){
        signUpPage.open();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Description: Register with empty credentials")
    @Story("Register with empty credentials")
    public void registerWithEmptyCreds() {
        signUpPage.register("","","","");
        assertContains(signUpPage.getTextErrorMessage(), "This is a required field.");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Description: Register with correct credentials")
    @Story("Register with correct credentials")
    public void registerWithCorrectCreds() {
    //  signUpPage.register(data.getFirstName(), data.getLastName(), data.getEmail(), data.getValidPassword());
    //  assertEquals(accountPage.getTextTitle(),"My Account");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Description: Register with invalid password")
    @Story("Description: Register with invalid password")
    public void registerWithInvalidPassword() {
        signUpPage.register(randomData.getFirstName(), randomData.getLastName(), randomData.getEmail(), randomData.getInvalidPassword());
        assertContains(signUpPage.getTextErrorMessage(),"Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Description: Register with small password")
    @Story("Description: Register with small password")
    public void registerWithSmallPassword() {
        signUpPage.register(randomData.getFirstName(), randomData.getLastName(), randomData.getEmail(), randomData.getSmallPassword());
        assertContains(signUpPage.getTextErrorMessage(),"Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.");
    }


}
