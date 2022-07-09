package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author Muthumani
 * @Description JVM report module that make the report after the API Automation
 * @created Date 07/01/2022
 *
 */
public class Reporting {

	public static void generateJVMReport(String jsonFile) {
		File file = new File(System.getProperty("user.dir") + "\\target");
		Configuration configuration = new Configuration(file, "AdactinOMRBranchAutomation");
		configuration.addClassifications("OS", "WIN10");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("version", "108");
		configuration.addClassifications("spirint", "33");
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();
	}

}
