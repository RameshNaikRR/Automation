package coyni_mobile.components;

import org.openqa.selenium.By;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class SuccessFailureComponent extends MobileFunctions {
	private By btnClickMore = MobileBy.xpath("//*[contains(@resource-id,'learnMoreTV')]");//
	private By lblSucessFailure = MobileBy.xpath("//*[contains(@text,'security')]/preceding-sibling::*[1]");
	private By lblHeading = MobileBy.xpath("//*[contains(@name,'total amount')]/preceding-sibling::*[3]");
	private By ImgSuccessFailure = MobileBy.xpath("");
	private By btnLogout = MobileBy.xpath("//*[contains(@resource-id,'Logout')]");
	private By lblReceipentEmail = MobileBy.xpath("//*[contains(@resource-id,'recipientMailTV')]");//
	
	
	private By btnDone = MobileBy.xpath("//*[contains(@resource-id,'doneCV')]");//
	private By lblReferenceID = MobileBy.xpath("//*[@text='Reference ID']");//

	public void getStatus() {
		ExtentTestManager.setInfoMessageInReport("Status: " + getText(lblHeading));
	}

	public void clickDone() {
		click(btnDone, "Done");
	}
	public void verifyRecipentEmail(String expHeading) {
		new CommonFunctions().verifyLabelText(lblReceipentEmail, "Email", expHeading);
	}

	public void verifySuccessFailureHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSucessFailure, "heading", expHeading);

	}

	public void clickLearnMore() {
		click(btnClickMore, "Click More");
	}

	public void verifyReferenceID() {
		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
	}

	public void clickLogOut() {
		click(btnLogout, "LogOut");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
