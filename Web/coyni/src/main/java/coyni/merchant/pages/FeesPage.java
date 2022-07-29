package coyni.merchant.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class FeesPage extends BrowserFunctions {
	CommonFunctions cf = new CommonFunctions();
	private By lblHeading = By.xpath("//div[contains(@class,'BusinessSettings_page')]//span[.='Fees']");

	private By getFeesChargesLbl = By.xpath("//div[contains(@class,'MerchantFees_fees_container')]/span");
	private By getLables = By.xpath("//div[contains(@class,'MerchantFees_head')]/span");

	public void verifyHeading(String Heading) {
		cf.verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyFeesChargesLbl() {
		List<WebElement> rows = getElementsList(getFeesChargesLbl, "percentage");
		for (WebElement row : rows) {
			String ChargesLbl = row.getText();
			ExtentTestManager.setInfoMessageInReport(ChargesLbl + "   Label is Displayed");
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
