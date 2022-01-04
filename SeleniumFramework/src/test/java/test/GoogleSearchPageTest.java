package test;

import org.apache.log4j.varia.NullAppender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObject;

public class GoogleSearchPageTest {
	
	private static WebDriver driver = null;
	private static String url = "http://google.com";
	private static String textToBeSearched = "A B C D";
	
	
	
	public static void main(String[] args) {
		
		googleSearchTest();
		 
	}
	
	public static void googleSearchTest() {
		

		// initialize properly log4j
		org.apache.log4j.BasicConfigurator.configure(new NullAppender());

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");	
		driver = new ChromeDriver();
		
		GoogleSearchPageObject searchPageObj = new GoogleSearchPageObject(driver);
		
		driver.get(url);
		
		searchPageObj.removeCookiesPopup();
		
		searchPageObj.setTextInSearchBox(textToBeSearched);
		
		searchPageObj.clickSearchButton();
		
		driver.close();
		
	
	}

	
}
