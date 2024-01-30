import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailFriendTest extends TestBase{
    HomePage homePage ;
    RegisterPage registerPage;
    LoginPage loginPage;
    String email = "alhussein2@gmail.com" ;
    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    EmailFriendPage emailFriendObject;
    String firstName = "Alhussein";
    String lastName = "Zaghloul";
    String friendEmail ="Ahmed@gmail.com";
    String password="710710";
    String friendMessage="This is a test";
    @Test
    public void userCanSendEmailToFriend() {
        //User Registration
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        registerPage = new RegisterPage(driver);
        registerPage.userRegister(firstName, lastName, email, password);
        Assert.assertEquals(registerPage.getSuccessMessage()
                , "Your registration completed");
        //User Login
        registerPage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.userLogin(email, password);
        Assert.assertEquals(homePage.logOutSuccessApperence(), "Log out");
        //Search for Product
        homePage.productSearch(productName);
        searchObject = new SearchPage(driver);
        searchObject.OpenProductPage();
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.getProductNameText().equalsIgnoreCase(productName));
        //Email to Friend
        productDetailsObject.openFriendEmail();
        emailFriendObject = new EmailFriendPage(driver);
        emailFriendObject.enterFriendEmail(friendEmail);
        emailFriendObject.enterPersonalMessage(friendMessage);
        emailFriendObject.sendMailtoFriend();
        Assert.assertEquals(emailFriendObject.getSuccessSentMailMessage(),"Your message has been sent.");
    }
}
