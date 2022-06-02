package coyni_mobile_merchant.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class ReserveReleaseDetailsPage extends MobileFunctions {

	private By lblReserveDetail = MobileBy.xpath("//*[@text='Reserve Detail']");

	private By txtAmount = MobileBy.xpath("//*[contains(@resource-id,'tvamount')]");

	private By txtReserveID = MobileBy.xpath("//*[contains(@resource-id,'tvReserveID')]");

	private By lblStatus = MobileBy.xpath("//*[contains(@text,'Status')]/following-sibling::*[1]");

	private By lblDailyBatchIDs = MobileBy.xpath("//*[contains(@resource-id,'reserveIDTV')]");

	private By lblBatchDate = MobileBy.xpath("//*[contains(@text,'Batch Date')]/following-sibling::*[1]");

	private By lblReserveRule = MobileBy.xpath("//*[contains(@text,'Reserve Rule')]/following-sibling::*[1]");

	private By lblRecentTransactionsList = MobileBy
			.xpath("//*[@text='Recent Transactions']/../following-sibling::*[1]");

	private By txtReserve = MobileBy.xpath("//*[contains(@resource-id,'onHoldAmtTV')]");

	public void getRecentTransactionsList() {
		List<WebElement> elementList = getElementList(lblRecentTransactionsList, " ");
		ExtentTestManager.setInfoMessageInReport("Recent Transactions List: " + elementList);

	}

	public void getReserveAmount() {
		ExtentTestManager.setInfoMessageInReport("Reserve Amount " + getText(txtAmount));
	}

	public void getReserveID() {
		ExtentTestManager.setInfoMessageInReport("Reserve ID " + getText(txtReserveID));
	}

	public void getStatus() {
		ExtentTestManager.setInfoMessageInReport("Status " + getText(lblStatus));
	}

	public void getDailyBatchIDs() {
		String text = getText(lblDailyBatchIDs);
		ExtentTestManager.setInfoMessageInReport("Daily Batch ID is " + text);
	}

	public void getBatchDate() {
		String text = getText(lblBatchDate);
		ExtentTestManager.setInfoMessageInReport("Batch Date " + text);
	}

	public void getReserveRule() {
		String text = getText(lblReserveRule);
		ExtentTestManager.setInfoMessageInReport("Reserve Rule" + text);
	}

	public void getReserve() {
		String text = getText(txtReserve);
		ExtentTestManager.setInfoMessageInReport("Reserve Rule" + text);

	}

}