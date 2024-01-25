package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver ;
    }

    By registerButton = By.className("ico-register");
    WebElement registerButtonElement=driver.findElement(registerButton);
    By loginButton = By.linkText("Log in");
    WebElement  loginButtonElement=driver.findElement(loginButton);
    By contactUsLink = By.linkText("Contact us");
    WebElement contactUsLinkElement= driver.findElement(contactUsLink);
    By currencyDropdown = By.id("customerCurrency");
    WebElement currencyDDlElement= driver.findElement(currencyDropdown);
    By logOutbutton=By.linkText("Log out");
    By searchTextBox = By.id("small-searchterms");
    By searchButton = By.xpath("//*[@id='small-search-box-form']/button");
  //  By productList= By.cssSelector("a[id='ui-id-8'] span");
  //  WebElement productListElement=driver.findElement(productList) ;

    public RegisterPage openRegisterPage(){
        clicking(registerButtonElement);
        return new RegisterPage(driver);
    }
    public LoginPage openLoginPage(){
        clicking(loginButtonElement);
        return new LoginPage(driver);
    }
    public ContactUsPage openContactUsPage() {
        scrollToButton(contactUsLinkElement);
        clicking(contactUsLinkElement);
        return new ContactUsPage(driver);
    }
    public String logOutSuccessApperence(){
      return  driver.findElement(logOutbutton).getText();
    }
    public SearchPage productSearch(String productName)  {
        sendText(driver.findElement(searchTextBox), productName);
        clicking(driver.findElement(searchButton));
        return new SearchPage(driver);
    }
    public ProductDetailsPage searchWithAutoSuggest(String productName) throws InterruptedException {
        sendText(driver.findElement(searchTextBox), productName);
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
       //  wait.until(ExpectedConditions.visibilityOfElementLocated());
        Thread.sleep(1000);
        driver.findElement(searchTextBox).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(searchTextBox).sendKeys(Keys.ENTER);
        return new ProductDetailsPage(driver);
    }
    public void changeCurrency() {
        highlight(currencyDDlElement);
        select = new Select(currencyDDlElement);
        select.selectByVisibleText("Euro");
    }



}
