package coyni_mobile.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.popups.OrderPreviewPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class WithdrawTokenPage extends MobileFunctions {

//	private By lblHeading = MobileBy.xpath("//*[@name='Withdraw Token']");
	private By lblHeading = MobileBy.AccessibilityId("Withdraw Token");
//	private By lblWithdraw = MobileBy.xpath("//*[@name='Withdraw to']");
	private By lblWithdraw = MobileBy.AccessibilityId("Withdraw to");
	private By lblLimit = MobileBy.xpath("//*[contains(@name,'Your daily limit is')]");
//	private By btnChangePaymentArrow = MobileBy
//			.xpath("//*[contains(@name,'Your daily limit is')]/../following-sibling::*[1]");
	private By btnChangePaymentArrow = MobileBy
			.AccessibilityId("arrow right");
	private By lblPaymentMethod = MobileBy
			.xpath("//*[contains(@name,'Your daily limit is')]/preceding-sibling::*[1]/*[1]");
	private By lblPaymentMethod4Digits = MobileBy
			.xpath("//*[contains(@name,'Your daily limit is')]/preceding-sibling::*[1]/*[2]");
	private By btnWithdraw = MobileBy.xpath("(//*[@name='Withdraw'])[1]");
	private By btnMessage = MobileBy.xpath("(//*[contains(@name,'Optional')])");
	private By btnBack = MobileBy.xpath("//*[@name='Back'or @name='Button' or @name='back']");
	private By txtAmount = MobileBy.xpath("//*[@name='Withdraw to']/following-sibling::XCUIElementTypeOther[2]/XCUIElementTypeTextField | //*[@name='Payment Method']/following-sibling::XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField");
	private By txtAmt = MobileBy.xpath("//*[@name='Payment Method']/following-sibling::XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField");
	private By lblAvailableBalance = MobileBy.xpath("//*[contains(@name,'Available Balance')]");
	private By lblDailyLimit = MobileBy
			.xpath("//*[contains(@name,'Your daily limit')] | //*[contains(@name, 'Your weekly limit')] | //*[contains(@name,'limit')] | //*[contains(@name,'per transaction limit')]");
	private By lblTransactionLimit = MobileBy.xpath("//*[contains(@name,'per transaction limit')]");
//	private By lblCYn = MobileBy.xpath("//XCUIElementTypeStaticText[@name='CYN']");
//	private By lblDollar = MobileBy.xpath("//XCUIElementTypeStaticText[@name='$']");
//	private By btnConvert = MobileBy.xpath("//XCUIElementTypeButton[@name='currency toggle']");
	private By lblCYn = MobileBy.AccessibilityId("CYN");
	private By lblDollar = MobileBy.AccessibilityId("$");
	private By btnConvert = MobileBy.AccessibilityId("currency toggle");
	
	
	
	
	
	//optional message//

		private By btnCancel = MobileBy.xpath("(//*[@name='Cancel'])[1]");
		private By btnDone = MobileBy.xpath("(//*[@name='Done'])[1]");
		private By txtMessage = MobileBy.xpath("(//*[@name='Cancel'])[1]/../preceding-sibling::*[1]");

		public void clickCancel() {
			click(btnCancel, "Cancel");
		}

		public void clickDone() {
			click(btnDone, "Done");
		}

		public void fillMessage(String message) {
			enterText(txtMessage, message, "Message");
		}
	
	
	
	
	
	private By getOneNumberOfPin(char num) {
		return MobileBy.xpath(
				String.format("(//*[@text='%s' or @name='%s'])", Character.toString(num), Character.toString(num)));
	}
    public void clearText() {
    	new CommonFunctions().clear(txtAmount);
    }
	
	private float getAmountFromtext(By ele) {
		String text = getText(ele);
		System.out.println(text);
		String texts = text.replace(",","");
		System.out.println(texts);
		Pattern pattern = Pattern.compile("\\d+.\\d+");
		Matcher match = pattern.matcher(texts);
		while (match.find()) {
			float amount = Float.parseFloat(match.group());
			return amount;
		}
		return 0.0f;
	}
	
	public float getAmountFromTransactionLimit(By ele) {
		String text     = getText(ele);
		String[] ac = text.split("CYN");
		System.out.println(ac.length);
        String[] x = ac[0].replace(",", "").split(" ");
         float pertransactions = Float.parseFloat( x[x.length-1]);
         return pertransactions;
		
		
		
	}
	public void verifyCynView() {
		new CommonFunctions().elementView(lblCYn, "Cyn");
	}
	public void clickConverter() {
		click(btnConvert, "Converter");
		new CommonFunctions().elementView(lblDollar, "Dollar symbol");
	}
	
	public float getTransactionLimits() {
		return this.getAmountFromTransactionLimit(lblTransactionLimit);
	}
	
	public void clickBack() {
		click(btnBack, "Back");
	}
	public float getAvailableBalance() {
		
	//	if(getElementList(lblAvailableBalance, "").size()> 0){
		return this.getAmountFromtext(lblAvailableBalance);
	//	}
	//	return 0;
	}
	public String getDailyOrWeeklyLimitText() {
	//	if(getElementList(lblAvailableBalance, "").size()> 0){
		return getText(lblDailyLimit);
	//	}
	//	return null;
	}
	
	public String getPerTransactionText() {
		return getText(lblTransactionLimit);
			}
	public float getDailyLimitOrWeeklyLimitAmount() {
	//	if(getElementList(lblDailyLimit, "").size()> 0){
		System.out.println("value:"+this.getAmountFromtext(lblDailyLimit));
		return this.getAmountFromtext(lblDailyLimit);
		//}
	//	return 0;
	}
	public int getTextSize() {
		return getElementList(lblDailyLimit, "").size();
		}

	public void verifyWithdrawTokenPageView() {
		new CommonFunctions().elementView(lblHeading, "Withdraw Token Page");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Page Heading", expHeading);
	}

	public void verifylblWithdrawView() {
		new CommonFunctions().elementView(lblWithdraw, "label Withdraw To");
		new CommonFunctions().elementView(btnChangePaymentArrow, "Arrow");
	}

	public void getLimits() {
		ExtentTestManager.setInfoMessageInReport("" + getText(lblLimit));
	}

	public void getPaymentMethod() {
		ExtentTestManager.setInfoMessageInReport(
				"Paymentmethod:" + getText(lblPaymentMethod) + " " + getText(lblPaymentMethod4Digits));
	}

	public void verifyPaymentMethod(String paymentMethod, String last4digits) {
		String pay = getText(lblPaymentMethod) + " " + getText(lblPaymentMethod4Digits);
		if (pay.contains(paymentMethod) && pay.contains(last4digits)) {
			ExtentTestManager.setPassMessageInReport("Payment Method is verified");
		} else {
			ExtentTestManager.setWarningMessageInReport("Payment method is not verified");
		}
	}

	public void ClickChangePaymentArrow() {
		click(btnChangePaymentArrow, "Arrow");
	}

	public void fillAmount(String amount) {
//		new CommonFunctions().clear(txtAmt);
		new ChoosePinComponent().fillPin(amount);
	}
	
	public void validateAmounts(String pin) {
		
		String[] field = pin.split(",");
		new CommonFunctions().clear(txtAmt);
		for (int i = 0; i < field[0].length(); i++) {
			click(getOneNumberOfPin(field[0].charAt(i)), "pin " + field[0].charAt(i));
		}
		System.out.println(field[0].length());
		System.out.println(new CommonFunctions().getTextBoxValue(txtAmt).length());
		if(field[0].length()== new CommonFunctions().getTextBoxValue(txtAmt).length()) {
			System.out.println("for loop i");
			ExtentTestManager.setPassMessageInReport("CVV field is accepting 11 numbers");
		}else {
			ExtentTestManager.setFailMessageInReport("CVV field is not accepting 11 numbers");
		}
		new CommonFunctions().clear(txtAmt);
		for (int j = 0; j < field[1].length(); j++) {	
			click(getOneNumberOfPin(field[1].charAt(j)), "pin " + field[1].charAt(j));	
		}
		System.out.println(field[1].length());
		System.out.println(new CommonFunctions().getTextBoxValue(txtAmt).length());
		if(field[1].length()!= new CommonFunctions().getTextBoxValue(txtAmt).length()) {
			System.out.println("for loop j");
			ExtentTestManager.setPassMessageInReport("CVV field is not accepting 13 numbers");
		}else {
			ExtentTestManager.setFailMessageInReport("CVV field is accepting 13 numbers");
		}
		
	}

	public void validateAmount(String amount) {
		String[] amt = amount.split(",");
		new CommonFunctions().validateField(txtAmount, "amount", amt[0]);
		new CommonFunctions().clearText(txtAmount, "amount");
		new CommonFunctions().validateFieldMaxichar(txtAmount, "amount", amt[1]);
	}
	
	public void clickWithdraw() {
		click(btnWithdraw, "Withdraw");
	}

	public void clickMessageButton() {
		click(btnMessage, "Message Button");
	}

	

	public OrderPreviewPopup orderPreviewPopup() {
		return new OrderPreviewPopup();
	}
	public void validateField(By ele, String eleName, String enterText) {
		try {
			new CommonFunctions().clearText(ele, eleName);
			ExtentTestManager
					.setInfoMessageInReport("trying to enter " + enterText.length() + " characters in " + eleName);
			//mobileFunctions.click(ele, eleName);
			DriverFactory.getDriver().findElement(ele).clear();
			new ChoosePinComponent().fillPin(enterText);
			String actualtext = new CommonFunctions().getTextBoxValue(ele).trim().replace("/", "").replace("-", "")
					.replace("(", "").replace(") ", "").replace(" ", "");
			
			System.out.println("length " + actualtext.length());
			By errorMsgs = MobileBy.xpath(String.format("//*[contains(@label,'%s,')]", eleName));
		//	new SignUpPage().clickDone();
			Thread.sleep(2000);
			if (enterText.equalsIgnoreCase(actualtext)
					&& getElementList(errorMsgs, "errorMsg").size() == 0) {

				ExtentTestManager
						.setPassMessageInReport(eleName + " is accepting " + enterText.length() + " characters");
			} else {

				ExtentTestManager
						.setFailMessageInReport(eleName + " is not accepting " + enterText.length() + " characters");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("validate field is failed due to exception " + e);

		}
	}
		public void validateFieldMaxichar(By ele, String eleName, String enterText) {
			try {
				new CommonFunctions().clearText(ele, eleName);
				ExtentTestManager
						.setInfoMessageInReport("trying to enter " + enterText.length() + " characters in " + eleName);
			//	mobileFunctions.click(ele, eleName);
				new ChoosePinComponent().fillPin(enterText);
				String actualtext = new CommonFunctions().getTextBoxValue(ele).trim().replace("/", "").replace("-", "").replace(") ", "").replace(" ", "")
						.replace("(", "");
		//		new SignUpPage().clickDone();
				if (!enterText.equalsIgnoreCase(actualtext)) {

					ExtentTestManager
							.setPassMessageInReport(eleName + " is not accepting " + enterText.length() + " characters");
				} else {

					ExtentTestManager
							.setInfoMessageInReport(eleName + " is accepting " + enterText.length() + " characters");
				}
			} catch (Exception e) {
				ExtentTestManager.setFailMessageInReport("validateFieldMaxichar is failed due to exception " + e);
			}
		}

}
