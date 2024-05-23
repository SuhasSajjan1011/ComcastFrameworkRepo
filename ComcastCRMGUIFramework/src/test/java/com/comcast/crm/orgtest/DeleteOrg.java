package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility1.CreateNewOrganisationPage;
import com.comcast.crm.objectrepositoryutility1.HomePage;
import com.comcast.crm.objectrepositoryutility1.LoginPage1;
import com.comcast.crm.objectrepositoryutility1.OrganisationInfoPage;
import com.comcast.crm.objectrepositoryutility1.OrganisationPage;

public class DeleteOrg {
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
	    
	    jLib.getRandomNumber();
	    String orgName=eLib.readDataFromExcel("Sheet1",7,4)+jLib.getRandomNumber();
	    
	    
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
	    d.manage().window().maximize();
	    d.get(URL);
	    LoginPage1 lp1=new LoginPage1(d);
	   
	    lp1.loginToApp(USERNAME, PASSWORD);
	    
	    HomePage hp= new HomePage(d);
	    hp.getOrgLink().click();
	    
	    OrganisationPage op1= new OrganisationPage(d);
	    op1.getCreateOrgButton().click();
	    
	    CreateNewOrganisationPage cnop= new CreateNewOrganisationPage(d);
	    cnop.createOrg(orgName);
	    
	    OrganisationInfoPage oip= new OrganisationInfoPage(d);
	    String actHeaderInfo =oip.getHeaderInfo().getText();
	    System.out.println(actHeaderInfo);
	    
	    if(actHeaderInfo.contains(orgName))
	    {
	    	System.out.println(orgName+" is verified ");
	    }else
	    {
	    	System.out.println(orgName+" is verification failed ");
	    }
	    
	    //go back to organization page
	    hp.getOrgLink().click();
	    
	    //search for organization
	    op1.getSearchEdt().sendKeys(orgName);
	    wLib.select(op1.getSearchDropdown(),"Organization Name");
	    op1.getSearchNowBtn().click();
	    
	    d.findElement(By.xpath("(//a[text()='"+orgName+"']/parent::td//following-sibling::td)[6]/a[text()='del']")).click();
	    //In dynamic webtable select and delete org
	    
	   // hp.signOut();
	   // d.quit();
	    
	    
	}
	    

}
