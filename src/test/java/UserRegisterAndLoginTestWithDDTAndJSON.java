import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserRegisterAndLoginTestWithDDTAndJSON extends TestBase {
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    @Test
    public void userCanRegisterTC() throws IOException, ParseException {
       //User Registration
       homePage = new HomePage(driver);
       registerPage= homePage.openRegisterPage();
       registerPage.chooseGender();
       JsonDataReader jsonReader= new JsonDataReader();
       jsonReader.readJasonData();
       registerPage.EnterFirstName(jsonReader.firstName);
       registerPage.EnterLastName(jsonReader.lastName);
       registerPage.EnterEmail(jsonReader.email);
       registerPage.EnterPassWord(jsonReader.password);
       registerPage.EnterRePassword(jsonReader.password);
       registerPage.clickOnRegisterButton();
       Assert.assertEquals(registerPage.getSuccessMessage(),"Your registration completed");
       //User login
       registerPage.openLoginPage();
       loginPage= new LoginPage(driver);
       loginPage.EnterEmail(jsonReader.email);
       loginPage.EnterPassWord(jsonReader.password);
       loginPage.loginButtonClick();
       Assert.assertEquals(homePage.logOutSuccessApperence(),"Log out");
    }
}
