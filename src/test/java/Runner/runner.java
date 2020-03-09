package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ={ "src/test/resources/com.cucumber.features/editEmployee.feature",
                "src/test/resources/com.cucumber.features/addEmployee.feature"},
        glue = "StepDefinitions",
        dryRun = false,
        monochrome = true
)
public class runner {
}
