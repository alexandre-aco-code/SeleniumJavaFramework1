package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"features/Login.feature", "features/CreateJobOrder.feature"}, 
		glue = "StepDefinitions", 
		tags = "not @ignore and @authentification",
		plugin = { "pretty", "json:target/Cucumber.json" }


		)

public class LoginRunner {

}
