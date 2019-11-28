package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UIPath extends Base{
	
	@Test
	public void UIpath()
	{
		initialize("https://www.uipath.com/developers/community-edition");
		driver.findElement(By.xpath("//a[@id='hs-eu-confirmation-button']")).click();
		driver.findElement(By.xpath("(//a[@title='Get Community Edition'])[1]")).click();
		driver.findElement(By.xpath("(//a[@class='Button Button--primary  Button--big'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='signUpThroughEmail'])")).click();
		driver.findElement(By.xpath("//div[starts-with(@class,'signupOrganizationNameField')]/input[@oninput='toggleSignUpButton()']")).sendKeys("NewOrg");
		
		
		driver.findElement(By.xpath("//div[contains(@class,'signupFirstNameField ')]/input[@oninput='toggleSignUpButton()']")).sendKeys("Bhargavi");
		driver.findElement(By.xpath("//div[contains(@class,'signupLastNameField ')]/input[@oninput='toggleSignUpButton()']")).sendKeys("Paltur");
		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		Select sel= new Select(country);
		sel.selectByValue("Australia");
		
		driver.findElement(By.xpath("//div[contains(@class,'emailSignUpField ')]/input[@oninput='toggleSignUpButton()']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//div[contains(@class,'textFieldForPassword')]/input[@oninput='toggleSignUpButton()']")).sendKeys("Test123");
		//driver.findElement(By.xpath("//button[@id='signUpButton']/div")).click();
		
		WebElement weakPassword = driver.findElement(By.xpath("//div[@class='weakPassword']"));
		
		
		
	}

}
