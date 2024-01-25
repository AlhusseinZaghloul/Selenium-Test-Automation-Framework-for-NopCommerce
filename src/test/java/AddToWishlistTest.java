import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.WishlistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToWishlistTest extends TestBase {
    HomePage homePage;
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    WishlistPage wishlistObject;

    @Test()
    public void guestCanAddProductToWishlist() {
        //Search for product
        homePage = new HomePage(driver);
        homePage.productSearch(productName);
        searchObject = new SearchPage(driver);
        searchObject.OpenProductPage();
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.getProductNameText().equalsIgnoreCase(productName));
        //Add product to wishlist
        productDetailsObject = new ProductDetailsPage(driver);
        productDetailsObject.addProductToWishlist();
        productDetailsObject.openWishlistPage();
        wishlistObject= new WishlistPage(driver);
        Assert.assertEquals(wishlistObject.getQuantityOfProducts(),"2");
    }
}