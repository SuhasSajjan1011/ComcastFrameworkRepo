  package com.comcast.crm.baseutility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.createcontactobjectrepository.HomePage;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility1.LoginPage1;

public class Base {
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public DatabaseUtility dLib = new DatabaseUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriver d;

	@BeforeSuite
	public void configBS() throws Exception {
		System.out.println("Connect to db");
		dLib.getDBConnection();

	}

	@BeforeClass
	public void configBC() throws Exception {
		System.out.println("Connect to browser");
		String BROWSER = fLib.getDataFromProperties("Browser");
		String brow = BROWSER;
		if (brow.equals("Chrome")) {
			d = new ChromeDriver();
		} else if (brow.equals("Edge")) {
			d = new EdgeDriver();
		} else {
			d = new FirefoxDriver();
		}

	}

	@BeforeMethod
	public void configBM() throws Exception {
		d.manage().window().maximize();
		wLib.waitForPageToLoad(d);
		String URL = fLib.getDataFromProperties("Url");
		d.get(URL);
		LoginPage1 lp = new LoginPage1(d);
		String USERNAME = fLib.getDataFromProperties("Username");
		String PASSWORD = fLib.getDataFromProperties("Password");
		lp.loginToApp(USERNAME, PASSWORD);

	}
	
	@AfterMethod
	public void configAM()
	{
	 HomePage hp = new HomePage(d);
	 hp.getSignOutLnk();
	}
	
	@AfterClass
	public void configAC()
	{
	System.out.println("Close the browser");
	d.quit();
	}
	
	@AfterSuite
	public void configAS() throws Exception {
		System.out.println("close db connection");
		dLib.closeDbConnection();
	}
	
	
}
