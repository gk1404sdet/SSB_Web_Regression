package runner;

import hooks.JvmReport;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks", "stepDefinitions"},
        plugin = {
                "pretty"
                , "json:target/Reports/cucumber.json"
                , "html:target/Reports/cucumber.html"
                , "junit:target/Reports/Web_Report.xml"
                , "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
                , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterSuite
    public void generateReport() {
        JvmReport.report("target/Reports/cucumber.json");
    }

}
