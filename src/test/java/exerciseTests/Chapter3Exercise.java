package exerciseTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Chapter3Exercise {

    private WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement shiftingContent = driver.findElement(By.linkText("Shifting Content"));
        shiftingContent.click();
        WebElement exampleOne = driver.findElement(By.partialLinkText("Example 1"));
        exampleOne.click();
        List<WebElement> menu = driver.findElements(By.xpath("//ul/li/a"));
        System.out.println("menu count: " + menu.size());

        for (int i = 0; i < menu.size(); i++) {
            System.out.println("Menu name " + (i+1)+ " = " + menu.get(i).getText());
        }

        driver.close();
    }

    public static void main(String[] args){
        Chapter3Exercise test = new Chapter3Exercise();
        test.setUp();
    }

}
