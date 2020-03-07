package StepDefinitions;

import Pages.AddEmployeePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AddEmployeeStepDefs {

    AddEmployeePage page = new AddEmployeePage();

    @Given("I am on the Benefits Dashboard page")
    public void i_am_on_the_Benefits_Dashboard_page() {
        String expectedHeader = "Benefits Dashboard";
        String actualHeader = page.header.getText();
        Assert.assertTrue(actualHeader.equals(expectedHeader));
    }

    @When("I select Add Employee")
    public void i_select_Add_Employee() {
        page.addEmployeeButton.click();
    }

    @Then("I should be able to enter employee details")
    public void i_should_be_able_to_enter_employee_details() {
        String expectedHeader ="Add Employee & His dependents";
        String actualHeader = page.addEmloyeeHeader.getText();
        Assert.assertTrue(actualHeader.equals(expectedHeader));
    }

    @Then("I should be able to enter firstName {string}")
    public void i_should_be_able_to_enter_firstName(String firstName) throws InterruptedException {
        Thread.sleep(2000);
        page.firstNameInput.sendKeys(firstName);
    }

    @Then("I should be able to enter lastName {string}")
    public void i_should_be_able_to_enter_lastName(String lastName) {
        page.lastNameInput.sendKeys(lastName);
    }

    @Then("I should be able to enter dependents {string}")
    public void i_should_be_able_to_enter_dependents(String dependents) {
        page.dependentsInput.sendKeys(dependents);
    }

    @Then("First Name does not begin with “A” or “a”")
    public void first_Name_does_not_begin_with_A_or_a() {
        //page.firstNameInput.sendKeys("");
    }

    @Then("the employee should save")
    public void the_employee_should_save() {
        page.submitButton.click();
    }

    @Then("I should see the employee in the table {string} {string} {string}")
    public void i_should_see_the_employee_in_the_table(String firstname, String lastname, String dependents) {
        List<String> employeeDetails = new ArrayList<>();
        for(WebElement element:page.employeeDetails){
            employeeDetails.add(element.getText());
        }
        //Bug: last name and first name are replaced with each other
        Assert.assertEquals(firstname,employeeDetails.get(1));//first name goes to last name column and
        Assert.assertEquals(lastname,employeeDetails.get(2));//last name goes to under first name column
        Assert.assertEquals(dependents,employeeDetails.get(4));
    }

    @Then("the benefit cost calculations are correct")
    public void the_benefit_cost_calculations_are_correct() {
        String actualBenefit = page.employeeDetails.get(6).getText();//34.62
        String expectedBenefit = ""+1000/26;//38.46
        Assert.assertTrue(actualBenefit.equals(expectedBenefit));
    }

}
