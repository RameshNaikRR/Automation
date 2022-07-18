package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.merchant.popups.DeclineReserveRulePopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ApplicationApprovedReservedPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Vishnu Pavan Has Been Declined']");

	private By lblApproveddReservedDescription = By
			.xpath("//h1[text()='Vishnu Pavan Is Approved With Conditional Reserve Rule']");

	private By lblStatus = By.xpath("//span[contains(text(),'Requires Your ')]");

	private By merchnatApplicationTracker = By.xpath("(//div[@class='flex mt-3 h-2.5 justify-around'])[1]");

	private By lblAcceptReserve = By.xpath("//button[contains(text(),'Accept Reserve')]");

	private By lblDeclineReserve = By.xpath("//p[contains(text(),'Decline Reserve Rule')]");

	private By lblName = By.xpath("(//p[text()='Vishnu'])[1]");

	private By lblMonthlyVolume = By.xpath("//p[text()='Monthly Volume:']/following-sibling::*");

	private By lblHighTicket = By.xpath("//p[text()='High Ticket:']/following-sibling::*");

	private By lblReserveRule = By.xpath("//p[text()='Reserve Rule:']/following-sibling::*");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, Heading, "Heading");
	}

	public void verifyApprovedReserveDescription() {
		String text = getText(lblApproveddReservedDescription, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);
	}

	public void verifyStatus() {
		String text = getText(lblStatus, "Status");
		ExtentTestManager.setInfoMessageInReport("Status " + text);

	}

	public void verifyName() {
		String text = getText(lblName, "Name");
		ExtentTestManager.setInfoMessageInReport("Name " + text);

	}

	public void verifyMonthlyVolume() {
		String text = getText(lblMonthlyVolume, "Monthly Volume");
		ExtentTestManager.setInfoMessageInReport("Monthly Volume " + text);

	}

	public void verifyHighTicket() {
		String text = getText(lblHighTicket, "High Ticket");
		ExtentTestManager.setInfoMessageInReport("High Ticket " + text);

	}

	public void verifyReserveRule() {
		String text = getText(lblReserveRule, "Reserve Rule");
		ExtentTestManager.setInfoMessageInReport("Reserve Rule " + text);

	}

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	// added
	public void getMerchantTrackerApplication() {
		new CommonFunctions().verifyCursorAction(merchnatApplicationTracker, "Notification ");
	}

	public void verifyMouseHoverChangedColor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "SideBarItems", expCssProp, expValue,
				expColor);
	}

	public void clickAcceptReserve() {
		click(lblAcceptReserve, "Accept Reserve");
	}

	public void clickDeclineReserve() {
		click(lblDeclineReserve, "Decline Reserve");
	}

	public DeclineReserveRulePopup declinedReserveRulePopup() {
		return new DeclineReserveRulePopup();
	}

}
