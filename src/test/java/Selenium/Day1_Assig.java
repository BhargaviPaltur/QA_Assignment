package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Day1_Assig extends Base{
	@Test
	public void sauce()
	{
		initialize("https://www.saucedemo.com/");
		driver. findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@class='btn_action']")).click();
		List<WebElement> wbs= driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for(WebElement wb: wbs)
		{
			String productName= wb.getText();
			System.out.println("The product name is  =" +productName);
			if(productName.contains("Sauce Labs Bolt T-Shirt"))
			{
				wb.click();
				break;
			}
		}
		
		 String price = driver.findElement(By.xpath("//div[@class='inventory_details_price']")).getText();
		 System.out.println("product Price is = "+ price);
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		driver.navigate().back();
		
		if(driver.findElement(By.xpath("//button[text()='REMOVE']")).isDisplayed())
		{
			System.out.println("Remove button is displayed");
		}
		else
			System.out.println("Remove button missing");

}
}
