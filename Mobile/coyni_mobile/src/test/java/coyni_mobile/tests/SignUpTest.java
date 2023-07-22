package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.pages.LandingPage;
import coyni_mobile.pages.SignUpPage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class SignUpTest {

	SignUpPage signUpPage;
	LandingPage landingPage;

	@BeforeTest
	public void init() {
		signUpPage = new SignUpPage();
		landingPage = new LandingPage();
		DriverFactory.getDriver().resetApp();
		DriverFactory.getDriver().hideKeyboard();
	}

	@Test
	@Parameters({ "strParams" })
	public void testSignUpWithAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			validateSignUp(strParams);
			if (data.get("validateLogin").equalsIgnoreCase("Yes")) {
				signUpPage.phoneAndEmailVerificationComponent().choosePinComponent()
						.verifyChooseYourPinView(data.get("choosePinHeading"));
				DriverFactory.getDriver().closeApp();
				DriverFactory.getDriver().activateApp("com.coyni.mapp");
				landingPage.clickLogin();
				signUpPage.loginPage().fillEmail(data.get("email"));
				signUpPage.loginPage().fillPassword(data.get("password"));
				signUpPage.loginPage().clickLogin();
				signUpPage.phoneAndEmailVerificationComponent()
						.verifyPhoneVerificationHeading(data.get("phNumVerifiHeadi"));
				signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			}
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyChooseYourPinView(data.get("choosePinHeading"));
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyChooseYouPinDes(data.get("choosePinDesc"));
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().fillPin(data.get("pin"));
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyConfirmYourPin(data.get("confirmPinHeading"));
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().fillPin(data.get("pin"));
//			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().toastComponent()
//					.verifyToastMsg(data.get("toastMsg"));
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().enableFaceOrTouchIDpage()
					.verifyEnableFaceIdView();
			if (data.get("validateLogin").equalsIgnoreCase("Yes")) {
				signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().enableFaceOrTouchIDpage()
						.clickNotNow();
//				Add Address in Profile
				signUpPage.dashboardPage().clickProfile();
				signUpPage.customerProfilePage().clickProfile();
				signUpPage.customerProfilePage().profilePage().clickEditAddress();
				signUpPage.customerProfilePage().profilePage().editProfilePage()
						.verifyEditAddres(data.get("editAddressHeading"));
				testAddAddress(strParams);
				signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
						.verifyAddressAdded(data.get("addressDesc"));
				signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent().clickDone();
				signUpPage.dashboardPage().navigationComponent().clickClose();
				signUpPage.dashboardPage().validateAddAddressview();
//				Add Payment method in Dash Board
				signUpPage.dashboardPage().clickAddPayment();
				signUpPage.dashboardPage().addNewPaymentComponent()
						.verifyAddPaymentHeading(data.get("addPaymentHeading"));
				signUpPage.dashboardPage().addNewPaymentComponent().clickDebitCard();
				testAddCard(strParams);
				signUpPage.dashboardPage().validateAddPaymntView();
				signUpPage.dashboardPage().clickProfile();
				signUpPage.customerProfilePage().clickPaymentMethods();
				signUpPage.dashboardPage().addNewPaymentComponent().viewCard();
			} else {
				signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().enableFaceOrTouchIDpage()
						.clickSkip();
				if (signUpPage.phoneAndEmailVerificationComponent().accountCreatedPage().VerifyGoToDashboard() == 1) {
					signUpPage.phoneAndEmailVerificationComponent().accountCreatedPage().clickGoToDashboard();
				} else {
					signUpPage.phoneAndEmailVerificationComponent().agreementPage().choosePinComponent()
							.enableFaceOrTouchIDpage().accountCreatedPage().clickSkip();
				}
//				Add Address in Dash Board
				signUpPage.dashboardPage().verifyAddAddressview();
				signUpPage.dashboardPage().clickAddAddress();
				signUpPage.dashboardPage().verifyAddAddressHdg();
				testAddAddress(strParams);
				signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
						.verifyAddressAdded(data.get("addressDesc"));
				signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent().clickDone();
				signUpPage.dashboardPage().validateAddAddressview();
				signUpPage.dashboardPage().clickProfile();
				signUpPage.customerProfilePage().clickProfile();
				signUpPage.customerProfilePage().profilePage().clickEditAddress();
				signUpPage.dashboardPage().navigationComponent().clickBack();
				signUpPage.dashboardPage().navigationComponent().clickClose();
//				Add Payment in Profile			
				signUpPage.dashboardPage().clickProfile();
				signUpPage.customerProfilePage().clickPaymentMethods();
				signUpPage.dashboardPage().addNewPaymentComponent()
						.verifyAddPaymentHeading(data.get("addPaymentHeading"));
				signUpPage.dashboardPage().addNewPaymentComponent().clickCreditCard();
				testAddCard(strParams);
				signUpPage.dashboardPage().navigationComponent().clickBack();
				signUpPage.dashboardPage().navigationComponent().clickClose();
				signUpPage.dashboardPage().validateAddPaymntView();
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test SignUp Failed due to this Exception" + e);
		}
	}

	public void testAddAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
					.clickCountryDropdown();
			signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
					.selectCountry(data.get("country"));
			signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
					.fillAddLine1(data.get("addLine1"));
			signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
					.fillAddLine2(data.get("addLine2"));
			signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
					.fillCity(data.get("city"));
			signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
					.fillState(data.get("state"));
			signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
					.clickAddAddress();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("AddAddress is failed due to Exception " + e);
		}
	}

	public void testAddCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			signUpPage.addCardComponent().verifyAddDebitorCredHeading(data.get("cardHeading"));
			signUpPage.addCardComponent().viewAddcardDesc();
			signUpPage.addCardComponent().fillNameOnCard(data.get("nameonCard"));
			signUpPage.addCardComponent().fillCardNumber(data.get("cardNumber"));
			signUpPage.addCardComponent().fillCardExp(data.get("cardExp"));
			signUpPage.addCardComponent().fillCVVorCVC(data.get("cvv"));
			signUpPage.addCardComponent().clickNext();
			signUpPage.addCardComponent().verifyAddDebitorCredHeading(data.get("cardHeading"));
			signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
					.clickAddAddress();
			signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
					.verifyHeading(data.get("preAuthHeading"));
			signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
					.fillAmount(data.get("amount"));
			signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent().clickVerify();
			signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
					.successFailureComponent().verifyAllDone(data.get("cardSucessHeading"));
			signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
					.successFailureComponent().verifyCardSucessDesc(data.get("cardSucessDescription"));
			signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
					.successFailureComponent().clickDone();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("AddAddress is failed due to Exception " + e);
		}
	}

	public void validateSignUp(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickSignUp();
			signUpPage.VerifyPhoneNumberHeading(data.get("phoneNumDesc"));
			signUpPage.clickDopdown();
			signUpPage.fillSearch(data.get("country"));
			signUpPage.fillPhoneNumbers(data.get("phoneNumber"));
			signUpPage.clickContinue();
			signUpPage.phoneAndEmailVerificationComponent()
					.verifyPhoneVerificationHeading(data.get("phNumVerifiHeadi"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			signUpPage.verifyEmailHeading(data.get("emailDescription"));
			signUpPage.fillEmail(data.get("email"));
			signUpPage.clickContinue();
			signUpPage.phoneAndEmailVerificationComponent()
					.verifyEmailVerificationHeading(data.get("emailVerification"));
			signUpPage.phoneAndEmailVerificationComponent().verifyEmailVerifiDesc(data.get("emailVerifiDesc"),
					data.get("email"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			signUpPage.verifyNameView(data.get("nameDesc"));
			signUpPage.fillFirstName(data.get("firstName"));
			signUpPage.fillLastName(data.get("lastName"));
			signUpPage.clickContinue();
			signUpPage.verifyPasswordView(data.get("passwordDesc"));
			signUpPage.fillPassword(data.get("password"));
			signUpPage.clickEyeIcon();
			signUpPage.clickContinue();
			signUpPage.phoneAndEmailVerificationComponent().agreementPage().verifyLegalView(data.get("legalDesc"));
			signUpPage.phoneAndEmailVerificationComponent().agreementPage().clickCheckBox();
			signUpPage.phoneAndEmailVerificationComponent().agreementPage().clickAgree();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test SignUp Failed due to this Exception" + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testSignUpWithAddDebitCreditCard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			validateSignUp(strParams);
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyChooseYourPinView(data.get("choosePinHeading"));
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyChooseYouPinDes(data.get("choosePinDesc"));
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().fillPin(data.get("pin"));
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent()
					.verifyConfirmYourPin(data.get("confirmPinHeading"));
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().fillPin(data.get("pin"));
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().enableFaceOrTouchIDpage()
					.verifyEnableFaceIdView();
			signUpPage.phoneAndEmailVerificationComponent().choosePinComponent().enableFaceOrTouchIDpage().clickSkip();
			if (signUpPage.phoneAndEmailVerificationComponent().accountCreatedPage().VerifyGoToDashboard() == 1) {
				signUpPage.phoneAndEmailVerificationComponent().accountCreatedPage().clickGoToDashboard();
			} else {
				signUpPage.phoneAndEmailVerificationComponent().accountCreatedPage().clickAddCreditOrDebit();
			}
			signUpPage.addCardComponent().verifyAddDebitorCredHeading(data.get("cardHeading"));
			signUpPage.addCardComponent().fillNameOnCard(data.get("nameonCard"));
			signUpPage.addCardComponent().fillCardNumber(data.get("cardNumber"));
			signUpPage.addCardComponent().fillCardExp(data.get("cardExp"));
			signUpPage.addCardComponent().fillCVVorCVC(data.get("cvv"));
			signUpPage.addCardComponent().clickNext();
			signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
					.verifyBillingAddress(data.get("billingAddrHeading"));
			signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
					.clickAddreChkBox();
			testAddAddress(strParams);
			signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
					.verifyHeading(data.get("preAuthHeading"));
			signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
					.fillAmount(data.get("amount"));
			signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent().clickVerify();
			signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
					.successFailureComponent()
					.verifyCardAddedHeading(data.get("cardSucessHeading"), data.get("cardSucessDescription"));
			signUpPage.addCardComponent().mailingAddressComponent().preAuthorizationComponent()
					.successFailureComponent().clickBuyTokens();
			Thread.sleep(1000);
			signUpPage.dashboardPage().buyTokenComponent().verifyBuyTokenHeading(data.get("buyTokenHeading"));

		} catch (

		Exception e) {
			ExtentTestManager.setFailMessageInReport("test SignUp Failed due to this Exception" + e);
		}
	}
}
