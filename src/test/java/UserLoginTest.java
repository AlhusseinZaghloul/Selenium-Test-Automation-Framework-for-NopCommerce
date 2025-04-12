import Pages.HomePage;
import Pages.LoginPage;
import drivers.DriverManager;
import listeners.TestNGListeners;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)

public class UserLoginTest {
    private  WebDriver driver = DriverManager.createInstance("chrome");
    private HomePage homePage;
    private final LoginPage loginPage= new LoginPage(driver);
    String email= "alhussein5@gmail.com";
    String password = "710710";

//    @Test
//    @Severity(SeverityLevel.CRITICAL)
//    public void userLoginTC(){
//        homePage = new HomePage(driver);
//        loginPage=homePage.openLoginPage();
//        loginPage.EnterEmail(email);
//        loginPage.EnterPassWord(password);
//        loginPage.loginButtonClick();
//        Assert.assertEquals(homePage.logOutSuccessApperence(),"Log out");
//    }
    @Test
    public void loginWithValidData(){
        loginPage
                .openLoginPage(driver)
                .enterEmail(email)
                .enterPassWord(password)
                .clickLoginButton();
        Assert.assertEquals(homePage.logOutSuccessApperence(),"Log out");

    }
}
