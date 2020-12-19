package base;

import alerts.AlertTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.List;

public class BaseTests {

    private static WebDriver driver;
    protected static HomePage homePage;

    @BeforeClass
    public void setUp() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        goHome();

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
    public void tearDown(){
        driver.quit();
    }

//    //no longer needed, TestNG will take care of running now.
//    public static void main(String[] args) throws InterruptedException {
//        BaseTests test = new BaseTests();
//        test.setUp();
//    }
}
