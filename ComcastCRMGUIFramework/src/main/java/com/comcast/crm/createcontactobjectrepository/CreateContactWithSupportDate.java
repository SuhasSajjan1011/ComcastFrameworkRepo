package com.comcast.crm.createcontactobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateContactWithSupportDate {
	WebDriver d;

	public CreateContactWithSupportDate(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement contactLastNameEdt;

	public WebElement getContactLastNameEdt() {
		return contactLastNameEdt;
	}

	@FindBy(xpath = "//input[@name='support_start_date']")
	private WebElement supportStartDateEdt;

	@FindBy(xpath = "//input[@name='support_end_date']")
	private WebElement supportEndDateEdt;

	public WebElement getSupportStartDateEdt() {
		return supportStartDateEdt;
	}

	public WebElement getSupportEndDateEdt() {
		return supportEndDateEdt;
	}

	public void contactWithDate() throws InterruptedException {
		JavaUtility jLib = new JavaUtility();
	
		supportStartDateEdt.clear();
		String startDate = jLib.getSystemDate();
		supportStartDateEdt.sendKeys(startDate);
		supportEndDateEdt.clear();
		String reqDate = jLib.getRequiredDate(30);
		supportEndDateEdt.sendKeys(reqDate);
	}

}
