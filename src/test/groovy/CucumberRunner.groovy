import cucumber.api.junit.Cucumber
import cucumber.api.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber.class)
@CucumberOptions (
        features = ["classpath:features/"]
        , monochrome = true
        , format = ["pretty", "html:target/results",  "json:target/cucumber.json", "rerun:rerun.txt" ]
        , glue = ["src/test/groovy/com/testAvenue/qa/steps"]
        , tags = ["@subtask"]
)
class CucumberRunner {
}