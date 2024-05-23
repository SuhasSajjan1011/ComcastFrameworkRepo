package com.comcast.crm.objectrepositoryutility1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver d  ;
	public HomePage(WebDriver d)
	{
		this.d= d;
		PageFactory.initElements(d,this);
	}
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orgLink;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactLink;
	
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement campaignsLink;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLnk;
	
	public WebElement getAdminImg() {
		return adminImg;
	}
	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	public WebElement getCampaignsLink() {
		return campaignsLink;
	}
	public WebElement getMoreLink() {
		return moreLink;
	}
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		
		return contactLink;
	}
			
	public void navigateToCampaignsPage()
	{
		Actions act = new Actions(d);
		act.moveToElement(moreLink).perform();
		campaignsLink.click();
	}
	
	public void signOut()
	{
		Actions act = new Actions(d);
		act.moveToElement(adminImg).perform();
		signOutLnk.click();
	}

}
