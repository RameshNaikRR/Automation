package coyni.business.popups;

import org.openqa.selenium.By;


import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CancelWalletPopup extends BrowserFunctions {

	private By lblCancelWalletHeding = By.xpath("//p[text()='Cancel Wallet?']");
	private By lbldescription = By.xpath("//p[@class='px-[19px] text-sm text-center text-cgy4']");
	private By clickCancel = By.xpath("//button[text()='Yes, cancel wallet']");
	private By goBack = By.xpath("//p[text()='No, go back']");

	public void verifyCancelHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblCancelWalletHeding, "Heading ", expHeading);
	}

	public void verifyDescrption() {
		String description = getText(lbldescription, "");
		ExtentTestManager.setInfoMessageInReport(description);
	}

	public void clickCancel() {
		click(clickCancel, "Cancel");
	}

	public void goBack() {
		click(goBack, "Goback");
	}
}
