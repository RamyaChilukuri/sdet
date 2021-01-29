package Cucumber_test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:/Users/RamyaChilukuri/eclipse-workspace/Cucumber_Project/src/test/java/Features",
    glue = {"StepDefinitions"},
    tags = "@HRM",
    plugin = {"html:test-reports-hrm.html"},
	monochrome = true
)

public class HRM_Runner {

}
