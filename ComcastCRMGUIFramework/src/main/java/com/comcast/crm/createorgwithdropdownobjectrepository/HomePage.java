package com.comcast.crm.createorgwithdropdownobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver d;

	public HomePage(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement orgLnk;

	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactLnk;
	
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement campaignsLnk;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement productLnk;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLnk;
	
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

	public WebElement getOrgLnk() {
		return orgLnk;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getCampaignsLnk() {
		return campaignsLnk;
	}

	public WebElement getProductLnk() {
		return productLnk;
	}

	public WebElement getMoreLnk() {
		return moreLnk;
	}
	
	public void navigateToCampaignsLnk()

	{
		Actions act = new Actions(d);
		act.moveToElement(moreLnk).perform();
		campaignsLnk.click();
	}
	public void navigateToSignOut()
	{
		Actions act = new Actions(d);
		act.moveToElement(adminImg).perform();
		signOutLnk.click();
	}
}
