package coyni.customer.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class MyQRCodeComponent extends BrowserFunctions {
	
	private By imgActualQRCode = By.cssSelector("");
	
	private By lblWalletAddress = By.cssSelector("");
	
	private By btnCopy = By.cssSelector("");
	
	private By btnShare =By.cssSelector("");
	
	private By btnDone = By.cssSelector("");
	
	
	public void verifyQRCodeDisplayed() 
	{
		verifyElementDisplayed(imgActualQRCode, "QR code image");
	}

	public void getWalletAddress() {
		getText(lblWalletAddress, "wallet address");
	}
	
	public void verifyCopyBtnWorking() {
		//
	}

   public void clickShare() {
	   click(btnShare, "click share");
   }
   
   public void clickDone() {
	   click(btnDone, "click done");
   }
   
   public SuccessFailurePopupCard successFailurePopupCard() {
	   return new SuccessFailurePopupCard();
   }







}
