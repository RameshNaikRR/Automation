package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ExportSelectedTransactionsPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("");
	private By lblDescription = By.xpath("");
	private By lnkExportPage = By.xpath("");
	private By btnSendTokens = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyHeading(String expHedaing) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading is: ", expHedaing);
	}

	public void verifyDescription(String expHeading) {
		new CommonFunctions().verifyLabelText(lblDescription, "Heading is: ", expHeading);
	}

	public void clickExportPage() {
		click(lnkExportPage, "Export Page");
	}

	public void clickSendTokens() {
		click(btnSendTokens, "Send Tokens");
	}

	public void clickClose() {
		click(crossClose, "Close");
	}

}
