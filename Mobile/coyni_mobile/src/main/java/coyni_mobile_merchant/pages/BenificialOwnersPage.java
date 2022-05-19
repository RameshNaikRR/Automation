package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class BenificialOwnersPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@text,'Beneficial Owners')]");
	private By lblOwnerName = MobileBy.xpath("//*[contains(@resource-id,'nameTx')]");
	private By lblOwnerShipPer = MobileBy.xpath("//*[contains(@resource-id,'ownershipTx')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Benificial Owners Heading", expHeading);
	}

//	public void verifyCustomerService(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblCustomerService, "Customer Service Heading", expHeading);
//	}

	public void getOwnerName() {
		String str = getText(lblOwnerName);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void getOwnerShipPercentage() {
		String str = getText(lblOwnerShipPer);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void clickOwner() {
		click(lblOwnerName, "Owner");
	}

	public BenificialOwnersDetailsPage benificialOwnersDetailsPage() {
		return new BenificialOwnersDetailsPage();
	}

}
