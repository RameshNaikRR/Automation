package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class MyQRCodeComponent extends BrowserFunctions {
	
	private By imgActualQRCode = By.cssSelector("");
	
	private By lblWalletAddress = By.cssSelector("");
	
	private By btnCopy = By.cssSelector("");
	
	private By btnShare =By.cssSelector("");
	
	private By btnDone = By.cssSelector("");
	
	private By txtTextMessage =By.cssSelector("");
	
	private By btnPasteTestMessage =By.cssSelector("");
	
	private By txtEmail =By.cssSelector("");
	
	private By txtMsgToRecipient =By.cssSelector("");

	
	public void verifyQRCodeDisplayed() 
	{
		verifyElementDisplayed(imgActualQRCode, "QR Code Image");
	}

	public String getWalletAddress() {
		return getText(lblWalletAddress, "wallet address");
	}
	//DOUBT
	public void verifyCopyBtnWorking() {
		 boolean enabled = getElement(	btnCopy, "Button copy").isEnabled();
		   if(enabled) {
			   ExtentTestManager.setPassMessageInReport("Button copy is working");
		   }
		   else {
			   ExtentTestManager.setFailMessageInReport("Button copy is not working");
		   }
	}

   public void clickShare() {
	   click(btnShare, "click share");
   }
   
   public void clickDone() {
	   click(btnDone, "click done");
   }
   
   public void fillTextMessage(String textMessage) {
	   enterText(txtTextMessage, textMessage, "Text Message");
   }
   //DOUBT
   public void verifyPasteTextMessageWorking() {
	   boolean enabled = getElement(btnPasteTestMessage, "Paste Text Message").isEnabled();
	   if(enabled) {
		   ExtentTestManager.setPassMessageInReport("Paste Text Message is working");
	   }
	   else {
		   ExtentTestManager.setFailMessageInReport("Paste Text Message is not working");
	   }
   }
   
   public void fillTextEmail(String textEmail) {
	   enterText(txtEmail, textEmail, "Text Email");
   }

   public void fillMsgToRecipient(String msgToRecipient) {
	   enterText(txtMsgToRecipient, msgToRecipient, "Message To Recipient");
   }
   
   public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
	   return new SuccessFailurePopupCardComponent();
   }







}
