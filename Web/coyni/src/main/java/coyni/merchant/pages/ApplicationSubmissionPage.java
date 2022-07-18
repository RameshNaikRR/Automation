package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.admin.components.NavigationComponent;
import coyni.merchant.popups.CancelMerchantApplicationPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ApplicationSubmissionPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Merchant Application Under Review']");

	private By lblUnderReviewDescription = By
			.xpath("//h1[contains(text(),'Merchant Application Under Review')]/following-sibling::*");

	private By lblStatus = By.xpath("//p[contains(text(),'Status')]");

	private By btnCancelApplication = By.xpath("//strong[contains(text(),'cancel')]");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, Heading, "Heading");
	}

	public void verifyUnderReviewDescription() {
		String text = getText(lblUnderReviewDescription, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);
	}

	public void verifyStatus() {
		String text = getText(lblStatus, "Status");
		ExtentTestManager.setInfoMessageInReport("Status " + text);
	}

	public void clickCancelApplication() {
		click(btnCancelApplication, "Cancel Application");
	}

	public CancelMerchantApplicationPopup cancelMerchantApplicationPopup() {
		return new CancelMerchantApplicationPopup();
	}

}
