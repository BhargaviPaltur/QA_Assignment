package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	WebDriver driver;
	public void initialize(String url)
	{
		//System.setProperty("webDriver.chrome.driver","./driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.get(url);	
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    
	    /*
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("camera");
	    driver.findElement(By.xpath("//input[@class='nav-input' and @type='submit']")).click();
	    */
	    
	}
}
