package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class PageBase {

    protected  WebDriver driver ;
    public JavascriptExecutor jse ;
    public Select select ;
    public PageBase(WebDriver driver){
        this.driver=driver ;
    }
    public void clicking(WebElement element){
        highlight(element);
        element.click();
    }
    public void sendText(WebElement element , String text){
        highlight(element);
        element.sendKeys(text);
    }
    public void highlight(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('style'," +
                " ' border: 2px solid red;');", element);
    }
    public void scrollToButton(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
      //  js.executeScript("scrollBy(0,2500)" ,element);
        js.executeScript("javascript:window.scrollBy(250,350)");

    }

}
