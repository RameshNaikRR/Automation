package coyni.admin.MerchantServicescomponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PaymentMethodsComponent extends BrowserFunctions {
	private By lblPaymentMethodHeading = By.xpath("//div[contains(@class,'card  PaymentsMethodsCards')]//span[text()='Payment Methods']");
	private By lblNoPaymentMethods = By.xpath("//p[contains(text(),'No Payment Methods Available')]");
	private By lblCardList = By.xpath("//div[contains(@class,'card PaymentMethod_payment_method')]");
	private By lblBankList = By.xpath("//div[contains(@class,'card Bank_payment_method')]");
	
	public void verifyHeading(String expPaymentMethodHeading) {
		new CommonFunctions().verifyLabelText(lblPaymentMethodHeading, "Heading", expPaymentMethodHeading);
	}
	
	public void PaymentMethodCardDetails() {
		//cardDetails("Card Details");
	}
	
	public int verifyNoPaymentMethods() {
		return getElementsList(lblNoPaymentMethods, "No payment Methods").size();
		
	}
	
	public int verifyCardslist() {
		return getElementsList(lblCardList, "Cards List").size();
		
	}
	
	public int verifyBankList() {
		return getElementsList(lblBankList, "Bank List").size();
		
	}
	
	
	
	public void viewNoPaymentMethods() {
		new CommonFunctions().elementView(lblNoPaymentMethods, "No Payment Methods Avaialble");
	}
	
	public void cardDetails() {
		
	//	  String[] column = columns.split(",");
		 		List<WebElement> list = getElementsList(lblCardList, "Card list ");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			String label = list.get(i).getText();
			ExtentTestManager.setInfoMessageInReport("Card details" + ": " + label);
		}
	}
	
	public void bankDetails() {
		
		//	  String[] column = columns.split(",");
			 		List<WebElement> list = getElementsList(lblBankList, "Bank list ");
			int size = list.size();
			for (int i = 0; i < size; i++) {
				String label = list.get(i).getText();
				ExtentTestManager.setInfoMessageInReport("Bank details" + ": " + label);
			}
		}
}
