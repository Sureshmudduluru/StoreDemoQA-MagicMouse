/** This Class contains "web element objects" and "methods" for Home page of Store.DemoQA web site.
  */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utility.Constant;


public class ToolsQA_Home_Page extends DriverClass{
    public ToolsQA_Home_Page(WebDriver driver){
   	super(driver);
   	}
    
	public static class ToolsQA_Page{
		
		public static void openToolsQAURL(){
			driver.get(Constant.appURL);
			try {
				String getSiteURL=driver.getCurrentUrl();
				Assert.assertTrue(Constant.appURL.equals(getSiteURL),"Not navigated to ToolsQA website-Test Case stopped");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static WebElement Product_Category(){
			
			WebElement productCategory = driver.findElement(By.linkText("Product Category"));
		    Actions action = new Actions(driver);
		    action.moveToElement(productCategory).build().perform();
			return productCategory;
			
		}
		public static WebElement Accesories(){
			
			WebElement accessories = driver.findElement(By.linkText("Accessories"));
			accessories.click();
			return accessories;
			
		}
		public static WebElement All_Product(){
			WebElement allProduct = driver.findElement(By.linkText("All Product"));
			return allProduct;
			
		}
	}
}
