package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AgreementsComponent extends BrowserFunctions {

	private By heading = By.xpath("//span[contains(text(),'Agreements')]");
	private By btnPrivacyPolicy = By.xpath("//button[contains(@class,'w-full agreements-row')]//p[text()='Privacy Policy']");
	private By btnTermsofServices = By.xpath("//button[contains(@class,'w-full agreements-row')]//p[text()='Terms of Service']");
	private By lblAgreements = By.xpath("//div[contains(@class,'Agreements_content')]");
	private By headingPrivacyPolicy = By.xpath("//span[contains(text(),'Privacy Policy')]");
	private By headingTermsofService = By.xpath("//span[contains(text(),'Terms of Service')]");

	
	
	public String verifyHeading() {
		String str = getText(heading,"Headind is");
		ExtentTestManager.setInfoMessageInReport("Heading is "+ str);
		return str;
	}
	
	public void viewAgreement() {
		new CommonFunctions().elementView(lblAgreements,"Agreements");
	}
	
	public String verifyPrivacyPolicyHeading() {
		String str = getText(headingPrivacyPolicy, "Heading");
		ExtentTestManager.setInfoMessageInReport("Agreement heading is "+ str);
		return str;
	}
	
	public String verifyTermsofServiceHeading() {
		String str = getText(headingTermsofService, "Heading");
		ExtentTestManager.setInfoMessageInReport("Agreement heading is "+ str);
		return str;
	}
	
	
	public void clickPrivacyPolicy() {
		click(btnPrivacyPolicy, "Privacy Policy");
	}
	
	public void clickTermsofService() {
		click(btnTermsofServices, "Terms of Services");
	}

}
