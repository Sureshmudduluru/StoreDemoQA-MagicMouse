/** This Class contains web driver functions to open and close web driver instances.
  */
package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtil {
	public static WebDriver driver = null;

	
	public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception{
		String sBrowserName;
		try{	
			sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Driver);
				if (sBrowserName.equals("FireFox")) {
					driver = new FirefoxDriver();
					System.out.println("beforeTest - " + "Loading Driver-" + sBrowserName);
				} else if (sBrowserName.equals("Chrome")) {
					System.setProperty("webdriver.chrome.driver","C:\\Delete\\Suresh\\chromedriver_win32\\chromedriver.exe");
					driver = new ChromeDriver();
				}
		

			} catch (Exception e) {
		         e.printStackTrace();
			}	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
		}
	
	public static WebDriver BrowserOpen(String getDriverName) {
		try {		
			if (getDriverName.equals("FireFox")) {
				driver = new FirefoxDriver();
				System.out.println("beforeTest - " + "Loading Driver-" + getDriverName);
			} else if (getDriverName.equals("Chrome")) {
				driver = new ChromeDriver();
			}
		} catch (Exception e) {
	         e.printStackTrace();
		}	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public static void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
		public static void closeBrowser() {
			driver.quit();
		}
}
