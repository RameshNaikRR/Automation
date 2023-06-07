package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.business.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawSummaryPopup extends BrowserFunctions {

	private By lblWithdrawSummaryHeading = By.xpath("");
	private By lblAmount = By.xpath("");
	private By lblProcessingFee = By.xpath("");
	private By lblTotal = By.xpath("");
	private By btnConfirm = By.xpath("");
	private By backArrow = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyWithdrawSummaryHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdrawSummaryHeading, "Withdraw Summary Heading is: ", expHeading);
	}

	public String verifyAmount() {
		String withdrawalAmount = getText(lblAmount, "Deposit Amount");
		ExtentTestManager.setInfoMessageInReport("Deposit Amount is: " + withdrawalAmount);
		return withdrawalAmount;
	}

	public String verifyProcessingFee() {
		String precessingFee = getText(lblProcessingFee, "Processing Fee");
		ExtentTestManager.setInfoMessageInReport("Processing Fee is: " + precessingFee);
		return precessingFee;
	}

	public String verifyTotal(String total) {
		String totalAmount = getText(lblTotal, "Total");
		ExtentTestManager.setInfoMessageInReport("Total is: " + totalAmount);
		return totalAmount;
	}

	public void clickClose() {
		new CommonFunctions().verifyCursorAction(crossClose, "Close");
		click(crossClose, "Close");
	}

	public void clickBackArrow() {
		new CommonFunctions().verifyCursorAction(backArrow, "Back Arrow");
		click(backArrow, "Back Arrow");
	}

	public void clickConfirm() {
		new CommonFunctions().verifyCursorAction(btnConfirm, "Confirm");
		if (getElement(btnConfirm, "Confirm").isEnabled()) {
			click(btnConfirm, "Confirm");
			ExtentTestManager.setPassMessageInReport("Confirm Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Confirm Button is Disabled");
		}
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

}
