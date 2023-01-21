package org.techtestbackend;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:build/reports/tests/cucumber/cucumber-report.html"}, 
					features = {"src/test/resources/features"} )
public class CucumberRunnerTest {

}
