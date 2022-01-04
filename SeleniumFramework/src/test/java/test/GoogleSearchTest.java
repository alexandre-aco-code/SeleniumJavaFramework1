package test;

import org.apache.log4j.varia.NullAppender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;

public class GoogleSearchTest {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		googleSearch();

	}
	
	public static void googleSearch() {
		
		// initialize properly log4j
		org.apache.log4j.BasicConfigurator.configure(new NullAppender());
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");	
		driver = new ChromeDriver();
		
		//goto google.com
		driver.get("https://google.com");
		
		//pop-up accepter les cookies
		driver.findElement(By.id("L2AGLb")).click();
				
		//enter text in search box
//		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation Step by Step");

		//click on search button
//		driver.findElement(By.name("btnK")).submit();
		GoogleSearchPage.button_search(driver).submit();
		
		//close browser
		driver.close();
		
		System.out.println("Test completed Successfully");
		
	}

}
