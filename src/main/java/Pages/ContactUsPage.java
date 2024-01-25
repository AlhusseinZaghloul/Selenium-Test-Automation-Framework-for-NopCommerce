package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage extends PageBase{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    By fullNameText = By.id("FullName");
    WebElement fullNameElement= driver.findElement(fullNameText);
    By emailText = By.id("Email");
    WebElement emailElement= driver.findElement(emailText);
    By enquiry = By.id("Enquiry");
    WebElement enquiryElement= driver.findElement(enquiry);
    By submitButton = By.name("send-email");
    WebElement submitButtonElement= driver.findElement(submitButton);
    By successMessage = By.xpath("//div[@class='result']");

    public void ContactUs(String fullName, String email, String message) {
        sendText(fullNameElement,fullName);
        sendText(emailElement, email);
        sendText(enquiryElement, message);
        clicking(submitButtonElement);
    }
    public String getSuccessMessageContactUs(){
        return driver.findElement(successMessage).getText();
    }


}

