package coyni.apibusiness.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	private By teamRecordsList = By.xpath("//div[@class='flex justify-between w-full mr-10']");
	private By removeheading1 = By.xpath("//p[contains(@class,'TeamMemberDelete_headerText__v2cq')][1]");
	private By removeheading2 = By.xpath("//p[contains(@class,'TeamMemberDelete_headerText__v2cq')][2]");
	private By removedescription = By.xpath("//p[contains(@class,'text-cgy4 Paragraph_para__zyOB6')]");

	public void verifyTeamHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTeam, expHeading, "Team");
	}

	public void verifyRemoveHeading1() {
		String str = getText(removeheading1, "Heading");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void verifyRemoveHeading2() {
		String str = getText(removeheading2, "Heading");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void verifyDescription() {
		String str = getText(removedescription, "Description");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void clickAddTeam() {
		click(lnkAddTeam, "Add Team Member");
	}

	public void clickFilter() {
		click(lnkFilter, "Filter");
	}

	public void verifyNoFoundRecords() {
		if (verifyElementPresence(noRecordFound, "No Records Founds")) {
			String str = getText(noRecordFound, "No Records Found");
			ExtentTestManager.setPassMessageInReport(str);
			clickAddTeam();
		} else {
			clickAddTeam();
		}
	}

	public void getRecordsList() {
		List<WebElement> rows = getElementsList(teamRecordsList, "Team Member List");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}

	public void verifyRecords() {
		if (verifyElementPresence(noRecordFound, "No Records Founds")) {
			String str = getText(noRecordFound, "No Records Found");
			ExtentTestManager.setPassMessageInReport(str);
		} else {
			getRecordsList();
		}
	}

	public void verifySearch(String searchingKey) {
		enterText(search, searchingKey, "Search");
	}

	public void iconSearch() {
		new CommonFunctions().verifyCursorAction(iconSearch, "Search");
		new CommonFunctions().elementView(iconSearch, "Search");
	}

	public void iconDelete() {
		new CommonFunctions().verifyCursorAction(iconDelete, "Delete");
		click(iconDelete, "Delete");
	}

	public void clickRemove() {
		new CommonFunctions().verifyCursorAction(btnRemove, "Remove");
		String str = getElement(btnRemove, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
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