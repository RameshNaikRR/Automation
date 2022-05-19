package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.MailingAddressComponent;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class TeamMemberDetailsPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@text,'Team')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@text,'Contact Info')]");
	private By lblTeamMemberName = MobileBy.xpath("//*[contains(@resource-id,'name')]");
	private By lblTeamMemberDesc = MobileBy.xpath("//*[contains(@resource-id,'role')]");
	private By lblTeamMemberStatus = MobileBy.xpath("//*[contains(@resource-id,'status')]");
	private By lblPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'phoneNumber')]");
	private By lblEmail = MobileBy.xpath("//*[contains(@resource-id,'emailAddress')]");
	private By btnEdit = MobileBy.xpath("//*[contains(@resource-id,'nextCV')]");
	private By btnResendInvitation=MobileBy.xpath("//*[contains(@resource-id,'resend')]");
	private By btnRemoveMember=MobileBy.xpath("//*[contains(@resource-id,'remove')]");
	private By lblRemoveMemberPopupHeading=MobileBy.xpath("//*[contains(@resource-id,'tv_dialog_title')]");
	private By lblRemoveMemberPopupDescription=MobileBy.xpath("//*[contains(@resource-id,'tv_dialog_message')]");
	private By btnNo=MobileBy.xpath("//*[contains(@resource-id,'tv_negative_button')]");
	private By btnYes=MobileBy.xpath("//*[contains(@resource-id,'tv_positive_button')]");
	private By btnCancel = MobileBy.xpath("//*[contains(@resource-id,'cancelCv')]");
	private By btnBack=MobileBy.xpath("//*[contains(@resource-id,'bpbackBtn')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Team Member Details Heading", expHeading);
	}

	public void verifyDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Team Member Details Description", expDescription);
	}
	public void verifyRemoveMemberPopupHeading(String expRemoveMemberPopupHeading) {
		new CommonFunctions().verifyLabelText(lblRemoveMemberPopupHeading, "Remove Member Popup Heading", expRemoveMemberPopupHeading);
	}
	public void verifyRemoveMemberPopupDescription(String expRemoveMemberPopupDescription) {
		new CommonFunctions().verifyLabelText(lblRemoveMemberPopupDescription, "Remove Member Popup Description", expRemoveMemberPopupDescription);
	}
	public void getTeamMemberName() {
		String str = getText(lblTeamMemberName);
		ExtentTestManager.setInfoMessageInReport("Team Member Name is" + str);
	}

	public void getTeamMemberStatus() {
		String str = getText(lblTeamMemberStatus);
		ExtentTestManager.setInfoMessageInReport("Team Member Status is" + str);
	}

	public void getTeamMemberDesc() {
		String str = getText(lblTeamMemberDesc);
		ExtentTestManager.setInfoMessageInReport("Team Member Description is" + str);
	}

	public void getEmail() {
		String str = getText(lblEmail);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void getPhoneNumber() {
		String str = getText(lblPhoneNumber);
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void clickEdit() {
		click(btnEdit, "Edit");
	}

	public void clickNo() {
		click(btnNo, "No");
	}
	public void clickYes() {
		click(btnYes, "Yes");
	}
	public void clickResendInvitation() {
		click(btnResendInvitation, "Resend Invitation");
	}
	public void clickbtnRemoveMember() {
		click(btnRemoveMember, "Remove Member");
	}
	public void clickCancel() {
		click(btnCancel, "Cancel");
	}
	public void clickBack() {
		click(btnBack, "Back");
	}
	public EditTeamMemberPage editTeamMemberPage() {
		return new EditTeamMemberPage();
	}
}
