package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //src/test/resources/com.cucumber.features/addEmployeeNoBenefit.feature

        features = "src\\test\\resources\\com.cucumber.features\\headerValidation.feature",
        glue = "StepDefinitions",
        dryRun = false,
        monochrome = true
)
public class headerValidationRunner {

}
