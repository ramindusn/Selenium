package pages.android;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import support.Hooks;

public class RegistrationPageAndroid extends BasePageAndroid{

    By registerEmailAndroid = By.id("works.tr.Android:id/loginEmailText");

    public static final Logger LOGGER= Logger.getLogger(RegistrationPageAndroid.class);

    public boolean setRegisterEmailAddressAndroid(String emailName, String extension){
        boolean isSet = false;
        try {
            elementManagerAndroid.visibilityOfElementLocated(registerEmailAndroid,TIMEOUT_THREE).sendKeys(emailName+getUniqueIDAndroid()+extension);
            isSet = true;
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isSet;
    }



}
