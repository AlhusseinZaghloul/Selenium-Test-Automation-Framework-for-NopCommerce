package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends PageBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    private By genderMale =By.id("gender-male");
    private By firstName =By.id("FirstName");
    private By lastName =By.id("LastName");
    private By emailField =By.id("Email");
    private By passwordField =By.id("Password");
    private By rePasswordField =By.id("ConfirmPassword");
    private By registerButton =By.id("register-button");
    private By successMessage = By.cssSelector("div.result");
    private  By loginButton= By.xpath("//a[@class='ico-login']");


    public void EnterFirstName(String fName){
        sendText(driver.findElement(firstName),fName);
    }
    public void EnterLastName(String lName){
        sendText(driver.findElement(lastName),lName);
    }
    public void EnterEmail(String email){
        sendText(driver.findElement(emailField),email);
    }
    public void EnterPassWord(String password){
        sendText(driver.findElement(passwordField),password);
    }
    public void EnterRePassword(String rePassword){
        sendText(driver.findElement(rePasswordField),rePassword);
    }
    public void chooseGender(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(genderMale));
        clicking(driver.findElement(genderMale));
    }
    public void clickOnRegisterButton(){
        clicking(driver.findElement(registerButton));
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
