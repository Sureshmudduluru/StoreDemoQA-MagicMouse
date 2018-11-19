/** * This Class contains "web element objects","methods" for product Checkout page of Store.DemoQA web site.
  */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.Constant;

public class Checkout_Page extends DriverClass{
    public Checkout_Page(WebDriver driver){
   	super(driver);
   	}
	public static class Check_Out{
		
	public static WebElement Check_Out_Title(){		
		WebElement checkOutTitle = driver.findElement(By.xpath("//h1[@class='entry-title' and text()='Checkout']"));
		return checkOutTitle;		
	}
	public static WebElement Product_Magic_Mouse(){
		
		WebElement productMagicMouse = driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/products-page/product-category/accessories/magic-mouse/']"));
	    String verfyProduct=productMagicMouse.getText();
	    
	   if (verfyProduct.equals("Magic Mouse")){
	    	System.out.println("Magic Mouse" + " product is present on the checkout page");
	        }
		
		return productMagicMouse;	
	}
	public static WebElement Product_Quantity(){
		
		WebElement productQuantity = driver.findElement(By.xpath("//input[@name='quantity']"));
	    Assert.assertTrue(productQuantity.isDisplayed(),"No "+ "Magic Mouse" +" quantity for Magic Mouse visible -Test Case stopped");
	    String verfyQuantValue=productQuantity.getAttribute("value");
	    if (verfyQuantValue.contains(Constant.productQuantityValue)){
	    	//status="Passed";
	    	System.out.println(verfyQuantValue);
	        }
		return productQuantity;		
	}
	public static WebElement Click_Continue(){
		
		WebElement continueButton = driver.findElement(By.xpath("//span[text()='Continue']"));
		Assert.assertTrue(continueButton.isDisplayed(),"No continue button on checkout page present -Test Case stopped");
		continueButton.click();
		if(driver.getCurrentUrl().contains("checkout")){
			//status="Passed";
			System.out.println("On Checkout Page");
	    }
		return continueButton;		
	}
	public static WebElement Billing_Form(){
		
		WebElement billingForm = driver.findElement(By.xpath("//td[@class='wpsc_billing_forms ']"));
	    try {
	    	
			WebDriverWait billing_Contact_Page = new WebDriverWait(driver, 60);			
			billing_Contact_Page.until(ExpectedConditions.visibilityOf(billingForm));
			//status="Passed";
	    } catch (Exception e1) {
			//status="Failed";
			e1.printStackTrace();
		}	
		return billingForm;		
	}
	
	public static  void Select_Shipping_Country(String countryCode){
		
		Select drpcountry= new Select(driver.findElement(By.xpath("//select[@name='country']")));
		drpcountry.selectByValue(countryCode);
	
	}
	
	public static WebElement Shipping_State(String provinceCode){
		
		WebElement shippingstate = driver.findElement(By.xpath("//input[@title='shippingstate']"));
		shippingstate.sendKeys(provinceCode);
		return shippingstate;		
	}
	public static WebElement Calculate_Shipping_Button(){
		
		WebElement calculateShippingButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Calculate']"));
		calculateShippingButton.click();
		return calculateShippingButton;		
	}
	public static WebElement Enter_Email(String emailID){
		
		WebElement email = driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_9']"));

	    email.sendKeys(emailID); 
		return email;		
	}
	public static void waitForEmail(){
		WebElement email = driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_9']"));
	    try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(email));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static WebElement Enter_First_Name(String firstName){
		
		WebElement firstNameObj = driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_2']"));
		firstNameObj.sendKeys(firstName); 
		return firstNameObj;		
	}
	public static WebElement Enter_Last_Name(String lastName){
		
		WebElement lastNameObj = driver.findElement(By.xpath("//*[@id='wpsc_checkout_form_3']"));
		lastNameObj.sendKeys(lastName);
		return lastNameObj;		
	}
	public static WebElement Enter_Address(String address){
		
		WebElement addressObj = driver.findElement(By.xpath("//*[@id='wpsc_checkout_form_4']"));
		addressObj.sendKeys(address); 
		return addressObj;		
	}
	public static WebElement Enter_City(String city){
		
		WebElement cityObj = driver.findElement(By.xpath("//*[@id='wpsc_checkout_form_5']"));
		cityObj.sendKeys(city); 
		return cityObj;		
	}
	public static WebElement Enter_Province(String province){
		
		WebElement provinceObj = driver.findElement(By.xpath("//*[@id='wpsc_checkout_form_6']"));
		provinceObj.sendKeys(province); 
		return provinceObj;		
	}
	public static void Select_Country(String countryCode){
		
		Select selectCountry= new Select(driver.findElement(By.xpath("//*[@id='wpsc_checkout_form_7']")));
		selectCountry.selectByValue(countryCode);
	}
	public static WebElement Enter_Postal_Code(String postalCode){
		
		WebElement postalCodeObj = driver.findElement(By.xpath("//*[@id='wpsc_checkout_form_8']"));
		postalCodeObj.sendKeys(postalCode); 
		return postalCodeObj;
	}
	public static WebElement Enter_Phone_No(){
		
		WebElement phoneNumber = driver.findElement(By.xpath("//*[@id='wpsc_checkout_form_18']"));
		return phoneNumber;
	}
	public static WebElement Same_As_Billing_Address(){
		
		WebElement shippingSameAddress = driver.findElement(By.xpath("//*[@id='shippingSameBilling']"));
		shippingSameAddress.click();
		return shippingSameAddress;
	}
	
	public static void scrollDown(){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
	}
	public static WebElement PurchaseButton(){
		
		WebElement purchaseButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Purchase']"));
	    try {
			
			WebDriverWait waitNew = new WebDriverWait(driver, 60);
			waitNew.until(ExpectedConditions.visibilityOf(purchaseButton));
			Assert.assertTrue(purchaseButton.isDisplayed(),"No Purchase button visible - Test Case stopped");
			purchaseButton.click();
			//status="Passed";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return purchaseButton;
	}
}
}
