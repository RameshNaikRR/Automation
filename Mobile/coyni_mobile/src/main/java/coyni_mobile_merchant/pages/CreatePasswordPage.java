package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class CreatePasswordPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By txtNewPassword = MobileBy.xpath("//*[contains(@resource-id,'etPassword')]");
	private By txtConfirmPassword = MobileBy.xpath("//*[contains(@resource-id,'etCPassword')]");
	private By lblPasswordErrMessage = MobileBy.xpath("//*[contains(@resource-id,'tvPasswordInfo')]");
	private By btnCloseIcon=MobileBy.xpath("//*[contains(@resource-id,'/imgClose')]");
	private By eyeIconNew = MobileBy.xpath("((//*[contains(@resource-id,'text_input_end_icon')])[1]");
	private By eyeIconConfirm = MobileBy.xpath("(//*[contains(@resource-id,'text_input_end_icon')])[2]");
	private By btnSave = MobileBy.xpath("//*[contains(@resource-id,'cvSave')]");
//	private By greendot = By.xpath("//span[@class='green-dot']/parent::span");
//	private By greendot1 = By.xpath("(//span[@class='green-dot']/parent::span)[2]");
//	private By reddot = By.cssSelector(".red-dot");
//	private String CreatePassword;
//	private String ConfirmPassword;

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Create Password Heading ", expHeading);
	}

	public void clickNewPassword() {
		click(txtNewPassword, " New Password");
	}

	public void fillNewPassword(String newPassword) {
		enterText(txtNewPassword, newPassword, "New Password");
	}

	public void fillConfirmPassword(String confirmPassword) {
		enterText(txtConfirmPassword, confirmPassword, "Confirm Password");
		click(txtConfirmPassword, " Confirm Password");

	}
	public void VerifyPasswordErrMessage(String expPasswordMessage) {
		new CommonFunctions().verifyLabelText(lblPasswordErrMessage, "Password Error Message  ", expPasswordMessage);
	}
	public void clickCloseIcon() {
		click(btnCloseIcon, " Close Icon");
	}

	
	public void clickSave() {
		click(btnSave, "Save");
	}

}
