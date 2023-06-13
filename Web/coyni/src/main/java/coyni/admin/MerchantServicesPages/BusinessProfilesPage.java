package coyni.admin.MerchantServicesPages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BusinessProfilesPage extends BrowserFunctions {

	private By lblBusinessProfile = By.xpath("");
	private By tabProfiles = By.xpath("");
	private By tabInvitations = By.xpath("");
	private By drpdwnAllStatuses = By.xpath("");
	private By txtSearch = By.xpath("");

	public void verifyBusinessProfiles(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBusinessProfile, "Business Profiles Heading is: ", expHeading);
	}

	public void clickProfilesTab() {
		click(tabProfiles, "Profiles");
	}

	public void clickInvitationsTab() {
		click(tabInvitations, "Invitations");
	}

	public void SelectDropDownAllStatuses() {
		click(drpdwnAllStatuses, "All Statuses");
	}

	public void fillSearch(String search) {
		enterText(txtSearch, search, "Search");
	}
}
