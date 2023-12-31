package mobileApplicationAppium;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class testCases {
	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;

	@BeforeTest
	public void setup() {
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "auto");
//		caps.setCapability("chromedriverExecutable", "D:\\chrome\\chromedriver.exe");
//		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		File calculatorApp= new File("src/calculatorApplication/calculator.apk");
		caps.setCapability(MobileCapabilityType.APP,calculatorApp.getAbsolutePath());

	}

	@Test(enabled = false)
	public void swagLabOnMobileBrowser() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.get("https://www.saucedemo.com/");
		WebElement userNameElement = driver.findElement(By.id("user-name"));
		WebElement userPassword = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));
		userNameElement.sendKeys("standard_user");
		userPassword.sendKeys("secret_sauce");
		loginButton.click();
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToCartButtons.size(); i++) {
			AddToCartButtons.get(i).click();
		}

	}

	@Test(enabled = false)
	public void calculatorApplication() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
//	    driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
//	    driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
//	    driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
//	    String result=driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
//	    Assert.assertEquals(result,"20");
		List<WebElement> allNumbers = driver.findElements(By.className("android.widget.ImageButton"));

		for (int i = 0; i < allNumbers.size(); i++) {
			if (allNumbers.get(i).getAttribute("resource-id").contains("digit"))

				allNumbers.get(i).click();

		}

	}

	@Test()
	public void clickOnEvenNumbers() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		List<WebElement> allNumbers = driver.findElements(By.className("android.widget.ImageButton"));
		for (int i = 0; i < allNumbers.size(); i++) {

			if (allNumbers.get(i).getAttribute("resource-id").contains("digit")) {
				int number = Integer.parseInt(allNumbers.get(i).getAttribute("content-desc"));
				if (number % 2 == 0) {
					allNumbers.get(i).click();
				}

			}
		}

	}

	@AfterTest
	public void postTest() {

	}

}
