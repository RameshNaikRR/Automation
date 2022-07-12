package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class EditPersonalFeeStructurePage extends BrowserFunctions {
	private By lblHeading = By.xpath("//span[text()='Edit Personal Fee Structure']");
	private By lblFirstRowHeading =By.xpath("//div[contains(@class,'grid w-full h-10 grid-cols-4 bg-cm1 rounded-xl')]");
	private By lnkEdit = By.xpath("//a[text()='Edit All']");
	private By getSideHeading(String HeadingNum) {
		return By.xpath(String.format("(//span[contains(@class,'font-bold text-cgy8')])[%s]", HeadingNum));
	}
	public void verifyWithdrawals() {
		new CommonFunctions().elementView(getSideHeading("1"),"Withdrawals");
	}
	public void verifyBuyToken() {
		new CommonFunctions().elementView(getSideHeading("2"),"BuyToken");
	}
	public void verifyDispute() {
		new CommonFunctions().elementView(getSideHeading("3"),"Dispute");
	}
	
	public void clickEdit() {
		new CommonFunctions().elementView(lnkEdit, "edit");
		click(lnkEdit, "edit");
	}

	public void verifyHeading(String expEditHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "expEditHeading", expEditHeading);
	}

	public void getFirstRowHeading() {
		String str = getText(lblFirstRowHeading, "FirstRowHeading");
		ExtentTestManager.setInfoMessageInReport(str);

	}

}
