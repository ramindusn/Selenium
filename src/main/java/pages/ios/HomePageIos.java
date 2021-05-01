package pages.ios;

import java.util.concurrent.TimeUnit;

public class HomePageIos extends BasePageIos{

    public boolean verifyLoginPage() {
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return appiumDriver.findElementByXPath("//XCUIElementTypeButton[@name='Next']").isDisplayed();
    }

    public boolean clickOnNextButton() {
        boolean isClick = false;
        try{
            appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            appiumDriver.findElementByXPath("//XCUIElementTypeButton[@name='Next']").click();
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
            appiumDriver.findElementByXPath("//XCUIElementTypeButton[@name='Next']").click();
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
            appiumDriver.findElementByXPath("//XCUIElementTypeButton[@name='Get started']").click();
            isClick = true;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return isClick;
    }


}
