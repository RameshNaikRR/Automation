package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BuyCoyniTokens extends BrowserFunctions{
	
	private By txtAmount = By.cssSelector("");
	private By lblErrorMessage = By.cssSelector("");
	private By lnkChange = By.cssSelector("");
	private By btnConvert = By.cssSelector("");
	private By btnNext = By.cssSelector("");
	
	public void enterAmount(String Amount) {
		enterText(txtAmount, Amount, "");
	}
	public void verifyCountry(String ErrorMessage) {
    	new CommonFunctions().verifyLabelText(lblErrorMessage, ErrorMessage, "ErrorMessage");
    }
    public void clickOnChangeLink() {
    	click(lnkChange, "Click on Change");
    }
    public void clickOnConvert() {
    	click(btnConvert, "Click on Convert");
    }
    public void clickOnNext() {
    	click(btnNext, "Click on Next");
    }
}
