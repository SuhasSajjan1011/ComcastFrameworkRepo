package com.comcast.crm.contactwithorgobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactChildWindowPage {
	WebDriver d;
	public ContactChildWindowPage(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d,this);
	}
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement orgNameSearch;
	
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement  selectDropdown;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBtn;
	
	
	public WebElement getOrgNameSearch() {
		return orgNameSearch;
	}

	public WebElement getSelectDropdown() {
		return selectDropdown;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	
	
	
	

}
