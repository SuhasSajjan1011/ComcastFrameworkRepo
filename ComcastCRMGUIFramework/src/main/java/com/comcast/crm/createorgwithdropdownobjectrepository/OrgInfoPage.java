package com.comcast.crm.createorgwithdropdownobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {
	
	WebDriver d;

	public OrgInfoPage(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderInfo;

	public WebElement getOrgHeaderInfo() {
		return orgHeaderInfo;
	}
	
	public WebElement getIndustryHeaderInfo() {
		return industryHeaderInfo;
	}

	public WebElement getTypeHeaderInfo() {
		return typeHeaderInfo;
	}

	@FindBy(xpath="//td[@id='mouseArea_Industry']")
	private WebElement industryHeaderInfo;
	
	@FindBy(xpath="//td[@id='mouseArea_Type']")
	private WebElement typeHeaderInfo;
	
	


}
