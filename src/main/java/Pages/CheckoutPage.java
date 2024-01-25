package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    private By firstName=By.id("BillingNewAddress_FirstName");
    private By lastName=By.id("BillingNewAddress_LastName");
    private By emailField=By.id("BillingNewAddress_Email");
    private By countryList = By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]");
    private By cityText = By.id("BillingNewAddress_City");
    private By address1Text = By.id("BillingNewAddress_Address1");
    private By postalCodeText = By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumberText = By.id("BillingNewAddress_PhoneNumber");
    private By continueButton = By.name("save");
    private By continueButton1 = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
    private By continueButton2 = By.xpath("//*[@id=\"payment-method-buttons-container\"]/button");
    private By continueButton3 = By.xpath("//*[@id=\"payment-info-buttons-container\"]/button");
    private By confirmButton = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button");
    private By successMessage= By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");
    private By checkoutAsGuestButton=By.xpath("//button[normalize-space()='Checkout as Guest']");

    public void selectCountry() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryList));
        highlight(driver.findElement(countryList));
        select =new Select(driver.findElement(countryList));
        select.selectByVisibleText("Palestine");
    }
    public void enterCity(String city) {
        highlight(driver.findElement(cityText));
        sendText(driver.findElement(cityText), city);
    }
    public void enterAddress(String address) {
        highlight(driver.findElement(address1Text));
        sendText(driver.findElement(address1Text), address);
    }
    public void enterPostalCode(String postalCode) {
        highlight(driver.findElement(postalCodeText));
        sendText(driver.findElement(postalCodeText), postalCode);
    }
    public void enterPhoneNumber(String phoneNumber) {
        highlight(driver.findElement(phoneNumberText));
        sendText(driver.findElement(phoneNumberText), phoneNumber);
    }
    public void saveShippingData() {
        highlight(driver.findElement(continueButton));
        clicking(driver.findElement(continueButton));
    }
    public void clickContinue1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton1));
        highlight(driver.findElement(continueButton1));
        clicking(driver.findElement(continueButton1));
    }
    public void clickContinue2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton2));
        highlight(driver.findElement(continueButton2));
        clicking(driver.findElement(continueButton2));
    }
    public void clickContinue3() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton3));
        highlight(driver.findElement(continueButton3));
        clicking(driver.findElement(continueButton3));
    }
    public void confirmOrder() {
        scrollToButton(driver.findElement(confirmButton));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        highlight(driver.findElement(confirmButton));
        clicking(driver.findElement(confirmButton));
    }
    public String getSuccessOrderMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(successMessage));
        return driver.findElement(successMessage).getText();
    }

    public void checkoutAsGuest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutAsGuestButton));
        clicking(driver.findElement(checkoutAsGuestButton));
    }
    public void enterFirstName(String fName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(firstName));
        sendText(driver.findElement(firstName), fName);
    }
    public void enterLastName(String lName){
        sendText(driver.findElement(lastName), lName);
    }
    public void enterEmail(String email){
        sendText(driver.findElement(emailField), email);
    }


}
