package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AgreementsComponent extends BrowserFunctions {
	private By lblHeading = By.xpath("(//span[text()='Agreements'])[2]");

	private By getAgreements(String Agreements) {
		return By.cssSelector(String.format(
				"div[class*='bg-cwhite BusinessSettingsAgreements_agreements']>div:nth-of-type(%s)", "Agreements"));
	}

	private By lnkAgreement = By.xpath("(//span[.='Agreements'])[2]");

	private By getHeading(String Heading) {
		return By.xpath(String.format("(//span[.='%s'])[2]", Heading));
	}

	private By lnkDownloadPDF = By.xpath("//span[.='Download PDF']");

	public void clickMerchantAgreement() {
		click(getAgreements("2"), "Merchant Agreements");
	}

	public void clickPrivacyPolicy() {
		click(getAgreements("3"), "Privacy Policy");
	}

	public void clickTermsOfServices() {
		click(getAgreements("4"), "Terms Of Services");
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, Heading, "Heading");
	}

	public void VerifyAgreements() {
		new CommonFunctions().elementView(lnkAgreement, "Agreements");
	}

	public void verifyMerchantAgreements() {
		new CommonFunctions().verifyLabelText(getHeading("Merchant Agreements"), "Merchant Agreements",
				"Merchant Agreements");
	}

	public void verifyPrivacyPolicy() {
		new CommonFunctions().verifyLabelText(getHeading("Privacy Policy"), "Privacy Policy", "Privacy Policy");
	}

	public void verifyTermsOfService() {
		new CommonFunctions().verifyLabelText(getHeading("Terms of Service"), "Terms of Service", "Terms of Service");
	}

	public void verifyDownloadPDFlnk() {
		new CommonFunctions().elementView(lnkDownloadPDF, "Download PDF lnk");
	}
}
