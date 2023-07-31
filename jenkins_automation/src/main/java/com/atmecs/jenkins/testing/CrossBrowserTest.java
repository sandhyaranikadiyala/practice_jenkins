package com.atmecs.jenkins.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTest {

	private WebDriver driver;
	ChromeOptions chromeOptions = new ChromeOptions();
	EdgeOptions edgeOptions = new EdgeOptions();

	@Parameters("browser")
	@BeforeClass
	public void init(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Launched chrome driver");

		} else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Launched edge driver");

		}

	}

	@Test
	public void googleSearchTest() {

		if (driver != null) {
			driver.get("https://www.google.com/");
			String actualTitle = driver.getTitle();
			String expectedTitle = "Google";
			Assert.assertEquals(actualTitle, expectedTitle, "Title not matched");
		} else {
			System.out.println("WebDriver is not initialized.");
		}

	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

}
