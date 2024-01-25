import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends TestBase{
    HomePage homePage;
    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;

    @Test
    public void userCanSearchForProducts() {
        homePage= new HomePage(driver);
        homePage.productSearch(productName);
        searchObject = new SearchPage(driver);
        searchObject.OpenProductPage();
        productDetailsObject=new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.getProductNameText().equalsIgnoreCase(productName));
    }
}
