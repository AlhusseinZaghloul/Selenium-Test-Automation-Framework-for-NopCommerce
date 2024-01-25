package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductReviewPage extends PageBase{
    public ProductReviewPage(WebDriver driver) {
        super(driver);
    }
    By reviewTitle = By.id("AddProductReview_Title");
    By reviewText = By.id("AddProductReview_ReviewText");
    By ratingButton5=By.id("addproductrating_5");
    By submitReviewButton=By.xpath("//button[@name='add-review']");
   private By successMessage = By.cssSelector("div.result");
    public void AddReviewProduct(String Title ,String reviewMessage) {
        sendText(driver.findElement(reviewTitle), Title);
        sendText(driver.findElement(reviewText), reviewMessage);
        clicking(driver.findElement(ratingButton5));
        clicking(driver.findElement(submitReviewButton));
    }
    public String getReviewSuccessMessage(){
       return driver.findElement(successMessage).getText();
    }


}
