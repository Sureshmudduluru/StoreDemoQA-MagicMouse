/** This Class contains methods for Entering Billing Details of store.demoQA web site.
  * testStep inside every method describes the function covered within it.
  */
package actions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.Checkout_Page;
import utility.TestNG_Reports;

public class EnterContactOrBillingDtls {
	private static  String testStep; 
	private static String status;
public static void enterContactBillingDtls(String countryCode,String provinceCode,String emailID,String firstName,String lastName,String address,String city,String province,String postalCode,String phoneNo){
		
	testStep="Step#6 - Enter test (dummy) data needed for email, billing/contact details and click Purchase";
	Checkout_Page.Check_Out.waitForEmail();
	try{    

    Checkout_Page.Check_Out.Select_Shipping_Country(countryCode);
    
    Checkout_Page.Check_Out.Shipping_State(provinceCode);
        
    Checkout_Page.Check_Out.Calculate_Shipping_Button();
    
    Reporter.log("Filling Contact/Billing details :"); 
    Checkout_Page.Check_Out.Enter_Email(emailID);
      
    Reporter.log(emailID); 

    Checkout_Page.Check_Out.Enter_First_Name(firstName);
    
    Reporter.log(firstName); 

    Checkout_Page.Check_Out.Enter_Last_Name(lastName);
     
    Reporter.log(lastName); 

    Checkout_Page.Check_Out.Enter_Address(address);
    
    Reporter.log(address); 

    Checkout_Page.Check_Out.Enter_City(city);
    
    Reporter.log(city); 
    
    Checkout_Page.Check_Out.Enter_Province(province);
    
    Reporter.log(province); 
    
    Checkout_Page.Check_Out.Select_Country(countryCode);

    Checkout_Page.Check_Out.Enter_Postal_Code(postalCode);
    
    Reporter.log(postalCode); 
    
    WebElement phoneNoObj=Checkout_Page.Check_Out.Enter_Phone_No();
    phoneNoObj.sendKeys(phoneNo); 
    Reporter.log(phoneNo); 
    
    Checkout_Page.Check_Out.Same_As_Billing_Address();
    
    status="Passed";  
    }catch (Exception  e) {       	
    	Assert.assertEquals(e,e,"Could not fill billing/contact details properly - Test Case Stopped"); 
        status="Failed";
	}

	Checkout_Page.Check_Out.scrollDown();
	try {
		Checkout_Page.Check_Out.PurchaseButton();
		status="Passed"; 
	} catch (Exception e) {
	
		e.printStackTrace();
		status="Failed";
	}

	System.out.println("Clicked On Purchase");
	TestNG_Reports.reportLog(testStep,"Details filled and clicked on Purchase" , "Done", status); 
	}

}
