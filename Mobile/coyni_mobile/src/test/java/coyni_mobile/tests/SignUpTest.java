package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.pages.LandingPage;
import coyni_mobile.pages.SignUpPage;
import coyni_mobile.utilities.CommonFunctions;
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
					signUpPage.dashboardPage().clickAddPayment();
					signUpPage.dashboardPage().addNewPaymentComponent()
							.verifyAddPaymentHeading(data.get("addPaymentHeading"));
					signUpPage.dashboardPage().addNewPaymentComponent().clickDebitCard();
					int errMsgDebit = signUpPage.dashboardPage().addNewPaymentComponent().validateErrorMessage();
					if (errMsgDebit == 1) {
						signUpPage.dashboardPage().addNewPaymentComponent().verifyErrorMessage(data.get("errorMsg"));
						signUpPage.dashboardPage().addNewPaymentComponent().clickOk();
						signUpPage.dashboardPage().addNewPaymentComponent()
								.verifyAddPaymentHeading(data.get("addPaymentHeading"));
					} else {
						signUpPage.dashboardPage().navigationComponent().clickBack();
					}
					signUpPage.dashboardPage().addNewPaymentComponent().clickCreditCard();
					int errMsgCredit = signUpPage.dashboardPage().addNewPaymentComponent().validateErrorMessage();
					if (errMsgCredit == 1) {
						signUpPage.dashboardPage().addNewPaymentComponent().verifyErrorMessage(data.get("errorMsg"));
						signUpPage.dashboardPage().addNewPaymentComponent().clickOk();
					} else {
						signUpPage.dashboardPage().navigationComponent().clickBack();
					}
					if (errMsgDebit == 1 || errMsgCredit == 1) {
						ExtentTestManager
								.setPassMessageInReport("Feature Control disabled,its not allowing to add cards");
					} else {
						ExtentTestManager
								.setFailMessageInReport("Feature Control disabled then also its allowing to add cards");
					}
				} else {
					signUpPage.phoneAndEmailVerificationComponent().agreementPage().choosePinComponent()
							.enableFaceOrTouchIDpage().accountCreatedPage().clickSkip();
//				Add Address in Dash Board
					signUpPage.dashboardPage().verifyAddAddressview();
					signUpPage.dashboardPage().clickAddAddress();
					signUpPage.dashboardPage().verifyAddAddressHdg();
					testAddAddress(strParams);
					signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
							.verifyAddressAdded(data.get("addressDesc"));
					signUpPage.customerProfilePage().profilePage().editProfilePage().mailingAddressComponent()
							.clickDone();
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

	@Test
	@Parameters({ "strParams" })
	public void testSignupInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			landingPage.clickSignUp();
			signUpPage.VerifyPhoneNumberHeading(data.get("phoneNumDesc"));
			String[] country = data.get("country").split(",");
			String[] phoneNumber = data.get("phoneNumber").split(",");
			signUpPage.clickDopdown();
			signUpPage.fillSearch(country[0]);
			signUpPage.fillPhoneNumbers(phoneNumber[0]);
			signUpPage.clickDopdown();
			signUpPage.fillSearch(country[1]);
			signUpPage.verifyPhoneNumber();
			for (int i = 1; i <= 3; i++) {
				signUpPage.fillPhoneNumbers(phoneNumber[i]);
				signUpPage.verifyContinue();
			}
			String[] fieldPhoneNumber = data.get("fieldPhoneNumber").split(",");
			signUpPage.fieldValidationsComponent().validatePhoneNumberField(fieldPhoneNumber[0], fieldPhoneNumber[1],
					fieldPhoneNumber[2]);
			signUpPage.clickContinue();
			signUpPage.phoneAndEmailVerificationComponent()
					.verifyPhoneVerificationHeading(data.get("phNumVerifiHeadi"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("invalidCode"));
			signUpPage.phoneAndEmailVerificationComponent().verifyInvalidCode(data.get("invalidCodeMsg"));
			signUpPage.phoneAndEmailVerificationComponent().clickResend();
			signUpPage.phoneAndEmailVerificationComponent().viewNewCodeSentMsg();
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			signUpPage.verifyEmailHeading(data.get("emailDescription"));
			String[] email = data.get("email").split(",");
			for (int i = 0; i <= 2; i++) {
				signUpPage.fillEmail(email[i]);
				signUpPage.verifyContinue();
			}
			String[] fieldEmail = data.get("fieldEmail").split(",");
			signUpPage.fieldValidationsComponent().validateEmailField(fieldEmail[0], fieldEmail[1], fieldEmail[2]);
			signUpPage.fillEmail(email[3]);
			signUpPage.clickContinue();
			signUpPage.phoneAndEmailVerificationComponent()
					.verifyEmailVerificationHeading(data.get("emailVerification"));
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("invalidCode"));
			signUpPage.phoneAndEmailVerificationComponent().verifyInvalidCode(data.get("invalidCodeMsg"));
			signUpPage.phoneAndEmailVerificationComponent().clickResend();
			signUpPage.phoneAndEmailVerificationComponent().viewNewCodeSentMsg();
			signUpPage.phoneAndEmailVerificationComponent().fillOtp(data.get("code"));
			signUpPage.verifyNameView(data.get("nameDesc"));
			String[] lastName = data.get("lastName").split(",");
			String[] firstName = data.get("firstName").split(",");
			signUpPage.fillLastName(lastName[2]);
			for (int i = 0; i < 2; i++) {
				signUpPage.fillFirstName(firstName[i]);
				signUpPage.clickLastName();
				String[] fstNameErrMsg = data.get("fstNameErrMsg").split(",");
				new CommonFunctions().validateFormErrorMessage(fstNameErrMsg[i], "First Name Field");
				signUpPage.verifyContinue();
			}
			String[] fieldFirstName = data.get("fieldFirstName").split(",");
			signUpPage.fieldValidationsComponent().validateFirstNameField(fieldFirstName[0], fieldFirstName[1],
					fieldFirstName[2], fieldFirstName[3], data.get("validateDataType"));
			signUpPage.fillFirstName(firstName[2]);
			for (int i = 0; i < 2; i++) {
				signUpPage.fillLastName(lastName[i]);
				signUpPage.clickFirstName();
				DriverFactory.getDriver().hideKeyboard();
				String[] lstNameErrMsg = data.get("lstNameErrMsg").split(",");
				new CommonFunctions().validateFormErrorMessage(lstNameErrMsg[i], "Last Name Field");
				signUpPage.verifyContinue();
			}
			String[] fieldLastName = data.get("fieldLastName").split(",");
			signUpPage.fieldValidationsComponent().validateLastNameField(fieldLastName[0], fieldLastName[1],
					fieldLastName[2], fieldLastName[3], data.get("validateDataType"));
			signUpPage.fillLastName(lastName[2]);
			signUpPage.clickContinue();
			signUpPage.verifyPasswordView(data.get("passwordDesc"));
			String[] password = data.get("password").split(",");
			for (int i = 0; i <= 2; i++) {
				signUpPage.fillPassword(password[i]);
				signUpPage.verifyContinue();
			}
			String[] fieldPassword = data.get("fieldPassword").split(",");
			signUpPage.fieldValidationsComponent().validatePasswordField(fieldPassword[0], fieldPassword[1],
					fieldPassword[2]);
			signUpPage.fillPassword(password[3]);
			signUpPage.clickEyeIcon();
			signUpPage.clickContinue();
			signUpPage.phoneAndEmailVerificationComponent().agreementPage().verifyLegalView(data.get("legalDesc"));
			signUpPage.phoneAndEmailVerificationComponent().agreementPage().verifyAgree();
			signUpPage.phoneAndEmailVerificationComponent().agreementPage().clickPrivacyPolicy();
			signUpPage.phoneAndEmailVerificationComponent().agreementPage().viewDocAgreeHeading();
			signUpPage.navigationComponent().clickClose();
			signUpPage.phoneAndEmailVerificationComponent().agreementPage().verifyLegalView(data.get("legalDesc"));
			signUpPage.phoneAndEmailVerificationComponent().agreementPage().clickTermsOfService();
			signUpPage.phoneAndEmailVerificationComponent().agreementPage().viewDocAgreeHeading();
			signUpPage.navigationComponent().clickClose();
			signUpPage.phoneAndEmailVerificationComponent().agreementPage().verifyLegalView(data.get("legalDesc"));
			Thread.sleep(1000);
			signUpPage.navigationComponent().clickBack();
			signUpPage.verifyPasswordView(data.get("passwordDesc"));
			signUpPage.navigationComponent().clickBack();
			signUpPage.verifyNameView(data.get("nameDesc"));
			signUpPage.navigationComponent().clickBack();
			signUpPage.verifyEmailHeading(data.get("emailDescription"));
			signUpPage.clickContinue();
			signUpPage.phoneAndEmailVerificationComponent()
					.verifyEmailVerificationHeading(data.get("emailVerification"));
			signUpPage.navigationComponent().clickBack();
			signUpPage.verifyEmailHeading(data.get("emailDescription"));
			signUpPage.navigationComponent().clickBack();
			signUpPage.VerifyPhoneNumberHeading(data.get("phoneNumDesc"));
			signUpPage.clickContinue();
			signUpPage.phoneAndEmailVerificationComponent()
					.verifyPhoneVerificationHeading(data.get("phNumVerifiHeadi"));
			signUpPage.navigationComponent().clickBack();
			signUpPage.VerifyPhoneNumberHeading(data.get("phoneNumDesc"));
			signUpPage.navigationComponent().clickClose();
			landingPage.verifyCoyniView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test SignUp Failed due to this Exception" + e);
		}
	}

}
