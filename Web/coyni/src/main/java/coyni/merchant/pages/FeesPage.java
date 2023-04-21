package coyni.merchant.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class FeesPage extends BrowserFunctions {
	CommonFunctions cf = new CommonFunctions();
	private By lblHeading = By.xpath("(//div[contains(@class,'BusinessSettings_page')]//span[.='Fees'])[2]");

	private By getFeesChargesLbl = By.xpath("//div[contains(@class,'AccountFees_fees_container__szs-L')]/span");
	private By getLables = By.xpath("//div[contains(@class,'MerchantFees_head')]/span");
	private By lbleCommereceAmount = By.xpath("//span[contains(text(),'Sale Order: eCommerce')]/following-sibling::*//span[contains(@class,'AccountFees_amount')]");

	public void verifyHeading(String Heading) {
		cf.verifyLabelText(lblHeading, "Heading", Heading);
	}

	
	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	public void verifyhandSymbolHighlightedFees(String cssProp, String expValue, String expColor) {
		click(getDashBoardItems("Fees"), "Fees");
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "Fees", cssProp, expValue,
				expColor);
	}
	
	public String geteCommerceProcessing() {
		String str = getText(lbleCommereceAmount, "eCommerce processing Amount");
		String str1 = str.replaceAll("[$]", "");
		return str1;
	}
	

	
	public void verifyFeesChargesLbl() {
		List<WebElement> rows = getElementsList(getFeesChargesLbl, "percentage");
		for (WebElement row : rows) {
			String ChargesLbl = row.getText();
			ExtentTestManager.setInfoMessageInReport(ChargesLbl + "   Label is Displayed");
//			String text = getText(getFeesChargesLbl, "Fees Details");
//			ExtentTestManager.setInfoMessageInReport(text);
		}
	}

	public void verifyLabelHeadings() {
		List<WebElement> rows = getElementsList(getLables, "Lables");
		for (WebElement row : rows) {
			String Lables = row.getText();
			ExtentTestManager.setInfoMessageInReport(Lables + "   Label is displayed");
		}
	}

}
