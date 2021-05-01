package pages.ios;

import io.appium.java_client.AppiumDriver;
import support.ElementManager;
import utilities.DriverFactory;

import java.util.Date;

public class BasePageIos {
    public AppiumDriver appiumDriver;
    public ElementManager elementManagerIos;
    public static final int TIMEOUT_ONE = 2;
    public static final int TIMEOUT_TWO = 5;
    public static final int TIMEOUT_THREE = 10;
    public static final int TIMEOUT_FOUR = 15;

    public  BasePageIos(){
        appiumDriver = DriverFactory.getMobileDriver("IOS");
        elementManagerIos = new ElementManager(appiumDriver);
    }

    public long getUniqueIDIOS() {
        Date date = new Date();
        long time = date.getTime();
        return time;
    }
}


