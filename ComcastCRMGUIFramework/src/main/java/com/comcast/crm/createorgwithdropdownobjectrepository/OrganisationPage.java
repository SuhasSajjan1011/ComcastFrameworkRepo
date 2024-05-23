package com.comcast.crm.createorgwithdropdownobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	WebDriver d;

	public OrganisationPage(WebDriver d) {

		this.d = d;
		PageFactory.initElements(d, this);

	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createNewOrgImg;

	public WebElement getCreateNewOrgImg() {
		return createNewOrgImg;
	}
	
	

}
