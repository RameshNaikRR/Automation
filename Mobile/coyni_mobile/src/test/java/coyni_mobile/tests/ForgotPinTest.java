package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.components.ForgotPinComponent;
import coyni_mobile.components.PhoneAndEmailVerificationComponent;
import coyni_mobile.components.VerifyEmailComponent;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class ForgotPinTest {

	ForgotPinComponent forgotPinComponent;
	VerifyEmailComponent verifyEmailCompnent;
	PhoneAndEmailVerificationComponent phoneAndEmailVerificationComponent;
	
	@BeforeTest
	public void init() {
		
		forgotPinComponent = new ForgotPinComponent();
		verifyEmailCompnent = new VerifyEmailComponent();
		
		phoneAndEmailVerificationComponent = new PhoneAndEmailVerificationComponent();
		
	}
	
	@Test
	@Parameters({"strParams"})
	public void testVerifyForgotPin(String strParams) {
		try{
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			forgotPinComponent.headingEnterYourPin(data.get("expEnterYourPinHeading"));
			
			  forgotPinComponent.clickForgotPin();
				
				  forgotPinComponent.headingForgotPin(data.get("expForgotPinHeading"));
				  forgotPinComponent.forgotPinDescription(data.get("expForgotPinDescrp"));
				  forgotPinComponent.emailFieldTiltle();
				  forgotPinComponent.crossIconView();
				  forgotPinComponent.verifyHeadingClickOnCrossIcon();
				 
			
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("Forgot Pin failed due to Exception " + e);
		}
	}
	
	@Test
	@Parameters({"strParams"})
	public void testVerifyVerifyEmail(String strParams) {
		try{
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			forgotPinComponent.headingEnterYourPin(data.get("expEnterYourPinHeading"));
			
			  forgotPinComponent.clickForgotPin();
				
				  forgotPinComponent.headingForgotPin(data.get("expForgotPinHeading"));
				  forgotPinComponent.emailFieldTiltle();
				  forgotPinComponent.clickNext();
				  forgotPinComponent.verifyEmailComponent().verifyEmailHeadingview();
				  forgotPinComponent.verifyEmailComponent().verifyEmailOtpHeading(data.get("expVerifyEmailDecrp"));
				  forgotPinComponent.verifyEmailComponent().verifyInputView();
				  forgotPinComponent.verifyEmailComponent().verifyResendlbl(data.get("resendlbl"));
				  forgotPinComponent.verifyEmailComponent().fillInputBoxes(data.get("otp"));
				  
		}
		
	
	catch(Exception e) {
		ExtentTestManager.setFailMessageInReport("Forgot Pin failed due to Exception " + e);
	}
	
}
	@Test
	@Parameters({"strParams"})
	public void testVerifyChooseYourPin(String strParams) {
		try{
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			forgotPinComponent.headingEnterYourPin(data.get("expEnterYourPinHeading"));
			
			  forgotPinComponent.clickForgotPin();
				
				  forgotPinComponent.headingForgotPin(data.get("expForgotPinHeading"));
				  forgotPinComponent.emailFieldTiltle();
				  forgotPinComponent.clickNext();
				  forgotPinComponent.verifyEmailComponent().verifyEmailHeadingview();
				  forgotPinComponent.verifyEmailComponent().verifyEmailOtpHeading(data.get("expVerifyEmailDecrp"));
				  forgotPinComponent.verifyEmailComponent().verifyInputView();
				  forgotPinComponent.verifyEmailComponent().verifyResendlbl(data.get("resendlbl"));
				  forgotPinComponent.verifyEmailComponent().fillInputBoxes(data.get("otp"));
				  
				  forgotPinComponent.verifyEmailComponent().choosePinComponent().verifyChoosePinHeading(data.get("expChooseYourPinHeading"));
				  forgotPinComponent.verifyEmailComponent().choosePinComponent().verifyChooseYourPinView();
				  forgotPinComponent.verifyEmailComponent().choosePinComponent().enterYourPINComponent().verifyPinView();
				  forgotPinComponent.verifyEmailComponent().choosePinComponent().verifyKeyPad();
				  
				  
				  
		}
		
	
	catch(Exception e) {
		ExtentTestManager.setFailMessageInReport("Forgot Pin failed due to Exception " + e);
	}
		
	
}	
	@Test
	@Parameters({"strParams"})
	public void testVerifyChooseYourPinWithBack(String strParams) {
		try{
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			forgotPinComponent.headingEnterYourPin(data.get("expEnterYourPinHeading"));
			
			  forgotPinComponent.clickForgotPin();
				
				  forgotPinComponent.headingForgotPin(data.get("expForgotPinHeading"));
				  forgotPinComponent.clickNext();
				  forgotPinComponent.verifyEmailComponent().verifyEmailHeadingview();
				  forgotPinComponent.verifyEmailComponent().verifyInputView();
				  forgotPinComponent.verifyEmailComponent().verifyResendlbl(data.get("resendlbl"));
				  forgotPinComponent.verifyEmailComponent().fillInputBoxes(data.get("otp"));
				  
				  forgotPinComponent.verifyEmailComponent().choosePinComponent().verifyChoosePinHeading(data.get("expChooseYourPinHeading"));
				 
				  forgotPinComponent.verifyEmailComponent().choosePinComponent().navigationComponent().clickBack();
				  forgotPinComponent.headingForgotPin(data.get("expForgotPinHeading"));
				  forgotPinComponent.clickNext();
				  forgotPinComponent.verifyEmailComponent().verifyEmailHeadingview();
					
					  forgotPinComponent.verifyEmailComponent().fillInputBoxes(data.get("otpagain") );
					  forgotPinComponent.verifyEmailComponent().choosePinComponent().
					  verifyChoosePinHeading(data.get("expChooseYourPinHeading"));
					  forgotPinComponent.verifyEmailComponent().choosePinComponent().
					  enterYourPINComponent().fillPin(data.get("pin"));
					  forgotPinComponent.verifyEmailComponent().choosePinComponent().
					  verifyConfirmPinHeading(data.get("expConfirmYourPinHeading"));
					 
		}
		
	
	catch(Exception e) {
		ExtentTestManager.setFailMessageInReport("Forgot Pin failed due to Exception " + e);
	}
}
	@Test
	@Parameters({"strParams"})
	public void testVerifyConfirmYourPin(String strParams) {
		try{
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			forgotPinComponent.headingEnterYourPin(data.get("expEnterYourPinHeading"));
			
			  forgotPinComponent.clickForgotPin();
				
				  forgotPinComponent.headingForgotPin(data.get("expForgotPinHeading"));
				  forgotPinComponent.clickNext();
				  forgotPinComponent.verifyEmailComponent().verifyEmailHeadingview();
				  forgotPinComponent.verifyEmailComponent().verifyInputView();
				  forgotPinComponent.verifyEmailComponent().fillInputBoxes(data.get("otp"));
				  
				  forgotPinComponent.verifyEmailComponent().choosePinComponent().verifyChoosePinHeading(data.get("expChooseYourPinHeading"));
					 
				 
				  forgotPinComponent.verifyEmailComponent().choosePinComponent().fillPin(data.get("pin"));
				  forgotPinComponent.verifyEmailComponent().choosePinComponent().verifyConfirmPinHeading(data.get("expConfirmYourPinHeading"));
		}
		
		
	
	catch(Exception e) {
		ExtentTestManager.setFailMessageInReport("Forgot Pin failed due to Exception " + e);
	}
}
	
	@Test
	@Parameters({"strParams"})
	public void testVerifyConfirmYourPinWithBack(String strParams) {
		try{
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			forgotPinComponent.headingEnterYourPin(data.get("expEnterYourPinHeading"));
			
			  forgotPinComponent.clickForgotPin();
				
				  forgotPinComponent.headingForgotPin(data.get("expForgotPinHeading"));
				  forgotPinComponent.clickNext();
				  forgotPinComponent.verifyEmailComponent().verifyEmailHeadingview();
				  forgotPinComponent.verifyEmailComponent().verifyInputView();
				  forgotPinComponent.verifyEmailComponent().fillInputBoxes(data.get("otp"));
				  
				  forgotPinComponent.verifyEmailComponent().choosePinComponent().verifyChoosePinHeading(data.get("expChooseYourPinHeading"));
					 
				 
				  forgotPinComponent.verifyEmailComponent().choosePinComponent().fillPin(data.get("pin"));
				  forgotPinComponent.verifyEmailComponent().choosePinComponent().verifyConfirmPinHeading(data.get("expConfirmYourPinHeading"));
				  forgotPinComponent.verifyEmailComponent().choosePinComponent().navigationComponent().clickBack();
				  forgotPinComponent.verifyEmailComponent().choosePinComponent().verifyChoosePinHeading(data.get("expChooseYourPinHeading"));
				  forgotPinComponent.verifyEmailComponent().choosePinComponent().fillPin(data.get("pin"));
				  forgotPinComponent.verifyEmailComponent().choosePinComponent().verifyConfirmPinHeading(data.get("expConfirmYourPinHeading"));
				  }
		
		
	
	catch(Exception e) {
		ExtentTestManager.setFailMessageInReport("Forgot Pin failed due to Exception " + e);
	}
}
}