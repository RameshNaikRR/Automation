package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class PayoutTransactionDetailsPage extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[contains(@text,'Payout Details')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'recent')]");
	private By lblTransactionType = MobileBy.xpath("//*[contains(@resource-id,'payoutId')]");
	private By lblAmount = MobileBy.xpath("//*[contains(@resource-id,'payoutIDAmount')]");
	private By lblStatus = MobileBy.xpath("//*[contains(@resource-id,'payoutStatus')]");
	private By lblPayoutID = MobileBy.xpath("//*[contains(@resource-id,'PayoutId')]");
	private By lblPayoutReferenceID = MobileBy.xpath("//*[contains(@resource-id,'payoutRefIdTV')]");
	private By lblPayoutDate = MobileBy.xpath("//*[contains(@resource-id,'payoutIDdate')]");
	private By lblToTokenAccount= MobileBy.xpath("//*[contains(@resource-id,'payoutTokenId')]");
	private By lblReserveID= MobileBy.xpath("//*[contains(@resource-id,'ReserveId')]");
	private By lblRecentTransaction = MobileBy.xpath("(//*[contains(@resource-id,'message')])[1]");
	private By lblNoTransactions = MobileBy.xpath("//*[contains(@resource-id,'noTransactions')]");


//	private By lblNameOnAccount = MobileBy.xpath("//*[contains(@resource-id,'banknameAC')]");
//	private By lblBankName = MobileBy.xpath("//*[contains(@resource-id,'banknameTV')]");
//	private By lblBankAccount = MobileBy.xpath("//*[contains(@resource-id,'bankaccount')]");
//	private By lblPurchaseAmount = MobileBy.xpath("//*[contains(@resource-id,'purchase')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading,"Payout Details Heading ", expHeading);
	}

	public void getTransactionType() {
//		scrollDownToElement(lblTotalAmount, "Total Availble Funds : ");
		ExtentTestManager.setInfoMessageInReport("Transaction Type : " + getText(lblTransactionType));

	}

	public void getAmount() {
//		scrollDownToElement(lblTotalAmount, "Total Availble Funds : ");
		ExtentTestManager.setInfoMessageInReport("Amount : " + getText(lblAmount));

	}

	public void getStatus() {
		ExtentTestManager.setInfoMessageInReport("Status : " + getText(lblStatus));

	}
	public void getPayoutID() {
		// scrollDownToElement(lblSaleOrderDetails, "Sale Order");
		ExtentTestManager.setInfoMessageInReport("Payout ID : " + getText(lblPayoutID));
	}

	public void getPayoutReferenceID() {
		ExtentTestManager.setInfoMessageInReport("Payout Reference ID : " + getText(lblPayoutReferenceID));
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", expDescription);

	}

	public void getPayoutDate() {
		ExtentTestManager.setInfoMessageInReport("Payout Date : " + getText(lblPayoutDate));
	}

	public void getToTokenAccount() {
		ExtentTestManager.setInfoMessageInReport("To Token Account : " + getText(lblToTokenAccount));
	}

	public void getReserveID() {
		ExtentTestManager.setInfoMessageInReport("Reserve ID : " + getText(lblReserveID));
	}
	
	public void verifyRecentTransaction() {
		if (DriverFactory.getDriver().findElements(lblNoTransactions).size() == 0) {
		new CommonFunctions().elementView(lblRecentTransaction, "Recent Transaction");
		} else {
			ExtentTestManager.setInfoMessageInReport("You Have No Transactions");
	}
	}
	public void getPayoutTransactionAllDetails() {
		getTransactionType();
		getPayoutID();
		getAmount();
		getStatus();
		getPayoutDate();
		getPayoutReferenceID();
		getToTokenAccount();
		getReserveID();
		verifyRecentTransaction();
	}
}
