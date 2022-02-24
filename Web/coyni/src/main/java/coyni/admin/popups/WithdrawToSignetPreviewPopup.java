package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawToSignetPreviewPopup extends BrowserFunctions {
	public By lblHeading = By.xpath("//h1[text()='Withdraw to Signet Account']");
	public By lblAmount = By.xpath("//input[@id='amount']");
	public By lblWithdrawAmount = By.xpath("//span[text()='Withdraw Amount']");
	public By lblSignetAccount = By.xpath("");
	public By lblProcessingFee = By.xpath("//span[text()='Processing Fee']");
	public By lblTotal = By.xpath("//span[text()='Total']");
	public By btnConfirm = By.xpath("//button[text()='Confirm']");
	public By btnDelete = By.xpath("//img[@class='cursor-pointer']");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Withdraw to signet Heading", expHeading);
	}

	public void verifyAmount(String amount) {
		new CommonFunctions().verifyLabelText(lblAmount, "Amount", amount);
	}

	public void getWithdrawAmount() {
		ExtentTestManager
				.setInfoMessageInReport("Withdraw Amount is " + getElement(lblWithdrawAmount, "Withdraw Amount"));
	}

	public void getSignetAccount() {
		ExtentTestManager
				.setInfoMessageInReport("Withdraw Amount is " + getElement(lblSignetAccount, "Signet Account"));
	}

	public void getProcessingFee() {
		ExtentTestManager.setInfoMessageInReport("Processing Fee is " + getElement(lblProcessingFee, "Processing Fee"));
	}

	public void getTotal() {
		ExtentTestManager.setInfoMessageInReport("Total is " + getElement(lblTotal, "Total"));
	}

	public void clickConfirm() {
		click(btnConfirm, "Click on Confirm");
	}

	public void clickDelete() {
		click(btnDelete, "Click on Delete");
	}

}
