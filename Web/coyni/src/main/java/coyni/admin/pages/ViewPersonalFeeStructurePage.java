package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.SideBarComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ViewPersonalFeeStructurePage extends BrowserFunctions {
	private By lblViewHeading = By.xpath("//span[text()='View Personal Fee Structure']");
	private By lblFirstRowHeading = By
			.xpath("//span[text()='Pay / Request']");
	private By btnBack = By.xpath("//button[text()='Back']");

	private By getSideHeading(String HeadingNum) {
		return By.xpath(String.format("(//span[contains(@class,'font-bold text-cgy8')])[%s]", HeadingNum));
	}

	public void verifyWithdrawals() {
		new CommonFunctions().elementView(getSideHeading("1"), "Withdrawals");
	}

	public void verifyBuyToken() {
		new CommonFunctions().elementView(getSideHeading("2"), "BuyToken");
	}

	public void verifyDispute() {
		new CommonFunctions().elementView(getSideHeading("3"), "Dispute");
	}

	public void verifyHeading(String expViewHeading) {
		new CommonFunctions().verifyLabelText(lblViewHeading, "expViewHeading", expViewHeading);
	}

	public void clickbtnBack() {
		click(btnBack, "Back");
	}

	public void getDefaultFirstRowHeading() {
		String str = getText(lblFirstRowHeading, "FirstRowHeading");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public SideBarComponent sideBarComponent() {
		return new SideBarComponent();
	}
}
