package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private Waits() {}

    //wait for element to be present
    public static WebElement waitForElementPresent(WebDriver driver, By locator) {
       // code to wait for element to be present
       LogsUtils.info("Waiting for element to be present: ", locator.toString());
       return  new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver1.findElement(locator) );
    }
    //wait for element to be visible
    public static WebElement waitForElementVisible(WebDriver driver, By locator) {
        // code to wait for element to be visible
        LogsUtils.info("Waiting for element to be visible: ", locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 ->
                {
                    WebElement element = waitForElementPresent(driver, locator);
                return element.isDisplayed() ? element : null;
                }
                );
    }
    //wait for element to be clickable
    public static WebElement waitForElementClickable(WebDriver driver, By locator) {
        // code to wait for element to be clickable
        LogsUtils.info("Waiting for element to be clickable: ", locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 ->
                {
                    WebElement element = waitForElementVisible(driver, locator);
                    return element.isEnabled() ? element : null;
                }
                );
    }
}
