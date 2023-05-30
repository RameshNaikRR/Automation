package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AgreementsPage extends BrowserFunctions {

	private By lblHeading = By.xpath("(//span[.='Agreements'])[2]");
	private By btnTermsOfService = By.xpath("//span[text()='Terms of Service']");
	private By btnPrivacyPolicy = By.xpath("//span[text()='Privacy Policy']"); // Privacy Policy
	private By lnkDownload = By.xpath("(//div[contains(@class,'__react_component_tooltip')])[4]");

	public void verifyAgreements(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading is: ", expHeading);
	}

	public void verifyTermsofService() {
		new CommonFunctions().verifyCursorAction(btnTermsOfService, "Terms Of Service");
		click(btnTermsOfService, "Terms Of Service");
	}

	public void verifyPrivacyPolicy() {
		new CommonFunctions().verifyCursorAction(btnPrivacyPolicy, "Privacy Policy");
		click(btnPrivacyPolicy, "Privacy Policy");
	}

	public void clickDownload() {
		click(lnkDownload, "Download");
	}

	
}
