package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.BankAccountAddedPage;
import coyni_mobile.pages.PaymentMethodsPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AddExternalBankAccountComponent extends MobileFunctions {

	private By heading = MobileBy.xpath("//*[@text='Add Bank Account']");
	private By txtRoutingNumber = MobileBy.xpath("//*[contains(@resource-id,'routingNumberET')]");
	private By txtConfirmRouting = MobileBy.xpath("//*[contains(@resource-id,'confirmRoutingNumberET')]");
	private By txtAccNumber = MobileBy.xpath("//*[contains(@resource-id,'checkAccNumberET')]");
	private By txtConfirmAccNumber = MobileBy.xpath("//*[contains(@resource-id,'confirmAccNumberET')]");
	private By btnAdd = MobileBy.xpath("//*[contains(@resource-id,'addCV')]");
	private By txtNameOnBank = MobileBy.xpath("//*[contains(@resource-id,'nameOnBankET')]");
	private By lblFindAccHeading = MobileBy.xpath("//*[contains(@resource-id,'head')]");
	private By lblFindAccDes = MobileBy.xpath("//*[contains(@resource-id,'descriptionTV')]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'addCV')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Bank Heading", expHeading);
	}

	public void fillNameOnBankAcc(String expBankName) {
		enterText(txtNameOnBank, expBankName, "Name On Bank Account");
	}

	public void fillRoutingNum(String expRoutingNumber) {
		enterText(txtRoutingNumber, expRoutingNumber, "Routing Number");
	}

	public void fillConfirmRoutingNum(String expConfirmRouting) {
		DriverFactory.getDriver().hideKeyboard();
		enterText(txtConfirmRouting, expConfirmRouting, "Confirm Routing Number");
	}

	public void fillAccNum(String expAccNumber) {
		DriverFactory.getDriver().hideKeyboard();
		enterText(txtAccNumber, expAccNumber, "AccNumber");
	}

	public void fillConfirmAccNum(String expConfirmAccNum) {
		DriverFactory.getDriver().hideKeyboard();
		enterText(txtConfirmAccNumber, expConfirmAccNum, "Confirm Account Number");
	}

	public void clickAdd() {
		DriverFactory.getDriver().hideKeyboard();
		//scrollDownToElement(btnAdd, "Add");
		click(btnAdd, "Add");
	}

	public void addBank(String expHeading, String expNameOnBank, String expRouting, String expConRouting,
			String expAccNum, String expConfirmAcc) {
		verifyHeading(expHeading);
		fillNameOnBankAcc(expNameOnBank);
		fillRoutingNum(expRouting);
		fillConfirmRoutingNum(expConRouting);
		fillAccNum(expAccNum);
		fillConfirmAccNum(expConfirmAcc);
		clickAdd();
	}

	public BankAccountAddedPage bankAccountAddedPage() {
		return new BankAccountAddedPage();
	}

//	private By lblHeading = MobileBy.xpath("//*[@name='Add External Bank Account']");
//	private By lnkLearnMore = MobileBy.xpath("//*[@name='Learn more']");
//private By btnNext = MobileBy.xpath("//*[@text='Next']");
//
//	public void verifyHeading(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
//	}

//	public void clickLearnMore() {
//		click(lnkLearnMore, "Learn More");
//	}

//	public void clickNext() {
//		click(btnNext, "Next");
//	}

	public AddAccountsComponent addAccountsComponent() {
		return new AddAccountsComponent();
	}

	public PaymentMethodsPage paymentMethodsPage() {
		return new PaymentMethodsPage();
	}

}
