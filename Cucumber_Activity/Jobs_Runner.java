package Cucumber_test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:/Users/RamyaChilukuri/eclipse-workspace/Cucumber_Project/src/test/java/Features",
    glue = {"StepDefinitions"},
    tags = "@Activity_jobs_1",
    plugin = {"html: test-reports-jobs.html"},
    monochrome = true
)
public class Jobs_Runner {

}
