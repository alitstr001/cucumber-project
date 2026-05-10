package stepsdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {
    WebDriver driver = Hooks.getDriver() ;
    HomePage homePage = new HomePage(driver) ;
    LoginPage loginPage;

    @Given("User is on login page")
    public void useIsOnLoginPage() {
        loginPage = homePage.getHederBar().clickOnLoginLink() ;

    }

    @When("User enters valid email and password")
    public void userEntersValidUsernameAndPassword() {
        loginPage.enterUserEmail("testaffaires8@gmail.com");
        loginPage.enterPassword("Demo-shop-1234");
        homePage = loginPage.clickLoginButton();
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
       Assert.assertTrue(homePage.getHederBar().isUserLoggedIn());
    }

}
