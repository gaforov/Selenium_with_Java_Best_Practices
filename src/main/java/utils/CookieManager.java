package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieManager {
    private WebDriver driver;

    public CookieManager(WebDriver driver) {
        this.driver = driver;
    }

    public void addTestCookie(String name, String value, String domain) {
        Cookie cookie = new Cookie.Builder(name, value)
                .domain(domain)
                .build();
        driver.manage().addCookie(cookie);
    }
}


/*How to use/implement, example:
CookieManager cookieManager = new CookieManager(driver);
cookieManager.addTestCookie("ChocolateChipCookie", "123", "the-internet.herokuapp.com");
*/