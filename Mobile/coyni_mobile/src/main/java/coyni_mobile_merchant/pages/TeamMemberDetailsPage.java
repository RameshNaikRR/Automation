package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.ToastComponent;
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
	private By txtSearch = MobileBy.xpath("//*[contains(@resource-id,'searchET')]|//*[contains(@resource-id,'payoutSearchET')]");
	private By btnSearchClear = MobileBy.id("com.coyni.mapp:id/clearTextLL");
	String fullName = getTeamMemberName();
	
	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Team Member Details Heading", expHeading);
	}

	public void verifyDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Team Member Details Description", expDescription);
	}
	public void verifyRemoveMemberPopupHeading(String expRemoveMemberPopupHeading) {
		new CommonFunctions().verifyLabelText(lblRemoveMemberPopupHeading, "Remove Member Popup Heading", expRemoveMemberPopupHeading);
	}

	public void verifyRemoveMemberPopupDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblRemoveMemberPopupDescription, "Remove Team Member Description", expDescription);
	}
	
	public void getRemoveMemberPopupDescription() {
	  ExtentTestManager.setInfoMessageInReport("Description : " + getText(lblRemoveMemberPopupDescription));
	}
	public String getTeamMemberName() {
		String str = getText(lblTeamMemberName);
		ExtentTestManager.setInfoMessageInReport("Team Member Name is : " + str);
		return str;
	}

	public String getTeamMemberFirstName() {
		String fullName = getText(lblTeamMemberName);
		String firstName = fullName.split(" ")[0];
		return firstName;
	}

	public String getTeamMemberLastName() {
		String fullName = getText(lblTeamMemberName);
		String lastName = fullName.split(" ")[1];
		return lastName;
	}

	public void getTeamMemberStatus() {
		String str = getText(lblTeamMemberStatus);
		ExtentTestManager.setInfoMessageInReport("Team Member Status is : " + str);
	}

	public void getTeamMemberDesc() {
		String str = getText(lblTeamMemberDesc);
		ExtentTestManager.setInfoMessageInReport("Team Member Description is : " + str);
	}

	public String getEmail() {
		String str = getText(lblEmail);
		ExtentTestManager.setInfoMessageInReport(str);
		return str;
	}

	public void verifySearchWithFullName() {
		enterText(txtSearch, fullName, "Verify search field with Full Name");
		if(fullName.equalsIgnoreCase(getTeamMemberName())) {
			ExtentTestManager.setPassMessageInReport("Search option is display the results, when we enter Full Name in Search field");
		}else {
			ExtentTestManager.setFailMessageInReport("Search option is not display the results, when we enter Full Name in Search field");
		}
	}

	public void verifyClearOptionInSearch() {
	click(btnSearchClear, "Search Clear");
	if(getText(txtSearch).length()==0||getText(txtSearch).equalsIgnoreCase("Name")) {
		ExtentTestManager.setPassMessageInReport("Search option is clearing the text");
	}else {
		ExtentTestManager.setFailMessageInReport("Search option is not clearing the text");	
	}
	}

	
	public void verifySearchWithFirstName() {
		String firstName = fullName.split(" ")[0];
		enterText(txtSearch, firstName, "Verify search with only First Name");
		if(firstName.equalsIgnoreCase(getTeamMemberFirstName())) {
			ExtentTestManager.setPassMessageInReport("Search option is display the results, when we enter First Name in Search field");
		}else {
			ExtentTestManager.setFailMessageInReport("Search option is not display the results, when we enter First Name in Search field");
		}
		new CommonFunctions().clearText(txtSearch, "Search");
	}
	
	public void verifySearchWithLastName() {
		
		String lastName = fullName.split(" ")[1];
		enterText(txtSearch, lastName, "Verify search with only First Name");
		if(lastName.equalsIgnoreCase(getTeamMemberLastName())) {
			ExtentTestManager.setPassMessageInReport("Search option is display the results, when we enter Last Name in Search field");
		}else {
			ExtentTestManager.setFailMessageInReport("Search option is not display the results, when we enter Last Name in Search field");
		}
	}
	
	public String getPhoneNumber() {
		String str = getText(lblPhoneNumber);
		ExtentTestManager.setInfoMessageInReport(str);
		return str;
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
	
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
}
