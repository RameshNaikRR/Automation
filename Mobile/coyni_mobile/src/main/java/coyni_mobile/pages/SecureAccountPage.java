package coyni_mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.components.ChoosePinComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SecureAccountPage extends MobileFunctions {

	private By heading = MobileBy.xpath("//*[@text='Secure your account']");
	private By lblSecureDescription = MobileBy.xpath("//*[contains(@text,'One way we')]");
	private By btnNext = MobileBy.xpath("//*[contains(@text,'Next')]");
	private By btnFinishSignup = MobileBy.xpath("//*[contains(@text,'Finish Signup')]");
	private By chboxAgree = MobileBy.xpath("//*[contains(@resource-id,'agreeCB')]");
	private By privacyPolicyUpdate = MobileBy
			.xpath("//*[contains(@resource-id,'privacy_policy')]|//*[contains(@text,'Privacy Policy')]");
	private By termsOfServiceUpdateHeading = MobileBy.xpath("//*[contains(@resource-id,'agreNameTV')]");
	private By privacyPolicyHeading = MobileBy
			.xpath("//*[contains(@resource-id,'privacy_policy')]|//*[contains(@resource-id,'agreNameTV')]");
	private By termsOfServiceUpdateOk = MobileBy.xpath("//*[contains(@resource-id,'actionCV')]");
	private By btnThreeDots = MobileBy.xpath("//*[contains(@resource-id,'optionsIV')]");
	private By btnDownload = MobileBy.xpath("//*[contains(@resource-id,'downloadLL')]");
	private By btnCancel = MobileBy.xpath("//*[contains(@resource-id,'cancelTV')]");
	private By lblSucessMsg = MobileBy.xpath("//*[contains(@resource-id,'toastTV')]");

//	private By chboxAgree = MobileBy.xpath("//*[contains(@resource-id,'agreeCB')]");

	public void verifyToastMsg(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSucessMsg, "Toast Message", expHeading);
	}
//	public void verifySecureDescription(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblSecureDescription, "Secure Account Description", expHeading);
//	}
	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 40);

	public void clickAgreeCheckBox() {
		click(chboxAgree, "Terms of service and Privacy");
	}
	public int verifySecureAccount() {
		new CommonFunctions().elementView(heading, "Heading");
		return 0;
	}
	
	public void verifyHeading(String expHeading, String expDescription) {
		new CommonFunctions().verifyLabelText(heading, "Heading", expHeading);
		new CommonFunctions().verifyLabelText(lblSecureDescription, "Secure Account Description", expDescription);
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void scrollTermsOfService() throws InterruptedException {
//		wait.until(ExpectedConditions.presenceOfElementLocated(btnNext));
//		while (getElementList(btnNext, "Next").size() == 0) {
//			TouchAction touch = new TouchAction(DriverFactory.getDriver());
//			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//					.moveTo(PointOption.point(540, (int) (300))).release().perform();
//		}
	}

	public void scrollPrivacyPolicy() throws InterruptedException {
//		while (getElementList(btnFinishSignup, "Finish Signup").size() == 0) {
//			TouchAction touch = new TouchAction(DriverFactory.getDriver());
//			touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//					.moveTo(PointOption.point(540, (int) (300))).release().perform();
//		}
	}

	public void verifyTermsOfServiceUpdateForSignUp(String expHeading, String toastMessage) throws InterruptedException {
//		wait.until(ExpectedConditions.titleIs(expHeading));
//		wait.until(ExpectedConditions.presenceOfElementLocated(termsOfServiceUpdateHeading));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(termsOfServiceUpdateHeading));
		new CommonFunctions().verifyLabelText(termsOfServiceUpdateHeading, "Terms Of Service Heading",
				expHeading);
		//click(btnThreeDots, "3 Dots");
		//click(btnDownload, "Download");
		//new CommonFunctions().verifyLabelText(lblSucessMsg, "Toast Message", toastMessage);
        //click(btnThreeDots, "3 Dots");
		//click(btnCancel, "Cancel");
		scrollDownToElement(termsOfServiceUpdateOk, "Terms of Service Agree button");
		clickAgreeCheckBox();
		click(termsOfServiceUpdateOk, "Terms Of Service Ok");
	}

	public void verifyPrivacyPolicyHeadingForSignUp(String expHeading, String toastMessage) throws InterruptedException {
//		wait.until(ExpectedConditions.presenceOfElementLocated(privacyPolicyHeading));
		wait.until(ExpectedConditions.visibilityOfElementLocated(privacyPolicyHeading));
		new CommonFunctions().verifyLabelText(privacyPolicyHeading, "Privacy Policy Heading", expHeading);
		//click(btnThreeDots, "3 Dots");
		//click(btnDownload, "Download");
		//new CommonFunctions().verifyLabelText(lblSucessMsg, "Toast Message", toastMessage);
        //click(btnThreeDots, "3 Dots");
		//click(btnCancel, "Cancel");
		scrollDownToElement(termsOfServiceUpdateOk, "Privacy Policy button");
		clickAgreeCheckBox();
		click(termsOfServiceUpdateOk, "Privacy Policy Ok");

	}

	public void clickFinishSignup() {
		click(btnFinishSignup, "Finish Signup");
	}

	public ChoosePinComponent choosePinComponent() {
		return new ChoosePinComponent();
	}
}
