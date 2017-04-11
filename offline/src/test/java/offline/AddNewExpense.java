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

public class AddNewExpense {

	static AppiumDriver driver= null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DesiredCapabilities capabilities= new DesiredCapabilities();
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
		driver.findElement(By.name("Add New Expense")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.expensemanager:id/expenseAmountInput']")).sendKeys("80");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.expensemanager:id/payee']")).sendKeys("BOFA");
	  	driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.expensemanager:id/editCategory']")).click();
	  	driver.findElement(By.name("Loans")).click();
	  	driver.findElement(By.name("Auto")).click();
	  	driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.expensemanager:id/editPaymentMethod']")).click();
	  	driver.findElement(By.name("Credit Card")).click();
	  	driver.findElement(By.name("OK")).click();
	  	driver.findElement(By.name("Today Expense:")).click();
	  	driver.findElement(By.name("Loans:Auto")).click();
	  	driver.findElement(By.name("Delete")).click();
	  	driver.findElement(By.name("OK")).click();
	  	driver.navigate().back();
	}

}
