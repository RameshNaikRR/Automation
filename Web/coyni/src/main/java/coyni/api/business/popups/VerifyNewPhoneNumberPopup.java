package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.customer.components.AuthyComponent;
import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class VerifyNewPhoneNumberPopup extends BrowserFunctions {
	
	private By lnkResendVerificationCode = By.xpath("//button[@type='submit']");
	private By headingNewPhoneNumber = By.xpath("//h1[@class='text-cm3 tracking-normal Heading_heading1__18f6i mt-4 text-center']");
	private By lblResendVerificationCodeDescription = By.xpath("//span[contains(text(),'Verification Code Sent!')]");
	private By lblresendErrorMsg = By.xpath("//span[contains(text(),'Looks like something went wrong. Please try again')]");
	private By lblNewPhoneNumberDescriptionText = By.xpath("//span[@class='mt-8 text-base font-normal leading-5 tracking-tight text-center text-cgy4']");


	    public NavigationComponent navigationComponent() {
	    	return new NavigationComponent();
	    }
		
		public void clickOnResendVerificationCode() {
			click(lnkResendVerificationCode, "Click ResendVerificationCode");
		}
		
		public void clickMultipleResend() {
			for (int i =0 ; i<5;i++) {
				click(lnkResendVerificationCode, "Click ResendVerificationCode");
			}
		}
		
		public void verifyNewPhoneNumberScreen(String expHeadig) {
			new CommonFunctions().verifyLabelText(headingNewPhoneNumber, "Verify New Phone Number", expHeadig);
		}
		
		public void verifyNewPhoneNumberDescription(String expNewPhoneNumber) {
			new CommonFunctions().verifyLabelText(lblNewPhoneNumberDescriptionText, expNewPhoneNumber, expNewPhoneNumber);
		}
		
		public void verifyResendDescription(String expHeading) {
			click(lnkResendVerificationCode, "Click Resend");
			new CommonFunctions().verifyLabelText(lblResendVerificationCodeDescription,
					"New Phone Number Resend Verification", expHeading);
		}

		public void verifyResendDescriptionAppears() throws InterruptedException {
			click(lnkResendVerificationCode, "Click Resend");
			Thread.sleep(2900);
			boolean flag = verifyElementPresence(lblResendVerificationCodeDescription, "Resend Verification Appears");
			if (flag) {
				ExtentTestManager.setPassMessageInReport("New Phone Number Resend Verification is Appears Upto 3 seconds");
			} else {
				ExtentTestManager
						.setFailMessageInReport("New Phone Number Resend Verification is not Appears Upto 3 seconds");
			}
		}

		public void verifyResendDescriptionDisappears() throws InterruptedException {
			click(lnkResendVerificationCode, "Click Resend");
			Thread.sleep(3100);
			boolean flag = verifyElementDisplayed(lblResendVerificationCodeDescription, "Resend Verification Appears");
			if (!flag) {
				ExtentTestManager
						.setPassMessageInReport("New Phone Number Resend Verification is Disappers Upto 3 seconds");
			} else {
				ExtentTestManager
						.setFailMessageInReport("New Phone Number Resend Verification is not Disappers Upto 3 seconds");
			}
		}
		public void ResendErrorMessage(String expResendErrorMsg) {
			new CommonFunctions().verifyLabelText(lblresendErrorMsg, expResendErrorMsg, "Resend Error Message");
		}
		
		public AuthyComponent authyComponent() {
			return new AuthyComponent();
		}

}
