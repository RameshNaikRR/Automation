package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.CurrentDetailsComponent;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class UserDetailsPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[@text='User Details']");
	private By lblUserName = MobileBy.xpath("//*[contains(@resource-id,'b_userNameTV')]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'CloseLL')]");
	private By lblCurrentEmail = MobileBy.xpath("//*[contains(@resource-id,'b_userEmailIdTV')]");
	private By lblCurrentPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'/b_userPhoneNumTV')]");
	private By lblCurrentAddress = MobileBy.xpath("//*[contains(@resource-id,'/b_userAddressTV')]");
	private By lblAddress = MobileBy.xpath("//*[contains(@text,'Address')]");
	private By lblEmail = MobileBy.xpath("//*[contains(@text,'Email')]");
	private By lblPhoneNumber = MobileBy.xpath("//*[contains(@text,'Phone Number')]");
	private By btnEmail = MobileBy.xpath("//*[contains(@resource-id,'/b_emailLL')]");
	private By btnPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'/b_phoneLL')]");
	private By btnAddress = MobileBy.xpath("//*[contains(@resource-id,'b_addressLL')]");
	private By lblDefault = MobileBy.xpath("//*[contains(@text,'Default Account')]");
	private By lblDefaultAccountName = MobileBy.xpath("//*[contains(@resource-id,'b_accountET')]");
	private By lblChildAccountName=MobileBy.xpath("(//*[contains(@resource-id,'title')])[2]");
	private By lblTickIcon = MobileBy.xpath("//*[contains(@resource-id,'tickIcon')]");
	private By btnSelectAccount1 = MobileBy.xpath("(//*[contains(@resource-id,'arrow')])[1]");
	private By btnSelectAccount2 = MobileBy.xpath("(//*[contains(@resource-id,'arrow')])[2]");
	private By btnChildAccount1 = MobileBy.xpath("(//*[contains(@resource-id,'ll_child_view')])[1]");
	private By btnChildAccount2 = MobileBy.xpath("(//*[contains(@resource-id,'ll_child_view')])[2]");
	private By btnSave = MobileBy.xpath("//*[contains(@text,'Save')]");

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "User Details Heading ", expHeading);
	}

	public void getUserDetails() {
		String str = getText(lblUserName);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void clickDefaultAccount() {
		ExtentTestManager.setInfoMessageInReport("Default Account is : " + getText(lblDefaultAccountName));
		click(lblDefaultAccountName, "Default Account");
	}

	public void clickSelectAccount1() {
		click(btnSelectAccount1, "Select Account 1");
	}

	public void clickChildAccount1() {
		click(btnChildAccount1, "Child Account 1");
	}

	public void clickChildAccount2() {
		click(btnChildAccount2, "Child Account 2");
	}

	public void clickSelectAccount2() {
		click(btnSelectAccount2, "Select Account 2");
	}

	public void clickSave() {
		new CommonFunctions().elementEnabled(btnSave, "Save");
		click(btnSave, "Save");
	}
	
	public void verifyTickIcon() {
		new CommonFunctions().elementView(lblTickIcon, "Tick Icon");
	}

	public void verifyDefaultAccount(String expHeading) {
		new CommonFunctions().elementView(lblDefault, "Default Acccount");
		new CommonFunctions().verifyLabelText(lblDefault, "Default Acccount Heading ", expHeading);
	}
	
	public void getDefaultAccountName() {
		ExtentTestManager.setInfoMessageInReport(getText(lblDefaultAccountName));
	}
	
	public void getChildAccountName() {
		ExtentTestManager.setInfoMessageInReport(getText(lblChildAccountName));
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

	public void clickAddress() {
		click(btnAddress, "Address");
	}

	public CurrentDetailsComponent currentDetailsComponent() {
		return new CurrentDetailsComponent();
	}
}
