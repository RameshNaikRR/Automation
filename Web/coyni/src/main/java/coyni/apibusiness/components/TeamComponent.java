package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TeamComponent extends BrowserFunctions {
	private By lblTeam = By.xpath("(//span[text()='Team'])[2]");
	private By lnkAddTeam = By.xpath("//span[text()='Add New Team Member']");
	private By lnkFilter = By.xpath("//div[text()='Filter']");
	private By search = By.xpath("placeholder=\"Search by Name, Email, or Phone\"");
	private By iconSearch = By.xpath("//button[@type='submit']");
	private By checkBox = By.xpath("//input[@type='checkbox']");
	private By noRecordFound = By.xpath("//p[text()='No Records Found'])");

	public void verifyTeamHeading() {
		new CommonFunctions().elementView(lblTeam, "Team");
	}

	public void clickAddTeamMember() {
		click(lnkAddTeam, "Add New Member");
	}

	public void clickFilter() {
		click(lnkFilter, "Filter");
	}

	public void verifyRecords() {
		new CommonFunctions().elementView(noRecordFound, "No Records Found");
	}

	public void verifySearch(String expHeading) {
		new CommonFunctions().verifyLabelText(search, expHeading, "Search");
	}

	public void iconSearch() {
		new CommonFunctions().elementView(iconSearch, "Search");
	}

	public void clickCheckBox() {
		click(checkBox, "CheckBox");
	}
}