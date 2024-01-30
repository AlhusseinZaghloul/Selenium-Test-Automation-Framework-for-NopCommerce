import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GuestUserCheckoutProductTest extends TestBase{
    HomePage homePage;
    String productName = "Apple MacBook Pro 13-inch";
    String email = "alhussein15@gmail.com" ;
    String firstName = "Alhussein";
    String lastName = "Zaghloul";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    ShoppingCartPage shoppingCartObject;
    CheckoutPage checkoutObject;
    String city = "Gaza";
    String address = "7 Khaled Street";
    String postalCode = "710610";
    String phoneNumber = "01234567891";
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("End to End Scenario from shopping as a guest to checkout")
    public void guestUserCanCheckoutProducts() {
        //Search for product
        homePage= new HomePage(driver);
        homePage.productSearch(productName);
        searchObject = new SearchPage(driver);
        searchObject.OpenProductPage();
        productDetailsObject=new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.getProductNameText().equalsIgnoreCase(productName));
        //Add product to cart
        productDetailsObject.addToCart();
        productDetailsObject.openShoppingCart();
        Assert.assertTrue(productDetailsObject.getProductNameInCart().equalsIgnoreCase(productName));
        // complete shipping
        shoppingCartObject = new ShoppingCartPage(driver);
        shoppingCartObject.agreeWithTerms();
        shoppingCartObject.openCheckoutPage();
        checkoutObject= new CheckoutPage(driver);
        checkoutObject.checkoutAsGuest();
        checkoutObject.enterFirstName(firstName);
        checkoutObject.enterLastName(lastName);
        checkoutObject.enterEmail(email);
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
