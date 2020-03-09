package StepDefinitions;

import Pages.LoginPage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();

    @When("the user navigate to login page")
    public void the_user_navigate_to_login_page() {
        driver.get(ConfigReader.getProperty("urlForWindows"));
    }

    @When("provide valid username {string}")
    public void provide_valid_username(String username) {
        loginPage.usernameInput.sendKeys(username);
    }

    @Then("provide valid password {string}")
    public void provide_valid_password(String password) {
        loginPage.passwordInput.sendKeys(password);
    }

    @Then("click login button")
    public void click_login_button() {
        loginPage.loginButton.click();
    }


    @When("provide invalid username {string}")
    public void provide_invalid_username(String username) {
        loginPage.usernameInput.sendKeys(username);
    }

    @Then("validate the error message")
    public void validate_the_error_message() {
        String expectedErrorMessage = "Invalid login attempt. Please try again.";
        String actualErrorMessage = loginPage.errorMessage.getText();
        Assert.assertTrue(actualErrorMessage.equals(expectedErrorMessage));

    }

    @Then("provide invalid password {string}")
    public void provide_invalid_password(String invalidPassword) {
        loginPage.passwordInput.sendKeys(invalidPassword);
    }

    @Then("validate the invalid password for username")
    public void validate_the_invalid_password_for_username() {
        String expectedErrorMessage = "The password is incorrect for username testUser";
        String actualErrorMessage = loginPage.errorMessage.getText();
        Assert.assertTrue(actualErrorMessage.equals(expectedErrorMessage));
    }

}
