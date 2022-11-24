package org.stepdefnition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class ReportsJvm {
	
	public static void jvReport(String jsonFile) {
		
		File f = new File("C:\\Users\\Lenovo\\eclipse-workspace\\Maven12\\Allreports\\jvmReport");
		
		
		Configuration c = new Configuration(f, "Facebook");
		c.addClassifications("Software", "jdk 1.8");
		c.addClassifications("testing tool", "Selenium");
		
		
		List<String> li = new ArrayList();
		li.add(jsonFile);
		
		ReportBuilder r = new ReportBuilder(li,c);
		r.generateReports();
		
		
		
		

	}

}
