package coyni_mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class BankAccountAddedPage extends MobileFunctions {

	private By heading = MobileBy.xpath("//*[@text='Bank Account Added']");
	private By lblStatus = MobileBy.xpath("//*[@text='Approved']");
	private By lblInstitution = MobileBy.xpath("//*[contains(@resource-id,'bankNameTV')]");
	private By lblAccNumber = MobileBy.xpath("//*[contains(@resource-id,'accNumTV')]");
	private By lblRoutingNum = MobileBy.xpath("//*[contains(@resource-id,'routingNumTV')]");
	private By btnDone = MobileBy.xpath("//*[@text='Done']");
	private By lblNameOnAcc = MobileBy.xpath("//*[contains(@resource-id,'nameOnBankTV')]");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Bank Heading", expHeading);
	}

	public int verifyBankSucessHeading() {
		return DriverFactory.getDriver().findElements(heading).size();
	}

	public void verifyStatus(String expStatus) {
		new CommonFunctions().verifyLabelText(lblStatus, "Bank Status", expStatus);
	}

	public String getNameOnAccount() {
		String str = getText(lblNameOnAcc);
		return str;

	}

	public void getBankDetails() {
		ExtentTestManager.setInfoMessageInReport("Name on Account is " + getText(lblNameOnAcc));
		ExtentTestManager.setInfoMessageInReport("Institution is " + getText(lblInstitution));
		ExtentTestManager.setInfoMessageInReport("Routing Number is " + getText(lblRoutingNum));
		ExtentTestManager.setInfoMessageInReport("Account Number  is " + getText(lblAccNumber));
		wait.until(ExpectedConditions.elementToBeClickable(btnDone));
		clickDone();
	}

	public String getRoutingNum() {
		String str = getText(lblRoutingNum);
		return str;

	}

	public String getAccNum() {
		String str = getText(lblAccNumber).replace("•", "");
		return str;
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void verifyBankDetails(String expHeading, String expNameOnBank, String expRouting, String expConRouting,
			String expAccNum, String expConfirmAcc) {
	}

}
