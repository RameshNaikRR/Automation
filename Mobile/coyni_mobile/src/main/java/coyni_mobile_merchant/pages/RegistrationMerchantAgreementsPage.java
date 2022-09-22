package coyni_mobile_merchant.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Dimension;

import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class RegistrationMerchantAgreementsPage extends MobileFunctions {

	private By btnSignature = MobileBy.xpath("//*[contains(@resource-id,'signatureEditIV')]");
	private By btnSignatureDone = MobileBy.xpath("//*[contains(@resource-id,'tv_signature_done')]");
	private By btnAgreementsDone = MobileBy.xpath("//*[contains(@resource-id,'AgreeDoneCv')]");
	private By lblToastMsg = MobileBy.xpath("//*[@text='The file has been saved to Google Drive.']");
	private By drawSignature = MobileBy.xpath("//*[contains(@resource-id,'csv_signature_view')]");
	private By btnClear = MobileBy.xpath("//*[@text='Clear']");
	private By btnMerchantAgreement = MobileBy.xpath("//*[contains(@resource-id,'aggrementsIncompleteLL')]");

	public void clickSignature(){
		click(btnSignature, "Signature");
	}

	public void clickSignatureDone() {
		click(btnSignatureDone, "Signature Done");
	}

	public void clickClear() {
		click(btnClear, "Clear");
	}
	
	public void clickAgreementsDone() {
		click(btnAgreementsDone, "Agreements Done");
	}

	public void drawSignature() throws InterruptedException {
	
		
		 DeviceRotation landscapeRightRotation = new DeviceRotation(0, 0, 90);
	        DriverFactory.getDriver().rotate(landscapeRightRotation);
	   Thread.sleep(2000);     
//	        assertEquals(DriverFactory.getDriver().rotation(), landscapeRightRotation);
//		Dimension  a =DriverFactory.getDriver().findElement(drawSignature).getSize();	
//		ExtentTestManager.setInfoMessageInReport(""+a);
//		
//		Dimension size = DriverFactory.getDriver().manage().window().getSize();
//		int x = size.getWidth();
//		int y = size.getHeight();
//		ExtentTestManager.setInfoMessageInReport(x+ " "+ y);

	TouchAction touch = new TouchAction(DriverFactory.getDriver());
	touch.press(PointOption.point(1645, 572)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
			.moveTo(PointOption.point(1900, (int) (572))).release().perform();
	}

	public void AcceptMerchantAgreement() throws InterruptedException {
		clickSignature();
		Thread.sleep(2000);
		drawSignature();
		clickClear();
		drawSignature();
		clickSignatureDone();
		clickAgreementsDone();
	}

	public void clickMerchantAgreement() {
		click(btnMerchantAgreement, "Merchant's Agreement");
	}
	
	
}
