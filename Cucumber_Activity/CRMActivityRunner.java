package Cucumber_test;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:/Users/RamyaChilukuri/eclipse-workspace/Cucumber_Project/src/test/java/Features",
		glue = {"StepDefinitions"},
		tags = "@CRM",
		plugin = {"html:test-reports-crm.html"},
		monochrome = true
)

public class CRMActivityRunner {

}
