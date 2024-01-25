import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends TestBase{
    HomePage homePage;
    ProductDetailsPage productDetailsObject;
    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchObject;

    @Test
    public void UserCanChangeCurrency() {
        homePage = new HomePage(driver);
        homePage.changeCurrency();
        homePage.productSearch(productName);
        searchObject = new SearchPage(driver);
        searchObject.OpenProductPage();
        productDetailsObject=new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.getProductPrice().contentEquals("€1548.00"));
    }


}
