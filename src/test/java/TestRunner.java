import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:target/report/cucumber-reports.html"},
        glue = {"stepdefs"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setup() {

    }
}
