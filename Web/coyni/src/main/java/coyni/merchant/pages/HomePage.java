package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class HomePage extends BrowserFunctions {

	private By lblHeading = By.cssSelector(".title");
	private By lblDescription = By.cssSelector(".disclaimer");
	private By lblPersonalAccount = By.xpath("//div[.='Personal Account']");
	private By lblPersonalAccountDescription = By.xpath("//div[.='Personal Account']/following-sibling::p[1]");
	private By lblMerchantAccount = By.xpath("//button[text()='Create a Merchant Account']");
	private By btnMerchantAccount = By.xpath("//div[.='Merchant Account']");
	private By lblMerchantAccountDescription = By.xpath("//div[.='Merchant Account']/following-sibling::p[1]");
	private By lblAlreadyRegistered = By.xpath("//div[text()='Already registered?']");
	private By lnkLogin = By.xpath("//button[.='Log In']");
	private By lblLoginHeading = By.xpath("//span[.='Log In to coyni']");
	private By logoLogin = By.cssSelector("._coyni_Logo");
	private By login = By.xpath("(//a[text()='Log In'])[1]");////button[contains(text(),'Log In')]

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyLoginHeading(String loginHeading) {
		new CommonFunctions().verifyLabelText(lblLoginHeading, "loginHeading", loginHeading);
	}

	public void verifyDescription(String Description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", Description);
	}

	public void clickCoyniLogin() {
		click(login, "Login");
	}

	public void clickCoyniLogo() {
		click(logoLogin, "Logo");
	}

	public void clickPersonalAccount() {
		click(lblPersonalAccount, "Personal Account");
	}
	
	public void clickOnMerchantAccount() {
		click(btnMerchantAccount, "Merchant Account");
	}

	public void verifyPersonalAccount() {
		new CommonFunctions().elementView(lblPersonalAccount, "Personal Account");
		String text = getText(lblPersonalAccount, "");
		ExtentTestManager.setInfoMessageInReport("This is personal Account label Heading : " + text);
	}

	public void verifyPersonalAccountDesription() {
		new CommonFunctions().elementView(lblPersonalAccountDescription, "Personal Account Description");
		String text = getText(lblPersonalAccountDescription, "");
		ExtentTestManager.setInfoMessageInReport("This is personal Account label Description : " + text);
	}

	public void clickMerchantAccount() {
		click(lblMerchantAccount, "Merchant Account");
	}

	public void verifyMerchantAccount() {
		new CommonFunctions().elementView(btnMerchantAccount, "Merchant Account");
		String text = getText(btnMerchantAccount, "");
		ExtentTestManager.setInfoMessageInReport("This is Merchant Account label Heading : " + text);
	}

	public void verifyMerchantAccountDesription() {
		new CommonFunctions().elementView(lblMerchantAccountDescription, "Merchant Account Desription");
		String text = getText(lblMerchantAccountDescription, "");
		ExtentTestManager.setInfoMessageInReport("This is Merchnat Account label Description : " + text);
	}

	public void verifyAlreadyRegistered() {
		new CommonFunctions().elementView(lblAlreadyRegistered, "Already Registered");
		String text = getText(lblAlreadyRegistered, "");
		ExtentTestManager.setInfoMessageInReport("This is Already Regestered label  : " + text);
	}

	public void verifyLoginLnk() {
		new CommonFunctions().elementView(lnkLogin, "Login Link");
	}

	public void clickLogin() {
		click(lnkLogin, "Login");
	}

}
