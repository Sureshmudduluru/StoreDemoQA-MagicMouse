/** This Class contains "Web element objects" , "Methods" for Accessories page of store.DemoQA web site.
  */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Accessories_Page extends DriverClass{
    public Accessories_Page(WebDriver driver){
   	super(driver);
   	}
    
	public static class Magic_Mouse{
		
		public static WebElement Product_Name(){
			
			WebElement productName = driver.findElement(By.xpath("//a[@class='wpsc_product_title' and text()='Magic Mouse']"));
			return productName;
			
		}
		public static WebElement Add_To_Cart_WE(){
			WebElement addToCartWE = driver.findElement(By.xpath("//form[@action='http://store.demoqa.com/products-page/product-category/accessories/magic-mouse/']//div[@class='input-button-buy']//input[@type='submit']"));
			return addToCartWE;
		}
		
		public static void Add_To_Cart(){			
			WebElement addToCart= Add_To_Cart_WE();
		    addToCart.click();
		    try {
				WebDriverWait waitAfterClickingAddToCart = new WebDriverWait(driver, 60);
				WebElement One_Product_Added_To_Cart=Accessories_Page.Magic_Mouse.One_Product_Added_To_Cart(); 
				waitAfterClickingAddToCart.until(ExpectedConditions.visibilityOf(One_Product_Added_To_Cart));
		    }
		    catch (Exception e1) {
				e1.printStackTrace();				
			}			
			
		}
		public static WebElement One_Product_Added_To_Cart(){
			
			WebElement oneProductAddedToCart = driver.findElement(By.xpath("//*[@id='header_cart']/a/em[1]"));
			return oneProductAddedToCart;
		}
		public static WebElement Checkout(){
			
			WebElement checkOut = driver.findElement(By.xpath("//*[@id='header_cart']/a"));		
			Assert.assertTrue(checkOut.isDisplayed(),"No CheckOut Button visible -Test Case stopped");
			checkOut.click();  
			System.out.println("Checkout clicked");
			
		    if(driver.getCurrentUrl().contains("checkout")){
		    	System.out.println("Successfully navigated to checkout page");
		    }

		    try {
		    	WebElement Check_Out_Title=Checkout_Page.Check_Out.Check_Out_Title();
				WebDriverWait waitForCheckOutPage = new WebDriverWait(driver, 60);			
				waitForCheckOutPage.until(ExpectedConditions.visibilityOf(Check_Out_Title));
				//status="Passed";
		    } catch (Exception e1) {
				//status="Failed";
				e1.printStackTrace();
			}
		    return checkOut;
		}
		
	}
	public static class IMacs{
	}
}
