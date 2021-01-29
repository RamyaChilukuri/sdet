package Cucumber_test;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:/Users/RamyaChilukuri/eclipse-workspace/Cucumber_Project/src/test/java/Features",
    glue = {"StepDefinitions"},
    tags = "@activity2_5",
    plugin = {"html: test-reports.html"},
    monochrome = true
)
public class ActivityRunner {

}
