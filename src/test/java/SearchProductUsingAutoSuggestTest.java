import Pages.HomePage;
import Pages.ProductDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductUsingAutoSuggestTest extends TestBase{
    String productName="Apple MacBook Pro 13-inch";
    HomePage homePage;
    ProductDetailsPage productDetailsObject;
    @Test
    public void userCanSearchWithAutoSuggest() throws InterruptedException {
        homePage= new HomePage(driver);
        homePage.searchWithAutoSuggest(productName);
        productDetailsObject=new ProductDetailsPage(driver);
        Assert.assertEquals(productDetailsObject.getProductName(),productName) ;
}
}