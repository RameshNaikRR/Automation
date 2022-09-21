package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TeamComponent extends BrowserFunctions {
	private By lblTeam = By.xpath("(//span[text()='Team'])[2]");
	private By lnkAddTeam = By.xpath("//button[text()='Add New Team Member']");
	private By lnkFilter = By.xpath("//div[text()='Filter']");
	private By search = By.xpath("//input[@placeholder='Search by Name, Email or Phone']");
	private By iconSearch = By.xpath("//button[@type='submit']");
	private By checkBox = By.xpath("//input[@type='checkbox']");
	private By noRecordFound = By.xpath("//div[text()='No Records Found']");
	private By editIcon = By.xpath("//span[text()='Edit']");
	private By sendInvite = By.xpath("//button[text()='Send Invitation']");
	private By iconDelete = By.xpath("//div[@data-tip='Delete']");
	private By btnRemove = By.xpath("//button[text()='Remove']");

	public void verifyTeamHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTeam, expHeading, "Team");
	}

	public void clickAddTeam() {
		click(lnkAddTeam, "Add Team Member");
	}

	public void clickFilter() {
		click(lnkFilter, "Filter");
	}

	public void verifyRecords() {
		new CommonFunctions().elementView(noRecordFound, "No Records Found");
	}

	public void verifySearch(String searchingKey) {
		enterText(search, searchingKey, "Search");
	}

	public void iconSearch() {
		new CommonFunctions().elementView(iconSearch, "Search");
	}

	public void iconDelete() {
		click(iconDelete, "Delete");
	}

	public void clickRemove() {
		click(btnRemove, "Remove");
	}

	public void clickSearchIcon() {
		click(iconSearch, "SearchIcon");
	}

	public void clickCheckBox() {
		click(checkBox, "CheckBox");
	}

	public void clickEdit() {
		click(editIcon, "Edit");
	}

	public void verifyEditIcon() {
		new CommonFunctions().elementView(editIcon, "Edit");
	}

	public void clickSendInvitation() {
//		if (getElement(sendInvite, "Send Invitation").isEnabled()) {
			click(sendInvite, "Send Invitation ");
//		} else {
//			ExtentTestManager.setPassMessageInReport("Send Invitation button is in disabled mode");
//		}

	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

}