package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static final String CHROME_DRIVER_MAC = "exe/mac/chromedriver";

    public static WebDriver webDriver;
    public static AppiumDriver appiumDriver;
    public static final Logger LOGGER = Logger.getLogger(DriverFactory.class);
    private PropertyFileReader pro;

    public DriverFactory() {
        pro = new PropertyFileReader();
        throw new IllegalStateException("Utility class");
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = getChromeDriver();
        }
        return webDriver;
    }

    public static AppiumDriver getMobileDriver(String mobileOsType) {
        if (appiumDriver == null) {
            appiumDriver = getAppiumDriver(mobileOsType);
        }
        return appiumDriver;
    }

    private static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_MAC);
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("safebrowsing.enabled", "true");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        return new ChromeDriver(chromeOptions);
    }

    private static AppiumDriver getAppiumDriver(String mobileOsType) {
        try {
            if(mobileOsType.equalsIgnoreCase("Android")){
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("deviceName", "Samsung S9");
                caps.setCapability("udid", "emulator-5554");
                caps.setCapability("platformName", "Android");
                caps.setCapability("platformVersion", "9.0.0");
                caps.setCapability("appPackage", "works.temper.temperAndroid");
                caps.setCapability("appActivity", "works.temper.temperAndroid.ui.splash.SplashScreenActivity");

                appiumDriver = new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
                //appiumDriver = new AppiumDriver<MobileElement>(url, cap);

            }else if(mobileOsType.equalsIgnoreCase("IOS")){
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setCapability("app", "/Users/ramindu/Library/Developer/Xcode/DerivedData/Temper-dkqtrrysyxiqelgbywfhkxqkjory/Build/Products/Debug-iphonesimulator/Temper.app");
                cap.setCapability("deviceName", "iPhone 11 Pro MAX");
                cap.setCapability("udid", "011A40AD-F5F9-4348-B127-5B95BB9BBA19");
                cap.setCapability("automationName", "XCUITest");
                cap.setCapability("platformName", "iOS");
                cap.setCapability("platformVersion", "13.5");

                URL url = new URL("http://127.0.01:4723/wd/hub");
                appiumDriver = new IOSDriver(url, cap);
            }else{
                LOGGER.error("Mobile type NOT found");
            }
        } catch (MalformedURLException e) {
            LOGGER.error("Some thing wrong in mobile driver -"+e);
        }
        return appiumDriver;
    }

    public static void close() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}
