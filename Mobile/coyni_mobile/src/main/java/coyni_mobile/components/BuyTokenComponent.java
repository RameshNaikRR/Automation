package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.popups.OrderPreviewPopup;
import coyni_mobile.popups.ReloadPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class BuyTokenComponent extends MobileFunctions {

	private By lblBuyToken = MobileBy.xpath("//*[@text='Buy Tokens']");
	private By lblBuyTokenDesc = MobileBy.xpath("//*[contains(@text,'Please select a')]");
	private By lblPmntMethodName = MobileBy.id("com.coyni.mapp:id/tvPayHead");
	private By lblCYN = MobileBy.id("com.coyni.mapp:id/tvCYN");
	private By btnDebitCard = MobileBy.xpath("//*[contains(@text,'Instant Pay')]/following-sibling::*/descendant::android.widget.TextView[1]");
	private By btnCreditCard = MobileBy.xpath("(//*[contains(@text,'Credit')])[1]");
	private By btnBank = MobileBy.xpath("(//*[contains(@text,'Bank')])[1]");
	private By lblDailylimits = MobileBy.id("com.coyni.mapp:id/tvLimit");
	private By btnChangePayment = MobileBy.id("com.coyni.mapp:id/imgArrow");
	private By txtAmount = MobileBy.id("com.coyni.mapp:id/etAmount");
	private By btnBuyToken = MobileBy.id("com.coyni.mapp:id/keyActionLL");
	private By lblExchangeValue = MobileBy.id("com.coyni.mapp:id/tvExchange");

	public void verifyCynView() {
		if (getText(lblCYN).equals(" CYN")) {
			new CommonFunctions().elementView(lblCYN, "CYN");
		} else {
			ExtentTestManager.setFailMessageInReport("Coyni currency not as expected");
		}
	}

	public void verifyBuyTokenDesc(String expDesc) {
		new CommonFunctions().verifyLabelText(lblBuyTokenDesc, "Description", expDesc);
	}

	public void verifyBuyTokenHeading(String hdg) {
		new CommonFunctions().verifyLabelText(lblBuyToken, "Heading", hdg);
	}

	public void verifyChangePaymentView() {
		new CommonFunctions().elementView(btnChangePayment, "ChangePayment");
	}

	public void verifyPayment(String expPayment) {
		String method = getText(lblPmntMethodName);
		if (method.contains(expPayment)) {
			ExtentTestManager.setPassMessageInReport("Payment Method: " + expPayment);
		} else {
			ExtentTestManager.setFailMessageInReport("Payment method is not " + expPayment);
		}
	}

	public void clickChangePayment() {
		click(btnChangePayment, "ChangePayment");
	}

	public void viewDailyLimits() {
		new CommonFunctions().elementView(lblDailylimits, getText(lblDailylimits));
	}

	public void fillAmount(String Amount) {
		enterText(txtAmount, Amount, Amount);
	}

	public void clickBuyToken() {
		click(btnBuyToken, "Buy Token");
	}

	public void clickDebitCard() {
		click(btnDebitCard, "Debit Card");
	}

	public void clickCreditCard() {
		click(btnCreditCard, "Credit Card");
	}
	
	public void clickBank() {
		click(btnBank, "Bank");
	}

	public OrderPreviewPopup orderPreviewPopup() {
		return new OrderPreviewPopup();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}

	public ReloadPopup reloadPopup() {
		return new ReloadPopup();
	}

}
