package com.atmecs.jenkins;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicControls {
	@Test
	public void testButtons() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.manage().window().maximize();

		WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
		removeButton.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

		
		
		
		
		WebElement addButton=driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		
		addButton.click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
		
		boolean isCheckedBoxPresent1 = driver.findElement(By.id("checkbox")).isDisplayed();
		System.out.println("Is checkbox present? " + isCheckedBoxPresent1);
		

		driver.quit();
	}
}