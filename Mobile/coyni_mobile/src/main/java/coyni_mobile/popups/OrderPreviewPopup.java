package coyni_mobile.popups;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;


import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.components.SuccessFailureComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class OrderPreviewPopup extends MobileFunctions {

//	private By lblOrderPreview = MobileBy.xpath("//*[@name='Order Preview']");
	private By lblYouwillRecieve = MobileBy.AccessibilityId("Order Preview");
	private By lblAmount = MobileBy.xpath("//*[@name='Order Preview']/following-sibling::*[1]");
	private By lblPaymentMethod = MobileBy.xpath(
			"(//*[@name='Payment Method']/following-sibling::XCUIElementTypeStaticText)[1]|(//*[@name='Withdraw to'])[2]/following-sibling::*[1]");
	private By lblPurchaseAmount = MobileBy.xpath("//*[@name='Purchase Amount']/following-sibling::*[1] | //*[@name='Withdraw Amount']/following-sibling::*[1] |//*[@name='Subtotal']/following-sibling::*[1]");
	private By lblWithdrawAmount = MobileBy.xpath("//*[@name='Withdraw Amount']/following-sibling::*[1]");
	private By lblProcessingFee = MobileBy.xpath("//*[@name='Processing Fee']/following-sibling::*[1]");
	private By lblTotal = MobileBy.xpath("//*[@name='Total']/following-sibling::*[1] | //*[@name='Grand Total']/following-sibling::*[1]");
//	private By btnConfirm = MobileBy.xpath("//*[contains(@name,'Slide')]");
	private By btnConfirm = MobileBy.AccessibilityId("Slide to confirm");
	private By lblAmountWithdraw = MobileBy
			.xpath("//*[@name='Order Preview']/following-sibling::*[1]/*[@name='$']/following-sibling::*[1]");
	private By lbldailylimitAndFee = MobileBy.xpath("//*[contains(@name,'limit')]");
	private By lbldailylimitAndFee1 = MobileBy.xpath("//*[contains(@name,  'Fee:')] | //*[contains(@name,'daily limit')] | //*[contains(@name,'per transaction')]");
	private By lbldailylimitAndFee2 = MobileBy.xpath("//*[contains(@name,  'Fee:')]");
	
	
	
	
	private By lblGiftCardSummary = MobileBy.AccessibilityId("Order Overview");
    private By lblGiftCardName =MobileBy.xpath("//*[@name='Order Overview']/following-sibling::*[2]");
	private By lblEmail	= MobileBy.xpath("//*[@name='Subtotal']/../preceding-sibling::*[1]/*[2]");
	
	
	public void verifyGiftCardHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblGiftCardSummary, "Popup Heading", expHeading);
	}
	public void getGiftCardName() {
		ExtentTestManager.setInfoMessageInReport("Gift Card Name:"+getText(lblGiftCardName));
	}
	
	public void getEmail() {
		ExtentTestManager.setInfoMessageInReport("Gift Card Name:"+getText(lblEmail));
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblYouwillRecieve, "Popup Heading", expHeading);
	}

	public void getAmount() {
		ExtentTestManager.setInfoMessageInReport("Amount: " + getText(lblAmount) + " CYN");
	}
	public int verifyEnteredAmount() {
		String str = getText(lblAmount).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN", "");
		Integer amt=Integer.parseInt(str);
		return amt;
	}
	

	public void getAmountWithdraw() {
		ExtentTestManager.setInfoMessageInReport("Amount: " + "$" + getText(lblAmountWithdraw));
	}
	public void getPurchaseAmount() {
		ExtentTestManager.setInfoMessageInReport("Purchase Amount :" + getText(lblPurchaseAmount));
	}
	public String verifyPurchaseAmount() {
		String str = getText(lblPurchaseAmount).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN", "");
		return str;
	}

	public void getPaymentMethod() {
		String text = getText(lblPaymentMethod);
		int length = text.length();
		if (length < 9) {
			ExtentTestManager.setInfoMessageInReport("Payment Method: Card Number " + text);
		} else {
			ExtentTestManager.setInfoMessageInReport("Payment method: " + text);
		}
	}
	
	public String verifyPaymentMethod() {
		String str = getText(lblPaymentMethod).trim().replace(" ", "").replace("VISA", "");
		return str;
	}
	
	
	
	public String getDailyLimitFeeLabel() {
		String text = getText(lbldailylimitAndFee1);
		System.out.println("Hello");
		return text;
	}
	public String getDailyLimitFeeLabel1() {
		String text = getText(lbldailylimitAndFee2);
		System.out.println("Hello");
		return text;
	}
	public void verifyTotalAmount(String dailyLimitFee) throws InterruptedException {
		Thread.sleep(1000);
		 String feeText = dailyLimitFee;
       System.out.println(feeText);
   //    System.out.println(feeText);
		String[] split = feeText.split(" ");
		Pattern pattern = Pattern.compile("\\d+.\\d+");
		float staticAmount = 0;
		float percentAmount = 0;
		if (feeText.contains("$")) {
			Matcher match;
			if (feeText.contains("%")) {
				match = pattern.matcher(split[split.length - 3]);
			}else {
				match = pattern.matcher(split[split.length - 1]);
			}
			while (match.find()) {
				staticAmount = Float.parseFloat(match.group());
				System.out.println(staticAmount);
			//	System.out.println(staticAmount);
			}
		}
		if (feeText.contains("%")) {
			Matcher match = pattern.matcher(split[split.length - 1]);
			while (match.find()) {
				percentAmount = Float.parseFloat(match.group());
				System.out.println(percentAmount);
				System.out.println(percentAmount);
			}
		}
		
		String Purchasetext = getText(lblPurchaseAmount);
		System.out.println(Purchasetext);
		double purchaseAmount = Double.parseDouble(Purchasetext.replace(" ", "").replace("USD", "").replace("CYN", ""));
		System.out.println("purchase amount is:" + purchaseAmount);
//		float feePercentage = dailyLimitFee;
//       System.out.println(feePercentage);


//		String Feetext = getText(lbldailylimitAndFee);
//		String[] fee = Feetext.split(" ");
//		double feePer = Double.parseDouble(fee[8].replace("%", ""));
//         double procesfee = purchaseAmount * (feePercentage/100); 
//         System.out.println(procesfee);
       
		double expTotalAmount = purchaseAmount + staticAmount +(purchaseAmount * (percentAmount/100));
		DecimalFormat df = new DecimalFormat("0.00");
		expTotalAmount = Double.parseDouble(df.format(expTotalAmount));
		System.out.println(expTotalAmount);
		String[] Amount = getText(lblTotal).trim().split(" ");
		double actualTotalAmount = Double.parseDouble(Amount[0]);
		System.out.println(actualTotalAmount + " " + expTotalAmount);
		if (expTotalAmount == actualTotalAmount) {
			ExtentTestManager.setPassMessageInReport("total amount is verified");
		} else {
			ExtentTestManager.setFailMessageInReport("total amount is missmatched");
		}

	}
	
	

//	public float getDailyLimitFee() throws InterruptedException {
//		Thread.sleep(2000);
//		String text = getText(lbldailylimitAndFee1);
//		System.out.println(text);
//		String[] split = text.split(" ");
//		Pattern pattern = Pattern.compile("\\d+.\\d+");
//		Matcher match = pattern.matcher(split[split.length - 1]);
//		while (match.find()) {
//			float amount = Float.parseFloat(match.group());
//			System.out.println(amount);
//			return amount;
//		}
//		return 0.0f;
//	}
//
//	public void verifyTotalAmount(float dailyLimitFee) throws InterruptedException {
//		String Purchasetext = getText(lblPurchaseAmount);
//		System.out.println(Purchasetext);
//		double purchaseAmount = Double.parseDouble(Purchasetext.replace(" ", "").replace("USD", ""));
//		System.out.println("purchase amount is:" + purchaseAmount);
//		float feePercentage = dailyLimitFee;
//        System.out.println(feePercentage);
//
//
////		String Feetext = getText(lbldailylimitAndFee);
////		String[] fee = Feetext.split(" ");
////		double feePer = Double.parseDouble(fee[8].replace("%", ""));
////          double procesfee = purchaseAmount * (feePercentage/100); 
////          System.out.println(procesfee);
//		double expTotalAmount = purchaseAmount + purchaseAmount * (feePercentage/100);
//		DecimalFormat df = new DecimalFormat("0.00");
//		expTotalAmount = Double.parseDouble(df.format(expTotalAmount));
//		System.out.println(expTotalAmount);
//		String[] Amount = getText(lblTotal).trim().split(" ");
//		double actualTotalAmount = Double.parseDouble(Amount[0]);
//		System.out.println(actualTotalAmount + " " + expTotalAmount);
//		if (expTotalAmount == actualTotalAmount) {
//			ExtentTestManager.setPassMessageInReport("total amount is verified");
//		} else {
//			ExtentTestManager.setFailMessageInReport("total amount is missmatched");
//		}
//
//	}
	
	public String verifyTotalAmount() {
		String str = getText(lblTotal).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN", "");;
		return str;
	}
	

	

	public void getProcessingFee() {
		ExtentTestManager.setInfoMessageInReport("Processing Fee: " + getText(lblProcessingFee));
	}

	public String verifyProcessingFee() {
		String str = getText(lblProcessingFee).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN", "");;
		return str;
	}
	public void getTotal() {
		ExtentTestManager.setInfoMessageInReport("Total: " + getText(lblTotal));
	}

	public void getWithdrawAmount() {
		ExtentTestManager.setInfoMessageInReport("Withdraw Amount: " + getText(lblWithdrawAmount));
	}
	public String verifyWithdrawAmount() {
		String str = getText(lblWithdrawAmount).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN", "");;
		return str;
	}

//	public void swipeConfirm() {
//		swipeOnElement(btnConfirm, "Confirm", SwipeDirection.RIGHT);
//	}
	public void clickConfirm() {
		click(btnConfirm, "confirm");
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
}
