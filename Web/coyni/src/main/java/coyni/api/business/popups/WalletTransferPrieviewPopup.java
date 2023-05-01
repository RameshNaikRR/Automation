package coyni.api.business.popups;

import java.sql.SQLException;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class WalletTransferPrieviewPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[.='Wallet Transfer Preview']");
	private By btnConfirm = By.xpath("//button[.='Confirm']");

	private By lblAmount = By.xpath("//p[@class='TransferTokenModal_amount__Fl4AQ']");

	private By getLblItems(String elementName) {
		return By.xpath(String.format(elementName, "//span[text()='%s']//following-sibling::span"));
	}

	public void VerifyTransferFromView() {
		new CommonFunctions().elementView(getLblItems("Transferring from:"), "Transferring from");
	}

	public void verifyTransferToView() {
		new CommonFunctions().elementView(getLblItems("Transferring to:"), "Transferring to");
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyWalletTransferPreviewPopupHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", heading);
	}

	public void verifyAmount() {
		String str = getText(lblAmount, "Amount");
		ExtentTestManager.setPassMessageInReport(str);
		ExtentTestManager.setInfoMessageInReport("Amount is verified");
	}

	public String getAmount() {
		String str = getText(lblAmount, "Amount");
		return str;
	}

	public void getVerifiedAmount(String query) throws SQLException {

		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getAmount());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport("Amount is matched ");
		} else {
			ExtentTestManager.setFailMessageInReport("Amount is not matched");
		}
	}

	public void clickConfirm() {
		click(btnConfirm, "Confirm");
	}

	public VerifyYourIdentityPopup verifyYourIdentityPopup() {
		return new VerifyYourIdentityPopup();
	}
}
