package pages.ios;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import pages.android.RegistrationPageAndroid;
import support.Hooks;

public class RegistrationPageIOS extends BasePageIos{
    By registerEmailIOS = By.xpath("//XCUIElementTypeApplication[@name='app1']/XCUIElementTypeTextField");

    public static final Logger LOGGER= Logger.getLogger(RegistrationPageAndroid.class);

    public boolean setRegisterEmailAddressAndroid(String emailName, String extension){
        boolean isSet = false;
        try {
            elementManagerIos.visibilityOfElementLocated(registerEmailIOS,TIMEOUT_THREE).sendKeys(emailName+getUniqueIDIOS()+extension);
            isSet = true;
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isSet;
    }
}
