import java.util.List;

import org.apache.log4j.varia.NullAppender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {
	public static void main(String[] args) {
		
		org.apache.log4j.BasicConfigurator.configure(new NullAppender());

		
		
//		System.out.println("projectPath : " + projectPath);
		
//		System.setProperty("webdriver.gecko.driver",projectPath+"/drivers/geckodriver/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		

		String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		//pop-up accepter les cookies
		driver.findElement(By.id("L2AGLb")).click();
		
		
		
		
	    WebElement textBox = driver.findElement(By.name("q"));
	    
	    textBox.sendKeys("Cheese!\n");
	    
	    
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	    
	    List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
	    
	    int count = listOfInputElements.size();
	    
	    System.out.println("Count of inputs elements : " +count);
	    
	    
	 // wait until the google page shows the result
//	    WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

//	    List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));
		

		driver.close();
		
//		driver.quit();
		
	}
}
