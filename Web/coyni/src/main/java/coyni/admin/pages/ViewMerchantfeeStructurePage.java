package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ViewMerchantfeeStructurePage extends BrowserFunctions {
	private By lblViewHeading = By.cssSelector(".rounded-full");
	private By lblFirstRowHeading = By
			.xpath("//div[contains(@class,'grid w-full h-10 grid-cols-3 bg-cm1 rounded-xl token_bar')]");
//	private By btnView = By.xpath(
//			"//button[contains(@class,'icon-button  icon-icon-View-Icon-and-Tooltip icon-View-Icon-and-Tooltip')]");
//	private By btnEdit = By.xpath("//div[contains(@class,'button-row-row show')]");

	private By getSideHeading(String eleName) {
		return By.xpath(
				String.format("//div[contains(@class,'card lvbcard')]//label[contains(text(),'%s')]", eleName));
	}
	public void verifyTokenAccount() {
		new CommonFunctions().elementView(getSideHeading("TOKEN ACCOUNT"), "TOKEN ACCOUNT");
	}
	public void verifyTransction() {
		new CommonFunctions().elementView(getSideHeading("TRANSCATION"), "TRANSCATION");
	}
	public void verifyOtherfees() {
		new CommonFunctions().elementView(getSideHeading("OTHER FEES"), "OTHER FEES");
	
	}

	public void verifyHeading(String expViewHeading) {
		new CommonFunctions().verifyLabelText(lblViewHeading, "expViewHeading", expViewHeading);
	}
	public void getDefaultFirstRowHeading() {
		String str = getText(lblFirstRowHeading, "FirstRowHeading");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	}
