package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
/**
 * @author Muthumani
 * @Description Test Runner class which run all the feature files based on tags
 *              scenarios present on the feature file
 * @created Date 06/29/2022
 */
@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE, strict = true, dryRun = false, plugin = { "pretty",
		"json:target/cucumber.json" }, monochrome = true, features = { "src\\test\\resources\\"}, glue = {"com.stepdefinition"})
public class TestRunnerClass {
	/**
	 * @Description To generate JVM report after the execution all scenarios in
	 *              feature file
	 * @created Date 06/29/2022
	 */
	@AfterClass
	public static void afterClass() {
		Reporting.generateJVMReport(System.getProperty("user.dir") + "\\target\\cucumber.json");
	}
}//tags = { "@newAddress" },