package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AccountFeesAndLimitsPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[@data-ui-auto='account_fees_limits']");
	private By lblDes = By.xpath("//p[@data-ui-auto='please_review_agree']");
	private By btnNext = By.xpath("//button[@data-ui-auto='next_button']");
	private By lnkBack = By.xpath("//button[@data-ui-auto='back_button']");
	private By lnkExit = By.xpath("");
	private By chkBox = By.xpath("//input[@data-ui-auto='checkbox']");
	private By viewAccountLimits = By.xpath("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading is: ", expHeading);
	}

	public void verifyDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblDes, "Description is: ", expDes);
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
