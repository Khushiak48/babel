package com.babel.es;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author Khushboo Taneja
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "json:target/cucumber-json"},
		  features = "classpath:functional",
	      glue = {"com.babel.es"}
)
public class RunFunctionalTests {
	

}
