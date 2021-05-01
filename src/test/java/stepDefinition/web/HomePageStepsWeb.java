package stepDefinition.web;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.web.HomePage;

public class HomePageStepsWeb {

    private HomePage homePage;

    public HomePageStepsWeb(){
        homePage = new HomePage();
    }

    @Given("user load the home page in web")
    public void userLoadTheHomePageInWeb() {
        Assert.assertTrue(homePage.verifyHomePage());
    }

    @Then("user click on Login button in web")
    public void userClickOnLoginButtonInWeb() {

    }
}
