package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.admin.popups.SaveChangePopUp;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PreferencesandControlsComponent extends BrowserFunctions {
	
	private By heading = By.xpath("(//span[contains(text(),'Preferences')])[2]") ;
	private By lblTimeZone = By.xpath("(//div[contains(@class,'PortalSettings_time_type')]//div)");
	private By lblLocalCurrency = By.xpath("(//div[contains(@class,'PortalSettings_time_type')]//div)[2]");
	private By btnEnable = By.xpath("//button[contains(text(),'Enable')]");
	private By btnDisable = By.xpath("//button[contains(text(),'Disable')]");
	private By btnPay = By.xpath("//span[text()='Pay']/..//div[contains(@class,'react-toggle react-toggle--checked toggle-blue')]");
	private By btnRequest = By.xpath("//span[text()='Request']/..//div[contains(@class,'react-toggle react-toggle--checked toggle-blue')]");
	private By btnWithDrawalExternalBankAccount = By.xpath("(//span[text()='External Bank Account']/..//div[contains(@class,'react-toggle react-toggle--checked toggle-blue')])[1]");
	private By btnWithDrawalInstantPay = By.xpath("(//span[text()='Instant Pay']/..//div[contains(@class,'react-toggle react-toggle--checked toggle-blue')])[1]");
	private By btnWithDrawalGiftCard = By.xpath("(//span[text()='Gift Card']/..//div[contains(@class,'react-toggle react-toggle--checked toggle-blue')])[1]");
	private By btnBuyTokensCreditCard = By.xpath("(//span[text()='Credit Card']/..//div[contains(@class,'react-toggle react-toggle--checked toggle-blue')])[1]");
	private By btnBuyTokensDebitCard = By.xpath("(//span[text()='Debit Card']/..//div[contains(@class,'react-toggle react-toggle--checked toggle-blue')])[1]");
	private By btnBuyTokensexternalBankAccount = By.xpath("(//span[text()='External Bank Account']/..//div[contains(@class,'react-toggle react-toggle--checked toggle-blue')])[2]");
	private By btnPaymentCreditCard = By.xpath("(//span[text()='Credit Card']/..//div[contains(@class,'react-toggle react-toggle--checked toggle-blue')])[2]");
	private By btnPaymentDebitCard = By.xpath("(//span[text()='Debit Card']/..//div[contains(@class,'react-toggle react-toggle--checked toggle-blue')])[2]");
	private By btnPaymentExternalBankAccount = By.xpath("(//span[text()='External Bank Account']/..//div[contains(@class,'react-toggle react-toggle--checked toggle-blue')])[3]");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By btnCancel = By.xpath("//button[text()='Cancel']");
	
	
	
	
	public String viewHeading() {
         String str =getText(heading,"");
         ExtentTestManager.setInfoMessageInReport("Heading is "+ str);
         return str;
	}
	
	public String verifyTimeZone() {
		String str = getText(lblTimeZone, "TimeZone");
		ExtentTestManager.setInfoMessageInReport("Time Zone is "+ str);
		return str;
	}
	
	public String verifyLocalCurrency() {
		String str = getText(lblLocalCurrency, "Local Currency");
		ExtentTestManager.setInfoMessageInReport("Local Currency is "+ str);
		return str;
	}
	
	public void clickEnable() {
		if(verifyElementDisplayed(btnEnable, "Button")) {
			//click(btnDisable, "");
			click(btnEnable,"Click Enable");
			//verifyElementDisabled(btnEnable, "Enabled button is disabled");
			}
			else {
			ExtentTestManager.setFailMessageInReport("Unable to disbale all controls");
			}
	}
	
	public void clickDisable() {
		
		if(verifyElementDisplayed(btnDisable, "Button")) {
		click(btnDisable,"Click Disable");
		//verifyElementDisabled(btnEnable, "Enabled button is disabled");
		}
		else {
		ExtentTestManager.setFailMessageInReport("Unable to disbale all controls");
	}
	}
	
	public void verifyAllControls() throws InterruptedException {
		click(btnPay,"Pay");
		click(btnRequest,"Request");
		click(btnWithDrawalExternalBankAccount, "Withdrawal ExternalBankAccount");
		click(btnWithDrawalInstantPay,"Withdrawal Instant Pay");
		click(btnWithDrawalGiftCard,"Withdrawal Gift Card");
		click(btnBuyTokensCreditCard,"BuyTokens Credit Card");
		click(btnBuyTokensDebitCard,"BuyToken Debit Card");
		Thread.sleep(1000);
		click(btnBuyTokensexternalBankAccount, "BuyToken ExternalBankAccount");
		Thread.sleep(1000);
		
//		click(btnPaymentCreditCard, "Payment Credit Card");
//		click(btnPaymentDebitCard,"Payment Debit Card");
//		click(btnPaymentExternalBankAccount, "Payment ExternalBankAccount");
	}
	
	public void clickSave() {
		click(btnSave,"Clcik Save");
	}
	
	public void clickCancel() {
		click(btnCancel, "Click Cancel");
	}

	public SaveChangePopUp saveChangePopUp() {
		return new SaveChangePopUp();
	}
	


}
