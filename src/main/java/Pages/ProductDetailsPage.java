package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage extends PageBase {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    By productNameLabel = By.cssSelector("strong.current-item");
    By emailFriendButton = By.xpath("//*[@id='product-details-form']/div[2]/div[1]/div[2]/div[9]/div[3]/button");
    By productPriceLabel = By.id("price-value-4");
    By addReviewLink = By.linkText("Add your review");
    By addToWishlistButton = By.id("add-to-wishlist-button-4");
    By addToCompareButton = By.xpath("//div[@class='compare-products']//button[@type='button'][normalize-space()='Add to compare list']");
    By addToCartButton = By.id("add-to-cart-button-4");
    By shoppingCart = By.xpath("//span[@class='cart-label']");
    By wishlistPage = By.xpath("//span[@class='wishlist-label']");
    By productComparison=By.xpath("//a[normalize-space()='product comparison']");
    By product1Label=By.xpath("//tr[@class='product-name']//td[2]");
    By product2Label=By.xpath("//tr[@class='product-name']//td[3]");
    By productNameInCart=By.xpath("//td[@class='product']");

    public String getProductNameText() {
        return driver.findElement(productNameLabel).getText();
    }
    public String getProductNameInCart() {
        return driver.findElement(productNameInCart).getText();
    }

    public EmailFriendPage openFriendEmail() {
        clicking(driver.findElement(emailFriendButton));
        return new EmailFriendPage(driver);
    }
    public ProductReviewPage openAddReviewPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addReviewLink));
        clicking(driver.findElement(addReviewLink));
        return new ProductReviewPage(driver);
    }
    public String getProductName() {
        return driver.findElement(productNameLabel).getText();
    }


    public void addProductToWishlist() {
        scrollToButton(driver.findElement(addToWishlistButton));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToWishlistButton));
        clicking(driver.findElement(addToWishlistButton));
    }
    public void addToCompare() {
        scrollToButton(driver.findElement(addToCompareButton));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCompareButton));
        clicking(driver.findElement(addToCompareButton));
    }
    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        clicking(driver.findElement(addToCartButton));
    }
    public String getProductPrice() {
        return driver.findElement(productPriceLabel).getText();
    }
    public ShoppingCartPage openShoppingCart() {
        driver.findElement(shoppingCart).click();
        return new ShoppingCartPage(driver);
    }
    public WishlistPage openWishlistPage(){
        scrollToButton(driver.findElement(wishlistPage));
        clicking(driver.findElement(wishlistPage));
        return new WishlistPage(driver);
    }
    public void openComparisonProductPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productComparison));
        clicking(driver.findElement(productComparison));
    }
    public String getProduct1Name(){
         return driver.findElement(product1Label).getText();
    }
    public String getProduct2Name(){
        return driver.findElement(product2Label).getText();
    }

}

