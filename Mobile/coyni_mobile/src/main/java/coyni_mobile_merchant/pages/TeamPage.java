package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class TeamPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("(//*[contains(@text,'Team')])[1]");
	private By lblDescription = MobileBy.xpath("//*[contains(@text,'Team Members')]");
	private By txtSearch = MobileBy.xpath("//*[contains(@resource-id,'searchET')]");
	private By lblTeamMemberNotFoundMsg = MobileBy.xpath("//*[contains(@resource-id,'no_team_member')]");
	private By btnClearText = MobileBy.xpath("//*[contains(@resource-id,'clearTextLL')]");
	private By btnAddTeamMember = MobileBy.xpath("//*[contains(@text,'Add Team')]");
	private By btnSelectPendingStatusTeamMember = MobileBy.xpath("(//*[contains(@resource-id,'teamsCV')]//*[contains(@text,'Pending')])[1]");
	private By btnSelectResendInvitationStatusTeamMember = MobileBy.xpath("(//*[contains(@resource-id,'rvTeam')]//*[contains(@resource-id,'teamLL')]//*[contains(@text,'Resend')])[1]|(//*[contains(@text,'Resend')])[1]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'bpbackBtn')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Team Heading", expHeading);
	}

	public void verifyDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Team Description", expDescription);
	}

	public void verifyTeamMemberNotFoundMsg(String expNotFoundMsg) {
		new CommonFunctions().verifyLabelText(lblTeamMemberNotFoundMsg, "Team Member Not Found Message",
				expNotFoundMsg);
	}

	public void fillSearch(String expSearch) {
		click(txtSearch, "Search");
		enterText(txtSearch, expSearch, "Search");
		DriverFactory.getDriver().hideKeyboard();

	}

	public void clickClear() {
		click(btnClearText, "Clear Search Text");
	}

	public void clickAddTeamMember() {
		click(btnAddTeamMember, "Add Team Member");
	}

	public void clickPendingStatusTeamMember() {
		scrollDownToElement(btnSelectPendingStatusTeamMember, "Select Pending Status Team Member");
		click(btnSelectPendingStatusTeamMember, "Select Pending Status Team Member");
	}
	public void clickResendInvitationStatusTeamMember() {
		//scrollDownToElement(btnSelectResendInvitationStatusTeamMember, "Select Resend Invitation Status Team Member");
		//scrollDownToElement(btnSelectResendInvitationStatusTeamMember, "Select Resend Invitation Status Team Member");
		click(btnSelectResendInvitationStatusTeamMember, "Select Resend Invitation Status Team Member");
	}
	public void clickBack() {
		click(btnBack, "Back");
	}

	public TeamMemberDetailsPage teamMemberDetailsPage() {
		return new TeamMemberDetailsPage();
	}

	public AddNewTeamMemberPage addNewTeamMemberPage() {
		return new AddNewTeamMemberPage();
	}
}
