package Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
	/*
     * Reusable function for Select class
     */
    
    public void resueableSelect(WebElement str,String abc)
    {
    	Select sel=new Select(str);
    	sel.selectByValue(abc);
    }
	
    
    /*
     * Reuseable function for Window handle
     */
     
    public void reuseableWindowHandle(String parent)
    {
    	Set<String> winHandles = driver.getWindowHandles();
		System.out.println("Total window opened "+winHandles.size());

		for (String string : winHandles) {
			System.out.println(string);

		}
		//Switch to Child window

		for (String winHandle : winHandles) {
			if(!winHandle.equals(parent)) {
				driver.switchTo().window(winHandle);
				System.out.println("Window switched");
			}

		}
    }	
    
    /*
     * Reuseable function to store Incident number
     */
    public void storeIncidentNum(String valueToStore)
    {
    	Properties prop=new Properties();
    	prop.setProperty("InciNum", valueToStore);
    	try {
			prop.store(new FileOutputStream("./ouput/IncidentNum.properties"), "The Incident value is stored");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /*
     * Reuseable function to read Incident number
     */ 
    
    public String readPropertiesFile(String key )
    {
    	String inciNum=null;
    	Properties prop=new Properties();
    	try {
			prop.load(new FileInputStream("./ouput/IncidentNum.properties"));
			 inciNum=prop.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    return inciNum;	
    }
}
