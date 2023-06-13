package coyni.admin.Paymentpages;

import org.openqa.selenium.By;

import coyni.admin.Paymentcomponents.FilterComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TeamPage extends BrowserFunctions {

	private By lblTeamMember = By.xpath("");
	private By txtSearch = By.xpath("");
	private By lblPermissionRoles = By.xpath("");

	public void verifyTeamMember(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTeamMember, "Heading is: ", expHeading);
	}

	public void fillSearch(String search) {
		new CommonFunctions().verifyLabelText(txtSearch, search, "Search");
	}

	public void verifyPermissionRole(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPermissionRoles, "Heading is: ", expHeading);
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

}
