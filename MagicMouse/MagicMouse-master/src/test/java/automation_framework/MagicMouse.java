/** This Class is to define Automation framework using TestNG
 *  Test Data sheet rows will be iterated on basis on test case names.
 *  *@BeforeTest method to open an new browser
 *  *@Test method to performs steps to buy the product Magic Mouse as specified in the Test requirement.
 *   *@AfterTest method to close browser once test completes.
  */
package automation_framework;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.DriverClass;
import scripts.DataDrivenClass;
import utility.Constant;
import utility.DriverUtil;
import utility.ExcelUtils;

public class MagicMouse {
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  sTestCaseName ="TestCase_1";
		  System.out.println(sTestCaseName);
		  Reporter.log("Start Of TestCase");
		  ExcelUtils.setExcelFile(Constant.testDataFilePath,"TestCase_1");
		  iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		  driver = DriverUtil.OpenBrowser(iTestCaseRow);
		  new DriverClass(driver);
	  }
	  @Test
	  public void main() throws Exception {
		  try{
			  DataDrivenClass.placeOrderMagicMouse(iTestCaseRow);
			  Reporter.log("Test method placeOrderMagicMouse passed");
	  }
		  catch(Exception e){
			  Reporter.log("Test method placeOrderMagicMouse failed");
		  }
			  
		  }
	  @AfterMethod
	  public void afterMethod() {
		  
		    Reporter.log("End Of TestCase");

		    DriverUtil.closeBrowser();
	  		}
}
