package StepDefinitions;

import Pages.AddEmployeePage;
import Utils.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class EditEmployeeStepDefs {

    AddEmployeePage page = new AddEmployeePage();
    List<String> employeeLastDetails = new ArrayList<>();

    @When("select the Edit  button")
    public void select_the_Edit_button() {
        page.editLastButton.click();
        BrowserUtils.waitForSec(10);
    }

    @When("an Employer should be able to edit employee {string} {string} {string}")
    public void an_Employer_should_be_able_to_edit_employee(String firstName, String lastName, String dependents) throws InterruptedException {
        Thread.sleep(3000);

        page.firstNameInput.clear();
        page.firstNameInput.sendKeys(firstName);

        page.lastNameInput.clear();
        page.lastNameInput.sendKeys(lastName);

        page.dependentsInput.clear();
        page.dependentsInput.sendKeys(dependents);
    }


    @Then("the data should change in the table {string} {string} {string}")
    public void the_data_should_change_in_the_table(String expectedFirstName, String expectedLastName, String expectedDependents) {

        List<String> actualEmployeeInfo = page.getEmployeeDetails(page.employeeDetailsLast);
        Assert.assertTrue(actualEmployeeInfo.get(1).equals(expectedFirstName));
        Assert.assertTrue(actualEmployeeInfo.get(2).equals(expectedLastName));
        Assert.assertTrue(actualEmployeeInfo.get(4).equals(expectedDependents));

    }

    @Given("an Employer")
    public void an_Employer() {

    }

    @Given("I am on the Benefit Dashboard page")
    public void i_am_on_the_Benefit_Dashboard_page() {

    }

    @When("I click the Action X")
    public void i_click_the_Action_X() {
        //get the details of the last employee before deleting
        employeeLastDetails = page.getEmployeeDetails(page.employeeDetailsLast);
        page.deleteLastEmployeeBtn.click();
    }



    @Then("the employee should be deleted")
    public void the_employee_should_be_deleted() {
        //the website doesn't delete the employee
        //it's a bug
        Assert.assertFalse(page.employeeDetailsLast.get(1).getText().equals(employeeLastDetails.get(1)));
        Assert.assertFalse(page.employeeDetailsLast.get(2).getText().equals(employeeLastDetails.get(2)));

    }

}
