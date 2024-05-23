package com.comcast.crm.contactwithorgobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver d;
	public ContactPage(WebDriver d)
	{
		this.d= d;
	    PageFactory.initElements(d,this);
		
	}
	
	public WebElement getCreateContactImg() {
		return createContactImg;
	}

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactImg;
	

}
