package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.merchant.pages.FiltersPage;
import coyni.merchant.popups.DeleteUserPopup;
import coyni.merchant.popups.RemoveUserPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TeamComponent extends BrowserFunctions {

	private By lblTeam = By.xpath("//span[text()='Team']");
	private By lnkAddTeam = By.xpath("//span[text()='Add New Team Member']");
	private By lnkFilter = By.xpath("//div[text()='Filter']");
	private By search = By.xpath("//input[@placeholder='Search by Name, Email or Phone']");
	private By iconSearch = By.xpath("//button[@type='submit']");
	private By checkBox = By.xpath("//input[@type='checkbox']");
	private By noRecordFound = By.xpath("//div[text()='No Records Found']");
	private By btnSettings = By
			.xpath("//div[@class='cursor-pointer icon-settings-gear-icon text-cgy3 hover:text-cgy4']");
	private By lblName = By.xpath("//p[text()='Vishnu Pav...']");
	private By lblActivation = By.xpath("//p[text()='Vishnu Pav...']/following-sibling::*[2]");
	private By btnRemoveUser = By.xpath("//span[text()='Remove User']");
	private By btnDelete = By.xpath("(//div[text()='Delete'])[2]");

	public void verifyTeamHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblTeam, Heading, "Heading");
	}

	public void clickAddTeamMember() {
		click(lnkAddTeam, "Add New Member");
	}

	public void clickFilter() {
		click(lnkFilter, "Filter");
	}

	public void clickDelete() {
		click(btnDelete, "Delete");
	}

	public void clickRemoveUser() {
		click(btnRemoveUser, "Remove User");
	}

	public void verifyRecords() {
		if (verifyElementDisplayed(noRecordFound, "No Record Found")) {
			new CommonFunctions().elementView(noRecordFound, "No Records Found");
		}

	}

	public void verifyName() {
		String text = getText(lblName, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);
	}

	public void verifyActivation() {
		String text = getText(lblActivation, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);
	}

	public void clickSettings() {
		click(btnSettings, "Settings");
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

	public AddTeamMemberComponent addTeamMemberComponent() {
		return new AddTeamMemberComponent();
	}

	public RemoveUserPopup removeUserPopup() {
		return new RemoveUserPopup();
	}

	public DeleteUserPopup deleteUserPopup() {
		return new DeleteUserPopup();
	}

	public FiltersPage filtersPage() {
		return new FiltersPage();
	}

}