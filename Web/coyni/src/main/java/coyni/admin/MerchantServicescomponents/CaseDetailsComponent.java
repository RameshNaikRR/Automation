package coyni.admin.MerchantServicescomponents;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CaseDetailsComponent extends BrowserFunctions {
	

	private By lblTransactionType = By.xpath("//div[contains(@class,'card  shadow-lg')]//span[text()='Buy Token']");
	private By lblTransactionSubType = By.xpath("//div[contains(@class,'card  shadow-lg')]//span[text()='Debit Card']");
	private By lblDate = By.xpath("//div[@class='card  shadow-lg']//div[@class='pb-5']//span[contains(text(),'/')]");
	private By lblAmount = By.xpath("(//p[@class='text-base'])[5]");//(//div[@class='card  shadow-lg']//div[@class='flex flex-col items-end']//p)[1]

	public String verifyTransactionType() {
		return getText(lblTransactionType, "Amount");
	}

	public String verifyTransactionSubType() {
		return getText(lblTransactionSubType, "lTransactionSubType");
	}

	public String verifyDate() {
		return getText(lblDate, "Date");
	}
}
