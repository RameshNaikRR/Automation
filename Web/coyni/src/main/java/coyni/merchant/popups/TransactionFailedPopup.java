package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionFailedPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[.='Transaction Failed']");
	private By lblDescription = By.xpath("//p[contains(.,'The transaction failed')]");
	private By btnTryAgain = By.xpath("//button[.='Try Again']");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyDescription() {
		String text = getText(lblDescription, "");
		ExtentTestManager.setInfoMessageInReport(text + " Is displayed");
	}

	public void verifyTryAgainBtn() {
		new CommonFunctions().elementView(btnTryAgain, "Try Again button");
	}

	public void clickTryAgainBtn() {
		click(btnTryAgain, "Try Again button");
	}

}
