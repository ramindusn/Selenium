package pages.android;

import io.appium.java_client.AppiumDriver;
import support.ElementManager;
import utilities.DriverFactory;

import java.util.Date;

public class BasePageAndroid {
    public AppiumDriver appiumDriver;
    public ElementManager elementManagerAndroid;
    public static final int TIMEOUT_ONE = 2;
    public static final int TIMEOUT_TWO = 5;
    public static final int TIMEOUT_THREE = 10;
    public static final int TIMEOUT_FOUR = 15;

    public  BasePageAndroid(){
        appiumDriver = DriverFactory.getMobileDriver("Android");
        elementManagerAndroid = new ElementManager(appiumDriver);
    }

    public long getUniqueIDAndroid() {
        Date date = new Date();
        long time = date.getTime();
        return time;
    }

}
