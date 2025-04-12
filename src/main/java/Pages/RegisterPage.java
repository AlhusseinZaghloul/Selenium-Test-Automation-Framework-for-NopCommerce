package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementsActions;

import java.time.Duration;

public class RegisterPage extends PageBase {
    private final String registerPageUrl = "https://demo.nopcommerce.com/register";
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    private final By genderMale =By.id("gender-male");
    private final By firstName =By.id("FirstName");
    private final By lastName =By.id("LastName");
    private final By emailField =By.id("Email");
    private final By passwordField =By.id("Password");
    private final By rePasswordField =By.id("ConfirmPassword");
    private final By registerButton =By.id("register-button");
    private final By successMessage = By.cssSelector("div.result");
    private final By loginButton= By.xpath("//a[@class='ico-login']");

    public RegisterPage openRegisterPage(WebDriver driver){
        driver.get(registerPageUrl);
        return this;
    }

    public void clickOnGenderMale(){
        clicking(driver.findElement(genderMale));
    }
    public void EnterFirstName(String fName){
        sendText(driver.findElement(firstName),fName);
    }
    public RegisterPage enterFirstName( String fName){
        ElementsActions.sendData(driver,firstName ,fName);
        return this;
    }
    public void EnterLastName(String lName){
        sendText(driver.findElement(lastName),lName);
    }
    public RegisterPage enterLastName(String lName){
        ElementsActions.sendData(driver,lastName ,lName);
        return this;
    }
    public void EnterEmail(String email){
        sendText(driver.findElement(emailField),email);
    }
    public RegisterPage enterEmail(String email){
        ElementsActions.sendData(driver,emailField ,email);
        return this;
    }
    public void EnterPassWord(String password){
        sendText(driver.findElement(passwordField),password);
    }
    public RegisterPage enterPassWord(String password){
        ElementsActions.sendData(driver,passwordField ,password);
        return this;
    }
    public void EnterRePassword(String rePassword){
        sendText(driver.findElement(rePasswordField),rePassword);
    }
    public RegisterPage enterRePassword(String rePassword){
        ElementsActions.sendData(driver,rePasswordField ,rePassword);
        return this;
    }
    public RegisterPage chooseGender(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(genderMale));
        clicking(driver.findElement(genderMale));
        return this;
    }
    public RegisterPage chooseGenderMale(){
        ElementsActions.clicking(driver,genderMale);
        return this;
    }
    public void clickOnRegisterButton(){
        ElementsActions.clicking(driver,registerButton);
    }
    public String getSuccessMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(successMessage)));
      return driver.findElement(successMessage).getText();
    }

    public LoginPage openLoginPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        clicking(driver.findElement(loginButton));
        return new LoginPage(driver);
    }
    public void userRegister(String fName,String lName,String email,String password ){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(genderMale));
        clicking(driver.findElement(genderMale));
        sendText(driver.findElement(firstName),fName);
        sendText(driver.findElement(lastName),lName);
        sendText(driver.findElement(emailField),email);
        sendText(driver.findElement(passwordField),password);
        sendText(driver.findElement(rePasswordField),password);
        clicking(driver.findElement(registerButton));
        wait.until(ExpectedConditions.presenceOfElementLocated(successMessage));
    }
}
