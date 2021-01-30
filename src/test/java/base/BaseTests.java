package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private static EventFiringWebDriver driver;
    protected static HomePage homePage;

    @BeforeClass
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        goHome();
        setCookie();

        homePage = new HomePage(driver);

//        //How many links on the given website? Print all links (total number)
//        List<WebElement> links = driver.findElements(By.tagName("a"));
//        System.out.println(links.size());
//        //Open browser any given size, for example, iPhone X dimensions as below.
//        driver.manage().window().setSize(new Dimension(375,812));
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
    }


    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
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
        options.addArguments("disable-infobars"); // starting with Chrome v76.x this feature is deprecated.
        //Here is alternative to hide "automated by test software" message
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.setHeadless(false); // when set to true, test runs without opening browser
        return options;
    }

    private void setCookie() {
        Cookie cookie = new Cookie.Builder("ChocolateChipCookie","123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
}
