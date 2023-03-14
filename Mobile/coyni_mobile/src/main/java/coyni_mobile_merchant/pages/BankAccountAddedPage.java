package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class BankAccountAddedPage extends MobileFunctions {

	private By heading = MobileBy.xpath("//*[contains(@resource-id,'tvAFailed')]|//*[@text='Bank Account Added']");
//	private By lblDescription = MobileBy.xpath("//*[@text='Your bank account(s) has been successfully authorized and added to your payment methods.']");
	private By btnDone = MobileBy.xpath("//*[@text='Done']");

	public void verifySucessHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Bank Heading", expHeading);
	}

	public void verifyAddedBankDescription(String description) {
		By lblDescription = MobileBy.xpath("//*[@text=" + "'" + description + "'" + "]");
		if (getElement(lblDescription, "Bank Description").isDisplayed()) {
			ExtentTestManager.setPassMessageInReport(getText(lblDescription) + " is displayed");
		} else {
			ExtentTestManager.setFailMessageInReport(getText(lblDescription) + " is not displayed");
		}
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void verifyBankDetails(String expHeading, String expNameOnBank, String expRouting, String expConRouting,
			String expAccNum, String expConfirmAcc) {
	}

}
