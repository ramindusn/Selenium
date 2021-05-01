package stepDefinition.IOS;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ios.HomePageIos;
import pages.ios.RegistrationPageIOS;

public class OnboardingIOSSteps {

    private HomePageIos homePageIos;
    private RegistrationPageIOS registrationPageIOS;

    public OnboardingIOSSteps() {
        homePageIos = new HomePageIos();
        registrationPageIOS = new RegistrationPageIOS();
    }

    @Given("FF navigate to the ios mobile application")
    public void ffNavigateToTheIosMobileApplication() {
        Assert.assertTrue(homePageIos.verifyLoginPage());
    }

    @Then("FF click on next button in welcome screen \\(IOS)")
    public void ffClickOnNextButtonInWelcomeScreenIOS() {
        Assert.assertTrue(homePageIos.clickOnNextButton());;
        Assert.assertTrue(homePageIos.clickOnSecondNextButton());
        Assert.assertTrue(homePageIos.clickOnThirdNextButton());
    }

    @Then("FF provide an email address to IOS app as {string} {string}")
    public void ffProvideAnEmailAddressToIOSAppAs(String emailName, String extension) {
        Assert.assertTrue(registrationPageIOS.setRegisterEmailAddressAndroid(emailName,extension));
    }
}
