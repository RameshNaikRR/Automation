package coyni.merchant.components;

import org.openqa.selenium.By;
import coyni.merchant.pages.FiltersPage;
import coyni.merchant.popups.DeleteUserPopup;
import coyni.merchant.popups.RemoveUserPopup;
import coyni.merchant.popups.TeamMemberRemoveUserPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TeamComponent extends BrowserFunctions {

	private By lblTeam = By.xpath("//span[text()='Team']");
	private By btnTeam = By.xpath("(//span[contains(text(),'Team')])[2]");
	private By lnkAddTeam = By.xpath("//button[text()='Add New Team Member']");
	private By lnkFilter = By.xpath("//div[text()='Filter']");
	private By search = By.xpath("//input[@placeholder='Search by Name, Email or Phone']");
	private By iconSearch = By.xpath("//button[@type='submit']");
	private By checkBox = By.xpath("//input[@type='checkbox']");
	private By noRecordFound = By.xpath("//div[text()='No Records Found']");
	private By btnSettings = By
			.xpath("//div[@class='cursor-pointer icon-settings-gear-icon text-cgy3 hover:text-cgy4']");
	private By lblName = By.xpath("//div[contains(@class,'flex')]/p");
	private By lblActivation = By.xpath("//p[text()='Vishnu Pav...']/following-sibling::*[2]");
	private By btnRemoveUser = By.xpath("//span[text()='Remove User']");
	private By btnDelete = By.cssSelector(".Team_icon__ai-o3");
	private By btnCheckBox = By.xpath("(//label[contains(@class,'custom-checkbox')])[2]");
	private By btnActions = By.xpath("//div[contains(text(),'Actions')]");
	private By btnRemoveUsers = By.xpath("//data[contains(text(),'Remove Users')]");
	private By btnApplyAction = By.xpath("//div[contains(text(),'Apply Action')]");
	private By btnResendInvitation = By.xpath("//div[@data-tip='Resend Invitation']");
	private By btnEdit = By.xpath("//div[@data-tip='Edit']");
	private By msgNoRecords = By.xpath("//div[contains(text(),'No Records Found')]");

	public void verifyTeamHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblTeam, Heading, "Heading");
	}

	public void clickAddTeamMember() {
		click(lnkAddTeam, "Add New Member");
	}

	public void clickEdit() {
		click(btnEdit, "Edit");
	}

	public void clickEditTeam() {
		click(btnTeam, "Team");
	}

	public void clickResendInvitation() {
		click(btnResendInvitation, "Resend Invitation");
	}

	public void clickApplyAction() {
		click(btnApplyAction, "Apply Action");
	}

	public void clickFilter() {
		click(lnkFilter, "Filter");
	}

	public int verifyTeamMemberRecords() {
		return getElementsList(msgNoRecords, "").size();
	}

	public String verifyNoRecordsFound() {
		new CommonFunctions().elementView(msgNoRecords, "No Records");
		return getText(msgNoRecords, "No Records");
	}

	public void clickActions() {
		click(btnActions, "Actions");
	}

	public void clickRemoveUser() {
		click(btnRemoveUsers, "Remove Users");
	}

	public void clickDelete() {
		click(btnDelete, "Delete");
	}

	public void selectFilter(String type) {
		click(getCheckBox(type), type);
	}

	private By getCheckBox(String elementName) {
		return By.xpath(String.format("//span[text()='%s']//preceding-sibling::input", elementName));
	}

	public void verifyRecords() {
		if (verifyElementDisplayed(noRecordFound, "No Record Found")) {
			new CommonFunctions().elementView(noRecordFound, "No Records Found");
		} else {
			click(btnSettings, "Settings");
		}

	}

	public void verifyName() throws InterruptedException {
		Thread.sleep(2000);
		String text = getText(lblName, "");
		ExtentTestManager.setInfoMessageInReport("Name " + text);
	}

	public void verifyActivation() {
		String text = getText(lblActivation, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);
	}

	public void clickSettings() {
		if (verifyElementDisplayed(btnSettings, "Click Signet Account")) {
			click(btnSettings, "Settings");

		} else {
			ExtentTestManager.setInfoMessageInReport(" Settings is not visible");
		}

	}

	public void verifySearch(String expHeading) {
		new CommonFunctions().verifyLabelText(search, expHeading, "Search");
	}

	public void iconSearch() {
		new CommonFunctions().elementView(iconSearch, "Search");
	}

	public void clickCheckBox() {
		click(btnCheckBox, "CheckBox");
	}

	public AddTeamMemberComponent addTeamMemberComponent() {
		return new AddTeamMemberComponent();
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public RemoveUserPopup removeUserPopup() {
		return new RemoveUserPopup();
	}

	public TeamMemberRemoveUserPopup teamMemberRemoveUserPopup() {
		return new TeamMemberRemoveUserPopup();
	}

	public DeleteUserPopup deleteUserPopup() {
		return new DeleteUserPopup();
	}

	public FiltersPage filtersPage() {
		return new FiltersPage();
	}
}