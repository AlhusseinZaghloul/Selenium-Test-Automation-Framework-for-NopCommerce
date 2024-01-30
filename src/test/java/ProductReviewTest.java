import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductReviewTest extends TestBase{

    HomePage homePage ;
    RegisterPage registerPage;
    LoginPage loginPage;
    String firstName = "Alhussein";
    String lastName = "Zaghloul";
    String email = "alhussein3@gmail.com" ;
    String password="710710";
    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    ProductReviewPage productReviewObject;
    String reviewTitle ="This a test for writing review title";
    String reviewMessage="The product quality is Very Good";

    @Test
    public void userAddReview() {
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
        productDetailsObject=new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.getProductNameText().equalsIgnoreCase(productName));
        //Add review
        productDetailsObject.openAddReviewPage();
        productReviewObject = new ProductReviewPage(driver);
        productReviewObject.AddReviewProduct(reviewTitle, reviewMessage);
        Assert.assertEquals(productReviewObject.getReviewSuccessMessage()
               , "Product review is successfully added.");
    }

}
