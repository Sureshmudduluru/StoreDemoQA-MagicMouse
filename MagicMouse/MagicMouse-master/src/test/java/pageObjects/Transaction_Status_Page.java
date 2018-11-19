/** This Class contains "web element objects" and "methods" for Transaction Status page of Store.DemoQA web site.
  */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Transaction_Results_Page extends DriverClass{
    public Transaction_Results_Page(WebDriver driver){
   	super(driver);
   	}
	public static class Transaction_Results{
	
		public static WebElement Transaction_Dtls_Title(){
			WebDriverWait waitForTransPage = new WebDriverWait(driver, 60);
			waitForTransPage.until(ExpectedConditions.urlContains("transaction-results"));
			
			WebElement transactionTitle = driver.findElement(By.xpath("//*[@id='post-30']/header/h1"));
			
			WebDriverWait waitForTxnTitle= new WebDriverWait(driver, 60);
			waitForTxnTitle.until(ExpectedConditions.visibilityOf(transactionTitle));
			return transactionTitle;
		}
		public static WebElement Transaction_Dtls_Content(){
			
			WebElement transactionContent = driver.findElement(By.xpath("//*[@id='post-30']"));
			String getPlacedProductDtls=transactionContent.getText();
			 try {
					
			if (getPlacedProductDtls.contains("Magic Mouse")){
	        	//status="Passed";
	            System.out.println(getPlacedProductDtls);
		        }
	    } catch (Exception e) {
			e.printStackTrace();
		}
			return transactionContent;
		}
		
	}
	 
}
