package pages.exercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By sliderBar = By.xpath("//input[@type='range']");
    //sliderBar By cssSelector =  ".sliderContainer input" // Alternatively, you can use cssSelector
    private By sliderValue = By.xpath("//span[@id='range']");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public String moveSlider(String value) {
        String sliderValueText = "";
        while (!sliderValueText.equals(value)) {
            driver.findElement(sliderBar).sendKeys(Keys.ARROW_RIGHT);
            sliderValueText = driver.findElement(sliderValue).getText();
        }
        return sliderValueText;
    }

    public String getSliderValue() {
        return driver.findElement(sliderValue).getText();
    }

}
