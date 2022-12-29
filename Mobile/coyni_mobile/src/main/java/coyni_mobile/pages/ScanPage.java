package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ScanPage extends MobileFunctions {

	private By btnScanCode = MobileBy.xpath("//*[contains(@resource-id,'scanCodeTV')]");
	private By btnScanMe = MobileBy.xpath("//*[contains(@resource-id,'scanMeTV')]");
	private By btnWhileUsingApp = MobileBy
			.xpath("//*[contains(@resource-id,'permission_allow_foreground_only_button')]");

	public void clickScanCode() {
		click(btnScanCode, "ScanCode");
	}

	public void clickScanMe() {
		click(btnScanMe, "ScanMe");
	}

	public void clickOnWhileUsingApp() {
		if(getElementList(btnWhileUsingApp, "While Using App").size()>0) {
		click(btnWhileUsingApp, "While Using App");
		}
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
