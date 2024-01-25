import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLoginTest extends TestBase{
    private HomePage homePage;
    private LoginPage loginPage;
    String email= "alhussein2@gmail.com";
    String password = "710710";
    @Test
    public void userLoginTC(){
        homePage = new HomePage(driver);
        loginPage=homePage.openLoginPage();
        loginPage.EnterEmail(email);
        loginPage.EnterPassWord(password);
        loginPage.loginButtonClick();
        Assert.assertEquals(homePage.logOutSuccessApperence(),"Log out");
    }
}
