package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Assignment2_2 extends Base{
	
	@Test
	public void resolveIncident() throws InterruptedException
	{
		initialize("https://dev93872.service-now.com/navpage.do");
		
		WebElement f = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(f);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("piCIn2iLD3Kx");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		
		WebElement serviceDesk = driver.findElement(By.xpath("//span[text()='Service Desk']"));
		WebElement incidents = driver.findElement(By.xpath("//div[@data-id='4fed4395c0a8016400fcf06c27b1e6c6']/div[text()='Incidents']"));
		List<WebElement>wbs = driver.findElements(By.xpath("//ul[@id='concourse_application_tree']"));
		for(WebElement wb:wbs)
		{
			if(wb.equals(serviceDesk))
			{
				wb.click();
			}
		}
		incidents.click();
	
	

		

		WebElement cframe= driver.findElement(By.xpath("//iframe[@data-original-title='Main Content']"));
	String inci = readPropertiesFile("InciNum");
		driver.switchTo().frame(cframe);
		WebElement searchbox = driver.findElement(By.xpath("//span[@id='incident_hide_search']/div/div/input"));
		searchbox.sendKeys(inci,Keys.ENTER);
		
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Email issue is resolved");
		driver.findElement(By.xpath("//button[@id='resolve_incident_bottom']")).click();
		String actualError = driver.findElement(By.xpath("//span[@class='outputmsg_text']")).getText();
		String expectedError= "The following mandatory fields are not filled in: Resolution code, Resolution notes";
		Assert.assertEquals(expectedError, actualError);
		driver.findElement(By.xpath("//span[text()='Resolution Information']")).click();
		WebElement resCode = driver.findElement(By.xpath("//select[@id='incident.close_code']"));
		Select sel5=new Select(resCode);
	    sel5.selectByValue("Solved (Permanently)");
	    driver.findElement(By.xpath("//textarea[@id='incident.close_notes']")).sendKeys("Resolved");
	    driver.findElement(By.xpath("//button[@id='resolve_incident_bottom']")).click();
	    
	   String actual_status =  driver.findElement(By.xpath("(//tr[@class='list_row list_odd'])/td[8]")).getText();
	   String expected_status= "Resolved";
	   //Assert.assertEquals(expected_status,actual_status);
	}

}
