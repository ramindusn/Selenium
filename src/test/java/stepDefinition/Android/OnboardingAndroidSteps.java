package stepDefinition.Android;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.android.HomeScreenPageAndroid;
import pages.android.RegistrationPageAndroid;

public class OnboardingAndroidSteps {
    private HomeScreenPageAndroid homeScreenPageAndroid;
    private RegistrationPageAndroid registrationPageAndroid;

    public OnboardingAndroidSteps() {
        homeScreenPageAndroid = new HomeScreenPageAndroid();
        registrationPageAndroid = new RegistrationPageAndroid();
    }

    @Given("user navigate to the android mobile login")
    public void userNavigateToTheAndroidMobileLogin() {
        Assert.assertTrue(homeScreenPageAndroid.verifyLoginPage());
    }

    @Then("user click on next button in welcome screen")
    public void userClickOnNextButtonInWelcomeScreen() {
        Assert.assertTrue(homeScreenPageAndroid.clickOnNextButton());
    }
}
