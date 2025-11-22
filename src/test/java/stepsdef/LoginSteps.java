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

    @When("User enters valid username and password")
    public void userEntersValidUsernameAndPassword() {
        loginPage.enterUserEmail("testaffaires@gmail.com");
        loginPage.enterPassword("Demo-shop-1234");
        homePage = loginPage.clickLoginButton();
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
       Assert.assertTrue(homePage.getHederBar().isUserLoggedIn());
    }









    @When("User enters in-valid username and password")
    public void userEntersInValidUsernameAndPassword() {
        driver.findElement(By.id("username")).sendKeys("tomsmfith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretfPassword!");
        driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click() ;
    }

    @Then("User shouldn't be logged in successfully")
    public void userShouldnTBeLoggedInSuccessfully() {
        String actual = driver.findElement(By.id("flash")).getText() ;
        String expected = "invalid!" ;
        Assert.assertTrue(actual.contains(expected));
        driver.quit() ;
    }


    @When("try with wrong {string} and {string}")
    public void tryWithWrongAnd(String arg0, String arg1) {
        driver.findElement(By.id("username")).sendKeys(arg0);
        driver.findElement(By.id("password")).sendKeys(arg1);
        driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click() ;
    }
}
