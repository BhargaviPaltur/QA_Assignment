package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AA extends Base {
	
	@Test
	public void automationAnywhere()
	{
		initialize("https://www.automationanywhere.com/au/products/community-edition");
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Bhargavi");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Paltur");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("abc@gmail.com");
		WebElement country = driver.findElement(By.xpath("//select[@id='Country']"));
		Select sel=new Select(country);
		sel.selectByValue("Australia");
		driver.findElement(By.xpath("//input[@id='Phone']")).sendKeys("4909319495");
		driver.findElement(By.xpath("//input[@id='RF_CE_company']")).sendKeys("ABCcompany");
		driver.findElement(By.xpath("//span[contains(text(),'I have read and accept the ')]")).click();
			
		
	}

}
