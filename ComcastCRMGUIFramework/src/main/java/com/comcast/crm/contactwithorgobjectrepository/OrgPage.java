package com.comcast.crm.contactwithorgobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {
	WebDriver d;
	public OrgPage(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d,this);
	}
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactLink;
	
	public WebElement getContactLink() {
		return contactLink;
	}

}
