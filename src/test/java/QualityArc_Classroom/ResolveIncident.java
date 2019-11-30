package QualityArc_Classroom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import QualityArc_Classroom.Base;

public class ResolveIncident extends Base {
	@Test
	public void resolveIncident() {
		/*
		 * This test case resolves an incident
		 * 
		 * @pre-condition = Incident number  
		 * 
		 */	

		//Get the incident number
		//String retrievedIncidentNum = readPropertyFile("Incident");

		//Launch the application
		initialize("https://dev92430.service-now.com/");

		//Switch to frame
		driver.switchTo().frame("gsft_main");

		//Login to application
		driver.findElement(By.id("user_name")).clear();
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys("Qarc@440");
		driver.findElement(By.id("sysverb_login")).click();

		//Verify login is successful
		boolean isLoginSucceeded = driver.findElement(By.xpath("//span[text()='System Administrator']")).isDisplayed();
		if(isLoginSucceeded) {
			System.out.println("Login Sucessful");
		}else {
			System.out.println("Login failed");
		}

		//Search the keyword 'incident'
		String inci = readPropertiesFile("InciNum");
		System.out.println("The incident number is = "+ inci);
		driver.findElement(By.id("filter")).click();
		driver.findElement(By.id("filter")).sendKeys("Incident");

		//Click on incident
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("ServiceDesk")));

		//Click on incident
		driver.findElement(By.xpath("(//*[text()='Incidents'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//span[@id='incident_hide_search']//input[@placeholder='Search']"))
		.sendKeys(inci, Keys.ENTER);

		driver.close();

	}

}
