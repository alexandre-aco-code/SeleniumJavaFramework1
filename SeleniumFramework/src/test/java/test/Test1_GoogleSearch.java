package test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.varia.NullAppender;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_GoogleSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		googleSearch();

	}
	
	public static void googleSearch() {
		// initialize properly log4j
		org.apache.log4j.BasicConfigurator.configure(new NullAppender());
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		
		//goto google.com
		driver.get("https://google.com");
		
		//pop-up accepter les cookies
		driver.findElement(By.id("L2AGLb")).click();
				
		//enter text in search box
		driver.findElement(By.name("q")).sendKeys("Cheese!\n");
//		driver.findElement(By.name("q")).sendKeys("Cheese!");
//		driver.findElement(By.name("q")).submit();
		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		//click on search button
//		driver.findElement(By.name("btnK")).click();
//		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		
		//close browser
		driver.close();
		
		System.out.println("Test completed Successfully");
	}

}
