package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.BankAccountAddedPage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AddBankAccountComponent extends MobileFunctions {

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
		// scrollDownToElement(txtConfirmRouting, "Confirm Routing Number");
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
		scrollDownToElement(btnAdd, "Add");
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

	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}

	public BankAccountAddedPage bankAccountAddedPage() {
		return new BankAccountAddedPage();
	}

}
