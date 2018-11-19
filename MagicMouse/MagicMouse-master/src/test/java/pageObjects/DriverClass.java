/** * This Class is to define driver using Selenium Webdriver.
 */

package pageObjects;

import org.openqa.selenium.WebDriver;

public class DriverClass {
	public static WebDriver driver;
	public  DriverClass(WebDriver driver){
		DriverClass.driver = driver;

	}
}
