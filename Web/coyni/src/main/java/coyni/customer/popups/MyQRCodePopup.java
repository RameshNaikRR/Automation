package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class MyQRCodePopup extends BrowserFunctions {
	
	private By lnkShare = By.cssSelector("");
	private By lnkCopy = By.cssSelector("");
	private By btnDone = By.cssSelector("");
	
	public void clickOnShareLink() {
		 click(lnkShare, "Click Share");
	    }
		
	public void clickOnCopyLink() {
			 click(lnkCopy, "Click Copy");
		}
			
	public void clickOnDone() {
		click(btnDone,"Succesfully done");
	}
			

}
