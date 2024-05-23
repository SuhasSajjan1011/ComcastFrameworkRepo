package com.comcast.crm.createcontactobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	WebDriver d;

	public ContactInfoPage(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}
	
	public WebElement getContactHeaderInfo() {
		return contactHeaderInfo;
	}
	
	

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeaderInfo;
	
	@FindBy(xpath="//span[@id='dtlview_Last Name']")
	public WebElement contactTextChk;

	public WebElement getContactTextChk() {
		return contactTextChk;
	}
	
	
	

}
