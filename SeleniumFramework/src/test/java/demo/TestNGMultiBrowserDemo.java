package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {
	
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	
//	String browserName = "chrome";
	

	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		System.out.println("browserName is : "+browserName);
		System.out.println("Thread id is " +Thread.currentThread().getId());
		
		if(browserName.equalsIgnoreCase("chrome")) {
		
			System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");		
			driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",projectPath+"/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.gecko.driver",projectPath+"/drivers/iedriver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		
	}
	
	@Test
	public void test1() throws InterruptedException {
		driver.get("http://google.com");
		Thread.sleep(3000);
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		System.out.println("test completed successfully!");
	}
	
	
}
