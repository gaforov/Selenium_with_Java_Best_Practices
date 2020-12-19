package exerciseTests;
/**
 * Here is alternative way how to do it:
 * SliderTests class: https://github.com/angiejones/selenium-webdriver-java-course/blob/master/webdriver_java/src/test/java/exercises/chapter6/slider/SliderTests.java
 * SliderPage class: https://github.com/angiejones/selenium-webdriver-java-course/blob/master/webdriver_java/src/main/java/pages/HorizontalSliderPage.java
 */

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SliderTests extends BaseTests {

    @Test
    public void testMoveSlider() {
        var sliderPage = homePage.clickHorizontalSlider();
        String setSliderValue = sliderPage.moveSlider("4");
        assertEquals(setSliderValue, sliderPage.getSliderValue(), "Slider value is incorrect");
    }
}