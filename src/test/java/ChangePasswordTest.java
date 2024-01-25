import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends TestBase {
    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    MyAccountPage myAccObject;
    String firstName = "Ahlhussein";
    String lastName = "Zaghloul";
    String email = "alhussein54@gmail.com";
    String password1 = "710710";
    String password2 = "810810";

    @Test
    public void userRegister() {
        //User Registration
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        registerPage = new RegisterPage(driver);
        registerPage.userRegister(firstName, lastName, email, password1);
        Assert.assertEquals(registerPage.getSuccessMessage()
                , "Your registration completed");
        //User Login
        registerPage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.userLogin(email, password1);
        Assert.assertEquals(homePage.logOutSuccessApperence(), "Log out");
        //User change password
        loginPage.openMyAccountPage();
        myAccObject = new MyAccountPage(driver);
        myAccObject.openChangePasswordTab();
        myAccObject.enterOldPassword(password1);
        myAccObject.enterNewPassword(password2);
        myAccObject.enterConfirmPassword(password2);
        myAccObject.clickChangePasswordButton();
        Assert.assertEquals(myAccObject.getPasswordChangeSuccessMessage(),
                "Password was changed");
    }

}
