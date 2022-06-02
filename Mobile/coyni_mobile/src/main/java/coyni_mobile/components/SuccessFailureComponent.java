package coyni_mobile.components;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class SuccessFailureComponent extends MobileFunctions {
	private By btnClickMore = MobileBy.xpath("//*[contains(@resource-id,'learnMoreTV')]");//
	private By lblSucessFailure = MobileBy.xpath("//*[contains(@resource-id,'tvHeading')]");
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'tvHeading')]");
	private By ImgSuccessFailure = MobileBy.xpath("");
	private By btnLogout = MobileBy.xpath("//*[contains(@resource-id,'Logout')]");
	private By lblReceipentEmail = MobileBy.xpath("//*[contains(@resource-id,'recipientMailTV')]");//
	private By btnDone = MobileBy.xpath("//*[contains(@resource-id,'doneCV')]|//*[contains(@resource-id,'cvDone')]");//
	private By lblReferenceID = MobileBy.xpath("//*[contains(@resource-id,'tvReferenceID')]");
	private By lnkReferenceID = MobileBy.xpath("//*[contains(@resource-id,'tvReferenceID')]/following-sibling::*[1]");
	private By lblTrasactionStatus = MobileBy.xpath("//*[contains(@text,'Trasactions')]");
	private By lblEmailSucessFul = MobileBy.xpath("//*[contains(@text,'Change Email Successful')]");

	public void getStatus() {
		ExtentTestManager.setInfoMessageInReport("Status: " + getText(lblHeading));
	}
	
	public void verifyTrasactionsStatus() {
		String str = getText(lblTrasactionStatus);
		
		ExtentTestManager.setPassMessageInReport("Trasactions status is "+ str);
		
	}
	
	public void viewEmailSuccessHeading() {
		new CommonFunctions().elementView(lblEmailSucessFul, "Email Successful");
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

	public void getReferenceID() {
		click(lnkReferenceID, "");
		ExtentTestManager.setInfoMessageInReport("Reference ID: "+getCopiedData());
		Uninterruptibles.sleepUninterruptibly(10000, TimeUnit.MILLISECONDS);
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
