package coyni.merchant.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AccountLimitsPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//div[contains(@class,'BusinessSettings_page')]//span[.='Account Limits']");
	private By getLbls = By.xpath("//div[contains(@class,'flex items-center')]/p");
	private By getDailyLimitLbl = By
			.xpath("//div[contains(@class,'MerchantLimits_border')]/..//div[contains(@class,'flex')]/span");

//	private By getLableValues = By.xpath(
//			"//div[contains(@class,'MerchantLimits_border')]/..//div[contains(@class,'flex')]/span/following-sibling::p");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyLables() {
		List<WebElement> lists = getElementsList(getLbls, "");
		for (WebElement list : lists) {
			String text = list.getText();
			ExtentTestManager.setInfoMessageInReport(text + " Label is displayed");

		}
	}

	public void verifyAccountLimits() {
		List<WebElement> lists = getElementsList(getDailyLimitLbl, "");
		for (WebElement list : lists) {
			String text = list.getText();
			ExtentTestManager.setInfoMessageInReport(text + " Label is displayed");
			String value = getText(By.xpath(String.format("//span[text() = '%s']/following-sibling::p", text)), "");
			ExtentTestManager.setInfoMessageInReport(text + " label value is " + value);
			String labelStatus = getText(
					By.xpath(String.format("(//span[.='%s']/../following-sibling::span)[1]", text)), "");
			ExtentTestManager.setInfoMessageInReport(text + " label status is " + labelStatus);
		}
	}
}
