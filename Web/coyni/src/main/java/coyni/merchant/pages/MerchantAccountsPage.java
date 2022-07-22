package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class MerchantAccountsPage extends BrowserFunctions {

	private By lblHeading = By.xpath("(//span[.='Merchant Accounts'])[2]");

	private By btnSettings = By
			.xpath("//button[@class='p-0.5 icon-settings-gear-icon cursor-pointer text-cgy3 hover:text-cgy4  ']");

	private By btnGoToMerchant = By
			.xpath("//button[@class='p-0.5 icon-go-into cursor-pointer mr-5 text-cgy3 hover:text-cgy4 ']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Merchant Accounts page", expHeading);
	}

	public void clickSettings() {
		click(btnSettings, "Settings");
	}

	public void clickGoToMerchant() {
		click(btnGoToMerchant, "Merchant");
	}
}
