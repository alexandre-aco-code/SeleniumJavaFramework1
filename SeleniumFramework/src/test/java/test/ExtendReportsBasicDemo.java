package test;

import org.apache.log4j.varia.NullAppender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportsBasicDemo {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				

		// initialize properly log4j
		org.apache.log4j.BasicConfigurator.configure(new NullAppender());
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");	
		driver = new ChromeDriver();
		
		
		
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		
		
		
		ExtentTest test1 = extent.createTest("Google Search Test One", "This is a test to validate google search functionnality");

		test1.log(Status.INFO, "Starting Test case");
		//goto google.com
		driver.get("https://google.com");
		test1.pass("Navigated to google");
		
		//pop-up accepter les cookies
		driver.findElement(By.id("L2AGLb")).click();

		//enter text in search box
		driver.findElement(By.name("q")).sendKeys("Cheese!\n");
		test1.pass("Entered Search box and validated research");
		
		//close browser
		driver.close();
		driver.quit();

		test1.pass("closed the browser");
		System.out.println("Test completed Successfully");
		test1.info("Test completed Successfully");
		
		extent.flush();
		

	}

}
