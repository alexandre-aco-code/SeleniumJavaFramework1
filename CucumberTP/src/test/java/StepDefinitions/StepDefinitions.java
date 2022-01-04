package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	private WebDriver driver;
	String actualResult, resultatAttendu;
	
	@Given("je suis sur la page Login")
	public void precondition() throws Throwable {
		System.setProperty("webdriver.chrome.driver","E:/Logiciels/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		
		driver.get("http://ats.faimerecruiter.com/");

		WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
	}
	
	@When("je saisi un username : {string} And un password : {string}")
	public void saisi_username_et_password(String username, String password) throws Throwable{		
		WebElement UsernameObj = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PasswordObj = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement ValidationObj = driver.findElement(By.xpath("//input[@value='Login']"));
		
		UsernameObj.clear();
		UsernameObj.sendKeys(username);
		PasswordObj.clear();
		PasswordObj.sendKeys(password);
		
		ValidationObj.click();
		
		int LogoutObjSize = driver.findElements(By.xpath("//a[contains(text(),'Logout')]")).size();
		int MsgErreurObjSize = driver.findElements(By.xpath("//p[contains(text(),'Invalid username or password.')]")).size();

		if(LogoutObjSize > 0) {
			actualResult = driver.getCurrentUrl();
			WebElement LogoutObj = driver.findElement(By.xpath("//a[contains(text(), 'Logout')]"));
			LogoutObj.click();
		}
		  
		if(MsgErreurObjSize > 0){
			WebElement ObjMsgError = driver.findElement(By.xpath("//p[@class=\"failure\"]"));
			actualResult = ObjMsgError.getText();
		}

        Thread.sleep(2000);
	    driver.quit();
	    
	}
	
	@Given("je suis sur la page Home")
	public void preconditionTest() throws Throwable {
		System.setProperty("webdriver.chrome.driver","E:/Logiciels/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		
		driver.get("http://ats.faimerecruiter.com/");

		WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
	    
	    //Aller sur la page job order
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement pageJob = driver.findElement(By.linkText("Job Orders"));
		pageJob.click();
	}
	
	@When("je saisi un titre : {string} And une compagny : {string} And une ville : {string} And un pays : {string} And un recruteur : {string} And un owner : {string} And un type : {string} And une openings : {string}")
	public void je_saisi_un_titre_and_une_compagny_and_une_ville_and_un_pays_and_un_recruteur_and_un_owner_and_un_type_and_une_openings(String title, String company, String city, String state, String recruiter, String owner, String type, String openings) throws Throwable{
	     WebElement UsernameObj = driver.findElement(By.xpath("//input[@id='username']"));
		 WebElement PasswordObj = driver.findElement(By.xpath("//input[@id='password']"));
		 WebElement ValidationObj = driver.findElement(By.xpath("//input[@value='Login']"));
			
		 UsernameObj.clear();
		 UsernameObj.sendKeys("admin");
		 PasswordObj.clear();
		 PasswordObj.sendKeys("admin");
		
		 ValidationObj.click();
	    
	   //Aller sur la page job order
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		 WebElement pageJob = driver.findElement(By.linkText("Job Orders"));
		 pageJob.click();
		
	   //Creation d'un job order
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 WebElement addJobObject = driver.findElement(By.linkText("Add Job Order"));
		 addJobObject.click();
		 
	   //Cliquer sur le bouton dans la pop-up
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.switchTo().frame(0);
		 WebElement createJobObject = driver.findElement(By.xpath("//input[@value='Create Job Order']"));
		 createJobObject.click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
	   //On remplit les champs obligatoire 
		 WebElement TitleObject = driver.findElement (By.xpath("//input[@id='title']"));
		 WebElement CompanyObject = driver.findElement (By.xpath("//input[@id='companyName']"));
		 WebElement CityObject = driver.findElement (By.xpath("//input[@id='city']"));
		 WebElement StateObject = driver.findElement (By.xpath("//input[@id='state']"));
		 WebElement RecruiterObject = driver.findElement (By.xpath("//select[@id='recruiter']"));
		 WebElement OwnerObject = driver.findElement (By.xpath("//select[@id='owner']"));
		 WebElement TypeObject = driver.findElement (By.xpath("//select[@id='type']"));
		 WebElement OpeningsObject = driver.findElement (By.xpath("//input[@id='openings']"));
		 WebElement SumitObject = driver.findElement (By.xpath("//input[@name='submit']"));
		 
		 TitleObject.click();
		 TitleObject.clear();
		 TitleObject.sendKeys(title);
		 
		 CompanyObject.click();
		 CompanyObject.clear();
		 CompanyObject.sendKeys(company);
		 if (company.length() != 0) {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.id("suggest0")).click();
		 }
		 
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 CityObject.click();
		 CityObject.clear();
		 CityObject.sendKeys(city);
		 
		 StateObject.click();
		 StateObject.clear();
		 StateObject.sendKeys(state);

		 RecruiterObject.click();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 new Select(driver.findElement(By.id("recruiter"))).selectByVisibleText(recruiter);
		    
		 OwnerObject.click();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 new Select(driver.findElement(By.id("owner"))).selectByVisibleText(owner);
		  
		 TypeObject.click();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 new Select(driver.findElement(By.id("type"))).selectByVisibleText(type);
		 
		 OpeningsObject.click();
		 OpeningsObject.clear();
		 OpeningsObject.sendKeys(openings);
		 
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 SumitObject.click();
		 
		//Retourne sur la page job order
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 WebElement pageJob1 = driver.findElement(By.linkText("Job Orders"));
		 pageJob1.click();
		 
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 
		 
	   //Message d'erreur champs obligatoire pas remplie
		 int msgErreur = driver.switchTo().alert().getText().length();
		 
		 if(msgErreur > 0) {
			 String messageAlerte = driver.switchTo().alert().getText();
			 driver.switchTo().alert().accept();
		 }
	}

	@Then("{string}")
	public void resultat_test(String resultatAttendu) throws Throwable {
		assertEquals(resultatAttendu, actualResult);
	}
}



