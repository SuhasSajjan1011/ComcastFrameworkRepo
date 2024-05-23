package com.comcast.crm.contactwithorgobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	WebDriver d;
	public CreateNewContactPage(WebDriver d)
	{
		this.d= d;
	    PageFactory.initElements(d,this);
		
	}
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement createOrgImg;
	
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
	
	
	

}
