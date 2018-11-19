/** This Class contains methods to cover test steps for product selection of store.demoQA web site.
  * testStep inside every method describes the function covered within it.
  */
package actions;

import pageObjects.ToolsQA_Home_Page;
import utility.TestNG_Reports;

public class SelectProductCategory {
	   private static  String testStep; 
	   private static String status;
	public static void selectProductCategory() {
		testStep="Step #2 - Go to Product category and select Accessories";

	    try {
			ToolsQA_Home_Page.ToolsQA_Page.Product_Category();
			    
			ToolsQA_Home_Page.ToolsQA_Page.Accesories();
			status="Passed";
		} catch (Exception e) {
			e.printStackTrace();
			status="Failed";
		}
	    
	
		System.out.println("Product Category Selected");
		TestNG_Reports.reportLog(testStep, "Navigated to Accessories page", "Done", status);        
	    
	}
}
