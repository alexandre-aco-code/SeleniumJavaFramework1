package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class appium {
	

	String URLExcelFile = "D:/Documents/AJC Formation/Cours AJC/10. selenium/CreateJobOrder.xlsx";

	public static void main(String[] args) throws Exception {
		// affectation du chemin de l'application
		File app = new File("E:/Code/AJC Formation/appium/Zoho-Recruit__81__0__85__0.apk");
		// mise en place des desiredcapabilities pour les propriétés qui seront
		// utilisées par le driver
		DesiredCapabilities cap = new DesiredCapabilities();
		// affectation de mon émulateur, lui donner le même nom que dans android
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL API 30");
		// instanciation de mon application
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		// utilisation de uiautomator2 pour automatiser les application natives mobiles
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		// instanciation de mon driver de type android driver en passant deux
		// paramètres: l'adresse url du
		// serveur appium AndroidElementities définies en haut.
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub/"), cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		AndroidElement SignupButtonElement = driver.findElement(By.xpath("//android.widget.TextView[@text='Sign In']"));
		SignupButtonElement.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		AndroidElement LoginElement = driver
				.findElement(By.xpath("//android.widget.EditText[@resource-id='login_id']"));
		LoginElement.sendKeys("alexandre.connanglecode@gmail.com");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		AndroidElement NextButtonElement = driver
				.findElement(By.xpath("//android.widget.Button[@resource-id='nextbtn']"));
		NextButtonElement.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		AndroidElement PasswordElement = driver
				.findElement(By.xpath("//android.widget.EditText[@resource-id='password']"));
		PasswordElement.sendKeys("Bisounours1!");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		AndroidElement NextButtonElement2 = driver
				.findElement(By.xpath("//android.widget.Button[@resource-id='nextbtn']"));
		NextButtonElement2.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		AndroidElement ImNotInterestedButton = driver
				.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button3']"));
		ImNotInterestedButton.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		AndroidElement TopLeftButton = driver.findElement(By.xpath("//android.widget.ImageButton"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TopLeftButton.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		AndroidElement SettingsButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']"));
//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
		SettingsButton.click();
//		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
		AndroidElement SignOutButton = driver
				.findElement(By.xpath("//android.widget.TextView[@resource-id='com.zoho.recurit:id/signout']"));
		SignOutButton.click();
//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		AndroidElement SignOutConfirmButton = driver
				.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
		SignOutConfirmButton.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}
