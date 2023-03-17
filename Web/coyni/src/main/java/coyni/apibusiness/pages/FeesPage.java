package coyni.apibusiness.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class FeesPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//div[contains(@class,'BusinessSettings_page')]//span[.='Fees']");
//	private By getFeesCharges(String feesCharges) {
//		return By.xpath(String.format("(//div[contains(@class,'MerchantFees_fees_container')])[1]", feesCharges));
//	}
	private By lbltxtYourFees = By.xpath("//p[@class='YourFees_side_heading__s+OYC mt-4']");
	private By btnYourFees = By.xpath("//span[text()='Your Fees']");
	private By yourFeesLableHeadings = By.xpath("//div[@class='YourFees_topLabel__YD8jW']");
	private By txtYourFeesCharges = By.xpath("//div[@class='YourFees_fees__xtUwS']");
	private By txtYourFeesLables = By.xpath("//div[@class='YourFees_h650__XQ29t flex flex-col']/div");
	private By btnUserFees = By.xpath("//span[text()='User Fees']");
	private By lbltxtUserFeesHeading = By.xpath("//p[@class='UserFees_side_heading__F6oHd mt-4']");
	private By txtUserFeesCharges = By.xpath("//div[@class='UserFees_fees__Jnu-p']");
	private By txtUserFeesLables = By.xpath("//div[@class='YourFees_h650__XQ29t flex flex-col']/div");
	private By txtUserFeesLableHeadings = By.xpath("//div[@class='UserFees_topLabel__h57y0']");

	public void clickYourFees() {
		new CommonFunctions().verifyCursorAction(btnYourFees, "User Fees");
		String str = getElement(btnYourFees, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(btnYourFees, "yourLimits");
	}

	public void verifyFeesHeading(String FeesHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "FeesHeading", FeesHeading);
	}

	public void verifyYourFeesHeading(String YourFeesHeading) {
		new CommonFunctions().verifyLabelText(lbltxtYourFees, "YourFeesHeading", YourFeesHeading);
	}

	public void verifyYourLimitsLableHeadings() {
		List<WebElement> rows = getElementsList(yourFeesLableHeadings, "topLables");
		for (WebElement row : rows) {
			String text = row.getText();
			ExtentTestManager.setInfoMessageInReport(text + " is Displayed");

		}
	}

	public void verifyYourFeesCharges() {
		List<WebElement> rows = getElementsList(txtYourFeesCharges, "percentage");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}

	public void verifyYourFeesLabels() {
		List<WebElement> rows = getElementsList(txtYourFeesLables, "Lables");
		for (WebElement row : rows) {
			String text = row.getText();
			ExtentTestManager.setInfoMessageInReport(text + " is Displayed");
		}
	}

	public void clickUserFees() {
		new CommonFunctions().verifyCursorAction(btnUserFees, "User Fees");
		String str = getElement(btnUserFees, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(btnUserFees, "UserFees");
	}

	public void verifyUserFeesHeading(String UserLimitsHeading) {
		new CommonFunctions().verifyLabelText(lbltxtUserFeesHeading, "UserLimitsHeading", UserLimitsHeading);
	}

	public void verifyUserFeesLabels() {
		List<WebElement> rows = getElementsList(txtUserFeesLables, "Lables");
		for (WebElement row : rows) {
			String text = row.getText();
			ExtentTestManager.setInfoMessageInReport(text + " is Displayed");
		}
	}

	public void verifyUserFeesLableHeadings() {
		List<WebElement> rows = getElementsList(txtUserFeesLableHeadings, "UserFeesTopLables");
		for (WebElement row : rows) {
			String text = row.getText();
			ExtentTestManager.setInfoMessageInReport(text + " is Displayed");

		}
	}

	public void verifyUserFeesCharges() {
		List<WebElement> rows = getElementsList(txtUserFeesCharges, "UserFeesCharges");
		for (WebElement row : rows) {
			String text = row.getText();
			ExtentTestManager.setInfoMessageInReport(text + " is Displayed");
		}
	}
}
