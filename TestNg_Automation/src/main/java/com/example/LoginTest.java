package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;

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
	public void testLogin() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		// Find login form elements and perform login
		driver.findElement(By.name("email")).sendKeys("AbhiBilla123@example.com");
		driver.findElement(By.name("password")).sendKeys("password123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

		if (isElementPresent(driver, By.cssSelector(".alert.alert-danger.alert-dismissible"))) {
			WebElement errorMessageElement = driver
					.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible"));
			String errorMessage = errorMessageElement.getText();
			System.out.println("Login Error Message: " + errorMessage);

			// Perform other actions if needed

			// Close the browser
			driver.quit();
		} else {
			driver.findElement(By.xpath("//*[@id=\"logo\"]/h1/a")).click();
			driver.findElement(By.name("search")).sendKeys("samsung");
			driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
			driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a")).click();
			driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();
			
			driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]")).click();
			Thread.sleep(2000);
			
		}

	}

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
		// Clean up resources
		driver.quit();
	}
}
