package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BuyCoyniTokensPopup extends BrowserFunctions{
	
	private By txtAmount = By.xpath("//input[@name='usd']");
	private By headingBuyCoyniToken = By.xpath("//h1[contains(text(),'Buy Coyni Tokens')]");
	private By btnAddNewPaymentMethod = By.xpath("//span[contains(text(),'Add New Payment Method')]");
	private By buyCoyniTokensDescp = By.xpath("//h2[contains(text(),'Choose Your Payment Method:')]");
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
    public void verifyBuyCoyniTokenHeading(String expBuyCoyniTokenHeading) {
    	new CommonFunctions().verifyLabelText(headingBuyCoyniToken, "Buy Coyni Token Heading is", expBuyCoyniTokenHeading);
    }
    public void clickAddNewPaymentMethod() {
    	click(btnAddNewPaymentMethod, "Add New Payment Method");
    }
    public void verifyBuyCoyniTokenDescription(String expBuyCoyniTokenDescrp) {
    	new CommonFunctions().verifyLabelText(buyCoyniTokensDescp, "Choose Your Paayment Method  ", expBuyCoyniTokenDescrp);
    }
    public AddNewPaymentMethodPopup addNewPaymentMethodPopup() {
    	return new AddNewPaymentMethodPopup();
    }
    
}
