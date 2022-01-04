package test;

import org.apache.log4j.varia.NullAppender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo2 {
	
	static WebDriver driver = null;

	@BeforeTest
	public void setUpTest() {
		
		// initialize properly log4j
		org.apache.log4j.BasicConfigurator.configure(new NullAppender());
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");	
		driver = new ChromeDriver();
		
	}
	
	@Test
	public static void googleSearch() {
		
		//goto google.com
		driver.get("https://google.com");
		
		//pop-up accepter les cookies
		driver.findElement(By.id("L2AGLb")).click();
				
		//enter text in search box
		driver.findElement(By.name("q")).sendKeys("Cheese!\n");		
		
	}
	
	@AfterTest
	public void tearDownTest() {
		//close browser
		driver.close();
		
		System.out.println("Test completed Successfully");
		 
	}

}
