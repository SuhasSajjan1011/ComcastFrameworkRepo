package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

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

public class CreateOrgCheckDate {
	public static void main(String[] args) throws Exception {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		
		
		String BROWSER = fLib.getDataFromProperties("Browser");
		String URL= fLib.getDataFromProperties("Url");
		String USERNAME= fLib.getDataFromProperties("Username");
		String PASSWORD =fLib.getDataFromProperties("Password");
		
		String lastName=eLib.readDataFromExcel("Sheet1",7,4)+jLib.getRandomNumber();
		String startDate=jLib.getSystemDate();
		String endDate=jLib.getRequiredDate(30);
	
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
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		d.get(URL);
		d.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		d.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		d.findElement(By.xpath("(//input[@value='Login'])[2]")).click();
		d.findElement(By.xpath("//a[text()='Contacts']")).click();
		d.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		
		
		d.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		d.findElement(By.xpath("//input[@name='support_start_date']")).clear();
		d.findElement(By.xpath("//input[@name='support_end_date']")).clear();
		
		d.findElement(By.xpath("//input[@name='support_start_date']")).sendKeys(startDate);
		d.findElement(By.xpath("//input[@name='support_end_date']")).sendKeys(endDate);
		
		
		
		d.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		
		
		
		String actLastName=d.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		if(actLastName.equals(lastName))
		{
			System.out.println("LastName  is verified");
		}else
		{
			System.out.println("LastName is not verified");
		}
		
		String actStartDate=d.findElement(By.xpath("//span[@id='dtlview_Support Start Date']")).getText();
		if(actStartDate.equals(startDate))
		{
			System.out.println("Start Date verified successfully");
		}else
		{
			System.out.println("Start Date verification failed ");
		}
		String actEndDate=d.findElement(By.xpath("//span[@id='dtlview_Support End Date']")).getText();
		if(actEndDate.equals(endDate))
		{
			System.out.println("End Date verified successfully");
		}
		else
		{
			System.out.println("End Date verification failed ");	
		}

		Actions a = new Actions(d);
		a.moveToElement(d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();
		d.quit();
		
	}

}
