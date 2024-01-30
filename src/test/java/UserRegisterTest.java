import Pages.HomePage;
import Pages.RegisterPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegisterTest extends TestBase {
    private HomePage homePage;
    private RegisterPage registerPage;
    String email= "alhussein5@gmail.com";
    String password = "710710";

    //User Registration
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void userCanRegisterTC(){
       homePage = new HomePage(driver);
       registerPage= homePage.openRegisterPage();
       registerPage.chooseGender();
       registerPage.EnterFirstName("Alhussein");
       registerPage.EnterLastName("Zaghloul");
       registerPage.EnterEmail(email);
       registerPage.EnterPassWord(password);
       registerPage.EnterRePassword(password);
       registerPage.clickOnRegisterButton();
       Assert.assertEquals(registerPage.getSuccessMessage(),"Your registration completed");
    }
}
