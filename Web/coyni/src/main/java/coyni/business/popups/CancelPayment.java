package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CancelPayment extends BrowserFunctions {
	private By heading = By.xpath("");
	private By payee = By.xpath("");
	private By ACHAmount = By.xpath("");
	private By clickCancelPayment = By.xpath("");
	private By goback = By.xpath("");
	private By close = By.xpath("");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(heading, "Heading is :", Heading);
	}

	public void getPayee() {
		String str = getText(payee, "Payee");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void getACHAmount() {
		String str = getText(ACHAmount, "ACHAmount");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void clickCancel() {
		click(clickCancelPayment, "Cancel Payment");
	}

	public void clickGoback() {
		click(goback, "Goback");
	}

	public void close() {
		click(close, "close");
	}
}
