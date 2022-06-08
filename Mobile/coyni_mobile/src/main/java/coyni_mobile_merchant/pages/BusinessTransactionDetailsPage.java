package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class BusinessTransactionDetailsPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'ll_dashboard_tab')]");
	private By lblAmount = MobileBy.xpath("//*[contains(@text,'Merchant Balance')]/following-sibling::*[2]");
	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'bankheader')]");
	private By lblStatus = MobileBy.xpath("//*[contains(@resource-id,'Status')]");
	private By lblDate = MobileBy.xpath("//*[contains(@resource-id,'Date')]");
	private By lblPurchaseAmount = MobileBy.xpath("//*[contains(@resource-id,'purchase')]");
	private By lblProcessingFee = MobileBy.xpath("//*[contains(@resource-id,'processing')]");
	private By lblTotalAmout = MobileBy.xpath("//*[contains(@resource-id,'Total')]");
	private By lblDepositID = MobileBy.xpath("//*[contains(@resource-id,'DepositIDTV')]");
	private By lblReferenceID = MobileBy.xpath("//*[contains(@resource-id,'RefidTV')]");
	private By lblDescriptorName = MobileBy.xpath("//*[contains(@resource-id,'Descrptor')]");
	private By lblNameOnAccount = MobileBy.xpath("//*[contains(@resource-id,'banknameAC')]");
	private By lblBankName = MobileBy.xpath("//*[contains(@resource-id,'banknameTV')]");
	private By lblBankAccount = MobileBy.xpath("//*[contains(@resource-id,'bankaccount')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, expHeading, "Business Token Account");
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, expDescription, "Business Token Account");
	}

	public void getStatus() {
//		scrollDownToElement(lblTotalAmount, "Total Availble Funds : ");
		ExtentTestManager.setInfoMessageInReport("Status : " + getText(lblStatus));

	}

	public void getTransactionAmount() {
		// scrollDownToElement(lblSaleOrderDetails, "Sale Order");
		ExtentTestManager.setInfoMessageInReport("Transaction Amount" + getText(lblAmount));
	}

	public void getDate() {
		ExtentTestManager.setInfoMessageInReport("Date" + getText(lblDate));
	}

	public void getPurchaseAmount() {
		ExtentTestManager.setInfoMessageInReport("Purchase Amount" + getText(lblPurchaseAmount));
	}

	public void getProcessingFee() {
		ExtentTestManager.setInfoMessageInReport("Processing Fee" + getText(lblProcessingFee));
	}

	public void getTotalAmout() {
		ExtentTestManager.setInfoMessageInReport("Total Amout" + getText(lblTotalAmout));
	}

	public void getDepositID() {
		ExtentTestManager.setInfoMessageInReport("Deposit ID" + getText(lblDepositID));
	}

	public void getReferenceID() {
		ExtentTestManager.setInfoMessageInReport("Reference ID" + getText(lblReferenceID));
	}

	public void getDescriptorName() {
		ExtentTestManager.setInfoMessageInReport("Descriptor Name" + getText(lblDescriptorName));
	}

	public void getNameOnAccount() {
		ExtentTestManager.setInfoMessageInReport("Name On Account" + getText(lblNameOnAccount));
	}

	public void getBankName() {
		scrollDownToElement(lblBankName, "Bank Name");
		ExtentTestManager.setInfoMessageInReport("Bank Name" + getText(lblBankName));
	}

	public void getBankAccount() {
		scrollDownToElement(lblBankAccount, "Bank Account");
		ExtentTestManager.setInfoMessageInReport("Bank Account" + getText(lblBankAccount));
	}

}
