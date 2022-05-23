package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class EditMerchantFeeStructurePage extends BrowserFunctions {
	private By lblHeading = By.xpath("//span[text()='Edit Merchant Fee Structure']");
	private By lblFirstRowHeading = By.className("rounded-full");

	private By getSideHeading(String HeadingNum) {
		return By.xpath(String.format("(//label[contains(@class,'text-cm3')])[%s]", HeadingNum));
	}

	public void verifyTranscation() {
		new CommonFunctions().elementView(getSideHeading("1"), "TRANSCATION");
	}

	public void verifyTokenAccount() {
		new CommonFunctions().elementView(getSideHeading("2"), "TOKENACCOUNT");
	}

	public void verifyOtherfees() {
		new CommonFunctions().elementView(getSideHeading("3"), "OTHERFEES");
	}

	public void verifyHeading(String expEditHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "expEditHeading", expEditHeading);
	}

	public void getFirstRowHeading() {
		String str = getText(lblFirstRowHeading, "FirstRowHeading");
		ExtentTestManager.setInfoMessageInReport(str);

	}

}
