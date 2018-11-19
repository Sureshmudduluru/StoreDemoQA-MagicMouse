/** This Class contains methods for ADD to Cart page of store.demoQA web site.
  * testStep inside every method describes the function covered within it.
  */
package actions;

import org.openqa.selenium.WebElement;

import pageObjects.Accessories_Page;
import utility.TestNG_Reports;

public class AddToCart {
	   private static  String testStep; 
	   private static String status;
		public static void addToCartMagicMouse(){
			
			testStep="Step #3 - Click on �Add to Cart� for just Magic Mouse"; 
		    WebElement productName= Accessories_Page.Magic_Mouse.Product_Name();       
		  
		    try {
				if (productName.equals("Magic Mouse")){
					System.out.println("Magic Mouse product is present");
					status="Passed";
				}
			} catch (Exception e) {			
				e.printStackTrace();
				status="Failed";
			}

		    try {
				Accessories_Page.Magic_Mouse.Add_To_Cart();
				status="Passed";
			} catch (Exception e) {
				e.printStackTrace();
				status="Failed";
			}        
			System.out.println("Magic Mouse Product added to cart");
			TestNG_Reports.reportLog(testStep,"Magic Mouse Product added to cart" , " Done", status);
		}
}