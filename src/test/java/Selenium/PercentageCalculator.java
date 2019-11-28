package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PercentageCalculator extends Base {
	
	@Test
	public void letsCalculate()
	{
		initialize("https://www.jbhifi.com.au");
		driver.findElement(By.xpath("//input[@class='ais-search-box--input']")).sendKeys("camera",Keys.ENTER);
		List<WebElement> wbs = driver.findElements(By.xpath("//h4[@class='ais-hit--title product-tile__title']"));
	    
		int count=1;
		for(WebElement wb:wbs)
	    {
	    	String productTitle = wb.getText();
	    	System.out.println("product Title is "+ count+ "." +productTitle);
	    	count++;
	    	if(productTitle.contains("DJI Osmo Pocket 4K 3 Axis Gimbal Camera"))
	    	{
	    		wb.click();
	    		break;
	    	}
	    	
	    }
		String priceInDollar = driver.findElement(By.xpath("//span[@class='price']")).getText();
    	System.out.println("Price in dollars is = "+ priceInDollar);
    	
    	String priceWithoutDollar  = priceInDollar.replace("$","");
    	int price= Integer.parseInt(priceWithoutDollar);
    	int percentAmount = (int)(price*0.05);
    	System.out.println("5% of item price is "+ percentAmount);
		
		
	}
	

}
