package offline;
import static org.junit.Assert.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Recurring {

	static AppiumDriver driver = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", System.getenv("DEVICE_NAME"));
		capabilities.setCapability("platformVersion", System.getenv("PLATFORM_VERSION"));
		capabilities.setCapability("platformName", System.getenv("PLATFORM_NAME"));
		capabilities.setCapability("udid", System.getenv("udid"));
		capabilities.setCapability("appPackage", "com.expensemanager");
		capabilities.setCapability("appActivity", "com.expensemanager.ExpenseManager");
		driver = new AndroidDriver(new URL(System.getenv("APPIUM_URL")),capabilities);
		//driver = new AndroidDriver(new URL("http://10.120.100.13:80/da/ensemble/device/yM4wseE2kERq8ancpoR7EQ/appium/wd/hub/"),capabilities);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.name("Recurring")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.name("Repeating Income")).click();
		Thread.sleep(2000);
				
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.expensemanager:id/expenseDescriptionRepeat']")).sendKeys("Verifying Repeating Income");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.expensemanager:id/expenseAmountRepeat']")).sendKeys("20000");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.expensemanager:id/expenseTaxRepeat']")).sendKeys("2500");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.expensemanager:id/numberOfPayment']")).sendKeys("20");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='com.expensemanager:id/processFutureTransaction']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("Monthly")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("Every 2 Month")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.expensemanager:id/datePickerRepeat']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("Set")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.expensemanager:id/payeeRepeat']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.expensemanager:id/text1']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.expensemanager:id/categoryRepeat']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("Salary")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.expensemanager:id/paymentMethodRepeat']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("Cash")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.expensemanager:id/statusRepeat']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("Cleared")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("Never")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("On due date")).click();
		Thread.sleep(2000);
		
//		driver.findElement(By.name("OK")).click();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
	
	}
	
}
