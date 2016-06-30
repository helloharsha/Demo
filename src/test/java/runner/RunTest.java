package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import baseFile.BaseFile;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features" }, dryRun = false, strict = false, monochrome = true, format = {
		"pretty", "html:target/cucumber-reports" }, glue = { "stepdefinations" }, tags = "@login")

public class RunTest extends BaseFile {

	@BeforeClass
	public static void init() throws Exception {

		videoRecord.startRecording();
	}

	@AfterClass
	public static void stop() throws Exception {
		videoRecord.stopRecording();
	

}}
	
	
