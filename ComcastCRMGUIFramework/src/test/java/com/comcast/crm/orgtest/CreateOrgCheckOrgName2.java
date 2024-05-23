package com.comcast.crm.orgtest;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

import com.comcast.crm.objectrepositoryutility1.LoginPage1;


public class CreateOrgCheckOrgName2 {
	public static void main(String[] args) throws Exception {
		FileUtility fLib = new FileUtility();
	    ExcelUtility eLib= new ExcelUtility();
	    JavaUtility jLib = new JavaUtility();
	    WebDriverUtility wLib= new WebDriverUtility();
	    
	    String BROWSER= fLib.getDataFromProperties("Browser");
	    String URL= fLib.getDataFromProperties("Url");
	    String USERNAME= fLib.getDataFromProperties("Username");
	    String PASSWORD= fLib.getDataFromProperties("Password");
	    String brow = BROWSER;
	    
	    WebDriver d = null;
	    if(brow.equals("Chrome"))
	    {
	    	d= new ChromeDriver();
	    }else if(brow.equals("Firefox"))
	    {
	    	d= new FirefoxDriver();
	    }else
	    {
	    	d= new EdgeDriver();
	    }
	    wLib.waitForPageToLoad(d);
	    d.get(URL);
	    d.manage().window().maximize();
	    
	    jLib.getRandomNumber();
	    LoginPage1 lp=new LoginPage1(d); //Rule 3 : Object Initialization
//	    lp.getUsernameEdt().sendKeys(USERNAME);
//	    lp.getPasswordEdt().sendKeys(PASSWORD);
//	    lp.getLoginBtn().click();
	    lp.loginToApp(USERNAME, PASSWORD);
	    
	    
	    
	    
	    
	    
	    
	}

}
