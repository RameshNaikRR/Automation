package coyni_mobile.popups;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.SuccessFailureComponent;
import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile.utilities.Direction;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class OrderPreviewPopup extends MobileFunctions {

//	private By headingOrderPreview = MobileBy.xpath("//*[@text='Order Overview']");      //  

	private By lblAmazon = MobileBy.xpath("//*[contains(@resource-id,'giftCardTypeTV')]"); //

	private By lblReceipentEmail = MobileBy.xpath("//*[contains(@resource-id,'recipientMailTV')]"); ///

	private By btnSideView = MobileBy.xpath("//*[contains(@resource-id,'slideToConfirm')]"); //

	private By lblOrderOverview = MobileBy.xpath("//*[contains(@text,'Order Overview')]");

	private By lblAmount = MobileBy.xpath("//*[contains(@resource-id,'tvGet')]");
	private By lblPaymentMethod = MobileBy
			.xpath("(//*[@name='Payment Method']/following-sibling::XCUIElementTypeStaticText)[1]");
	// private By lblPurchaseAmount = MobileBy.xpath("//*[@text='Purchase
	// Amount']/following-sibling::*[1]");
	private By lblProcessingFee = MobileBy.xpath("//*[contains(@resource-id,'feeTV')]|//*[contains(@resource-id,'ProcessingFee')]");
	private By lblTotal = MobileBy.xpath("//*[contains(@resource-id,'totalTV')]|//*[contains(@resource-id,'tvTotal')]");
	private By btnConfirm = MobileBy
			.xpath("//*[contains(@resource-id,'tv_lable')]|//*[contains(@resource-id,'slideToConfirm')]");
	private By lblPurchaseAmount = MobileBy.xpath("//*[contains(@resource-id,'tvPurchaseAmt')]");
	private By lbldailylimitAndFee1 = MobileBy.xpath("//*[contains(@resource-id,'tvFeePer')] | //*[contains(@name,'daily limit')] | //*[contains(@name,'per transaction')]");

	public String getDailyLimitFeeLabel() {

		String text = getText(lbldailylimitAndFee1);

		return text;
	}
	
	public String verifyTransactionTotalAmount() {
		String str = getText(lblTotal).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN", "");
		return str;
	}
	

	public void verifyTotalAmount(String dailyLimitFee) throws InterruptedException {

		String feeText = dailyLimitFee;

		System.out.println(feeText);

		String[] split = feeText.split(" ");

		Pattern pattern = Pattern.compile("\\d+.\\d+");

		float staticAmount = 0;

		float percentAmount = 0;

		if (feeText.contains("$")) {

			Matcher match;

			if (feeText.contains("%")) {

				match = pattern.matcher(split[split.length - 3]);
			} else {
				match = pattern.matcher(split[split.length - 1]);
			}
			while (match.find()) {
				staticAmount = Float.parseFloat(match.group());
				System.out.println(staticAmount);
			}

		}
		if (feeText.contains("%")) {
			Matcher match = pattern.matcher(split[split.length - 1]);

			while (match.find()) {

				percentAmount = Float.parseFloat(match.group());

				System.out.println(percentAmount);
			}
		}

		String Purchasetext = getText(lblPurchaseAmount);
		System.out.println(Purchasetext);
		double purchaseAmount = Double.parseDouble(Purchasetext.replace(" ", "").replace("USD", "").replace("CYN", ""));
		System.out.println("purchase amount is:" + purchaseAmount);
		double expTotalAmount = purchaseAmount + staticAmount + (purchaseAmount * (percentAmount / 100));
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

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblOrderOverview, "Popup Heading", expHeading);
	}

	public void verifyAmazonHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAmazon, "Amazon", expHeading);
	}

	public void getAmount() {
		ExtentTestManager.setInfoMessageInReport("Amount: " + getText(lblAmount) + " CYN");
	}

	public void verifyRecipentEmail(String expHeading) {
		new CommonFunctions().verifyLabelText(lblReceipentEmail, "Email", expHeading);
	}

	public String verifySlideText() {
		return getText(btnConfirm);

	}

	public String verifyPurchaseAmount() {
		String purAmount = getText(lblPurchaseAmount);
		return purAmount;
	}

	public void getPaymentMethod(String expPaymentMethod) {
		String text = getText(lblPaymentMethod);
		int length = text.length();
		if (length < 9) {
			ExtentTestManager.setInfoMessageInReport("Payment Method: Card Number " + text);
		} else {
			ExtentTestManager.setInfoMessageInReport("Payment method: " + text);
		}
	}

	public void getPurchaseAmount(String expPurchaseAmount) {
		ExtentTestManager.setInfoMessageInReport("Purchase Amount: " + getText(lblPurchaseAmount));
	}

	public void getProcessingFee() {
		ExtentTestManager.setInfoMessageInReport("Processing Fee: " + getText(lblProcessingFee));
	}

	public void getTotal() {
		ExtentTestManager.setInfoMessageInReport("Total: " + getText(lblTotal));
	}

	public void swipeConfirm() {
		new CommonFunctions().swipeElement(btnConfirm, Direction.RIGHT);

	}

	public void slideToConfirm() {
		// new CommonFunctions().swipeElement(btnSideView, Direction.RIGHT);
		swipeOnElement(btnSideView, "Purchased", SwipeDirection.RIGHT);
	}

	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

	private By lblHeadingOrderPre = MobileBy.xpath("//*[@text='Order Preview']");// tvTotal
	private By lblProcessingF = MobileBy.xpath("//*[contains(@resource-id,'tvProcessingFee')]");
	private By lblTotalAmount = MobileBy.xpath("//*[contains(@resource-id,'tvTotal')]");

	public void verifyOrderHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeadingOrderPre, "Order Preview", expHeading);
	}

	public void getBankProcessingFee() {
		ExtentTestManager.setInfoMessageInReport("Processing Fee: " + getText(lblProcessingF) + "CYN");
	}

	public void getBankTotal() {
		ExtentTestManager.setInfoMessageInReport("Total: " + getText(lblTotalAmount) + "CYN");
	}

	public By getPaymentItems(String last4digits) {
		return By.xpath(String.format("//*[contains(@text,'%s')]", last4digits));
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
