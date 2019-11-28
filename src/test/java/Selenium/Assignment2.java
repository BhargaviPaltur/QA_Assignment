package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Assignment2 extends Assignment1 {
	
	@Test
	public void resolveIncident() throws InterruptedException
	{
		initialize("https://dev93872.service-now.com/navpage.do");
		
		WebElement f = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(f);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("piCIn2iLD3Kx");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incidents");
		driver.findElement(By.xpath("(//div[text()='Incidents'])[1]")).click();
		
		WebElement cframe= driver.findElement(By.xpath("//iframe[@data-original-title='Main Content']"));
		driver.switchTo().frame(cframe);
		WebElement searchbox = driver.findElement(By.xpath("//span[@id='incident_hide_search']/div/div/input"));
		searchbox.sendKeys(incidentNum,Keys.ENTER);
	}
}
