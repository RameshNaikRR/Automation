package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AgreementsPage extends BrowserFunctions {
	private By lblHeading = By.xpath("(//span[text()='Agreements'])[2]");

	private By getAgreements(String Agreements) {
		return By.cssSelector(String.format(
				"div[class*='bg-cwhite BusinessSettingsAgreements_agreements']>div:nth-of-type(%s)", "Agreements"));
	}

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

}
