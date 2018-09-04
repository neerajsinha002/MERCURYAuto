package cuke;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\test\\resources\\test.feature"},
        plugin = {"pretty", "html:target/cucumber-html-report"},
        // tags = {"@Second"},
        glue = {"stepDef"}/*,
        monochrome = true*/
)
public class runner {
}
