import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

public class TestBase {

    protected WebDriver driver;
    @BeforeClass
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
    @BeforeMethod
    public void openHome(){
        driver.get("https://demo.nopcommerce.com/");
    }
    @AfterMethod
    //Take screenshot when test cases fail and add it to screenshots folder
    public void screenshotOnFailure (ITestResult result ) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test case failed!");
            System.out.println("Taking screenshot...");
            Helper.captureScreenshot(driver, result.getName());
        }
    }
    @AfterClass
    public void quit(){
       driver.quit();
    }
}
