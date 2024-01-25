import Pages.ContactUsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase{

    HomePage homepageObject;
    ContactUsPage contactUsObject;
    String fullName ="Alhussein Ahmed Zaghloul";
    String email ="Alhussein@gmail.com";
    String message ="There is an error in homepage,We test it now";
    @Test
    public void contactUsTest() {
        homepageObject = new HomePage(driver);
        homepageObject.openContactUsPage();
        contactUsObject = new ContactUsPage(driver);
        contactUsObject.ContactUs(fullName, email, message);
        Assert.assertEquals(contactUsObject.getSuccessMessageContactUs()
        ,"Your enquiry has been successfully sent to the store owner.");
    }
}
