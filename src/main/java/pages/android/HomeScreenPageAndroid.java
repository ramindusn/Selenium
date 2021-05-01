package pages.android;

import java.util.concurrent.TimeUnit;

public class HomeScreenPageAndroid extends BasePageAndroid{

    public boolean verifyLoginPage() {
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return appiumDriver.findElementById("works.tr.Android:id/btnFinishEducation").isDisplayed();
    }

    public boolean clickOnNextButton() {
        boolean isClick = false;
        try{
            appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            appiumDriver.findElementById("works.tr.Android:id/btnFinishEducation").click();
            isClick = true;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return isClick;
    }

    public boolean clickOnSecondNextButton() {
        boolean isClick = false;
        try{
            appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            appiumDriver.findElementById("works.tr.Android:id/btnFinishEducation").click();
            isClick = true;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return isClick;
    }

    public boolean clickOnThirdNextButton() {
        boolean isClick = false;
        try{
            appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            appiumDriver.findElementById("works.works.tr.Android:id/btnFinishEducation").click();
            isClick = true;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return isClick;
    }

}
