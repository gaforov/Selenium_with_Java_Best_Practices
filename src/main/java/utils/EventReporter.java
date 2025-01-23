//package utils;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.events.WebDriverListener;
//
//public class EventReporter implements WebDriverListener {
//
//    @Override
//    public void beforeAlertAccept(WebDriver driver) {
//        System.out.println("Before accepting the alert.");
//    }
//
//    @Override
//    public void afterAlertAccept(WebDriver driver) {
//        System.out.println("After accepting the alert.");
//    }
//
//    @Override
//    public void afterAlertDismiss(WebDriver driver) {
//        System.out.println("After dismissing the alert.");
//    }
//
//    @Override
//    public void beforeAlertDismiss(WebDriver driver) {
//        System.out.println("Before dismissing the alert.");
//    }
//
//    @Override
//    public void beforeNavigateTo(WebDriver driver, String url) {
//        System.out.println("Navigating to: " + url);
//    }
//
//    @Override
//    public void afterNavigateTo(WebDriver driver, String url) {
//        System.out.println("Navigated to: " + url);
//    }
//
//    @Override
//    public void beforeNavigateBack(WebDriver driver) {
//        System.out.println("Navigating back.");
//    }
//
//    @Override
//    public void afterNavigateBack(WebDriver driver) {
//        System.out.println("Navigated back.");
//    }
//
//    @Override
//    public void beforeNavigateForward(WebDriver driver) {
//        System.out.println("Navigating forward.");
//    }
//
//    @Override
//    public void afterNavigateForward(WebDriver driver) {
//        System.out.println("Navigated forward.");
//    }
//
//    @Override
//    public void beforeNavigateRefresh(WebDriver driver) {
//        System.out.println("Refreshing the page.");
//    }
//
//    @Override
//    public void afterNavigateRefresh(WebDriver driver) {
//        System.out.println("Page refreshed.");
//    }
//
//    @Override
//    public void beforeFindElement(WebDriver driver, By locator) {
//        System.out.println("Before finding element: " + locator);
//    }
//
//    @Override
//    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
//        System.out.println("Found element: " + locator);
//    }
//
//    @Override
//    public void beforeClick(WebElement element) {
//        System.out.println("Before clicking on: " + element.getText());
//    }
//
//    @Override
//    public void afterClick(WebElement element) {
//        System.out.println("Clicked on: " + element.getText());
//    }
//
//    @Override
//    public void beforeExecuteScript(WebDriver driver, String script) {
//        System.out.println("Before executing script: " + script);
//    }
//
//    @Override
//    public void afterExecuteScript(WebDriver driver, String script) {
//        System.out.println("After executing script: " + script);
//    }
//
//    @Override
//    public void onError(WebDriver driver, Throwable throwable) {
//        System.out.println("Exception occurred: " + throwable.getMessage());
//    }
//
//    @Override
//    public <X> void beforeGetScreenshot(WebDriver driver, OutputType<X> target) {
//        System.out.println("Before taking a screenshot.");
//    }
//
//    @Override
//    public <X> void afterGetScreenshot(WebDriver driver, OutputType<X> target, X screenshot) {
//        System.out.println("Screenshot taken.");
//    }
//
//    @Override
//    public void beforeGetText(WebElement element) {
//        System.out.println("Before getting text from element.");
//    }
//
//    @Override
//    public void afterGetText(WebElement element, String text) {
//        System.out.println("Text retrieved: " + text);
//    }
//}
