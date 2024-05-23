package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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

public class CreateOrgCheckOrgName {
	public static void main(String[] args) throws Exception {
		
		
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		
		String BROWSER = fLib.getDataFromProperties("Browser");
		String URL= fLib.getDataFromProperties("Url");
		String USERNAME = fLib.getDataFromProperties("Username");
		String PASSWORD = fLib.getDataFromProperties("Password");
				
		String orgName=eLib.readDataFromExcel("Sheet1",1,2)+jLib.getRandomNumber();
		
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
		
	
		d.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();

		
		d.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		
		d.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		d.findElement(By.xpath("(//input[@class='crmbutton small save'])[2]")).click();
		
	    //verify header msg Expected result
		String headerInfo=d.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgName))
		{
			System.out.println(orgName + " is created==PASS");
		}else
		{
			System.out.println(orgName + " is not created==FAIL");
		}
		String actOrgInfo=d.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(actOrgInfo.equals(orgName))
		{
			System.out.println(orgName + " information created==PASS");
		}else
		{
			System.out.println(orgName + " information not created==FAIL");
		}
		Actions a = new Actions(d);
		a.moveToElement(d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();
		d.quit();
		
		
	}

}
