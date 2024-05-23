package testcase;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CampaignModule {
	public static void main(String[] args) throws Exception {
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromProperties("Browser");
		String URL= fLib.getDataFromProperties("Url");
		String USERNAME= fLib.getDataFromProperties("Username");
		String PASSWORD =fLib.getDataFromProperties("Password");
		
		String productName=eLib.readDataFromExcel("Sheet1",4,5)+jLib.getRandomNumber();
		String campaignName=eLib.readDataFromExcel("Sheet1",7,6)+jLib.getRandomNumber();
		String campaignType=eLib.readDataFromExcel("Sheet1",7,7);
		
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
		d.findElement(By.xpath("//a[text()='Products']")).click();
		d.findElement(By.xpath("//img[@title='Create Product...']")).click();
		d.findElement(By.xpath("//input[@name='productname']")).sendKeys(productName);
		d.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		String actHeaderProductName=d.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(actHeaderProductName.contains(productName))
		{
			System.out.println("Product header is verified successfully");
		}else
		{
			System.err.println("Product header mismatching");
		}
		
		String actProductName=d.findElement(By.xpath("(//td[@class='dvtCellInfo'])[1]")).getText();
		if(actProductName.equals(productName))
		{
			System.out.println("Product name is verified successfully");
		}else
		{
			System.err.println("Product name mismatching");
		}
		WebElement moreButton=d.findElement(By.xpath("//a[text()='More']"));
		wLib.moveMouseOnElement(d, moreButton);
		d.findElement(By.xpath("//a[text()='Campaigns']")).click();
		d.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		d.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaignName);
		WebElement dd1=d.findElement(By.xpath("//select[@name='campaigntype']"));
		wLib.select(dd1,campaignType);
		WebElement closingDateField = d.findElement(By.xpath("//input[@name='closingdate']"));
		closingDateField.clear();
		String date =jLib.getRequiredDate(20);
		closingDateField.sendKeys(date);
		d.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String camHeader=d.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(camHeader.contains(campaignName))
		{
			System.out.println("Campaign header is verified successfully");
		}else
		{
			System.err.println("Campaign header mismatching");
		}
		String actCampaignName=d.findElement(By.xpath("//td[@id='mouseArea_Campaign Name']")).getText();
		if(actCampaignName.trim().equals(campaignName))
		{
			System.out.println("Campaign name is verified successfully");
		}else
		{
			System.err.println("Campaign name mismatching");
		}
		String actualCampaignType=d.findElement(By.xpath("//td[@id='mouseArea_Campaign Type']")).getText();
		if(actualCampaignType.trim().equals(campaignType))
		{
			System.out.println("Campaign type is verified successfully");	
		}else
		{
			System.err.println("Campaign type mismatching");
		}
		WebElement admin=d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.moveMouseOnElement(d,admin);
		

		d.findElement(By.xpath("//a[text()='Sign Out']")).click();
		d.quit();
		
		
		
		
	}
}
