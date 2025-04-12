package drivers;

import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;


import static org.testng.AssertJUnit.fail;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
        super();
    }

    @Step("Setting up browser")
    public static WebDriver createInstance(String browserName) { // no usages
        // code
        WebDriver driver = BrowserFactory.getBrowser(browserName);
        setDriver(driver);
        return getDriver();
    }

    @Step("Getting WebDriver instance")
    public static WebDriver getDriver() { // 1 usage
        if (driverThreadLocal.get() == null) {
            // code
            fail("Driver is null"); // Assuming a fail method exists or should be replaced with appropriate error handling
        }
        return driverThreadLocal.get();
    }

    @Step("Setting WebDriver instance")
    public static void setDriver(WebDriver driver) { // 1 usage
        driverThreadLocal.set(driver);
    }



//    @Step("Getting WebDriver instance")
//    public static WebDriver getDriverThreadLocal() {
//        if (driverThreadLocal == null) {
//            setupChromeDriver();
//        }
//        return driverThreadLocal;
//    }
//
//    @Step("Quitting WebDriver")
//    public static void quitDriver() {
//        if (driverThreadLocal != null) {
//            driverThreadLocal.quit();
//            driverThreadLocal = null;
//        }
//    }
}