package com.comcast.crm.createcontactobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver d;

	public ContactPage(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactImg;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement contactSaveBtn;

	public WebElement getCreateContactImg() {
		return createContactImg;
	}

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement contactLastNameEdt;

	public WebElement getContactLastNameEdt() {
		return contactLastNameEdt;
	}

	public WebElement getContactSaveBtn() {
		return contactSaveBtn;
	}

}
