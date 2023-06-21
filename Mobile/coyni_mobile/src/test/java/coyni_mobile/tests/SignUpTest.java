package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.pages.LandingPage;
import coyni_mobile.pages.SignUpPage;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class SignUpTest {

	SignUpPage signUpPage;
	LandingPage landingPage;

	@BeforeTest
	public void init() {
		signUpPage = new SignUpPage();
		landingPage = new LandingPage();
	}

//	/**
//	 * testCreateAccountInvalidData script is to test By giving Invalid data in the
//	 * text fields and validating Error messages.
//	 * 
//	 * @param strParams
//	 */
//	@Test
//	@Parameters({ "strParams" })
//	public void testCreateAccountInvalidData(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			landingPage.clickGetStarted();
//			landingPage.chooseAccountPage().clickPersonalAccount();
//			signUpPage.verifyCreateAccount(data.get("createAccount"));
//			signUpPage.fillFirstName(data.get("firstName"));
//			signUpPage.fillLastName(data.get("lastName"));
//			signUpPage.fillEmail(data.get("email"));
//			signUpPage.fillPhoneNumber(data.get("phoneNumber"));
//			signUpPage.fillPassword(data.get("password"));
//			if (data.get("validatePassword").equalsIgnoreCase("Yes")) {
//				signUpPage.verifyPasswordREquirementError(data.get("errMessage"));
//			}
//			Thread.sleep(1000);
//			// signUpPage.validateCreatePassword();
//			signUpPage.fillConfirmPassword(data.get("confirmPassword"));
//			if (data.get("validatePhoneNumber").equalsIgnoreCase("Yes")) {
//				signUpPage.clickNext();
//				signUpPage.verifyPhnNumErrorMsg(data.get("phNumErrorMsg"));
//				signUpPage.clickOk();
//			}
//			if (data.get("validateConfirmPassword").equalsIgnoreCase("Yes")) {
//				signUpPage.verifyPwdNotMatched(data.get("errMessage"));
//			}
//			if (data.get("validateErrorMessage").equalsIgnoreCase("Yes")) {
//				Thread.sleep(1000);
//				if (!data.get("errMessage").isEmpty() /* && !data.get("elementName").equals("Phone Number") */) {
//
//					new CommonFunctions().validateFormErrorMessageIOS(data.get("errMessage"), data.get("elementName"));
//				}
//			}
////			if (data.get("elementName").equals("Phone Number")) {
////				signUpPage.validatePhoneErrorMsg(data.get("errMessage"), data.get("elementName"));
////			}
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
//		}
//
//	}
//
//	/**
//	 * testFieldValidationCreateAccount script is to test the field validations for
//	 * create account text fields.
//	 * 
//	 * @param strParams
//	 */
//	@Test
//	@Parameters({ "strParams" })
//	public void testFieldValidationCreateAccount(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			landingPage.clickGetStarted();
//			landingPage.chooseAccountPage().clickPersonalAccount();
//			signUpPage.validateFirstNameField(data.get("firstName"));
//			signUpPage.validateLastNameField(data.get("lastName"));
////			signUpPage.validateEmail(data.get("email"));
////			signUpPage.validatePhoneNumber(data.get("phoneNumber"));
//			Thread.sleep(10000);
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Failed due to this Exception" + e);
//		}
//
//	}

	@Test
	@Parameters({ "strParams" })
	public void testSignUp(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			if(data.get("validateCreateAccount").equalsIgnoreCase("Yes")) {
			landingPage.clickSignUp();
			signUpPage.VerifyPhoneNumberView(data.get("phoneNumDesc"));
			signUpPage.clickDopdown();
			signUpPage.fillSearch(data.get("country"));
			signUpPage.fillPhoneNumbers(data.get("phoneNumber"));
			signUpPage.clickContinue();
			signUpPage.phoneAndEmailVerificationComponent()
					.verifyPhoneVerificationView(data.get("phoneVerificationDescription"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("otp"));
			signUpPage.verifyEmailView(data.get("emailDescription"));
			signUpPage.fillEmail(data.get("email"));
			signUpPage.clickContinue();
			signUpPage.phoneAndEmailVerificationComponent()
					.verifyEmailVerificationView(data.get("emailVerificationDescription"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("otp"));
			signUpPage.verifyNameView(data.get("nameDesc"));
			signUpPage.fillFirstName(data.get("firstName"));
			signUpPage.fillLastName(data.get("lastName"));
			signUpPage.clickContinue();
			signUpPage.verifyPasswordView(data.get("passwordDesc"));
			signUpPage.fillPassword(data.get("password"));
			signUpPage.clickEye();
			signUpPage.clickContinue();
			signUpPage.phoneAndEmailVerificationComponent().agreementPage().verifyLegalView(data.get("legalDesc"));
//			signUpPage.phoneAndEmailVerificationComponent().agreementPage().clickPrivacyPolicy();
//			signUpPage.phoneAndEmailVerificationComponent().agreementPage().clickDone();
//			signUpPage.phoneAndEmailVerificationComponent().agreementPage().clickTermsOfService();
			signUpPage.phoneAndEmailVerificationComponent().agreementPage().clickCheckBox();
			signUpPage.phoneAndEmailVerificationComponent().agreementPage().clickAgree();
			}
		//	}
		if(data.get("validateLogin").equalsIgnoreCase("Yes")) {
				landingPage.clickLogin();
				signUpPage.loginPage().fillEmail(data.get("email"));
				signUpPage.loginPage().fillPassword(data.get("password"));
				signUpPage.loginPage().clickLogin();
				signUpPage.phoneAndEmailVerificationComponent()
				.verifyPhoneVerificationView(data.get("phoneVerificationDescription"));
		        signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("otp"));
			}
		if(data.get("validatePin").equalsIgnoreCase("Yes")) {
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().verifyChooseYourPinView();
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().fillPin(data.get("pin"));
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyConfirmYourPin(data.get("confirmPinHeading"));
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().fillPin(data.get("pin"));
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().enableFaceOrTouchIDpage()
					.verifyEnableFaceIdView();
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().enableFaceOrTouchIDpage()
					.clickNotNow();
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().enableFaceOrTouchIDpage().clickSkip();
		}	
		if(data.get("validateSkip").equalsIgnoreCase("Yes")) {
			  if(signUpPage.phoneAndEmailVerificationComponent().accountCreatedPage().VerifyGoToDashboard()==1) {
				    signUpPage.phoneAndEmailVerificationComponent().accountCreatedPage().clickGoToDashboard();
			  }else {
		signUpPage.phoneAndEmailVerificationComponent().agreementPage().choosePinComponent().enableFaceOrTouchIDpage()
				.accountCreatedPage().clickSkip();
			  }
//					Thread.sleep(5000);
//					signUpPage.dashboardPage().verifyAddPaymentView();
//					signUpPage.dashboardPage().clickAddPayment();
//					signUpPage.dashboardPage().addNewPaymentComponent().verifyAddNewPaymentHeading(data.get("addPaymentMethodHeading"));
//					signUpPage.navigationComponent().clickClose();
					Thread.sleep(5000);
					if(data.get("validateAddressDashboard").equalsIgnoreCase("Yes")) {
					if(data.get("validateAddress").equalsIgnoreCase("Yes")) {
					signUpPage.dashboardPage().verifyAddAddressview();
					signUpPage.dashboardPage().clickAddAddress();
					signUpPage.dashboardPage().verifyAddAddressHdg(data.get("addAddressHeading"));
					}
					if(data.get("validateProfileAddress").equalsIgnoreCase("Yes")) {
					signUpPage.navigationComponent().clickClose();
			        signUpPage.dashboardPage().clickProfile();
			        signUpPage.customerProfilePage().clickProfile();
			        signUpPage.customerProfilePage().profilePage().clickEditAddress();
			        signUpPage.customerProfilePage().profilePage().editProfilePage().clickChange();
			        signUpPage.customerProfilePage().profilePage().editProfilePage().verifyEditAddres(data.get("editAddressHeading"));
					}
			        signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent().clickCountryDropdown();
			        signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
							.selectCountry(data.get("fillCountry"));
			        signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
							.fillAddLine1(data.get("addline1"));
			        signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
							.fillAddLine2(data.get("addline2"));
			        signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent().fillCity(data.get("city"));
			        signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent().fillState(data.get("state"));
			        signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
							.fillZipCode(data.get("zipcode"));
			        
			        signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent().clickAddAddress();
			        signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent().verifyAddressAdded();
			        signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent().clickDoneButton();
					}  
		}
			if (data.get("validateAddDebitOrCreditCard").equalsIgnoreCase("Yes")) {
				  if(signUpPage.phoneAndEmailVerificationComponent().accountCreatedPage().VerifyGoToDashboard()==1) {
				    signUpPage.phoneAndEmailVerificationComponent().accountCreatedPage().clickGoToDashboard();
				    Thread.sleep(3000);
				    signUpPage.dashboardPage().clickAddPayment();
				 //   signUpPage.dashboardPage().addNewPaymentComponent().verifyAddNewPaymentHeading(data.get("addPaymentMethodHeading"));
				    Thread.sleep(1000);
				    signUpPage.dashboardPage().addNewPaymentComponent().clickDebitCard();
				    if(signUpPage.dashboardPage().addNewPaymentComponent().verifyCoyniView()==1) {
				//    signUpPage.dashboardPage().addNewPaymentComponent().verifyCoyniView();
				    signUpPage.dashboardPage().addNewPaymentComponent().verifyErrorTextView();
				    }else {
				    	signUpPage.addCardComponent().verifyHeadingView();
				    	signUpPage.addCardComponent().navigationComponent().clickBack();
				    }
				    Thread.sleep(1000);
				    signUpPage.dashboardPage().addNewPaymentComponent().clickCreditCard();
				    if(signUpPage.dashboardPage().addNewPaymentComponent().verifyCoyniView()==1) {
				    	signUpPage.dashboardPage().addNewPaymentComponent().verifyErrorTextView();
				    }else {
				    	signUpPage.addCardComponent().verifyHeadingView();
				    	signUpPage.addCardComponent().navigationComponent().clickBack();
				    }
				  }else {
						signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().enableFaceOrTouchIDpage().accountCreatedPage()
						.verifyAccountCreatedImageView();
			        	signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().enableFaceOrTouchIDpage().accountCreatedPage()
						.verifyAccountCreatedHdgView(data.get("description"));
						signUpPage.phoneAndEmailVerificationComponent().accountCreatedPage().clickAddCreditOrDebit();
						Thread.sleep(2000);
						 signUpPage.dashboardPage().clickAddPayment();
						 Thread.sleep(1000);
						 signUpPage.dashboardPage().addNewPaymentComponent().clickDebitCard();
							signUpPage.addCardComponent().verifyPageHeading(data.get("expCardHeading"));
							signUpPage.addCardComponent().verifyHeadingView();
							signUpPage.addCardComponent().fillNameOnCard(data.get("NameonCard"));
							signUpPage.addCardComponent().fillCardNumber(data.get("cardNumber"));
							signUpPage.addCardComponent().fillCardExp(data.get("cardExp"));
							signUpPage.addCardComponent().fillCVVorCVC(data.get("cvvCVC"));
							signUpPage.addCardComponent().clickContinue();
							if(data.get("addAddress").equalsIgnoreCase("Yes")) {
							signUpPage.addCardComponent().mailingAddressComponent().verifyBillingAddressView();
							signUpPage.addCardComponent().mailingAddressComponent().clickCountryDropdown();
							signUpPage.addCardComponent().mailingAddressComponent().selectCountry(data.get("country"));
							signUpPage.addCardComponent().mailingAddressComponent().fillAddLine1(data.get("addline1"));
							signUpPage.addCardComponent().mailingAddressComponent().fillAddLine2(data.get("addline2"));
							signUpPage.addCardComponent().mailingAddressComponent().fillCity(data.get("city"));
							signUpPage.addCardComponent().mailingAddressComponent().fillState(data.get("state"));
							signUpPage.addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));
							if(data.get("validateCheckbox").equalsIgnoreCase("Yes")) {
								signUpPage.addCardComponent().mailingAddressComponent().clickSaveThisAddCheckBox();
							}
							}
							signUpPage.addCardComponent().mailingAddressComponent().clickAddCard();
							if (data.get("validateAuthorization").equalsIgnoreCase("Yes")) {
								signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
										.verifyHeading(data.get("preAuthHeading"));
								signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
										.fillAmount(data.get("amount"));
								Thread.sleep(1000);
								signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent().clickVerify();
								Thread.sleep(2000);
								signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
										.successFailureComponent().verifyAllDone(data.get("sucessHeading"));
								Thread.sleep(1000);
								signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
								.successFailureComponent().verifyCardSucessDesc(data.get("sucessDescription"));
								signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
								.successFailureComponent().clickDone();
							 }
							if(data.get("validateBuyToken").equalsIgnoreCase("Yes")) {
								Thread.sleep(4000);
					       signUpPage.dashboardPage().verifyBuyTokensView();
					       signUpPage.phoneAndEmailVerificationComponent().agreementPage().choosePinComponent().enableFaceOrTouchIDpage()
							.accountCreatedPage().clickSkip();
					       if(data.get("validateAddAddressView").equalsIgnoreCase("Yes")) {
					    	   signUpPage.dashboardPage().verifyAddAddressview();
							}
						  }
						}
 
				        
				        
				        
				        
				        
				        
				        
				        
				        
				        
				        
				        
				        
				        
				        
				        
				        signUpPage.customerProfilePage().profilePage().editProfilePage().clickSave();
				        signUpPage.navigationComponent().clickBack();
				        signUpPage.navigationComponent().clickBack();
				        signUpPage.navigationComponent().clickBack();
			}       
			} catch (Exception e) {
				ExtentTestManager.setFailMessageInReport("test SignUp Failed due to this Exception" + e);
			}
		}
			
			
			
			
			
			
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
			
//			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().enableFaceOrTouchIDpage().accountCreatedPage()
//					.verifyAccountCreatedImageView();
//			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().enableFaceOrTouchIDpage().accountCreatedPage()
//					.verifyAccountCreatedHdgView(data.get("description"));
//			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().enableFaceOrTouchIDpage().accountCreatedPage()
//					.clickAddCreditOrDebit();
//			signUpPage.addCardComponent().verifyAddDebitorCredHeadingView(data.get("expHeading"));
//			signUpPage.addCardComponent().fillNameOnCard(data.get("NameonCard"));
//			signUpPage.addCardComponent().fillCardNumber(data.get("cardNumber"));
//			signUpPage.addCardComponent().fillCardExp(data.get("cardExp"));
//			signUpPage.addCardComponent().fillCVVorCVC(data.get("cvvCVC"));
//			signUpPage.addCardComponent().clickContinue();
//			signUpPage.addCardComponent().mailingAddressComponent().verifyBillingAddressView();
//			signUpPage.addCardComponent().mailingAddressComponent().clickCountryDropdown();
//			signUpPage.addCardComponent().mailingAddressComponent().selectCountry(data.get("country"));
//			signUpPage.addCardComponent().mailingAddressComponent().fillAddLine1(data.get("addline1"));
//			signUpPage.addCardComponent().mailingAddressComponent().fillAddLine2(data.get("addline2"));
//			signUpPage.addCardComponent().mailingAddressComponent().fillCity(data.get("city"));
//			signUpPage.addCardComponent().mailingAddressComponent().fillState(data.get("state"));
//			signUpPage.addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipCode"));
//			if(data.get("validateCheckbox").equalsIgnoreCase("Yes")) {
//				signUpPage.addCardComponent().mailingAddressComponent().clickSaveThisAddCheckBox();
//			}
//			signUpPage.addCardComponent().mailingAddressComponent().clickAddCard();
//			if (data.get("validateAuthorization").equalsIgnoreCase("Yes")) {
//				signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
//						.verifyHeading(data.get("preAuthHeading"));
//				signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
//						.fillAmount(data.get("amount"));
//				Thread.sleep(1000);
//				signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent().clickVerify();
//				Thread.sleep(2000);
//				signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
//						.successFailureComponent().verifyAllDone(data.get("sucessHeading"));
//				Thread.sleep(1000);
//				signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
//				.successFailureComponent().verifyCardSucessDesc(data.get("sucessDescription"));
////				signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
////				.successFailureComponent().clickDone();
//			 }
//
//			if(data.get("validateSkip").equalsIgnoreCase("Yes")) {
//			  if(signUpPage.phoneAndEmailVerificationComponent().accountCreatedPage().VerifyGoToDashboard()==1) {
//				    signUpPage.phoneAndEmailVerificationComponent().accountCreatedPage().clickGoToDashboard();
//			  }else {
//		signUpPage.phoneAndEmailVerificationComponent().agreementPage().choosePinComponent().enableFaceOrTouchIDpage()
//				.accountCreatedPage().clickSkip();
//			  }
//		Thread.sleep(5000);
//		signUpPage.dashboardPage().clickAddPayment();
//		signUpPage.dashboardPage().addNewPaymentComponent().verifyAddNewPaymentHeading(data.get("addPaymentMethodHeading"));
//		signUpPage.dashboardPage().addNewPaymentComponent().clickCross();
//		Thread.sleep(5000);
//		signUpPage.dashboardPage().clickAddAddress();
//		signUpPage.dashboardPage().verifyAddAddressview();
//		signUpPage.dashboardPage().navigationComponent().clickBack();
//        signUpPage.dashboardPage().clickProfile();
//      signUpPage.customerProfilePage().clickProfile();
//      signUpPage.customerProfilePage().profilePage().clickEditAddress();
//      signUpPage.customerProfilePage().profilePage().clickChange();
////      signUpPage.customerProfilePage().userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
//      signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent().clickCountryDropdown();
//      signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent().selectCountry(data.get("country"));
//      signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent().fillAddLine1(data.get("addline1"));
//      signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent().fillAddLine1(data.get("addline2"));
//      signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent().fillCity(data.get("city"));
//      signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent().selectState(data.get("state"));
//      signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent().fillZipCode(data.get("zipcode"));
//      signUpPage.customerProfilePage().profilePage().editProfilePage().clickSave();
//      signUpPage.customerProfilePage().profilePage().editProfilePage().navigationComponent().clickBack();
//      signUpPage.customerProfilePage().profilePage().editProfilePage().navigationComponent().clickClose();
//	//		}

//			landingPage.clickGetStarted();
//			landingPage.chooseAccountPage().clickPersonalAccount();
//		//	if(data.get("validateCreateAccount").equalsIgnoreCase("Yes")) {
//			signUpPage.verifyCreateAccount(data.get("createAccount"));
//			signUpPage.fillFirstName(data.get("firstName"));
//			signUpPage.fillLastName(data.get("lastName"));
//			signUpPage.fillEmail(data.get("email"));
//			signUpPage.fillPhoneNumber(data.get("phoneNumber"));
//			signUpPage.fillPassword(data.get("password"));
//			Thread.sleep(1000);
//			signUpPage.fillConfirmPassword(data.get("confirmPassword"));
//			Thread.sleep(2000);
//		//	signUpPage.clickCheckBox();
//			signUpPage.clickNext();
//		    String lblPhoneHeading = signUpPage.phoneAndEmailVerificationComponent().getPhoneHeading();
//		    if(lblPhoneHeading.contains("Please Verify")) {
//		     	signUpPage.phoneAndEmailVerificationComponent().verifyPhoneHeading(phoneHeading[0]);
//		    }
//		    	else{
//		    		signUpPage.phoneAndEmailVerificationComponent().verifyPhoneHeading(phoneHeading[1]);
//		    	}
//	//		signUpPage.phoneAndEmailVerificationComponent().verifyPhoneHeading(data.get("phoneVerificationHeading"));
//			signUpPage.phoneAndEmailVerificationComponent().fillOTP(data.get("code"));
//			signUpPage.phoneAndEmailVerificationComponent().verifyEmailHeading(data.get("emailVerificationHeading"));
//			signUpPage.phoneAndEmailVerificationComponent().fillOTP(data.get("code"));
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().TermsOfservice();
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().clickchkBx();
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().clickNextButton();
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().scrollPrivacyPOlicy();
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().clickchkBx();
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().clickFinishSignUp();
//			}
//			if(data.get("validatePhoneOtp").equalsIgnoreCase("Yes")) {
//				landingPage.clickLogin();
//				signUpPage.loginPage().fillEmail(data.get("email"));
//				signUpPage.loginPage().fillPassword(data.get("password"));
//				signUpPage.loginPage().clickLogin();
//				 String lblPhoneHeading = signUpPage.phoneAndEmailVerificationComponent().getPhoneHeading();
//				    if(lblPhoneHeading.contains("Please Verify")) {
//				     	signUpPage.phoneAndEmailVerificationComponent().verifyPhoneHeading(phoneHeading[0]);
//				    }
//				    	else{
//				    		signUpPage.phoneAndEmailVerificationComponent().verifyPhoneHeading(phoneHeading[1]);
//				    	}
//				signUpPage.phoneAndEmailVerificationComponent().fillOTP(data.get("code"));
//			}
//			if(data.get("validatePin").equalsIgnoreCase("Yes")) {
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage()
//					.verifyHeading(data.get("secureYourAccountHeading"));
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().clickNext();
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
//					.verifyChoosePinHeading(data.get("choosePinHeading"));
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
//					.fillPin(data.get("pin"));
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
//					.verifyConfirmPinHeading(data.get("confirmPinHeading"));
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent()
//					.fillPin(data.get("pin"));
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
//					.verifyHeading(data.get("enableFaceIdHeading"));
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage().verifyDontRemindButtonView();
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage().verifyEnableFaceIDButtonView();
//			Thread.sleep(3000);
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
//					.clickNotNow();
////			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
////					.accountCreatedPage().verifyAccountCreatedHdg(data.get("createAccountHeading"));
//			}
//			if (data.get("validateAddDebitOrCreditCard").equalsIgnoreCase("Yes")) {
//			  if(signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage().accountCreatedPage().VerifyGoToDashboard()==1) {
//			    signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage().accountCreatedPage().clickGoToDashboard();
//			    Thread.sleep(3000);
//			    signUpPage.dashboardPage().clickPayment();
//			 //   signUpPage.dashboardPage().addNewPaymentComponent().verifyAddNewPaymentHeading(data.get("addPaymentMethodHeading"));
//			    Thread.sleep(1000);
//			    signUpPage.dashboardPage().addNewPaymentComponent().clickDebitCard();
//			    if(signUpPage.dashboardPage().addNewPaymentComponent().verifyCoyniView()==1) {
//			//    signUpPage.dashboardPage().addNewPaymentComponent().verifyCoyniView();
//			    signUpPage.dashboardPage().addNewPaymentComponent().verifyErrorTextView();
//			    }else {
//			    	signUpPage.addCardComponent().verifyHeadingView();
//			    	signUpPage.addCardComponent().navigationComponent().clickBack();
//			    }
//			    Thread.sleep(1000);
//			    signUpPage.dashboardPage().addNewPaymentComponent().clickCreditCard();
//			    if(signUpPage.dashboardPage().addNewPaymentComponent().verifyCoyniView()==1) {
//			    	signUpPage.dashboardPage().addNewPaymentComponent().verifyErrorTextView();
//			    }else {
//			    	signUpPage.addCardComponent().verifyHeadingView();
//			    	signUpPage.addCardComponent().navigationComponent().clickBack();
//			    }
//			    
//			  }else {
//			    signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
//					.accountCreatedPage().verifyAccountCreatedHdg(data.get("createAccountHeading"));
//				signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
//				.accountCreatedPage().clickAddCreditOrDebit();
//				Thread.sleep(2000);
//				 signUpPage.dashboardPage().clickPayment();
//				 Thread.sleep(1000);
//				 signUpPage.dashboardPage().addNewPaymentComponent().clickDebitCard();
//				signUpPage.addCardComponent().verifyPageHeading(data.get("expCardHeading"));
//				signUpPage.addCardComponent().verifyHeadingView();
//				signUpPage.addCardComponent().fillNameOnCard(data.get("NameOnCard"));
//				signUpPage.addCardComponent().fillCardNumber(data.get("cardNumber"));
//				Thread.sleep(2000);
//				signUpPage.addCardComponent().fillCardExp(data.get("cardExp"));
//				signUpPage.addCardComponent().fillCVVorCVC(data.get("cvvCVC"));
//				signUpPage.addCardComponent().clickNext();
//				signUpPage.addCardComponent().verifyPageHeading(data.get("expCardHeading"));
//				signUpPage.addCardComponent().mailingAddressComponent().fillAddressLine1(data.get("addline1"));
//				signUpPage.addCardComponent().mailingAddressComponent().fillAddressLine2(data.get("addline2"));
//				signUpPage.addCardComponent().mailingAddressComponent().fillCity(data.get("city"));
//				signUpPage.addCardComponent().mailingAddressComponent().selectState(data.get("state"));
//				signUpPage.addCardComponent().mailingAddressComponent().fillZipCode(data.get("zipcode"));
//				signUpPage.addCardComponent().mailingAddressComponent().verifyCountry(data.get("expCountry"));
//				if(data.get("validateSaveAddressCheckBox").equalsIgnoreCase("Yes")) {
//				signUpPage.addCardComponent().mailingAddressComponent().clickSaveThisAddCheckBox();
//				}
//				Thread.sleep(4000);
//				signUpPage.addCardComponent().mailingAddressComponent().clickAddCard();
//				if (data.get("validateAuthorization").equalsIgnoreCase("Yes")) {
//					signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
//							.verifyHeading(data.get("preAuthHeading"));
//					signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
//							.fillAmount(data.get("amount"));
//					Thread.sleep(1000);
//					signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent().clickVerify();
//					Thread.sleep(2000);
//					signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
//							.successFailureComponent().getStatus();
//					signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
//							.successFailureComponent().clickDone();
//					Thread.sleep(1000);
//				}
//				if(data.get("validateBuyToken").equalsIgnoreCase("Yes")) {
//					Thread.sleep(4000);
//		       signUpPage.dashboardPage().verifyBuyTokenView();
//				}
//			  }
//			}
//			if(data.get("validateSkip").equalsIgnoreCase("Yes")) {
//				  if(signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage().accountCreatedPage().VerifyGoToDashboard()==1) {
//					    signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage().accountCreatedPage().clickGoToDashboard();
//				  }else {
//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
//					.accountCreatedPage().clickSkip();
//				  }
//			Thread.sleep(5000);
//			signUpPage.dashboardPage().verifyAddPaymentView();
//			signUpPage.dashboardPage().clickPayment();
//			signUpPage.dashboardPage().addNewPaymentComponent().verifyAddNewPaymentHeading(data.get("addPaymentMethodHeading"));
//			signUpPage.dashboardPage().addNewPaymentComponent().clickCross();
//			Thread.sleep(5000);
//			signUpPage.dashboardPage().verifyAddAddressView();
//			signUpPage.dashboardPage().clickAddanAddresss();
//			signUpPage.dashboardPage().verifyAddAddressHeading(data.get("addAddressHeading"));
//			signUpPage.dashboardPage().addNewPaymentComponent().clickCross();
//	        signUpPage.tokenAccountPage().clickProfile();
//	     //   signUpPage.customerProfilePage().clickUserDetails();
//	        signUpPage.customerProfilePage().userDetailsPage().clickEditAddress();
//	        signUpPage.customerProfilePage().userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
//	        signUpPage.customerProfilePage().userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().fillAddLine1(data.get("addline1"));
//	        signUpPage.customerProfilePage().userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().fillAddLine1(data.get("addline2"));
//	        signUpPage.customerProfilePage().userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().fillCity(data.get("city"));
//	        signUpPage.customerProfilePage().userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().selectState(data.get("state"));
//	        signUpPage.customerProfilePage().userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().fillZipCode(data.get("zipcode"));
//	        signUpPage.customerProfilePage().userDetailsPage().enterYourPINComponent().editAddressPage().clickSave();
//	        signUpPage.customerProfilePage().userDetailsPage().enterYourPINComponent().editAddressPage().navigationComponent().clickBack();
//	        signUpPage.customerProfilePage().userDetailsPage().enterYourPINComponent().editAddressPage().navigationComponent().clickBack();
//	        signUpPage.customerProfilePage().userDetailsPage().enterYourPINComponent().editAddressPage().navigationComponent().clickBack();

//	        customerProfilePage.userDetailsPage().enterYourPINComponent().verifyEnterYourPinView();
//			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyPinView();
//			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyForgotPinView();
//			customerProfilePage.userDetailsPage().enterYourPINComponent().navigationComponent().clickClose();
//			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
//			customerProfilePage.userDetailsPage().clickEditAddress();
//			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage()
//					.verifyHeading(data.get("editAddrHeading"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
//					.verifyLine1View(data.get("addline1"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
//					.verifyLine2View(data.get("addline2"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
//					.verifyCityView(data.get("city"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
//					.verifyStateView();
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
//					.verifyZipCodeView();
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
//					.validateZipCode(data.get("zipcode"));

//			signUpPage.phoneAndEmailVerificationComponent().secureAccountPage().choosePinComponent().enableFaceIDpage()
//			.tokenAccountPage().verifyRegistration();
	

	@Test
	@Parameters({ "strParams" })
	public void testSignUpFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickSignUp();
			signUpPage.clickDopdown();
			signUpPage.fillSearch(data.get("country"));
			signUpPage.validatePhoneNumber(data.get("phoneNumber"));
			signUpPage.clickContinue();
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("Otp"));
			signUpPage.validateEmail(data.get("email"));
			signUpPage.clickContinue();
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("Otp"));
			signUpPage.validateFirstNameField(data.get("firstName"));
			signUpPage.validateLastNameField(data.get("lastName"));
			signUpPage.clickContinue();
			signUpPage.CreatePasswordfields(data.get("password"));
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test SignUp field validations is Failed due to this Exception" + e);
		}

	}

}
