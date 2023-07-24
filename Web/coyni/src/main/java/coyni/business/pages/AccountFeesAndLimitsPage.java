package coyni.business.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AccountFeesAndLimitsPage extends BrowserFunctions {

	private By lblFeeHeading = By.xpath("");
//	private By lblDesc = By.xpath("//div[contains(@class,'grid grid-cols-[60%_minmax(40%,_1fr)]')]");
	private By btnNext = By.xpath("");
	private By lnkBack = By.xpath("");
	private By lnkExit = By.xpath("");
	private By chkBox = By.xpath("");
	//Business Settings - Account Fee and Limits
	private By lblHeading = By.xpath("//span[@data-ui-auto='accountfees_limits']");
//	private By lblDesc = By.xpath("//div[contains(@class,'grid grid-cols-[60%_minmax(40%,_1fr)]')]");
	private By viewAccountLimits = By.xpath("//div[contains(@class,'grid grid-cols-[60%_minmax(40%,_1fr)]')]");
	private By viewChange = By.xpath("//button[@data-ui-auto='viewchange_button']");
	private By hide = By.xpath("//button[text()='Hide']");
	private By newFeeStructure = By.xpath("//p[@data-ui-auto='newfee_structure']");
	private By close = By.xpath("//button[@class='self-end']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading: ", expHeading);
	}

	public void verifyFeeHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(newFeeStructure, "Heading: ", expHeading);
	}

	public void viewAccountFeeLimits() {
		List<WebElement> rows = getElementsList(viewAccountLimits, "Account Fee Limits");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}

	public void close() {
		click(close, "close");
	}

	public void clickViewChange() {
		click(viewChange, "view change");
	}

	public void clickHide() {
		click(hide, "Hide");
	}

	public void clickNext() {
		new CommonFunctions().verifyCursorAction(btnNext, "Next");
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Next Button is Disabled");
		}
	}

	public void viewFeeLimits() {
		String getFeeLimits = getText(viewAccountLimits, "Limits");
		ExtentTestManager.setPassMessageInReport(getFeeLimits);
	}

	public void clickBack() {
		click(lnkBack, "Back");
	}

	public void clickExit() {
		click(lnkExit, "Exit");
	}

	public void clickCheckBox() {
		click(chkBox, "Check Box");
	}

	public AgreementsPage agreementsPage() {
		return new AgreementsPage();
	}
}
