/** This Class contains methods to open home page of Store.DemoQA web site.
 * testStep inside every method describes the function covered within it.
  */
package actions;

import org.testng.Reporter;

import pageObjects.ToolsQA_Home_Page;
import utility.TestNG_Reports;

public class OpenToolsQAwebSite {
	private static  String testStep; 
	private static String status;
	public static void openURL(){
	
	testStep="Step#1 - Go to ToolsQA URL";	
	try {
		ToolsQA_Home_Page.ToolsQA_Page.openToolsQAURL();
		status="Passed"; 
	} catch (Exception e) {
		e.printStackTrace();
		status="Failed";
	}
	System.out.println("ToolsQA URL opened");	
	Reporter.log("Start of Test Case");
	TestNG_Reports.reportLog(testStep,"ToolsQA URL opened" , "Done", status); 
	}
}
