package StepDefinitions;

import Pages.Homepage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HeaderValidationStepDefs {

Homepage homepage=new Homepage();

    @Then("validate the header {string}")
    public void validate_the_header(String expectedMainPageHeader) {
        String actualMainPageHeader=homepage.header.getText();
        Assert.assertTrue(actualMainPageHeader.equals(expectedMainPageHeader));
    }


    @Then("the user validate the following table headers")
    public void the_user_validate_the_following_table_headers(List<String> expectedTableHeaders) {
        List<String> actualTableHeader=Homepage.getTextList(homepage.tableHeaders);

        Assert.assertArrayEquals(actualTableHeader.toArray(),expectedTableHeaders.toArray());

    }



}
