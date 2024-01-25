package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends PageBase{
    public WishlistPage(WebDriver driver) {
        super(driver);
    }
    By quantityLabel=By.xpath("//td[@class='quantity']");
    public String getQuantityOfProducts() {
        return driver.findElement(quantityLabel).getAccessibleName();
    }

}
