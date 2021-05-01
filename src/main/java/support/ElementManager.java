package support;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverFactory;

public class ElementManager {
    private WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(ElementManager.class);

    public ElementManager(WebDriver webDriver) {
        driver = webDriver;
    }

    public ElementManager(AppiumDriver appiumDriver) {
        driver = appiumDriver;
    }

    public boolean waitForPageLoad(int timeout) {
        boolean isLoaded = false;

        WebDriverWait wait = new WebDriverWait(driver, timeout);
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver1 -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").toString().equals("complete");

        //Get JS is Ready
        boolean jsReady = (Boolean) jsExec.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            //Wait for Javascript to load
            wait.until(jsLoad);
            isLoaded = true;
        } else {
            isLoaded = true;
            LOGGER.info("JS is Ready");
        }
        return isLoaded;
    }

    public boolean alertIsPresent(int timeout){
        boolean isPresent = true;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        if(wait.until(ExpectedConditions.alertIsPresent())==null){
            isPresent = false;
        }
        return isPresent;
    }

    public WebElement visibilityOfElementLocated(By locator, int timeout) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public WebElement presenceOfElementLocated(By locator, int timeout) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    public WebElement elementToBeClickable(By locator, int timeout) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public boolean elementToBeSelected(By locator, int timeout) {
        boolean isSelected = false;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        isSelected = wait.until(ExpectedConditions.elementToBeSelected(locator));
        return isSelected;
    }

    public boolean stalenessOf(WebElement element, int timeout) {
        boolean isSelected = false;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        isSelected = wait.until(ExpectedConditions.stalenessOf(element));
        return isSelected;
    }

    public boolean waitForUrlContains(String expectedString, int timeout) {
        boolean isCheck = false;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        ExpectedCondition<Boolean> urlIsCorrect = arg0 -> driver.getCurrentUrl().contains(expectedString);
        if(wait.until(urlIsCorrect)){
            isCheck =true;
        }
        //waitForPageLoad(timeout);
        return isCheck;
    }
}
