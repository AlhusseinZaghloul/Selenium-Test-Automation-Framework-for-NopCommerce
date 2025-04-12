import Pages.LoginPage;
import Pages.RegisterPage;
import drivers.DriverManager;
import listeners.TestNGListeners;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.TestDataGenerator;

@Listeners(TestNGListeners.class)
public class TestRegister {
    WebDriver driver;
    RegisterPage registerPage;
    LoginPage loginPage;

    @BeforeClass
    public void dataPrepration() {
        // Call the data generation method here
        TestDataGenerator.generateRegistrationData();
    }
    @BeforeMethod
    public void setUp() {
        driver = DriverManager.createInstance("chrome");
    }

    @Test (priority = 1)
    public void testRegister() {
        registerPage = new RegisterPage(driver);
        registerPage
                .openRegisterPage(driver)
                .chooseGender()
                .enterFirstName(TestDataGenerator.getFirstName())
                .enterLastName(TestDataGenerator.getLastName())
                .enterEmail(TestDataGenerator.getEmail())
                .enterPassWord(TestDataGenerator.getPassword())
                .enterRePassword(TestDataGenerator.getPassword())
                .clickOnRegisterButton();

    }
    @Test (priority = 2)
    public void loginWithValidData(){
        loginPage
                .openLoginPage(driver)
                .enterEmail(TestDataGenerator.getEmail())
                .enterPassWord(TestDataGenerator.getPassword())
                .clickLoginButton();
        //Assert.assertEquals(homePage.logOutSuccessApperence(),"Log out");

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            //    driver.quit();
        }
    }
}
