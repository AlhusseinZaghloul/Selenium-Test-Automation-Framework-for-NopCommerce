package Pages;

import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.time.Duration;

    public class EmailFriendPage extends PageBase{
    public EmailFriendPage(WebDriver driver) {
    super(driver);
    }

    By emailFriendField = By.id("FriendEmail") ;
    By registeredMailField = By.id("YourEmailAddress");
    By personalMessageField = By.id("PersonalMessage");
    By sendEmailButton = By.name("send-email");
    By successSentMailMessage = By.cssSelector("div.result");
        public void sendMailtoFriend( ){
            clicking(driver.findElement(sendEmailButton));
        }
        public void enterFriendEmail(String FriendMail){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailFriendField)));
            sendText(driver.findElement(emailFriendField),FriendMail);
        }
        public void enterPersonalMessage(String personalMessageText){
            sendText(driver.findElement(personalMessageField),personalMessageText);
        }
        public String getSuccessSentMailMessage(){
            return driver.findElement(successSentMailMessage).getText();
        }

    }


