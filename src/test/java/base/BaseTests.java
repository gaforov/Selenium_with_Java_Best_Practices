package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;

public class BaseTests {

    private static WebDriver driver;
    protected static HomePage homePage;

    @BeforeClass
    public void setUp() {
        // Selenium 4 automatically manages the driver binaries
        driver = new ChromeDriver(getChromeOptions());

        // Attach the EventReporter listener
//        EventReporter listener = new EventReporter();
//        driver = new EventFiringDecorator(listener).decorate(driver);

        // Implicit wait with new Duration API
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        goHome();
        setCookie();

        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000); // Consider removing in real-world scenarios
        driver.quit();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    @AfterMethod
    public void takeScreenshotWhenFails(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
//        options.setHeadless(false); // Set true to run without opening browser
        return options;
    }

    private void setCookie() {
        Cookie cookie = new Cookie.Builder("ChocolateChipCookie", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
}
