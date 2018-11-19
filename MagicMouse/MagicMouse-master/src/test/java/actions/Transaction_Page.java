/** This Class contains methods for Transaction Status page of Store.DemoQA web site.
  * testStep inside every method describes the function covered within it.
  */
package actions;

import org.testng.Reporter;

import pageObjects.Transaction_Results_Page;
import utility.DriverUtil;
import utility.TestNG_Reports;

public class TransactionPage {
	   private static  String testStep; 
	   private static String status;
	public static void viewTransactionDtls() {

		testStep="Step#7 - Confirm that you have placed the Order in �Transaction Results� page";

		try {
			Transaction_Results_Page.Transaction_Results.Transaction_Dtls_Title();

			Transaction_Results_Page.Transaction_Results.Transaction_Dtls_Content();
			status="Passed";
		} catch (Exception e) {
			e.printStackTrace();
			status="Failed";
		}

		DriverUtil.deleteCookies();
		
		System.out.println("Txns Dtls viewed");
		TestNG_Reports.reportLog(testStep,"One " +"Magic Mouse"+
		 " order present on the Transaction page" , "Done", status);
		System.out.println("End of Test Case");
		Reporter.log("End of Test Case");

	}
}
