package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends PageBase{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    By  removeButton = By.xpath("//button[@class='remove-btn']");
    By  quantityLabel=By.xpath("//td[@class='quantity']");
    By  successEmptyMessage=By.cssSelector("div.no-data");
    By  checkOutButton=By.id("checkout");
    By  agreeWithTermsButton=By.id("termsofservice");
    By  productName=By.xpath("//td[@class='product']");
    public void agreeWithTerms(){
        scrollToButton(driver.findElement(agreeWithTermsButton));
        clicking(driver.findElement(agreeWithTermsButton));
    }
    public CheckoutPage openCheckoutPage(){
        clicking(driver.findElement(checkOutButton));
        return new CheckoutPage(driver);
    }
    public void removeProductFromCart() {
        clicking(driver.findElement(removeButton));
    }
    public String getQuantityOfProducts() {
       return driver.findElement(quantityLabel).getAccessibleName();
    }
    public String getSuccessRemoveMessage(){
       return driver.findElement(successEmptyMessage).getText();
    }

    public String getProductName(){
         return driver.findElement(productName).getText();
    }
}
