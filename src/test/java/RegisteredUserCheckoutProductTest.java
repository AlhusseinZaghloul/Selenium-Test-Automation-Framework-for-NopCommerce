import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisteredUserCheckoutProductTest extends TestBase {
    HomePage homePage ;
    RegisterPage registerPage;
    LoginPage loginPage;
    String email = "alhussein4@gmail.com" ;
    String password="710710";
    String firstName = "Alhussein";
    String lastName = "Zaghloul";
    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    ShoppingCartPage shoppingCartObject;
    CheckoutPage checkoutObject;
    String city = "Gaza";
    String address = "7 Khaled Street";
    String postalCode = "710610";
    String phoneNumber = "01234567891";

    //User Registration
    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("End to End Scenario from registration to checkout")
    public void userRegister() {
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
        //Add product to cart
        homePage.productSearch(productName);
        searchObject = new SearchPage(driver);
        searchObject.OpenProductPage();
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.getProductNameText().equalsIgnoreCase(productName));
        productDetailsObject.addToCart();
        productDetailsObject.openShoppingCart();
        Assert.assertTrue(productDetailsObject.getProductNameInCart().equalsIgnoreCase(productName));
        // complete shipping
        shoppingCartObject = new ShoppingCartPage(driver);
        shoppingCartObject.agreeWithTerms();
        shoppingCartObject.openCheckoutPage();
        checkoutObject= new CheckoutPage(driver);
        checkoutObject.selectCountry();
        checkoutObject.enterCity(city);
        checkoutObject.enterAddress(address);
        checkoutObject.enterPostalCode(postalCode);
        checkoutObject.enterPhoneNumber(phoneNumber);
        checkoutObject.saveShippingData();
        checkoutObject.clickContinue1();
        checkoutObject.clickContinue2();
        checkoutObject.clickContinue3();
        checkoutObject.confirmOrder();
        Assert.assertEquals(checkoutObject.getSuccessOrderMessage(),
            "Your order has been successfully processed!");
    }

}
