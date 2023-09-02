package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		// Set up WebDriver and navigate to the registration page
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sathw\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
	}

	@Test
	public void testRegistration() throws InterruptedException {
		// Find registration form elements and perform registration
		wait = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();

		driver.findElement(By.name("firstname")).sendKeys("Abhi");
		driver.findElement(By.name("lastname")).sendKeys("Billa");
		driver.findElement(By.name("email")).sendKeys("AbhiBilla123@example.com");
		driver.findElement(By.name("telephone")).sendKeys("1234567890");
		driver.findElement(By.name("password")).sendKeys("password123");
		driver.findElement(By.name("confirm")).sendKeys("password123");
		driver.findElement(By.name("agree")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		if (isElementPresent(driver, By.cssSelector(".alert.alert-danger"))) {
			// Locate the element for the error message
			WebElement errorMessageElement = driver.findElement(By.cssSelector(".alert.alert-danger"));

			// Get the text of the error message
			String errorMessage = errorMessageElement.getText();

			// Print the error message to the console
			System.out.println("Registration Error Message: " + errorMessage);

			driver.quit();
		} else {
			// If no error message is found, continue with other actions
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
			driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[13]")).click();
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		}
	}

	// Helper method to check if an element is present
	public static boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
