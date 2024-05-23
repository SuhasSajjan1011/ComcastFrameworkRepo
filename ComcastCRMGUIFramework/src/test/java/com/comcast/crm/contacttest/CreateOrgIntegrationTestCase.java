package com.comcast.crm.contacttest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrgIntegrationTestCase {
	public static void main(String[] args) throws Exception {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromProperties("Browser");
		String URL= fLib.getDataFromProperties("Url");
		String USERNAME = fLib.getDataFromProperties("Username");
		String PASSWORD = fLib.getDataFromProperties("Password");
		
		
		String orgName=eLib.readDataFromExcel("Sheet1",1,2)+jLib.getRandomNumber();
		String lastName=eLib.readDataFromExcel("Sheet1",7,4)+jLib.getRandomNumber();
		
		String brow = BROWSER;
		WebDriver d = null;
		if(brow.equals("Chrome"))
		{
			d =new ChromeDriver();
		}else if(brow.equals("Edge"))
		{
			d= new EdgeDriver();
		}else
		{
			d=new FirefoxDriver();
		}
		d.manage().window().maximize();
	   wLib.waitForPageToLoad(d);
		d.get(URL);
		d.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		d.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		d.findElement(By.xpath("(//input[@value='Login'])[2]")).click();
		
		d.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		d.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		d.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		
		d.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actOrgName=d.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actOrgName.contains(orgName))
		{
			System.out.println("Organisation Name is verified successfully");
		}else
		{
			System.err.println("Organisation Name mismatching");
		}
		
		d.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		d.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		d.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		
		d.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//switching to child window
		wLib.switchToTabOnUrl(d,"module=Accounts");
		d.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgName);
		d.findElement(By.xpath("//input[@name='search']")).click();
		//String back=d.getWindowHandle();
		d.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		//switch to parent window
		wLib.switchToTabOnUrl(d,"Contacts&action");
		
		
		d.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		String headerInfo=d.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		System.out.println(headerInfo);
		
	    if(headerInfo.contains(lastName))
	    {
	    	System.out.println("Last Name is verified successfully");
	    }else
        {
	    	System.err.println("Last Name mismatching");
	    }
         String contactOrg=d.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
         
	    if(contactOrg.trim().equals(orgName))
	    {
	    	System.out.println("Organisation Name in contact module is verified successfully");	
	    }else
	    {
	    	System.err.println("Organisation Name in contact module mismatching");	
	    }
	    Thread.sleep(3000);
		Actions a = new Actions(d);
		a.moveToElement(d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();
		d.quit();
	    
		
		
	}

}
