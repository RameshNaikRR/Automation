package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.FiltersComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class TransactionPage extends MobileFunctions {

	private By lblTransactions = MobileBy.xpath("//*[@text='Transactions']");

	private By searchOption = MobileBy.xpath("//*[contains(@resource-id,'searchET')]");

	private By filtersIcon = MobileBy.xpath("//*[contains(@resource-id,'filterIconIV')]");

	private By closeIcon = MobileBy.xpath("//*[contains(@resource-id,'closeBtnIV')]");

	private By lblMerchantAndeferenceID = MobileBy.xpath("//*[@text='Merchant’s Name/Reference ID.']");

	private By message = MobileBy.xpath("(//*[contains(@resource-id,'messageTV')])[3]");

	private By status = MobileBy.xpath("(//*[contains(@resource-id,'statusTV')])[3]");

	private By amount = MobileBy.xpath("(//*[contains(@resource-id,'amountTV')])[3]");

	public void verifyLabelTransactions(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactions, "Transactions", expHeading);
	}

	public void verifySearchOption() {
		new CommonFunctions().elementView(searchOption, "Search Option");
	}

	public void verifyFiltersIcon() {
		new CommonFunctions().elementView(filtersIcon, "Filters Icon");
	}

	public void verifyMerchantAndReferenceID() {
		new CommonFunctions().elementView(lblMerchantAndeferenceID, "Merchant & Reference ID");
	}

	public void verifyCloseView() {
		new CommonFunctions().elementView(closeIcon, "Close Icon");
	}

	public void verifyMessage() {
		new CommonFunctions().elementView(message, "message " + getText(message));
	}

	public void verifyAmount() {
		new CommonFunctions().elementView(amount, "amount " + getText(amount));
	}

	public void verifyStatus() {
		new CommonFunctions().elementView(status, "Status " + getText(status));
	}

	public FiltersComponent FiltersComponent() {
		return new FiltersComponent();
	}

}
