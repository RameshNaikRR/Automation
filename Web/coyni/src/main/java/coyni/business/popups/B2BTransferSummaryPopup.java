package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.business.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class B2BTransferSummaryPopup extends BrowserFunctions {

	private By lblB2BTransferSummaryHeading = By.xpath("");
	private By lblTransferAmount = By.xpath("");
	private By lblProcessingFee = By.xpath("");
	private By lblTotal = By.xpath("");
	private By btnConfirm = By.xpath("");
	private By backArrow = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyB2BTransferSummaryHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblB2BTransferSummaryHeading, "B2B Transfer Summary Heading is: ",
				expHeading);
	}

	public String verifyAmount() {
		String transferAmount = getText(lblTransferAmount, "Transfer Amount");
		ExtentTestManager.setInfoMessageInReport("Transfer Amount is: " + transferAmount);
		return transferAmount;
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
