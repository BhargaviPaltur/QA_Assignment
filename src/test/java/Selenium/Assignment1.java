package Selenium;

import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Assignment1 extends Base{

	String incidentNum;
	@Test
	public void createIncident() throws InterruptedException
	{
		
		initialize("https://dev93872.service-now.com/navpage.do");
		
		WebElement f = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(f);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("piCIn2iLD3Kx");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
		driver.findElement(By.xpath("//a[@id='14641d70c611228501114133b3cc88a1']")).click();
				
		WebElement cframe= driver.findElement(By.xpath("//iframe[@data-original-title='Main Content']"));
		String parent=driver.getWindowHandle();
		driver.switchTo().frame(cframe);
		 incidentNum = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Incident num is = "+incidentNum);
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		Set<String>whs = driver.getWindowHandles();
		for(String w:whs)
		{
			if(!parent.equals(w))
			{
				driver.switchTo().window(w);
				driver.findElement(By.xpath("//a[@sys_id='62826bf03710200044e0bfc8bcbe5df1']")).click();
				driver.switchTo().window(parent);
				driver.switchTo().frame(cframe);
			}
		}
				
		WebElement categorySelect = driver.findElement(By.xpath("//select[@id='incident.category']"));
		Select sel=new Select(categorySelect);
		sel.selectByValue("software");
		WebElement subCategorySelect = driver.findElement(By.xpath("//select[@id='incident.subcategory']"));		
		Select sel2=new Select(subCategorySelect);
		sel2.selectByValue("email");
		driver.findElement(By.xpath("//button[@id='lookup.incident.business_service']")).click();
		Set<String> whs2= driver.getWindowHandles();
		for(String w2:whs2)
		{
			if(!parent.equals(w2))
			{
				driver.switchTo().window(w2);
				driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys("outlook",Keys.ENTER);
				driver.findElement(By.xpath("(//a[@sys_id='27d35b6fc0a8000b0027ee9ce7c4cc1b'])[1]")).click();
				driver.switchTo().window(parent);
				driver.switchTo().frame(cframe);
			}
		}
	WebElement contact= driver.findElement(By.xpath("//select[@id='incident.contact_type']"));
		Select sel3= new Select(contact);
		sel3.selectByValue("email");
	WebElement impact= driver.findElement(By.xpath("//select[@id='incident.impact']"));	
	   Select sel4= new Select(impact);
	   sel4.selectByValue("1");
	   WebElement urgency= driver.findElement(By.xpath("//select[@id='incident.urgency']"));	
	   Select sel5= new Select(urgency);
	   sel5.selectByValue("1");	
	Boolean b = driver.findElement(By.xpath("//select[@id='incident.priority']")).isEnabled();	
		Assert.assertTrue(b);
		driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']")).click();
	Set<String> whs3= driver.getWindowHandles();	
		for(String w3:whs3)
		{
			if(!parent.equals(w3))
			{
				driver.switchTo().window(w3);
				driver.findElement(By.xpath("//a[@sys_id='0a52d3dcd7011200f2d224837e6103f2']")).click();
				driver.switchTo().window(parent);
				driver.switchTo().frame(cframe);		
			}
		}
		
		driver.findElement(By.xpath("//textarea[@id='incident.description']")).sendKeys("Email could not be configured for my machine");
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
		String actualError = driver.findElement(By.xpath("//span[@class='outputmsg_text']")).getText();
		String expectedError = "The following mandatory fields are not filled in: Short description";
		Assert.assertEquals(expectedError,actualError);
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Email Issue");
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
		
		WebElement searchbox = driver.findElement(By.xpath("//span[@id='incident_hide_search']/div/div/input"));
		searchbox.sendKeys(incidentNum,Keys.ENTER);
		
		String verifyIncidentNum = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		Assert.assertEquals(incidentNum,verifyIncidentNum);
		
		
		


	
	}

}
