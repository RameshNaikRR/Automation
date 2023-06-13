package coyni.admin.MerchantServicespopups;

import org.openqa.selenium.By;

import coyni.business.components.ToastComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ApproveCasePopup extends BrowserFunctions {

	private By heading = By.xpath("//h1[text()='Approve Case']");
	private By lblDescription = By.xpath("//p[contains(@class,'description-title')]");
	private By btnYes = By.xpath("//button[text()='Yes']");
	private By btnNoGoBack = By.xpath("//div[text()='No, go back']");
	private By btnConfirm = By.xpath("//button[text()='Confirm']");
	private By btnApproveConditions = By.xpath("//input[@type='checkbox']/..");
	private By txtResrverAmount = By.xpath("//input[@id='amountPerTransaction']");
	private By txtReservePeriod = By.xpath("//input[@id='period']");
	private By txtReason = By.xpath("//textarea[@name='reason']");

	public void verifyHeading() {
		new CommonFunctions().elementView(heading, "Heading");
	}

	public void enterReserveAmount(String reserveAmount) {
		enterText(txtResrverAmount, reserveAmount, "Resrve Amount");
	}

	public void enterReservePeriod(String reservePeriod) {
		enterText(txtReservePeriod, reservePeriod, "Reserve Period");
	}

	public void enterReason(String reason) {
		enterText(txtReason, reason, "Reason");
	}

	public void verifyDescription() {
		new CommonFunctions().elementView(lblDescription, "Description");
	}

	public void clickApproveConditions() {
		click(btnApproveConditions, "Approve Conditions");
	}

	public String verifyCaseNumber() {
		String str = getText(lblDescription, "Description");
		String str1 = str.replaceAll("[^0-9]", "");
		ExtentTestManager.setInfoMessageInReport("the case number is " + str1);
		return str1;
	}

	public void clickYes() {
		click(btnYes, "Yes");
	}

	public void clickNoGoBack() {
		click(btnNoGoBack, "No Go back");
	}

	public ToastComponent toastComponet() {
		return new ToastComponent();
	}

	public void clickConfirm() {
		click(btnConfirm, "Confirm");
	}
}
