package com.side.project;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class dryrunTest {
	
	@Test
	public void OpenSite() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement flashMessage = wait.until(ExpectedConditions.elementToBeClickable(By.id("flash-messages")));
		flashMessage.isDisplayed();
		WebElement contentText = driver.findElement(By.id("content"));
		assertEquals(contentText.isDisplayed(), true);
		WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
		for (int i = 0; i < 4; i++) {
			addElementButton.click();
			}
		List<WebElement> deleteButtons = wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//button[@class='added-manually']"), 4));
        assertEquals(deleteButtons.size(), 4);
        Thread.sleep(5000);
		
        driver.quit();
		
	}
	
	

}
