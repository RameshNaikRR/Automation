package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ScanPage extends MobileFunctions {

	private By btnScanCode = MobileBy.xpath("");
	private By btnScanMe = MobileBy.xpath("");
	private By btnWhileUsingApp = MobileBy
			.xpath("//*[contains(@resource-id,'permission_allow_foreground_only_button')]");

	public void clickScanCode() {
		click(btnScanCode, "ScanCode");
	}

	public void clickScanMe() {
		click(btnScanMe, "ScanMe");
	}

	public void clickOnWhileUsingApp() {
		click(btnWhileUsingApp, "While Using App");
	}

	public void verifyScanCodeAndScanMe() {
		new CommonFunctions().elementView(btnScanCode, "Scan Code");
		new CommonFunctions().elementView(btnScanMe, "Scan Me");
	}

	public ScanCodePage scanCodePage() {
		return new ScanCodePage();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
