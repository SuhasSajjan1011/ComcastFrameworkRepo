package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateOrgProductModule {
	public static void main(String[] args) throws Exception {
		
	
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	
	
	  String BROWSER = fLib.getDataFromProperties("Browser");
	  String URL= fLib.getDataFromProperties("Url");
	  String USERNAME= fLib.getDataFromProperties("Username");
	  String PASSWORD =fLib.getDataFromProperties("Password");
	
		
		String productName=eLib.readDataFromExcel("Sheet1",4,5)+jLib.getRandomNumber();//45
		String partNo=eLib.readDataFromExcel("Sheet1",7,5)+jLib.getRandomNumber();//75
		String prodCat=eLib.readDataFromExcel("Sheet1",4,6)+jLib.getRandomNumber();//46
		
		
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
		
		d.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
		
		d.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		d.findElement(By.xpath("//input[@name='productname']")).sendKeys(productName);
		
		d.findElement(By.xpath("//input[@name='productcode']")).sendKeys(partNo);
		
		WebElement proCat=d.findElement(By.xpath("//select[@name='productcategory']"));
		Select sel1=new Select(proCat);
		sel1.selectByValue(prodCat);
		
		
		
		d.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		String headerInfo=d.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(headerInfo.contains(productName))
		{
			System.out.println(productName+ "verification successfull");
		}else
		{
			System.out.println(productName+ "verification unsuccessfull");
		}
		
		String actPartNum=d.findElement(By.xpath("//span[@id='dtlview_Part Number']")).getText();
		
		if(actPartNum.equals(partNo))
		{
			System.out.println(partNo + " Verification successful");
		}else
		{
			System.out.println(partNo + " Verification unsuccessful");
		}
		
		String actProdCat=d.findElement(By.xpath("//span[@id='dtlview_Product Category']")).getText();
		
		if(actProdCat.equals(prodCat))
			
			{
				System.out.println(prodCat + " Verification successful");	
			}else
			{
				System.out.println(prodCat + " Verification unsuccessful");
			}
		Thread.sleep(3000);

		Actions a = new Actions(d);
		a.moveToElement(d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		Thread.sleep(3000);
		d.quit();
		}
	}
	


