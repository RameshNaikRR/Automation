package coyni.merchant.pages;

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
	private By getFeesCharges = By.xpath("//div[contains(@class,'MerchantFees_fees_container')]");
	private By getLables = By.xpath("//div[contains(@class,'MerchantFees_head')]/span");

	public void verifyFeesCharges(String type) {
		List<WebElement> rows = getElementsList(getFeesCharges, "percentage");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}

	public void verifyLabels() {
		List<WebElement> rows = getElementsList(getLables, "Lables");
		for (WebElement row : rows) {
			String replace = row.getText();
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
			break;
		}
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}
}
