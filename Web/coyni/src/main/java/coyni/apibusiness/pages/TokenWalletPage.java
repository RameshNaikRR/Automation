package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TokenWalletPage extends BrowserFunctions {

	private By lblHeading = By
			.xpath("//h3[@class='text-cgy4 tracking-wide Heading_heading3__3l6XX font-bold text-cm3']");
	private By walletamount = By.xpath("//span[@class='font-bold cursor-default text-cgy4 text-5xl']");
	private By lblcurrency = By.xpath("//span[@class='ml-1 text-2xl font-semibold text-cgy2']");

	public void getWalletBalance() {
		ExtentTestManager.setInfoMessageInReport("Withdraw Amount is " + getElement(walletamount, "Available Balance"));

	}

	public void verifyCurrencyView() {
		new CommonFunctions().elementView(lblcurrency, "Coyni");
	}

	public void verifyTokenWalletBalanceView(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Token Wallet Balance", expHeading);
	}
}
