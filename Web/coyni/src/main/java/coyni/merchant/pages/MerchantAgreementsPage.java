package coyni.merchant.pages;

import org.openqa.selenium.By;
import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class MerchantAgreementsPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//h4[text()='Agreements']");
	private By lblMerchantAgreementsView = By.xpath("//button[text()='View']");
	private By lblMerchantAgreement = By.xpath("//h6[text()='Merchant Agreements']");
	private By lblPrivacyPolicy = By.xpath("//p[text()='Privacy Policy']");
	private By lblTermsOfService = By.xpath("//p[text()='Terms of Service']");
	private By lblESignature = By.xpath("//div[text()='eSignature']");
	private By btnSignature = By.xpath("//div[contains(@class,'outline-none')]");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By btnBack = By.xpath("//button[text()='Back']");
	private By btnExit = By.xpath("//button[text()='Exit']");
	private By btnNext = By.xpath("//button[text()='Next']");

	public By getAgreements(String Agreements) {
		return By.cssSelector(String.format(
				"div[class*='bg-cwhite BusinessSettingsAgreements_agreements']>div:nth-of-type(%s)", "Agreements"));
	}

	public void clickMerchantAgreement() {
		click(lblMerchantAgreementsView, "Merchant Agreements");
	}

	public void clickMerchantAgreements() {
		click(lblMerchantAgreement, "Agreements");
	}

	public void clickSave() {
		click(btnSave, "Save");
	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void clickExit() {
		click(btnExit, "Exit");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void verifyESignature(String signature) {
		scrollToElement(lblESignature, "ESignature");
		click(btnSignature, "Signature");
		enterText(btnSignature, signature, "Signature");
	}

	public void verifyMerchantAgreement(String expHeading) {
		new CommonFunctions().elementView(lblMerchantAgreementsView, expHeading);
	}

	public void verifyPrivacyPolicy(String expHeading) {
		new CommonFunctions().elementView(lblPrivacyPolicy, expHeading);
	}

	public void verifyTermsOfService(String expHeading) {
		new CommonFunctions().elementView(lblTermsOfService, expHeading);
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, Heading, "Heading");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
