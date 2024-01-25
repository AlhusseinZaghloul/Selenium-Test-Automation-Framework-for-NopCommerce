import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductsToCompare extends TestBase{
    HomePage homePage ;
    RegisterPage registerPage;
    LoginPage loginPage;
    String firstName = "Alhussein";
    String lastName = "Zaghloul";
    String email = "alhussein4@gmail.com" ;
    String password="710710";
    String product1Name="Apple MacBook Pro 13-inch";
    String product2Name="Asus N551JK-XO076H Laptop";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    ShoppingCartPage shoppingCartObject;
    //User Registration
    @Test
    public void addTwoProductsToCompare() {
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
        //Add two products to cart
        homePage.productSearch(product1Name);
        searchObject = new SearchPage(driver);
        searchObject.OpenProductPage();
        productDetailsObject=new ProductDetailsPage(driver);
        productDetailsObject.addToCompare();
        homePage.productSearch(product2Name);
        searchObject.OpenProductPage();
        productDetailsObject.addToCompare();
        productDetailsObject.openComparisonProductPage();
        Assert.assertEquals(productDetailsObject.getProduct1Name(),product1Name);
        Assert.assertEquals(productDetailsObject.getProduct2Name(),product2Name);
    }

}
