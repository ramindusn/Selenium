package pages.web;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import support.Hooks;

public class HomePage extends BasePage {

    By loginButton = By.xpath("//a[@id='log-in']");

    public static final Logger LOGGER = Logger.getLogger(HomePage.class);

    public boolean loadHomePage() {
        boolean isLoad = false;
        try{
            webDriver.manage().window().maximize();
            webDriver.get(prop.getProperty("url"));
            isLoad = true;
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isLoad;
    }

    public boolean verifyHomePage() {
        boolean isLoaded = false;
        try{
            isLoaded = elementManager.visibilityOfElementLocated(By.xpath("//a[@id='log-in']"),TIMEOUT_FOUR).isDisplayed();
        }catch (Exception e){
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isLoaded;
    }

}
