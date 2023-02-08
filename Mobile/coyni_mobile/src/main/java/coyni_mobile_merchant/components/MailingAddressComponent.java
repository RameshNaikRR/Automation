package coyni_mobile_merchant.components;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni_mobile.pages.PreAuthorizationPage;
import coyni_mobile.pages.TokenAccountPage;
import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.AllDonePage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MailingAddressComponent extends MobileFunctions {
	private By txtAddressLine1 = MobileBy.xpath(
			"//*[contains(@resource-id,'etAddress1')]|//*[contains(@resource-id,'addressLineOneET')]|//*[contains(@resource-id,'companyaddressET')]");
	private By txtAddressLine2 = MobileBy.xpath(
			"//*[contains(@resource-id,'etAddress2')]|//*[contains(@resource-id,'addressLineTwoET')]|//*[contains(@resource-id,'companyaddress2ET')]");
	private By txtCity = MobileBy.xpath(
			"//*[contains(@resource-id,'etCity')]|//*[contains(@resource-id,'cityET')]|//*[contains(@resource-id,'cityET')]");
	private By drpDwnState = MobileBy
			.xpath("//*[contains(@resource-id,'etState')]|//*[contains(@resource-id,'stateET')]");
	private By drpdwnStatelist = MobileBy.xpath("//*[contains(@resource-id,'statesRV')]");

	private By txtZipCode = MobileBy.xpath(
			"//*[contains(@resource-id,'etZipcode') or contains(@resource-id,'etZipCode')]|//*[contains(@resource-id,'zipcodeET')]");
	private By lblCountry = MobileBy
			.xpath("//*[contains(@resource-id,'etCountry')]|//*[contains(@resource-id,'countryET')]");
	private By btnAddCard = MobileBy
			.xpath("//*[contains(@resource-id,'cvAddCard')] | //*[contains(@resource-id,'cvAdd')]");
	private By txtState = MobileBy
			.xpath("//*[contains(@resource-id,'searchET')]|//*[contains(@resource-id,'stateET')]");
	private By btnConfirmState = MobileBy.xpath("//*[contains(@resource-id,'cvAction')]");
	private By btnSave = MobileBy.xpath("//*[contains(@resource-id,'cvSave')]");
	private By btnRemove = MobileBy.xpath("//*[contains(@resource-id,'cvRemove')]");
	private By btnNo = MobileBy.xpath("//*[contains(@resource-id,'tvNo')]");
	private By btnYes = MobileBy.xpath("//*[contains(@resource-id,'tvYes')]");

	private By verifyAllStates(int Value) {
		return By.xpath(String.format("(//*[contains(@resource-id,'tvState')])[%s]", Value));
	}

	private By txtCurrentState(String currentState) {
		return MobileBy.xpath(String.format("//*[contains(@text,'%s')]", currentState));
	}

	public void clickCurrentState() {
		click(txtCurrentState("California"), "California");
	}

	public void fillAddressLine1(String addressLine1) {
		click(txtAddressLine1, "Address Line1");
		enterText(txtAddressLine1, addressLine1, "Address Line1");
	}

	public void fillAddressLine2(String addressLine2) {
		scrollDownToElement(txtAddressLine2, "Address Line2");
		click(txtAddressLine2, "Address Line2");
		enterText(txtAddressLine2, addressLine2, "Address Line2");
	}

	public void fillCity(String city) {
		scrollDownToElement(txtAddressLine2, "Address Line2");
		click(txtCity, "City");
		enterText(txtCity, city, "City");
		// new CommonFunctions().clickEnter();
		DriverFactory.getDriver().hideKeyboard();
	}

	public void selectState(String state) throws InterruptedException {
		DriverFactory.getDriver().hideKeyboard();
		click(drpDwnState, "State Drop down");
		enterText(txtState, state, "State");
		Thread.sleep(2000);
		new CommonFunctions().clickEnter();
		// click(MobileBy.xpath(String.format("//*[@text='%s']", state)), "state");
		new CommonFunctions().clickEnter();
		click(btnConfirmState, "Done");
	}

	public void fillZipCode(String zipCode) throws InterruptedException {
		Thread.sleep(2000);
		scrollDownToElement(txtZipCode, "zipCode");
		click(txtZipCode, "zip Code");
		enterText(txtZipCode, zipCode, "Zip Code");
		new CommonFunctions().clickTab();
		DriverFactory.getDriver().hideKeyboard();
	}

	public void scrollDownToAddress2() {
		scrollDownToElement(txtAddressLine2, "Address2");
	}

	public void scrollDownToSave() {
		scrollDownToElement(btnSave, "Save");
	}

//	public void fillZipCode(String zipCode) {
//		click(txtZipCode, "zip Code");
//		enterText(txtZipCode, zipCode, "Zip Code");
//		new CommonFunctions().clickEnter();
//		// DriverFactory.getDriver().hideKeyboard();
//
//	}

	public void verifyCountry(String expCountry) {
		scrollDownToElement(btnSave, "Save");
		new CommonFunctions().verifyLabelText(lblCountry, "Country", expCountry);
	}

	public void clickAddCard() {
		scrollDownToElement(btnAddCard, "Add Card");
		click(btnAddCard, "Add Card");
	}

	public void clickSave() {
		scrollDownToElement(btnSave, "Save");
		click(btnSave, "Save");
	}

	public void clickRemove() {
		scrollDownToElement(btnRemove, "Remove");
		click(btnRemove, "Remove");
	}

	public void clickNo() {
		click(btnNo, "No");
	}

	public void clickYes() {
		click(btnYes, "Yes");
	}

	public void validateAllStates() throws InterruptedException {

		click(drpDwnState, "State Drop down");	
		for (int j = 1; j < 10; j++) {
			for (int i = 1; i < 7; i++) {
				// scrollDownToElement(txtCity, "City");
//				click(drpDwnState, "State Drop down");
//			enterText(txtState, state, "State");
//			Thread.sleep(2000);
//			new CommonFunctions().clickEnter();
//			// click(MobileBy.xpath(String.format("//*[@text='%s']", state)), "state");
//			new CommonFunctions().clickEnter();
				scrollDownToElement(verifyAllStates(i), getText(verifyAllStates(i)));
				click(verifyAllStates(i), getText(verifyAllStates(i)));
				click(btnConfirmState, "Done");
				ExtentTestManager.setPassMessageInReport("Selected State is" + getText(drpDwnState));
				click(drpDwnState, "State Drop down");
		}
			Thread.sleep(2000);
			TouchAction touch = new TouchAction(DriverFactory.getDriver());
			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
					.moveTo(PointOption.point(540, (int) (440))).release().perform();
		}
	}

	public void DropdownState() throws InterruptedException {

		click(drpDwnState, "State Drop down");
		Thread.sleep(2000);
		List<WebElement> elements = getElementList(drpdwnStatelist, "drpdwnstate");

		int size = elements.size();

		System.out.println(size);

		for (int i = 0; i < size; i++) {

			List<WebElement> element = getElementList(drpdwnStatelist, "drpdwnstate");

			element.get(i).click();

//            click(btnDone, "Done");

			click(btnConfirmState, "Done");

			ExtentTestManager.setInfoMessageInReport("selected state is: " + getText(drpDwnState));
			click(drpDwnState, "State Drop down");

			// System.out.println(i);

		}

	}

	public void verifyAddressLine1View() {
		new CommonFunctions().elementView(txtAddressLine1, "Address line1 text field");
	}

	public void verifyAddressLine2View() {
		new CommonFunctions().elementView(txtAddressLine2, "Address line2  text field");
	}

	public void verifyCityView() {
		new CommonFunctions().elementView(txtCity, "City text field");
	}

	public void verifyStateView() {
		new CommonFunctions().elementView(drpDwnState, "State dropdown");
	}

	public void verifyZipCodeView() {
		new CommonFunctions().elementView(txtZipCode, "ZipCode  text field");
	}

	public PreAuthorizationPage preAuthorizationPage() {
		return new PreAuthorizationPage();
	}

	public AllDonePage allDonePage() {
		return new AllDonePage();
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
	public TokenAccountPage tokenAccountPage() {
		return new TokenAccountPage();
	}

}
