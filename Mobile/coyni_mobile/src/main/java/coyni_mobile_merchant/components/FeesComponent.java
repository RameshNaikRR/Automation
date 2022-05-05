package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class FeesComponent extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("");
	private By lblTransactions = MobileBy.xpath("");
	private By lblTokenAccount = MobileBy.xpath("");
	private By lblBuyToken = MobileBy.xpath("");
	private By lblOtherFees = MobileBy.xpath("");
	private By lblExternalBankAccount = MobileBy.xpath("");
	private By lblInstantPay = MobileBy.xpath("");
	private By lblSignetAccount = MobileBy.xpath("");
	private By lblGiftCard = MobileBy.xpath("");
	private By lblFailedBankWithdraw = MobileBy.xpath("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Page Heading", expHeading);
	}

	public void verifyTransactionsLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactions, "Label", expHeading);
	}

	public void verifyTokenAccountLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTokenAccount, "Label", expHeading);
	}

	public void verifyBuyTokenLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBuyToken, "Label", expHeading);
	}

	public void verifyExternalBankAccountLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblExternalBankAccount, "Label", expHeading);
	}

	public void verifyInstantPayLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblInstantPay, "Label", expHeading);
	}

	public void verifySignetAccountLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSignetAccount, "Label", expHeading);
	}

	public void verifyGiftCardLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblGiftCard, "Label", expHeading);
	}

	public void verifyFailedBankWithdrawLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblFailedBankWithdraw, "Label", expHeading);
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
