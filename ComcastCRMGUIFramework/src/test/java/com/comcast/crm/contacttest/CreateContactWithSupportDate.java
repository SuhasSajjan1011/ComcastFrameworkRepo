package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateContactWithSupportDate {
	public static void main(String[] args) throws Exception {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		
		
		String BROWSER = fLib.getDataFromProperties("Browser");
		String URL= fLib.getDataFromProperties("Url");
		String USERNAME= fLib.getDataFromProperties("Username");
		String PASSWORD =fLib.getDataFromProperties("Password");
		
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
		
		WebElement startDate=d.findElement(By.xpath("//input[@name='support_start_date']"));
		String systemDate=jLib.getSystemDate();
		startDate.sendKeys(systemDate);
		

		WebElement endDate=d.findElement(By.xpath("//input[@name='support_end_date']"));
		String reqDate=jLib.getRequiredDate(40);
		endDate.sendKeys(reqDate);
		
		
		
		
		d.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		String actLastName=d.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		if(actLastName.equals(lastName))
		{
			System.out.println(lastName+ " is verified");
		}else
		{
			System.out.println(lastName +" is not verified");
		}
		Actions a = new Actions(d);
		a.moveToElement(d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();
		d.quit();
		
	}

}
