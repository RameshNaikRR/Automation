package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.admin.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawToSignetPreviewPopup extends BrowserFunctions {
	public By lblHeading = By.xpath("//h1[text()='Withdraw to Signet Account']");
	public By lblAmount = By.cssSelector(".WithdrawToSignet_amount__3EkcQ ");
	// public By lblWithdrawAmount = By.xpath("//span[text()='Withdraw Amount']");
	// public By lblSignetAccount = By.xpath("");
	// public By lblProcessingFee = By.xpath("//span[text()='Processing Fee']");
	// public By lblTotal = By.xpath("//span[text()='Total']");
	public By btnConfirm = By.xpath("//button[text()='Confirm']");
	public By btnDelete = By.xpath("//img[@class='cursor-pointer']");

	public By getLabelItem(String Type) {
		return By.xpath(String.format("//span[text()='%s']//following-sibling::span", Type));
	}

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Withdraw to signet Heading", expHeading);
	}

	public void verifyAmount(String amount) {
		new CommonFunctions().verifyLabelText(lblAmount, "Amount", amount);
	}

	public void getWithdrawAmount() {
		ExtentTestManager.setInfoMessageInReport("Withdraw Amount is " + getText(getLabelItem("Withdraw Amount"), ""));
	}

	public void getProcessingFee() {
		ExtentTestManager.setInfoMessageInReport("Processing Fee is " + getText(getLabelItem("Processing Fee"), ""));
	}

	public void getTotal() {
		ExtentTestManager.setInfoMessageInReport("Total is " + getText(getLabelItem("Total"), ""));
	}

	public void clickConfirm() {
		click(btnConfirm, "Click on Confirm");
	}

	public void clickDelete() {
		click(btnDelete, "Click on Delete");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
}
