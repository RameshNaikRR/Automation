package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AccountCreatedPage extends MobileFunctions {
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

//	
	/****
	 * 
	 */
	private By lblAccountCreatedhdg = MobileBy.AccessibilityId("Account Created!");
	private By lblAccountCreatedImg = MobileBy.AccessibilityId("Success image");
	private By lblAccountCreatedDesc = MobileBy.AccessibilityId("Account is Ready");
	private By btnAddCreditOrDebit = MobileBy.AccessibilityId("Add Debit or Credit Card");
	private By btnSkip = MobileBy.AccessibilityId("Skip");
	private By btnGoToDashBoard = MobileBy.xpath("(//*[@name='Go to Dashboard'])[2]");

	public void verifyAccountCreatedHdgView() {
		if (getElementList(lblAccountCreatedhdg, "lblAccountCreatedhdg").size() > 0) {
			new CommonFunctions().elementView(lblAccountCreatedhdg, "Account Created");
		}
	}

	public void verifyAccountCreatedImageView() {
		if(getElementList(lblAccountCreatedDesc, "Account Created").size()>0) {
		new CommonFunctions().elementView(lblAccountCreatedImg, "Account Created Image");
		ExtentTestManager.setInfoMessageInReport("the desc is:" + getText(lblAccountCreatedDesc));
	}
	}

	public void clickAddCreditOrDebit() {
			click(btnAddCreditOrDebit, "Add Debit or Credit");
	}
	public void verifyAccountCreatedHdgView(String desc) {
		if(getElementList(lblAccountCreatedhdg, "lblAccountCreatedhdg").size()>0) {
		new CommonFunctions().elementView(lblAccountCreatedhdg, "Account Created");
		new CommonFunctions().verifyLabelText(lblAccountCreatedDesc, "desc", desc);
		}
	}
	

	public void clickSkip() {
		if(getElementList(btnSkip, "Skip").size()>0) {
		if (getElement(btnSkip, "Skip").isEnabled()) {
			click(btnSkip, "Skip");
		}
		}
	}

	public int VerifyGoToDashboard() {
		return getElementList(btnGoToDashBoard, "btnGoToDashBoard").size();
	}

	public void clickGoToDashboard() {
		click(btnGoToDashBoard, "Go to dashboard");
	}

}
