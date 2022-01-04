package Authentification;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

//@Listeners(Automatisation.ListenerTest.class)
public class Authentification {

private WebDriver driver;
	String Username;
	String Password;
	String ResultatAttendu;

	
  @BeforeTest
  public void beforeClass() throws InterruptedException {
	  
	// Instantiation du driver 
	  System.setProperty("webdriver.chrome.driver", "E:/Logiciels/chromedriver_win32/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	
	// Connexion à l'ATS 
	  
	  driver.get("http://ats.faimerecruiter.com/");
	  //Temporisateur wait attend jusqu'à remplir la condition username
	  WebDriverWait wait = new WebDriverWait(driver, 5);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
	  
  }
  
  @DataProvider(name="RegisterData")
  
  public Object[][] RegisterData() throws IOException {
	  
	    FileInputStream inputStream = new FileInputStream(new File("D:/Documents/AJC Formation/Cours AJC/10. selenium/TestLogin.xlsx"));
		XSSFWorkbook Workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = Workbook.getSheetAt(0);
		int NombreLigne=sheet.getLastRowNum();
		Object[][] Data=new Object[NombreLigne][4];
		DataFormatter formatter = new DataFormatter();
	 	
	 	for (int i=1;i<=NombreLigne;i++)
		{
			XSSFCell CellUsername=sheet.getRow(i).getCell(0);
//			Username=CellUsername.getStringCellValue();
			Username=formatter.formatCellValue(CellUsername);
			XSSFCell CellPassword=sheet.getRow(i).getCell(1);
//			Password=CellPassword.getStringCellValue();
			Password=formatter.formatCellValue(CellPassword);
			XSSFCell CellResultatAttendu=sheet.getRow(i).getCell(2);
			ResultatAttendu=CellResultatAttendu.getStringCellValue();
			Data[i-1][0]=Username;
	 		Data[i-1][1]=Password;
	 		Data[i-1][2]=ResultatAttendu;
	 		Data[i-1][3]=i;
		}
	 	return Data;
  }
 

  @Test(dataProvider="RegisterData")
  public void TestLogin (String Username, String Password, String ResultatAttendu,int i) throws InterruptedException {
	  
		WebElement ObjUsername =  driver.findElement(By.xpath("//input[@id='username']"));
		WebElement ObjPassword =  driver.findElement(By.xpath("//input[@id='password']"));
		WebElement ObjValidation =  driver.findElement(By.xpath("//input[@value='Login']"));
	    
		ObjUsername.clear();
		ObjUsername.sendKeys(Username);
		ObjPassword.clear();
		ObjPassword.sendKeys(Password);

		ObjValidation.click();
		int ObjLogoutSize = driver.findElements(By.xpath("//a[contains(text(),'Logout')]")).size();
		int ObjMsgErrorSize = driver.findElements(By.xpath("//p[contains(text(),'Invalid username or password.')]")).size();

		if(ObjLogoutSize>0)
	{
		String ActualResult=driver.getCurrentUrl();
		WebElement ObjLogout=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		ObjLogout.click();
		assertEquals(ResultatAttendu, ActualResult);
		 Reporter.log("Le resultat attendu est : "+ResultatAttendu+ " et nous avons comme résultat :" + ActualResult);

		
	}

	if(ObjMsgErrorSize>0)
	{
		WebElement ObjMsgError=driver.findElement(By.xpath("//p[@class=\"failure\"]"));
		String ActualResult=ObjMsgError.getText();
		assertEquals(ResultatAttendu, ActualResult);
		 Reporter.log("Le resultat attendu est : "+ResultatAttendu+ " et nous avons comme résultat :" + ActualResult);

		
		
	}
  }

@AfterClass
  public void afterClass() {
//	driver.quit();
  }

}