package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.admin.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AgreementsPage extends BrowserFunctions {
	private By lblHeading = By.xpath("(//span[text()='Agreements'])[2]");

	private By lblMerchantAgreements = By.xpath("//span[text()='Merchant Agreement']");
	private By lblPrivacyPolicy = By.xpath("//span[text()='Privacy Policy']");
	private By lblTermsOfService = By.xpath("//span[text()='Terms of Service']");

	public By getAgreements(String Agreements) {
		return By.cssSelector(String.format(
				"div[class*='bg-cwhite BusinessSettingsAgreements_agreements']>div:nth-of-type(%s)", "Agreements"));
	}

	public void clickMerchantAgreement() throws Exception {
		click(getAgreements("2"), "Merchant Agreements");
		Thread.sleep(3000);
	}

	public void verifyMerchantAgreement(String expHeading) {
		new CommonFunctions().elementView(lblMerchantAgreements, expHeading);
	}

	public void verifyPrivacyPolicy(String expHeading) {
		new CommonFunctions().elementView(lblPrivacyPolicy, expHeading);
	}

	public void verifyTermsOfService(String expHeading) {
		new CommonFunctions().elementView(lblTermsOfService, expHeading);
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

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
