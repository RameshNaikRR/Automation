package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.CurrentDetailsComponent;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class CompanyInformationPage extends MobileFunctions{
	private By lblHeading = MobileBy.xpath("//*[contains(@text,'Company Information')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'business_entity')]");
	private By lblCompanyName = MobileBy.xpath("//*[contains(@resource-id,'name_id')]");
	private By lblContactInformation = MobileBy.xpath("//*[contains(@text,'Contact Information')]");
	private By lblCurrentEmail = MobileBy.xpath("//*[contains(@resource-id,'emailTx')]");
	private By lblCurrentPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'phoneNumberTx')]");
	private By lblCurrentAddress = MobileBy.xpath("//*[contains(@resource-id,'addressTx')]");
	private By lblAddress = MobileBy.xpath("//*[contains(@text,'Address')]");
	private By lblEmail = MobileBy.xpath("//*[contains(@text,'Email')]");
	private By lblPhoneNumber = MobileBy.xpath("//*[contains(@text,'Phone Number')]");
	private By btnEmail = MobileBy.xpath("//*[contains(@resource-id,'emailLL')]");
	private By btnPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'phoneLL')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Company Infromation Heading", expHeading);
	}

	public void verifyCustomerService(String expHeading) {
		new CommonFunctions().verifyLabelText(lblContactInformation, "Contact Information Heading", expHeading);
	}

	public void getDescription() {
		String str = getText(lblDescription);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void getCompanyName() {
		String str = getText(lblCompanyName);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void verifyEmail() {
		new CommonFunctions().elementView(lblEmail, "Email");
	}

	public void verifyPhoneNumber() {
		new CommonFunctions().elementView(lblPhoneNumber, "Phone Number");
	}

	public void verifyAddress() {
		new CommonFunctions().elementView(lblAddress, "Address");
	}

	public void getCurrentEmail() {
		String str = getText(lblCurrentEmail);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void getCurrentPhoneNumber() {
		String str = getText(lblCurrentPhoneNumber);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void getCurrentAddress() {
		String str = getText(lblCurrentAddress);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void clickEmail() {
		click(btnEmail, "Email");
	}

	public void clickPhoneNumber() {
		click(btnPhoneNumber, "Phone Number");
	}

	public CurrentDetailsComponent currentDetailsComponent() {
		return new CurrentDetailsComponent();
	}

}
