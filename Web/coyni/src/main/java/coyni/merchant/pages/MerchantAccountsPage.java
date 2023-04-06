package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.merchant.popups.LeaveMerchantAccountPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class MerchantAccountsPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[.='Merchant Accounts']");

	private By btnSettings = By.xpath("//button[contains(@class,'icon-settings-gear-icon cursor-p')]");

	private By btnGoToMerchant = By
			.xpath("(//button[contains(@class,'hover:text-cgy4 ')])[3]");

	private By btnDelete = By.xpath("//div[@data-tip='Leave Account']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Merchant Accounts page", expHeading);
	}

	public void clickSettings() {
		click(btnSettings, "Settings");
	}

	public void clickDelete() {
		scrollToElement(btnDelete, "Delete");
		click(btnDelete, "Delete");
	}

	public void clickGoToMerchant() {
		click(btnGoToMerchant, "Merchant");
	}

	public LeaveMerchantAccountPopup leaveMerchantAccountPopup() {
		return new LeaveMerchantAccountPopup();
	}
}
