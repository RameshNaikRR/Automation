package coyni.admin.MerchantServicespopups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ActionsPopup extends BrowserFunctions {
	private By lblHeading = By.cssSelector(".alert-body>h1");
	private By popDes =By.cssSelector(".alert-body>p");
	private By btnYes =By.xpath("//button[text()='Yes']");
	private By btnNoGoBack =By.xpath("No, go back");
	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Page Heading ", expHeading);
	}
	public void verifyPopDes() {
		ExtentTestManager.setInfoMessageInReport(getText(popDes, ""));
	}
	public void clickYes() {
		click(btnYes, "Yes");
	}
	public void clickNoGoBack() {
		click(btnNoGoBack, "NoGoBack");
	}

}
