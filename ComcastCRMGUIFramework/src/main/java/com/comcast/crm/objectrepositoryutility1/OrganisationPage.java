package com.comcast.crm.objectrepositoryutility1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
	WebDriver d  ;
	public OrganisationPage(WebDriver d)
	{
		this.d= d;
		PageFactory.initElements(d,this);
	}
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgButton;
	
	//to delete dynamic elements using POM
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchEdt;
	
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement searchDropdown;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchNowBtn;
	
	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getCreateOrgButton() {
		return createOrgButton;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDropdown() {
		return searchDropdown;
	}
	

	
}
