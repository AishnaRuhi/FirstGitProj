package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    public WebDriver driver;
    public LoginPage lp; //create login page obj, can access action methods in LoginPage

    @Given("User Launch Chrome Browser")
    public void userLaunchChromeBrowser() {

        lp = new LoginPage();
    }

    @When("User opens URL")
    public void userOpensURL() {
        DriverFactory.getDriver().get("https://admin-demo.nopcommerce.com/login");
    }
    /*@When("User opens URL {string}")
    public void userOpensURL(String url) {
        DriverFactory.getDriver().get(url);
    }*/

    @And("User enter Email as {string} and Password as {string}")
    public void userEnterEmailAsAndPasswordAs(String email, String password) {
        lp.setUserName(email);
        lp.setUserPassword(password);
    }

    @And("User clicks on Login")
    public void userClicksOnLogin() {
        lp.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void pageTitleShouldBe(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful."))
        {
            driver.close();
            Assert.assertTrue(false);
        } else
        {
            Assert.assertEquals(title, driver.getTitle());
        }
    }

    @When("User clicks on Log Out link")
    public void userClicksOnLogOutLink() throws InterruptedException {
        lp.clickLogout();
        Thread.sleep(3000);
    }

    @And("close browser")
    public void closeBrowser() {
        driver.quit();
    }


}
