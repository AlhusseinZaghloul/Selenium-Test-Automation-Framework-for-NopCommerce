package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    By productTitle = By.xpath("//div[@class='product-item']");
   // By product2Title = By.xpath("//div[@class='product-item']");
    public ProductDetailsPage OpenProductPage() {
        scrollToButton(driver.findElement(productTitle));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(productTitle));
        clicking(driver.findElement(productTitle));
        return new ProductDetailsPage(driver);
    }
    }

