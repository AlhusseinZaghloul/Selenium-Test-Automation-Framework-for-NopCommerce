import Pages.HomePage;
import Pages.RegisterPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import listeners.TestNGListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestDataGenerator;

//@Listeners(TestNGListeners.class)
public class UserRegisterTest extends TestBase {
    private HomePage homePage;
    private RegisterPage registerPage;
    String email= "alhussein5@gmail.com";
    String password = "710710";

    //User Registration
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void userCanRegisterTC() throws InterruptedException {
       homePage = new HomePage(driver);
       registerPage= homePage.openRegisterPage();
       Thread.sleep( 2000);
       registerPage.chooseGender();
       registerPage.EnterFirstName(TestDataGenerator.getFirstName());
       registerPage.EnterLastName(TestDataGenerator.getLastName());
       registerPage.EnterEmail(TestDataGenerator.getEmail());
       registerPage.EnterPassWord(TestDataGenerator.getPassword());
       registerPage.EnterRePassword(TestDataGenerator.getPassword());
       registerPage.clickOnRegisterButton();
       Assert.assertEquals(registerPage.getSuccessMessage(),"Your registration completed");
    }
}
