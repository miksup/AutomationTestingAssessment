package Assessment.AutomatedTesting;

import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:")



public class TestRunner {
	
public static ExtentReports report = new ExtentReports(Constants.ReportLoc, true);

}
