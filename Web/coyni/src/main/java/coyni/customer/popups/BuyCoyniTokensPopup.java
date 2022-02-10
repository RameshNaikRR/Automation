package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class BuyCoyniTokensPopup extends BrowserFunctions{
	
	private By txtAmount = By.xpath("//input[@name='usd']");
	private By headingBuyCoyniToken = By.xpath("//h1[contains(text(),'Buy Coyni Tokens')]");
	private By btnAddNewPaymentMethod = By.xpath("//span[contains(text(),'Add New Payment Method')]");
	private By buyCoyniTokensDescp = By.xpath("//h2[contains(text(),'Choose Your Payment Method:')]");
	private By lblErrorMessage = By.cssSelector("");
	private By lnkChange = By.xpath("//span[contains(text(),'Change')]");
	private By lblDollar = By.xpath("//span[contains(text(),'$')]");
	private By lblCYN = By.xpath("(//span[text()='CYN'])[2]");
	private By btnConvert = By.xpath("//button[@class='group flex flex-col justify-center items-center ']");
	private By btnNext = By.cssSelector("");
	private By lblBuyTokenNoPayments = By.xpath("//h2[contains(text(),'No Payment Method Available')]");
	
	public void fillAmount(String Amount) {
		enterText(txtAmount, Amount, "");
	}
	public void verifyCountry(String ErrorMessage) {
    	new CommonFunctions().verifyLabelText(lblErrorMessage, ErrorMessage, "ErrorMessage");
    }
	public void viewChangeLink() {
		new CommonFunctions().elementView(lnkChange, "Change link");
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
    public void verifyBuyCoyniTokenDescrpWithOutPaymentMethods() {
    	new CommonFunctions().elementView(lblBuyTokenNoPayments, "No Payment Method Availble");
    }
    
    public BuyCoyniTokensPaymentMethodPopup buyCoyniTokensPaymentMethodPopup() {
    	return new BuyCoyniTokensPaymentMethodPopup();
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
    public void verifyConvert() {
    	if(verifyElementDisplayed(lblDollar, "Dollar Symbol")){
    		click(btnConvert,"CLick Covert");
    		ExtentTestManager.setPassMessageInReport("Succesfully Converted to CYN");
    	}
    	else if(verifyElementDisabled(lblCYN, "CYN Symbol")) {
    		click(btnConvert,"Click Convert");
    		ExtentTestManager.setPassMessageInReport("Succesfully Converted to Dollar");
    	}
    	else {
    		ExtentTestManager.setFailMessageInReport("Not Converted");
    	}
    }
    
    public NavigationComponent navigationComponent() {
    	return new NavigationComponent();
    }
}
