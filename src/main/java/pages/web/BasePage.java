package pages.web;

import org.openqa.selenium.WebDriver;
import support.ElementManager;
import utilities.DriverFactory;
import utilities.PropertyFileReader;

import java.util.Date;
import java.util.Properties;

public class BasePage {
    public WebDriver webDriver;
    protected String projectPath = System.getProperty("user.dir");
    public ElementManager elementManager;
    public static final int TIMEOUT_ONE = 2;
    public static final int TIMEOUT_TWO = 5;
    public static final int TIMEOUT_THREE = 10;
    public static final int TIMEOUT_FOUR = 15;
    public PropertyFileReader runningConfig = new PropertyFileReader();
    public Properties prop = runningConfig.getProperties();

    public  BasePage(){
        webDriver = DriverFactory.getWebDriver();
        elementManager = new ElementManager(webDriver);
    }

    public long getUniqueID() {
        Date date = new Date();
        long time = date.getTime();
        return time;
    }
}
