package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.admin.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AgreementsPage extends BrowserFunctions {
	private By lblHeading = By.xpath("(//span[text()='Agreements'])[2]");
	private By lnkDownload = By.xpath("//span[text()='Download PDF']");
	private By lnkAgreements = By.xpath("//span[@aria-hidden=\"true\"]");
	private By iconDownload = By.xpath("(//div[@data-tip='Download'])[1]");

	public By getAgreements(String Agreements) {
		return By.cssSelector(String.format(
				"div[class*='bg-cwhite BusinessSettingsAgreements_agreements']>div:nth-of-type(%s)", "Agreements"));
	}

	public void clickMerchantAgreement() throws Exception {
		click(getAgreements("2"), "Merchant Agreements");
		Thread.sleep(3000);
	}

	public void clickPrivacyPolicy() {
		click(getAgreements("3"), "Privacy Policy");
	}

	public void clickTermsOfServices() {
		click(getAgreements("4"), "Terms Of Services");
	}

	public void clickDownloadPDF() {
		click(lnkDownload, "Download PDF");
	}

	public void clickLinkAgreements() {
		click(lnkAgreements, "Agreements");
	}

	public void clickiconDownload() {
		click(iconDownload, " Download Agreements");
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, Heading, "Heading");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
