package coyni_mobile_merchant.pages;

import java.text.DecimalFormat;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.EnterYourPINComponent;
import coyni_mobile_merchant.popups.OrderPreviewPopup;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.actions.SwipeDirection;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class GiftCardPage extends MobileFunctions {
	private By iconSearch = MobileBy.xpath(" ");
	private By txtSearchBox = MobileBy.xpath("//*[contains(@resource-id,'searchET')]");
	private By iconCross = MobileBy.xpath(" ");

	private By lblHeading = MobileBy.xpath("//*[@text='Select Your Gift Card']");

	private By lblPopularCard = MobileBy.xpath("//*[@text='Brands']");

	private By lblWithdrawHeading = MobileBy.xpath("//*[@text='Withdraw Gift Card']");

	private By imgAmazon = MobileBy.xpath("(//*[contains(@resource-id,'imgBrand')])[2]");
	private By imgVisa = MobileBy.xpath("(//*[contains(@resource-id,'imgBrand')])[1]");

	private By txtAmount = MobileBy.id("com.coyni.mapp:id/amountET");
	private By txtFirstName = MobileBy.xpath("//*[contains(@resource-id,'firstNameET')]");
	private By txtLastName = MobileBy.xpath("//*[contains(@resource-id,'lastNameET')]");

	private By txtEmail = MobileBy.xpath("//*[contains(@resource-id,'emailET')]");

	private By btnPurchas = MobileBy.xpath("//*[contains(@resource-id,'purchaseCV')]");

	private By lblheadingOrderPreview = MobileBy.xpath("//*[@text='Order Overview']");//

	private By lblAmazon = MobileBy.xpath("//*[contains(@resource-id,'giftCardTypeTV')]");

	private By lblReceipentEmail = MobileBy.xpath("//*[contains(@resource-id,'recipientMailTV')]");
	private By btnSideView = MobileBy.xpath("//*[contains(@resource-id,'tv_lable')]");

	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'giftCardDescTV')]");

	private By btnDone = MobileBy.xpath("//*[@text='Done']");
	private By lblFees = MobileBy.id("com.coyni.mapp:id/tvFeePer");

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void verifyWithdrawGiftCard(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdrawHeading, "Withdraw Gift Card", expHeading);
//		DriverFactory.getDriver().hideKeyboard();
	}

	public void verifyDescription(String expHeading) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", expHeading);
	}

	public void verifyOrderPreviewHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblheadingOrderPreview, "Order Overview", expHeading);
	}

	public void verifyAmazonHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAmazon, "Amazon", expHeading);
	}

	public void verifyRecipentEmail(String expHeading) {
		new CommonFunctions().verifyLabelText(lblReceipentEmail, "Email", expHeading);
	}

	public void sideBar() {
		swipeOnElement(btnSideView, "Purchase", SwipeDirection.RIGHT);
	}

	public void verifyGiftCardHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Select Your Gift Card", expHeading);
	}

	public void verifyBrandHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPopularCard, "Popular Brands", expHeading);
	}

	public void clickAmazon() {
		click(imgAmazon, "Amazon");
	}

	public void clickVisa() {
		click(imgVisa, "Visa");
	}

	public void fillFirstName(String firstName) {
		DriverFactory.getDriver().hideKeyboard();
		click(txtFirstName, "First Name");
		enterText(txtFirstName, firstName, "First Name");

	}

	public void fillLastName(String lastName) {
		DriverFactory.getDriver().hideKeyboard();
		click(txtLastName, "Last Name");
		enterText(txtLastName, lastName, "Last Name");
//		DriverFactory.getDriver().hideKeyboard();
	}

	public void fillEmail(String email) {
		DriverFactory.getDriver().hideKeyboard();
		scrollDownToElement(txtEmail, "Email");
		click(txtEmail, "Email");
		enterText(txtEmail, email, "Email");
//		new CommonFunctions().clickTab();
//		DriverFactory.getDriver().hideKeyboard();
	}

	public void fillAmount(String amount) {
		DriverFactory.getDriver().hideKeyboard();
		click(txtAmount, "Amount");
		DriverFactory.getDriver().hideKeyboard();
		enterText(txtAmount, amount, "Amount");
//		scrollDownToElement(txtLastName, "Last Name");
//		DriverFactory.getDriver().hideKeyboard();
	}

	public void clickPurchase() {
		DriverFactory.getDriver().hideKeyboard();
		scrollDownToElement(btnPurchas, "Purchased");
		if (getElement(btnPurchas, "Purchased").isEnabled()) {
			click(btnPurchas, "Purchased");
		} else {
			ExtentTestManager.setInfoMessageInReport("Purchased button is Disable Mood");
		}
	}

	public void clickSearch() {
		click(iconSearch, "Search");
	}

	public void fillSearchBox(String userName) {
		enterText(txtSearchBox, userName, "User Name");

	}

	public void clickCross() {
		click(iconCross, "Cross");
	}

	public Double validateProcessingFees() {
		String[] fee1 = getText(lblFees).replace(" ", "").split(":");
		String feeDollars = fee1[1].replace("$", "");
		Double feeDollar = Double.parseDouble(feeDollars);
		DecimalFormat df = new DecimalFormat("#.##");
		double fee = Double.parseDouble(df.format(feeDollar));
		System.out.println(fee);
		return fee;
	}

	public Double validateTotal() {
		Double purchaseAmount = Double.parseDouble(getText(txtAmount));
		Double amount = validateProcessingFees() + purchaseAmount;
		DecimalFormat df = new DecimalFormat("#.##");
		double totalAmount = Double.parseDouble(df.format(amount));
		System.out.println(totalAmount);
		return totalAmount;
	}

	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}

	public OrderPreviewPopup orderPreviewPopup() {
		return new OrderPreviewPopup();
	}

}
