/**This Class contains methods for Product Checkout page of store.demoQA web site.
  * testStep inside every method describes the function covered within it.
  */
package actions;

import pageObjects.Accessories_Page;
import pageObjects.Checkout_Page;
import utility.TestNG_Reports;

public class CheckOutProduct {

   private static  String testStep; 
   private static String status;
	
	public static void checkOutProduct(){
		
		testStep="Step#4 - Click on �Checkout� and confirm you have 1 product in your Check-Out Page";
		Accessories_Page.Magic_Mouse.Checkout();

	    try {
			Checkout_Page.Check_Out.Product_Magic_Mouse();

			Checkout_Page.Check_Out.Product_Quantity();
			status="Passed";
		} catch (Exception e) {
			
			e.printStackTrace();
			status="Failed";
		}
	          
		System.out.println("CheckOut Product done");
		TestNG_Reports.reportLog(testStep,"One "+ "Magic Mouse" +" Magic Mouse product present" , "One Magic Mouse is present", status); 
		status=null;
		}
	public static void continueAfterCheckout(){
		
		testStep="Step#5 - After confirming, click on Continue";
		try {
			Checkout_Page.Check_Out.Click_Continue();
			Checkout_Page.Check_Out.Billing_Form();
			status="Passed";
		} catch (Exception e) {
			
			e.printStackTrace();
			status="Failed";
		}
		
		System.out.println("Continued after CheckOut");
		TestNG_Reports.reportLog(testStep,"Clicked on continue" , " Done", status);
		status=null;	
		}
		
}
