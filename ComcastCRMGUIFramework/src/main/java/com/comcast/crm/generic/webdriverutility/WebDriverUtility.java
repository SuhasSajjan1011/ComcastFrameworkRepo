package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
  
	public void waitForPageToLoad(WebDriver d)
	{
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver d,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(d,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabOnUrl(WebDriver d,String partialUrl)
	{
		Set<String> set=d.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String windowID=it.next();
			d.switchTo().window(windowID);
			
			String actUrl=d.getCurrentUrl();
			if(actUrl.contains(partialUrl)) {
				break;
				
			}
		}
	}
	public void switchToTabOnTitle(WebDriver d,String partialTitle)
	{
		Set<String> set=d.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String windowID=it.next();
			d.switchTo().window(windowID);
			
			String actTitle=d.getTitle();
			if(actTitle.contains(partialTitle)) {
				break;
			}
		}
	}
	public void switchToFrame(WebDriver d ,int index)
	{
		d.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver d ,String nameID)
	{
		d.switchTo().frame(nameID);
	}
	public void switchToFrame(WebDriver d ,WebElement element)
	{
		d.switchTo().frame(element);
	}
	
	public void switchToAlertAndAccept(WebDriver d)
	{
		d.switchTo().alert().accept();
	}
	public void switchToAlertAndCancel(WebDriver d)
	{
		d.switchTo().alert().dismiss();
	}
	
	public void select(WebElement element,String name)
	{
		Select sel= new Select(element);
		sel.selectByVisibleText(name);
	}
	public void select(WebElement element,int index)
	{
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}
	
	 public void moveMouseOnElement(WebDriver d,WebElement element)
		{
			Actions a = new Actions(d);
			a.moveToElement(element).perform();
		}
	 public void doubleClick(WebDriver d,WebElement element)
		{
			Actions a = new Actions(d);
			a.doubleClick().perform();
		}
}
