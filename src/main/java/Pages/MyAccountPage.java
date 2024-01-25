package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    private By changePasswordTab=By.linkText("Change password");
    private By oldPassword = By.id("OldPassword");
    private By newPassword = By.id("NewPassword");
    private By confirmPassword = By.id("ConfirmNewPassword");
    private By changePasswordButton =
            By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button");
    private By successPasswordChangeMessage=By.cssSelector("p.content");
    public void openChangePasswordTab(){
      clicking(driver.findElement(changePasswordTab));
    }
    public void enterOldPassword(String oldPasswordtext){
        sendText(driver.findElement(oldPassword),oldPasswordtext);
    }
    public void enterNewPassword(String newPasswordtext){
        sendText(driver.findElement(newPassword),newPasswordtext);
    }
    public void enterConfirmPassword(String confirmPasswordtext){
        sendText(driver.findElement(confirmPassword),confirmPasswordtext);
    }
    public void clickChangePasswordButton(){
        clicking(driver.findElement(changePasswordButton));
    }
    public String getPasswordChangeSuccessMessage(){
        return driver.findElement(successPasswordChangeMessage).getText();
    }



}
