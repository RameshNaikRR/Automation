
package coyni_mobile.popups;

import org.openqa.selenium.By;

import coyni_mobile.components.CalendarComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class FiltersPopup extends MobileFunctions {
    private By lblFilters = MobileBy.xpath("");
    private By lblTransactionType = MobileBy.AccessibilityId("");
	private By lblTransactionStatus = MobileBy.xpath("//*[@name='Transactions']");
	private By txtFromAmount = MobileBy.xpath("//*[@name='To']/following-sibling::*[1]");
	private By txtToAmount =MobileBy.xpath("//*[@name='To']/preceding-sibling::*[2]");
	private By btnCalender =MobileBy.xpath("//*[@name='Date']/following-sibling::*[1]");
	private By btnResetAllFilters = MobileBy.xpath("//XCUIElementTypeButton[@name='Reset all filters']");
	private By btnApplyfilter =MobileBy.name("Apply Filter");
	private By lnkSaleOrderPlus = MobileBy.AccessibilityId("");
	private By lnkRefundPlus = MobileBy.AccessibilityId("");
	private By lnkBuyTokensPlus = MobileBy.AccessibilityId("");
	private By lnkWithdrawPlus = MobileBy.AccessibilityId("");
	
	public By getElementPlus(String elementName) {
		return MobileBy.AccessibilityId(String.format("%s", elementName));
	}
	
	public void selectFilterPlus(String type) {
		scrollDownToElement(getElementPlus(type),type );
			click(getElementPlus(type), type);
		}
	//Permission Alert
	
	private By lblAlertHeading =MobileBy.xpath("Would Like to Access Your");
	private By lblAlertDes = MobileBy.xpath("(//*[contains(@name,'accessed')])[1]");
	private By btnDontAllow =MobileBy.xpath("(//*[contains(@name,'Allow')])[1]");
//	private By btnOk =MobileBy.xpath("(//*[@name='OK'])[1]");
	private By btnOk =MobileBy.name("OK");
//	private By lblAlertErrorMsg = MobileBy.xpath("//*[@name='Alert!']/following-sibling::XCUIElementTypeStaticText");
	private By lblAlertErrorMsg1 = MobileBy.AccessibilityId("Please enter From amount");
	private By lblAlertErrorMsg2 = MobileBy.AccessibilityId("Please enter To amount");
	private By lblAlertErrorMsg3 = MobileBy.AccessibilityId("To amount should be greater than From amount");
	private By lblAlertLessThanAmountErrorMsg = MobileBy.xpath("//XCUIElementTypeStaticText[@name='To amount should be less than From amount']");
	
	
	
	
	
	
	public void verifyErrorMessage1(String errMsg) {
		new CommonFunctions().verifyLabelText(lblAlertErrorMsg1, "errMsg", errMsg);
	}
	public void verifyErrorMessage2(String errMsg) {
		new CommonFunctions().verifyLabelText(lblAlertErrorMsg2, "errMsg", errMsg);
	}
	public void verifyErrorMessage3(String errMsg) {
		new CommonFunctions().verifyLabelText(lblAlertErrorMsg3, "errMsg", errMsg);
	}
	public void verifyAlertErrorMessage(String errMsg) {
		new CommonFunctions().verifyLabelText(lblAlertLessThanAmountErrorMsg, "errMsg", errMsg);
	}
	
	
	
	public void getAlertLabel() {
		ExtentTestManager.setInfoMessageInReport("Alert Title:"+getText(lblAlertHeading));
	}
	public void getAlertDes() {
		ExtentTestManager.setInfoMessageInReport("Alert Title:"+getText(lblAlertDes));
	}
	public void clickOk() {
		click(btnOk, "Ok");
	}
	public void clickDontAllow() {
		click(btnDontAllow, "Don't Allow");
	}

	public void handlingPopup() {
		if(getElementList(lblAlertHeading, "").size()>0) {
			getAlertLabel();
			getAlertDes();
			clickOk();
		}
}

	
	public void clickSaleOrderPlus() {
		click(lnkSaleOrderPlus, "Sale Order plus ");
	}
	
	public void clickRefundPlus() {
		click(lnkRefundPlus, "Refund plus ");
	}
	
	public void clickBuyTokensPlus() {
		click(lnkBuyTokensPlus, "Buy Tokens plus ");
	}
	public void clickWithdrawTokensPlus() {
		click(lnkWithdrawPlus, "Withdraw Tokens plus ");
	}

	public void clickApplyfilters(){
	click(btnApplyfilter, "Apply filters");	
	}	
	public void clickResetAllFilters() {
		click(btnResetAllFilters, "Reset All Filters");
	}
	public void clickCalender() {
		click(btnCalender, "Calender");
	}
	public void fillFromAmount(String fromAmount) {
	 	click(txtFromAmount, "fromAmount");
	// 	new EnterYourPINComponent().fillPins(fromAmount);
		enterText(txtFromAmount, fromAmount, "From Amount");
//		new CommonFunctions().clickDone();
	}
	public void fillToAmount(String toAmount) {
	   click(txtToAmount, "toAmount");
	//	new EnterYourPINComponent().fillPins(toAmount);
		enterText(txtToAmount, toAmount, "To Amount");
//		new CommonFunctions().clickDone();
	}
	public void verifyFilters(String expHeading) {
		new CommonFunctions().verifyLabelText(lblFilters, "Page Heading", expHeading);
	}
	public void verifyTransactionType(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionType, "Transaction Type", expHeading);
	}
	public void verifyTransactionStatus(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionStatus, "Transaction Status", expHeading);
	}
	
	
	
	
	
//	public By getElement(String elementName) {
//		return MobileBy.xpath(String.format("//XCUIElementTypeCell/*[@name='%s']", elementName));
//	}
	public By getElement(String elementName) {
		return MobileBy.AccessibilityId(String.format("%s", elementName));
	}
	public void selectFilter(String type) {
	scrollDownToElement(getElement(type),type );
		click(getElement(type), type);
	}
	public CalendarComponent calendarComponent() {
		return new CalendarComponent();
	}
//	public PermissionAlert permissionAlert() {
//		return new PermissionAlert();
//	}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	
}
