import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLoginTest extends TestBase{
    private HomePage homePage;
    private LoginPage loginPage;
    String email= "alhussein5@gmail.com";
    String password = "710710";
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void userLoginTC(){
        homePage = new HomePage(driver);
        loginPage=homePage.openLoginPage();
        loginPage.EnterEmail(email);
        loginPage.EnterPassWord(password);
        loginPage.loginButtonClick();
        Assert.assertEquals(homePage.logOutSuccessApperence(),"Log out");
    }
}
