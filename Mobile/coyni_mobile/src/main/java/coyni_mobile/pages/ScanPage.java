package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ScanPage extends MobileFunctions {

	private By btnScanCode = MobileBy.xpath("//*[contains(@resource-id,'scanCodeTV')]");
	private By btnScanMe = MobileBy.xpath("//*[contains(@resource-id,'scanMeTV')]");
	private By btnAlbum = MobileBy.xpath("//*[contains(@resource-id,'albumIV')]");
	private By btnPictures = MobileBy.xpath("//*[contains(@class,'RelativeLayout')][1]");
	private By imgScanQR1 = MobileBy.xpath("//*[contains(@content-desc,'Photo taken')][2]");
	private By imgScanQR2 = MobileBy.xpath("//*[contains(@content-desc,'Photo taken')][1]");
	private By btnWhileUsingApp = MobileBy
			.xpath("//*[contains(@resource-id,'permission_allow_foreground_only_button')]|//*[@text='While using the app']");
	private By btnOnlyThisTime = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_one_time_button']");
	public void clickScanCode() {
		click(btnScanCode, "ScanCode");
	}

	public void clickScanMe() {
		click(btnScanMe, "ScanMe");
	}

	public void clickOnWhileUsingApp() throws InterruptedException {
		Thread.sleep(1200);
		if(getElementList(btnWhileUsingApp, "While Using App").size()==1) {
		click(btnWhileUsingApp, "While Using App");
		}
	}
	public void clickPictures() {
		click(btnPictures, "Pictures");
	}
	public void clickAlbum() {
		click(btnAlbum, "Album");
	}
	public void clickQRCode() {
		click(imgScanQR1, "Code");
	}
	public void clickQRWithAmount() {
		click(imgScanQR2, "With Amount");
	}

	public void verifyScanMe() {
		new CommonFunctions().elementView(btnScanMe, "Scan Me");
	}

	public void verifyScanCode() {
		new CommonFunctions().elementView(btnScanCode, "Scan Code");
	}
	public ScanCodePage scanCodePage() {
		return new ScanCodePage();
	}

	public ScanMePage scanMePage() {
		return new ScanMePage();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
