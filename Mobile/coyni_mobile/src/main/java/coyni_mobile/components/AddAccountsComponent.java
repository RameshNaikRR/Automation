package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AddAccountsComponent extends MobileFunctions {
	
	private By headingAddAccount = MobileBy.xpath("//*[contains(@text,'Add Accounts')]");
	private By txtBankName = MobileBy.xpath("//*[contains(@resource-id,'searchbar')]");
	private By unSelectBank1ChckBox = MobileBy.xpath("//*[contains(@resource-id,'acctForm:classifiList:0:accountCheckbox')]");
	private By unSelectBank2ChckBox = MobileBy.xpath("//*[contains(@resource-id,'acctForm:classifiList:1:accountCheckbox')]')]");
	private By txtUserName = MobileBy.xpath("//*[contains(@resource-id,'acctForm:j_idt143:0:login_')]");
	private By txtPassword = MobileBy.xpath("//*[contains(@resource-id,'acctForm:j_idt147:0:password_')]");
    private By btnNext = MobileBy.xpath("//*[contains(@text,'Next')]");
    private By btnDone = MobileBy.xpath("//*[contains(@text,'Done')]");
    private By doneHeading = MobileBy.xpath("//*[contains(@text,'All Done')]");
	
	public void verifyHeadingAddAccount() {
		new CommonFunctions().elementView(headingAddAccount, "Add Account");
	}
	
	public void enterBankName(String expBankName) {
		enterText(txtBankName,expBankName,"Enter Bank Name");
	}
	
	public void unSelectBank1() {
		click(unSelectBank1ChckBox,"click Unselect Bank");
	}
	
	public void unSelectBank2() {
		click(unSelectBank2ChckBox,"click Unselect Bannk");
	}
	
	public void fillUserName(String expUserName) {
		enterText(txtUserName, expUserName, "User Name");
	}
	
	public void fillPassword(String expPassword) {
		enterText(txtPassword, expPassword, "Password");
	}
	
	public void clickNext() {
		click(btnNext, "Click Next");
	}
	
	public void clickDone() {
		click(btnDone,"Done");
	}
	
	public void verifyDoneHeading(String expDoneHeading) {
		new CommonFunctions().verifyLabelText(doneHeading, "Done Heading", expDoneHeading);
	}
	

}
