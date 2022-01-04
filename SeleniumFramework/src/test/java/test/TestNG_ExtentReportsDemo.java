package test;

import org.apache.log4j.varia.NullAppender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestNG_ExtentReportsDemo {
	
	static WebDriver driver = null;
	
	ExtentSparkReporter spark = null;
	static ExtentReports extent = null;

	@BeforeSuite
	public void setUp() {
		
		// initialize properly log4j
		org.apache.log4j.BasicConfigurator.configure(new NullAppender());
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");	
		driver = new ChromeDriver();
		
		
		spark = new ExtentSparkReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		
	}
	
	@Test
	public static void test1() throws Exception {
		
		ExtentTest test1 = extent.createTest("Google Search Test One", "This is a test to validate google search functionnality");

		test1.log(Status.INFO, "Starting Test case");
		
		//goto google.com
		driver.get("https://google.com");
		
		//pop-up accepter les cookies
		driver.findElement(By.id("L2AGLb")).click();
				
		//enter text in search box
		driver.findElement(By.name("q")).sendKeys("Cheese!\n");		

		// reference image saved to disk
		test1.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
		
		test1.addScreenCaptureFromPath("screenshot.png");

	}
	

	@Test
	public static void test2() throws Exception {
		
		ExtentTest test2 = extent.createTest("Google Search test2", "This is a second test");

		test2.log(Status.INFO, "Starting Test case");
		
		//goto google.com
		driver.get("https://google.com");
		
		//pop-up accepter les cookies
		driver.findElement(By.id("L2AGLb")).click();
				
		//enter text in search box
		driver.findElement(By.name("q")).sendKeys("Cheese!\n");		

		// reference image saved to disk
		test2.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
		
		test2.addScreenCaptureFromPath("screenshot.png");

	}
	
	@AfterTest
	public void tearDownTest() {
		
		//close browser
		driver.close();
		
		System.out.println("Test completed Successfully");
		
	}
	
	@AfterSuite
	public void tearDown() {
		
		extent.flush();
		 
	}

}
