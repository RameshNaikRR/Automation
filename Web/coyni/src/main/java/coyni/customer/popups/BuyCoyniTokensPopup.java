package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BuyCoyniTokensPopup extends BrowserFunctions{
	
	private By txtAmount = By.cssSelector("");
	private By lblErrorMessage = By.cssSelector("");
	private By lnkChange = By.cssSelector("");
	private By btnConvert = By.cssSelector("");
	private By btnNext = By.cssSelector("");
	
	public void fillAmount(String Amount) {
		enterText(txtAmount, Amount, "");
	}
	public void verifyCountry(String ErrorMessage) {
    	new CommonFunctions().verifyLabelText(lblErrorMessage, ErrorMessage, "ErrorMessage");
    }
    public void clickChangeLink() {
    	click(lnkChange, "Click on Change");
    }
    public void clickConvert() {
    	click(btnConvert, "Click on Convert");
    }
    public void clickNext() {
    	click(btnNext, "Click on Next");
    }
    public OrderPreviewPopup orderPreviewPopup() {
 	   return new OrderPreviewPopup();
    }
}
