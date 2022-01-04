package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitDemo {
	
	public static void main(String[] args) throws Exception {
		seleniumWaits();
	}
	
	@SuppressWarnings("deprecation")
	public static void seleniumWaits() throws Exception {
		
		String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://google.com");

		//pop-up accepter les cookies
		driver.findElement(By.id("L2AGLb")).click();
		
		driver.findElement(By.name("q")).sendKeys("ABCD");
		driver.findElement(By.name("btnK")).submit();
		
		driver.findElement(By.linkText("Maître Gims - ABCD (Clip officiel) - YouTube")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcd")));
				
		driver.findElement(By.name("abcd")).click();
		
		// Waiting// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
//		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//		       .withTimeout(30, TimeUnit.SECONDS)
//		       .pollingEvery(5, TimeUnit.SECONDS)
//		       .ignoring(NoSuchElementException.class);
//
//		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
//		     public WebElement apply(WebDriver driver) {
//		       return driver.findElement(By.id("foo"));
//		     }
//		   });
		
		Thread.sleep(4000);
		
		driver.close();
		driver.quit();
		
	}

}
