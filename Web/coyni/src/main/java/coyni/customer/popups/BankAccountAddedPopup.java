package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class BankAccountAddedPopup extends BrowserFunctions {
	
	private By lblFullName = By.xpath("//span[text()='Name on Account']/following-sibling::*[1]");
	private By lblRoutingNumber = By.xpath("//span[text()='Routing Number']/following-sibling::*[1]");
	private By lblStatus = By.xpath("//span[text()='Approved']");
	private By heading = By.xpath("//h1[text()='Bank Account Added']");
	private By btnDone = By.xpath("//button[text()='Done']");
	private By btnBuyToken = By.xpath("//button[text()='Buy coyni']");
	private By btnWithdraw = By.xpath("//button[text()='Withdraw']");

	
	public void verifyHeading() {
		new CommonFunctions().elementView(heading, "Heading");
	}
	
	public void verifyRoutingNumber(String expRoutingNumber) {
		String str = getText(lblRoutingNumber, "Routing Number");
		ExtentTestManager.setInfoMessageInReport("Routing Number is"+str);
		if(str.equals(expRoutingNumber)) {
			ExtentTestManager.setPassMessageInReport("Routing Number is Matched");
		}
		else {
			ExtentTestManager.setInfoMessageInReport("Routing Number is not Matched");
		}
	}
	
	public void verifyFullName() {
		String str = getText(lblFullName, "Full Name");
		ExtentTestManager.setPassMessageInReport("Full Name on Account is"+ str);
	}
	
	public void verifyStatus() {
		String str = getText(lblStatus, "Statuus");
		ExtentTestManager.setInfoMessageInReport("Status is"+str);
	}
	
	public int verifyBuyTokenButton() {
		int i = getElementsList(btnBuyToken, "Buy Token").size();
		return i;
	}
	
	public int verifyWithdrawButton() {
		int i =getElementsList(btnWithdraw, "With Draw").size();
		return i;
	}
	
	public void clickWithdraw() {
		click(btnWithdraw, "WithDraw");
	}
	
	public void clickBuyToken() {
		click(btnBuyToken, "Buy Token");
	}
	
	public void clickDone() {
		click(btnDone, "Done");
	}

}
