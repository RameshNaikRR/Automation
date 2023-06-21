package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.popups.OrderPreviewPopup;
import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

	 

	public class BuyTokenComponent extends MobileFunctions {

	 

		 private By lblBuyToken = MobileBy.AccessibilityId("");
		    private By lblBuyTokenDesc = MobileBy.AccessibilityId("");
		    private By lblBuyTokensHdg = MobileBy.AccessibilityId("");
		    private By lblPaymentMethod = MobileBy
		            .xpath("(//XCUIElementTypeStaticText[@name='Payment Method'])[2]|(//XCUIElementTypeStaticText[@name='Payment Method'])[3]|//*[@name ='arrow-right']/preceding-sibling::*[1]/child::*");
		    private By lblDailylimits = MobileBy.xpath("//*[@name ='arrow-right']/following-sibling::*[1]");
//		    private By btnChangePayment = MobileBy.xpath("//*[@name ='arrow-right']");
		    private By btnChangePayment = MobileBy.AccessibilityId("arrow-right");
		    private By txtAmount = MobileBy.xpath("//*[@name ='currency toggle']/preceding-sibling::XCUIElementTypeTextField");
		    private By btnBuyToken = MobileBy.xpath("(//*[@name='Buy Token'])[2]|//*[contains(@resource-id,'keyActionTV')]");
//		    private By btnConvert = MobileBy.xpath("//XCUIElementTypeButton[@name='currency toggle']");
		  //  private By btnConvert = MobileBy.AccessibilityId("currency toggle");
		    private By lnkAddNewPayment = MobileBy.xpath("(//XCUIElementTypeStaticText[@name='Add New Payment Method'])[2]");
//		    private By lblCYn = MobileBy.xpath("//XCUIElementTypeStaticText[@name='CYN']");
		    private By lblCYn = MobileBy.AccessibilityId("CYN");
//		    private By lblDollar = MobileBy.xpath("//XCUIElementTypeStaticText[@name='$']");
		    private By lblDollar = MobileBy.AccessibilityId("");

		    public void verifyCynView() {
		        new AndroidCommonFunctions().elementView(lblCYn, "CYN");
		    }
		    public void verifyDollarView() {
		        new AndroidCommonFunctions().elementView(lblDollar, "Dollar");
		    }

		 

		    public void verifyBuyTokenDesc(String expDesc) {
		        new AndroidCommonFunctions().verifyLabelText(lblBuyTokenDesc, "Description", expDesc);
		    }

		    public void verifyBuyTokenHeading(String hdg) {
		        new AndroidCommonFunctions().verifyLabelText(lblBuyToken, "Heading", hdg);
		    }
		    public void verifyBuyTokensHeading(String hdg) {
		        new AndroidCommonFunctions().verifyLabelText(lblBuyTokensHdg, "Heading", hdg);
		    }

		    public void verifyChangePaymentView() {
		        new AndroidCommonFunctions().elementView(btnChangePayment, "ChangePayment");
		    }

	    public void verifyPayment(String expPayment) {
	        String method = getText(lblPaymentMethod);
	        if (method.contains(expPayment)) {
	            ExtentTestManager.setPassMessageInReport("Payment Method: " + expPayment);
	        } else {
	            ExtentTestManager.setFailMessageInReport("Payment method is not " + expPayment);
	        }
	    }
	    public void verifyPaymentView() {
	        new AndroidCommonFunctions().elementView(lblPaymentMethod, "payment method heading");
	    }
	    public void clickChangePaymentView() {
	        new AndroidCommonFunctions().elementView(btnChangePayment, "ChangePayment");
	    }

	 

	    public void getDailyLimits() {
	        ExtentTestManager.setInfoMessageInReport(getText(lblDailylimits));
	    }

	 

	    public void clickArrow() {
	        click(btnChangePayment, "Arrow");
	    }

	 

	    public void fillAmount(String Amount) {
	        new ChoosePinComponent().fillPin(Amount);
	        ExtentTestManager.setInfoMessageInReport("Entered Amount: " + Amount);
	    }

	 

	    public void clickBuyToken() {
	        click(btnBuyToken, "Buy Token");
	    }

	 

//	    public void clickConvert() {
//	        click(btnConvert, "convert");
//	    }

	 

	    
	    public OrderPreviewPopup orderPreviewPopup() {
	        return new OrderPreviewPopup();
	    }
	    public NavigationComponent navigationComponent() {
	        return new NavigationComponent();
	    }
	

}
