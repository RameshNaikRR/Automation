package coyni_mobile_merchant.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class ReserveReleaseDetailsPage extends MobileFunctions {

	private By lblReserveDetail = MobileBy.xpath("//*[@text='Transaction Details']");

	private By txtAmount = MobileBy.xpath("//*[contains(@resource-id,'tvamount')]|//*[contains(@resource-id,'reserve_amount')]");

	private By txtReserveID = MobileBy.xpath("//*[contains(@resource-id,'tvReserveID')]|//*[contains(@resource-id,'reserveIDLL')]");

	private By lblStatus = MobileBy.xpath("//*[contains(@text,'Status')]/following-sibling::*[1]");

	private By lblDailyBatchIDs = MobileBy.xpath("//*[contains(@resource-id,'reserveIDTV')]");

	private By lblBatchDate = MobileBy.xpath("//*[contains(@text,'Batch Date')]/following-sibling::*[1]");

	private By lblReserveRule = MobileBy.xpath("//*[contains(@text,'Reserve Rule')]/following-sibling::*[1]");

	private By lblRecentTransactionsList = MobileBy
			.xpath("//*[@text='Recent Transactions']/../following-sibling::*[1]");

	private By txtAmountReleased = MobileBy.xpath("//*[contains(@resource-id,'releasedAMT')]");

	private By lblReleaseOn = MobileBy.xpath("//*[contains(@resource-id,'ReleasedDate')]|//*[contains(@resource-id,'released')]");

	private By lblReleaseTransactionID = MobileBy.xpath("//*[contains(@resource-id,'trans')]");

	private By lblToTokenAccount = MobileBy.xpath("//*[contains(@resource-id,'DBA')]");

	private By lblTransactionType = MobileBy.xpath("//*[contains(@resource-id,'head')]");

	private By lblReserveHeld = MobileBy.xpath("//*[contains(@text,'Reserve Held')]");

	private By lblHeldHeading = MobileBy.xpath("//*[contains(@text,'Still Being')]");

	private By lblHeldDescription = MobileBy.xpath("//*[contains(@resource-id,'HoldAmt')]");

	private By lblRecentTransaction = MobileBy.xpath("(//*[contains(@resource-id,'message')])[1]");

	private By lblNoTransactions = MobileBy.xpath("//*[contains(@resource-id,'MoreTransactions')]");
	
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'Mpayoutll')]|//*[contains(@resource-id,'btbankprevious')]|//*[contains(@resource-id,'Close')]|//*[contains(@resource-id,'close')]|//*[contains(@resource-id,'revious')]");

	public void clickBack() {
		click(btnBack, "Back");
	}
	
	public void verifyReserveDetail(String expHeading) {
		new CommonFunctions().verifyLabelText(lblReserveDetail, "Reserve Detail", expHeading);
	}

	public void verifyReserveDetails() {
		new CommonFunctions().elementView(lblReserveDetail, "Transaction Details");
//		new CommonFunctions().elementView(txtAmount, "Amount");
	}
	
	public void verifyReserveDetail() {
		new CommonFunctions().elementView(lblReleaseOn, "Reserve Detail");
		new CommonFunctions().elementView(txtReserveID, "Reserve ID");
	}
	
	public void getRecentTransactionsList() {
		List<WebElement> elementList = getElementList(lblRecentTransactionsList, " ");
		ExtentTestManager.setInfoMessageInReport("Recent Transactions List: " + elementList);

	}

	public void getReserveAmount() {
		ExtentTestManager.setInfoMessageInReport("Reserve Amount is " + getText(txtAmount));
	}

	public void getReserveID() {
		ExtentTestManager.setInfoMessageInReport("Reserve ID is " + getText(txtReserveID));
	}

	public void getStatus() {
		ExtentTestManager.setInfoMessageInReport("Status is " + getText(lblStatus));
	}

	public void getDailyBatchIDs() {
		String text = getText(lblDailyBatchIDs);
		ExtentTestManager.setInfoMessageInReport("Daily Batch ID is " + text);
	}

	public void getBatchDate() {
		String text = getText(lblBatchDate);
		ExtentTestManager.setInfoMessageInReport("Batch Date is " + text);
	}

	public void getReserveRule() {
		String text = getText(lblReserveRule);
		ExtentTestManager.setInfoMessageInReport("Reserve Rule is " + text);
	}

	public void getReserve() {
		String text = getText(txtAmountReleased);
		ExtentTestManager.setInfoMessageInReport("Reserve Amount is " + text);

	}

	public void getReserveReleasedDetails() {
		getReserveID();
		getTransactionType();
		getReserveAmount();
		getStatus();
		getDailyBatchIDs();
		getBatchDate();
		getReserveRule();
		getReserve();
		getReleaseOn();
		getReleaseTransactionID();
		getToTokenAccount();
		clickBack();
	}
	public void getReserveOnHoldDetails() {
		getTransactionType();
		getReserveID();
		getReserveHeld();
		getStatus();
		getDailyBatchIDs();
		getBatchDate();
		getReserveRule();
		getHeldHeading();
		getHeldDescription();
		clickBack();
	}

	public void getBuyTokenDetails() {
		getReserveID();
		getReserveAmount();
		getStatus();
		getDailyBatchIDs();
		getBatchDate();
		getReserveRule();
		getReserve();
		getReleaseOn();
		getReleaseTransactionID();
		getToTokenAccount();
	}

	public void verifyRecentTransaction() {
			new CommonFunctions().elementView(lblRecentTransaction, "Recent Transaction");
	}

	
	
	public void getTransactionType() {
		ExtentTestManager.setInfoMessageInReport("Transaction Type : " + getText(lblTransactionType));
	}

	public void getReserveHeld() {
		ExtentTestManager.setInfoMessageInReport("Reserve Held : " + getText(lblReserveHeld));
	}

	public void getHeldHeading() {
		ExtentTestManager.setInfoMessageInReport("Reserve Held : " + getText(lblHeldHeading));
	}

	public void getHeldDescription() {
		ExtentTestManager.setInfoMessageInReport("Reserve Held Description : " + getText(lblHeldDescription));
	}

	public void getReleaseOn() {
		ExtentTestManager.setInfoMessageInReport("Release On is " + getText(lblReleaseOn));
	}

	public void getReleaseTransactionID() {
		ExtentTestManager.setInfoMessageInReport("Release Transaction ID is " + getText(lblReleaseTransactionID));
	}

	public void getToTokenAccount() {
		ExtentTestManager.setInfoMessageInReport("To Token Account is " + getText(lblToTokenAccount));
	}

}