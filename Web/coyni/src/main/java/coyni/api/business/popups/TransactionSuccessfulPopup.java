package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TransactionSuccessfulPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//div[.='Transaction Successful']");
	private By lblDescription = By.xpath("//h2[contains(@class,'TransferTokenModal_Pay')]");
	private By lblBorder = By.xpath("//hr[contains(@class,'border-1 border-cm2')]");
	private By btnDone = By.xpath("//button[.='Done']");
	private By getAccountDetails(String Number) {
		return By.xpath(String.format("(//div[contains(@class,'flex items-center justify-between')])[%s]", Number));
	}
	
//	private By lblReferenceID = By.xpath("(//div[contains(@class,'flex items-center justify-between')])[1]");
//	private By lblFromBalanceName = By.xpath("(//div[contains(@class,'flex items-center justify-between')])[2]");
//	private By lblToBalanceName = By.xpath("(//div[contains(@class,'flex items-center justify-between')])[3]");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}
	public void verifyDescriptionView() {
		new CommonFunctions().elementView(lblDescription, "Description");
	}
	public void VerifyReferenceIdView() {
		new CommonFunctions().elementView(getAccountDetails("1"), "ReferenceID");
	}
	public void verifyFromBalanceNameView() {
		new CommonFunctions().elementView(getAccountDetails("2"), "FromBalanceName");
	}

	public void verifyToBalanceNameView() {
		new CommonFunctions().elementView(getAccountDetails("3"), "ToBalanceName");
	}

	public void verifyDescription(String Description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", Description);
	}

	public void verifyBorder() {
		new CommonFunctions().elementView(lblBorder, "Border");
	}

	public void VerifyReferenceId() {
		new CommonFunctions().elementView(getAccountDetails("1"), "ReferenceID");
	}
	public void verifyFromBalanceName() {
		new CommonFunctions().elementView(getAccountDetails("2"), "FromBalanceName");
	}

	public void verifyToBalanceName() {
		new CommonFunctions().elementView(getAccountDetails("3"), "ToBalanceName");
	}
	public void clickDone() {
		click(btnDone, "Done");
	}

}
