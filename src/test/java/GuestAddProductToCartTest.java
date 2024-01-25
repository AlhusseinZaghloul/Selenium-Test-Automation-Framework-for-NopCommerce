import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GuestAddProductToCartTest extends TestBase{
    HomePage homePage;
    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    ShoppingCartPage shoppingCartObject;

    @Test
    public void guestAddProductToCart() {
        homePage= new HomePage(driver);
        homePage.productSearch(productName);
        searchObject = new SearchPage(driver);
        searchObject.OpenProductPage();
        productDetailsObject=new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.getProductNameText().equalsIgnoreCase(productName));
        //Add product to cart
        productDetailsObject.addToCart();
        productDetailsObject.openShoppingCart();
        //Remove product from cart
        shoppingCartObject =new ShoppingCartPage(driver);
        shoppingCartObject.removeProductFromCart();
        Assert.assertEquals(shoppingCartObject.getSuccessRemoveMessage(), "Your Shopping Cart is empty!");
    }

}
