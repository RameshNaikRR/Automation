package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AccountCreatedPage extends MobileFunctions{
//	private By heading = MobileBy.xpath("//*[@name='Your Account Has Been Created']");
//	private By btnGetStarted =MobileBy.xpath("(//*[@name='Get Started'])[1]");
//	
////	private By btnSkip =MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Skip'`]");
//	
//	//2.3
////	private By lblAccountCreatedhdg = MobileBy.xpath("//*[@name= 'Account Created!']");
//	
//	private By btnGoToDashBoard = MobileBy.xpath("(//*[@name='Go to Dashboard'])[2]");
//	
//	
//	
//	//////////////
//	public void verifyHeading(String expHeading) {
//		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
//	}
//	
//	public void clickGetStarted() {
//		click(btnGetStarted, "Get Started");
//	}
//	public  TokenAccountPage tokenAccountPage() {
//		   return new TokenAccountPage();
//    }
//
//	public int VerifyGoToDashboard() {
//    return getElementList(btnGoToDashBoard, "btnGoToDashBoard").size();
//	}
////	}
//	public void clickGoToDashboard() {
//		click(btnGoToDashBoard, "Go to dashboard");
//	}
//	
	/****
	 * 
	 */
	private By lblAccountCreatedhdg = MobileBy.AccessibilityId("Account Created!");
	private By lblAccountCreatedImg = MobileBy.AccessibilityId("");
	private By lblAccountCreatedDesc = MobileBy.AccessibilityId("");
	private By btnAddCreditOrDebit = MobileBy.AccessibilityId("");
	private By btnSkip =MobileBy.AccessibilityId("");
	
	public void verifyAccountCreatedHdgView() {
		if(getElementList(lblAccountCreatedhdg, "lblAccountCreatedhdg").size()>0) {
		new AndroidCommonFunctions().elementView(lblAccountCreatedhdg, "Account Created");
		}
	}
	public void verifyAccountCreatedImageView() {
		new AndroidCommonFunctions().elementView(lblAccountCreatedImg, "Account Created Image");
		ExtentTestManager.setInfoMessageInReport("the desc is:" + getText(lblAccountCreatedDesc));
	}
	
	public void clickAddCreditOrDebit() {
		if(getElement(btnAddCreditOrDebit, "AddCreditOrDebit").isEnabled()) {
		click(btnAddCreditOrDebit, "Add Debit or Credit");
		
		}
	}
	public void clickSkip() {
		if(getElement(btnSkip, "Skip").isEnabled()) {
		click(btnSkip, "Skip");
		}
	}
	
}
