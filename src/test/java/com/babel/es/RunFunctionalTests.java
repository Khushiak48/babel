package com.babel.es;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * @author Khushboo Taneja
 *
 */

@CucumberOptions(format = { "pretty", "json:target/cucumber-json" },
		// features = {"classpath:functional/babel.feature:63",
		// "classpath:functional/babel2.feature:36" },
		features = "classpath:functional/babel.feature:63", glue = {"com.babel.es"})

public class RunFunctionalTests extends AbstractTestNGCucumberTests {

	@Parameters("browsername")
	@BeforeClass
	public void parameterTest(String browsername) {
		BabelStepDefs.browserType = browsername;
		System.out.println("Parameterized value is : " + browsername);
	}
}