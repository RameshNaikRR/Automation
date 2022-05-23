package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.AccountTableComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class FeeStructurePage extends BrowserFunctions {
	private By lblHeading = By.xpath("//span[text()='Fee Structure']");
	private By lnkPersonal = By.xpath("//div[text()='Personal']");
	private By lnkMerchant = By.xpath("//div[text()='Merchant']");
	private By btnView = By.xpath("//button[contains(@class,'icon-button')]");
	private By btnEdit = By.xpath("//button[contains(@class,'icon-edit')]");
	private By lblInactive = By.xpath("(//div[text()='Inactive'])[1]");
	private By lblActive = By.xpath("//div[text()='Active'])[1]");
	private By lblCancelled = By.xpath("//div[text()='Cancelled'])[1]");
	private By lblScheduled = By.xpath("//div[text()='Scheduled'])[1]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "expHeading", expHeading);
	}

	public void clickPersonal() {
		click(lnkPersonal, "personal");

	}

	public void clickMerchant() {
		click(lnkMerchant, "merchant");
	}

	public void clickView() {
		click(btnView, "view");
	}

	public void clickEdit() {
		click(btnEdit, "edit");
	}

	public AccountTableComponent accountTableComponent() {
		return new AccountTableComponent();
	}

	public void statusView() {

		if (verifyElementDisplayed(lblInactive, "Inactive")) {
			ExtentTestManager.setInfoMessageInReport("Status is Inactive displayed");
		}

		else if (verifyElementDisplayed(lblActive, "Active")) {
			ExtentTestManager.setInfoMessageInReport("Status is Inactive displayed");
		} else if (verifyElementDisplayed(lblCancelled, "Cancelled")) {
			ExtentTestManager.setInfoMessageInReport("Status is Cancelled displayed");
		} else if (verifyElementDisplayed(lblScheduled, "Scheduled")) {
			ExtentTestManager.setInfoMessageInReport("Status is Scheduled displayed");
		} else {
			ExtentTestManager.setInfoMessageInReport("Status is not displayed");
		}

	}

	public ViewPersonalFeeStructurePage viewPersonalFeeStructurePage() {
		return new ViewPersonalFeeStructurePage();
	}

	public EditPersonalFeeStructurePage editPersonalFeeStructurePage() {
		return new EditPersonalFeeStructurePage();
	}

	public ViewMerchantfeeStructurePage viewMerchantfeeStructurePage() {
		return new ViewMerchantfeeStructurePage();
	}

	public EditMerchantFeeStructurePage editMerchantFeeStructurePage() {
		return new EditMerchantFeeStructurePage();
	}
}