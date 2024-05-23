package com.comcast.crm.objectrepositoryutility1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage { 
	WebDriver d  ;
	public OrganisationInfoPage(WebDriver d)
	{
		this.d= d;
		PageFactory.initElements(d,this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerInfo;
	
	
	public WebElement getHeaderInfo() {
		return headerInfo;
	}
	
	
	

}
