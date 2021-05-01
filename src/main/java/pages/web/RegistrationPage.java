package pages.web;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.Hooks;

import java.util.concurrent.TimeUnit;

public class RegistrationPage extends BasePage {

    By loginButton = By.id("log-in");
    By getStartedButton = By.id("get-started");
    By createProfileButton = By.id("as_contractor");
    By registerEmail = By.id("email");
    By postalCodeNumber = By.name("home_address[zipcode]");
    By houseNumber = By.name("home_address[number_with_extra]");
    By firstFFName = By.id("first_name");
    By lastFFName = By.name("last_name");
    By registerButton = By.xpath("//button[@class='button button--cta-big button--full-width']");
    By acceptAgreementButton = By.xpath("//input[@class='button button--cta-big button--full-width']");
    By picInputType = By.id("picture");
    //Save and next picture upload
    By pictureUploadSubmit = By.xpath("//button[@class='button button--green button--cta-big button--full-width picture-upload-submit']");
    By addPhotoButton = By.xpath("//button[@class='button button--green button--cta-big button--full-width add-photo']");
    By phoneNumber = By.id("mobile");
    By birthDay = By.id("birth_date");
    By nextButton = By.xpath("//button[@class='button button--green button--cta-big button--full-width']");
    By passportButton = By.xpath("//div[contains(text(),'Passport')]");
    By uploadClearPhotoLabel = By.xpath("//h1[contains(text(),'Upload a clear photo')]");
    By passportInputType = By.name("front");
    By nextButtonAfterPassportUpload = By.id("upload_submit");
    By waitingForVerificationLabel = By.xpath("//div[@id='requestedManualCheck']");
    By continueToDashboardButton = By.id("button-skip-onboarding");

    public static final Logger LOGGER= Logger.getLogger(RegistrationPage.class);
    String imageFilePath = projectPath + "/src/test/resources/media/profilePic.jpg";
    String PassportFilePath = projectPath + "/src/test/resources/media/NLPassport.jpg";

    public boolean verifyNavigatedToTheHomePage(){
        boolean isCheck = false;
        try {
            isCheck = elementManager.presenceOfElementLocated(loginButton,TIMEOUT_TWO).isDisplayed();
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isCheck;
    }

    public boolean clickOnGetStartButton(){
        boolean isClicked = false;
        try {
            elementManager.elementToBeClickable(getStartedButton,TIMEOUT_ONE).click();
            isClicked = true;
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isClicked;
    }

    public boolean clickOnCreateProfileButton(){
        boolean isClicked = false;
        try {
            elementManager.elementToBeClickable(createProfileButton,TIMEOUT_ONE).click();
            isClicked = true;
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isClicked;
    }

    public boolean setRegisterEmailAddress(String emailName, String extension){
        boolean isSet = false;
        try {
            elementManager.visibilityOfElementLocated(registerEmail,TIMEOUT_TWO).sendKeys(emailName+getUniqueID()+extension);
            isSet = true;
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isSet;
    }

    public boolean setPostalCode(String postalCode){
        boolean isSet = false;
        try {
            elementManager.visibilityOfElementLocated(postalCodeNumber,TIMEOUT_TWO).sendKeys(postalCode);
            isSet = true;
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isSet;
    }
    public boolean setHomeNumber(String homeNumber){
        boolean isSet = false;
        try {
            //isSet = ElementHandler.sendKeys(houseNumber,homeNumber,TIMEOUT_ONE);
            elementManager.visibilityOfElementLocated(houseNumber,TIMEOUT_ONE).sendKeys(homeNumber);
            isSet = true;
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isSet;
    }

    public boolean setFirstName(String firstName){
        boolean isSet = false;
        try {
            //isSet = ElementHandler.sendKeys(firstFFName,firstName,TIMEOUT_ONE);
            elementManager.visibilityOfElementLocated(firstFFName,TIMEOUT_ONE).sendKeys(firstName);
            isSet = true;
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isSet;
    }

    public boolean setLastName(String lastName){
        boolean isSet = false;
        try {
            elementManager.visibilityOfElementLocated(lastFFName,TIMEOUT_ONE).sendKeys(lastName);
            isSet = true;
            //isSet = ElementHandler.sendKeys(lastFFName,lastName,TIMEOUT_ONE);
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isSet;
    }

    public boolean clickOnRegisterButton(){
        boolean isClicked = false;
        try {
            elementManager.elementToBeClickable(registerButton,TIMEOUT_ONE).click();
            isClicked =true;
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isClicked;
    }

    public boolean clickOnAcceptAgreementButton(){
        boolean isClicked = false;
        try {
            elementManager.elementToBeClickable(acceptAgreementButton,TIMEOUT_TWO).click();
            isClicked = true;
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isClicked;
    }

    public boolean uploadAndSubmitProfilePicture(){
        boolean isClicked = false;
        try {
            WebElement ele = elementManager.visibilityOfElementLocated(addPhotoButton,TIMEOUT_TWO);
            if(ele.isDisplayed()){
                elementManager.presenceOfElementLocated(picInputType,TIMEOUT_TWO).sendKeys(imageFilePath);
                elementManager.elementToBeClickable(pictureUploadSubmit,TIMEOUT_TWO).click();
                isClicked = true;
            }
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isClicked;
    }

    public boolean setPhoneNumber(String phoneNo){
        boolean isSet = false;
        try {
            elementManager.visibilityOfElementLocated(phoneNumber,TIMEOUT_ONE).sendKeys(phoneNo);
            isSet = true;
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isSet;
    }

    public boolean setBirthDate(String bDay){
        boolean isSet = false;
        try {
            elementManager.visibilityOfElementLocated(birthDay,TIMEOUT_ONE).sendKeys(bDay);
            isSet = true;
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isSet;
    }

    public boolean clickOnNextButton(){
        boolean isClicked = false;
        try {
            elementManager.elementToBeClickable(nextButton,TIMEOUT_ONE).click();
            isClicked = true;
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isClicked;
    }

    public boolean clickOnPassportButton(){
        boolean isClicked = false;
        try {
            elementManager.elementToBeClickable(passportButton,TIMEOUT_ONE).click();
            isClicked = true;
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isClicked;
    }

    public boolean uploadAndSubmitPassport(){
        boolean isClicked = false;
        try {
            WebElement ele = elementManager.presenceOfElementLocated(uploadClearPhotoLabel,TIMEOUT_TWO);
            if(ele.isDisplayed()){
                elementManager.presenceOfElementLocated(passportInputType,TIMEOUT_TWO).sendKeys(PassportFilePath);
                elementManager.elementToBeClickable(nextButtonAfterPassportUpload,TIMEOUT_TWO).click();
                isClicked =true;
            }
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isClicked;
    }

    public boolean verifyTextPresentInWaitingForVerificationPage() {
        boolean value = false;
        try {
            WebElement ele = elementManager.presenceOfElementLocated(waitingForVerificationLabel, TIMEOUT_THREE);
            value = ele.isDisplayed();
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return value;
    }

    public boolean clickOnContinueToDashboard(){
        boolean isClicked = false;
        try {
            //isClicked = ElementHandler.clickOnButton(continueToDashboardButton,TIMEOUT_ONE);
            elementManager.elementToBeClickable(continueToDashboardButton,TIMEOUT_TWO).click();
            //webDriver.findElement(By.xpath("//a[@id='button-skip-onboarding']")).click();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            isClicked =true;
        } catch (RuntimeException e) {
            LOGGER.error(this.getClass().getSimpleName() + Hooks.currentRunningScenario + e);
        }
        return isClicked;
    }

}

