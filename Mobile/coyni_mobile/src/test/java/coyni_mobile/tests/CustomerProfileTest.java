package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.pages.CustomerProfilePage;
import coyni_mobile.pages.TokenAccountPage;
import coyni_mobile.pages.UserDetailsPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class CustomerProfileTest {

	CustomerProfilePage customerProfilePage;
	UserDetailsPage userDetailsPage;
	TokenAccountPage tokenAccountPage;
	NavigationComponent navigationComponent;

	@BeforeTest
	public void init() {
		customerProfilePage = new CustomerProfilePage();
		userDetailsPage = new UserDetailsPage();
		tokenAccountPage = new TokenAccountPage();
		navigationComponent = new NavigationComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testUserDetailsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyUserDetailsView();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyUserDetailsPageview();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().verifyEditUserImageView();
			customerProfilePage.userDetailsPage().navigationComponent().verifyBackView();
			customerProfilePage.userDetailsPage().navigationComponent().clickBack();
			customerProfilePage.verifyProfilePageView();
			// customerProfilePage.clickLogOut();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test user details view failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditImageView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().clickEditUserImage();
			customerProfilePage.userDetailsPage().editUserImagePopup().verifyChooseFromLibraryView();
			customerProfilePage.userDetailsPage().editUserImagePopup().verifyTakeAPhotoView();
			customerProfilePage.userDetailsPage().editUserImagePopup().clickChooseFromLibrary();
			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().verifyLibraryView();
			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().navigationComponent()
					.verifyCloseView();
			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().verifyDoneView();
			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().clickImage();
			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().clickDone();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			// Navigation userDetailsPage - ChooseFromLibraryPopup
			customerProfilePage.userDetailsPage().clickEditUserImage();
			customerProfilePage.userDetailsPage().editUserImagePopup().clickChooseFromLibrary();
			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().navigationComponent()
					.clickClose();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test user details view failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmailView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyEmailTitleView();
			customerProfilePage.userDetailsPage().verifyExistingEmailView();
			customerProfilePage.userDetailsPage().verifyEditEmailArrowView();
			customerProfilePage.userDetailsPage().clickEditEmail();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyEnterYourPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyForgotPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().navigationComponent().clickBack();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditEmail();
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.verifyHeading(data.get("editEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.verifyCurrentEmail(data.get("email"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyDontHaveAccessView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyContactUsView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().navigationComponent()
					.verifyBackView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().navigationComponent()
					.clickBack();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.fillNewEmail(data.get("newEmail"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().clickSave();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyCurrentEmailHeading(data.get("currentEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyCurrentEmail(data.get("email"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyResendView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.navigationComponent().clickBack();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.verifyHeading(data.get("editEmailHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit Email view failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmail(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditEmail();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.verifyHeading(data.get("editEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.verifyCurrentEmail(data.get("email"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.fillNewEmail(data.get("newEmail"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().clickSave();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyCurrentEmailHeading(data.get("currentEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.fillPin(data.get("code"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.verifyNewEmailHeading(data.get("newEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.fillPin(data.get("code"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.successFailureComponent().verifySuccessFailureHeading(data.get("expHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyEmailPage()
					.successFailureComponent().clickLogOut();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit Email failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testEditEmailWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditEmail();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.verifyHeading(data.get("editEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage()
					.fillNewEmail(data.get("newEmail"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().clickSave();
			if (!data.get("errMessage").isEmpty()) {

				// new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit Email with invalid data failed due to exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testEditPhoneNumberView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyPhoneNumberTitleView();
			customerProfilePage.userDetailsPage().verifyExistingPhoneNumberView();
			customerProfilePage.userDetailsPage().verifyEditPhoneNumberArrowView();
			customerProfilePage.userDetailsPage().clickEditPhoneNumber();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyEnterYourPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyForgotPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().navigationComponent().clickBack();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditPhoneNumber();
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.verifyHeading(data.get("editphoneNumberHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.verifyCurrentPhoneNumber(data.get("phoneNumber"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.verifyDontHaveAccessView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyContactUsView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().navigationComponent()
					.verifyBackView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().navigationComponent()
					.clickBack();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.fillNewPhoneNumber(data.get("newPhoneNumber"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().clickSave();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyCurrentPhoneHeading(data.get("currentPhoneNumberHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyCurrentPhone(data.get("PhoneNumber"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyResendView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.navigationComponent().clickBack();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.verifyHeading(data.get("editphoneNumberHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit PhoneNumber view failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditPhoneNumber(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditPhoneNumber();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.verifyHeading(data.get("editPhoneHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.verifyCurrentPhoneNumber(data.get("phoneNumber"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage()
					.fillNewPhoneNumber(data.get("newPhoneNumber"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().clickSave();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyCurrentPhoneHeading(data.get("currentPhoneHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.fillPin(data.get("code"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.verifyNewPhoneHeading(data.get("newPhoneHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
					.fillPin(data.get("code"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
//					.successFailureComponent().verifySuccessFailureHeading(data.get("expHeading"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyPhoneNumberPage()
//					.successFailureComponent().clickLogOut();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit PhoneNumber view failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditAddressView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyAddressTitleView();
			customerProfilePage.userDetailsPage().verifyExistingAddressView();
			customerProfilePage.userDetailsPage().verifyEditAddressArrowView();
			customerProfilePage.userDetailsPage().clickEditAddress();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyEnterYourPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyForgotPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().navigationComponent().clickBack();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditAddress();
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage()
					.verifyHeading(data.get("editAddrHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.verifyAddressLine1View();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.verifyAddressLine2View();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.verifyCityView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.verifyStateView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.verifyZipCodeView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().navigationComponent()
					.clickBack();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit Address view failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditAddress(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditAddress();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage()
					.verifyHeading(data.get("editAddrHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillAddressLine1(data.get("addLine1"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillAddressLine2(data.get("addline2"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillCity(data.get("city"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.selectState(data.get("state"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillZipCode(data.get("zipcode"));
//			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
//					.verifyCountry(data.get("country"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().clickSave();
			// Toast Message
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit Address failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditAddressWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			customerProfilePage.userDetailsPage().clickEditAddress();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage()
					.verifyHeading(data.get("editAddrHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillAddressLine1(data.get("addLine1"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillAddressLine2(data.get("addline2"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillCity(data.get("city"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent()
					.fillZipCode(data.get("zipcode"));
			if (!data.get("errMessage").isEmpty()) {

				// new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("Test Edit Address with invalid data failed due to exception " + e);
		}
	}

	// added
	@Test
	@Parameters({ "strParams" })
	public void testCustomerProfileView(String strParams) {

		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyImageUserView();
			customerProfilePage.verifyUserNameView();
			customerProfilePage.verifyAccountIDView();
			customerProfilePage.verifyAccountStatusView();
			customerProfilePage.verifyImageUserView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("TestCustomerProfileView failed due to exception " + e);
		}

	}

	// added
	@Test
	@Parameters({ "strParams" })
	public void testClickCustomerProfile(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyUserNameView();
			customerProfilePage.clickQRImage();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("TestClickCustomerProfile failed due to exception " + e);
		}

	}

	// added
	@Test
	@Parameters({ "strParams" })
	public void testCopyTextAndShare(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickQRImage();
			customerProfilePage.verifyLabelMyQRCodeView();
			customerProfilePage.verifyLabelCopyText();
			customerProfilePage.clickShare();
			customerProfilePage.verifyPopUp();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("TestCopyTextAndShare failed due to exception " + e);
		}

	}

	// added
	@Test
	@Parameters({ "strParams" })
	public void testCrossIcon(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickQRImage();
			customerProfilePage.navigationComponent().clickClose();
			customerProfilePage.verifyUserNameView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("TestCrossIcon failed due to exception " + e);
		}

	}

//	// M
//	@Test
//	@Parameters({ "strParams" })
//	public void testAddExternalBankAccount(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			tokenAccountPage.clickProfile();
//			customerProfilePage.clickPaymentMethods();
//			customerProfilePage.externalBankAccountPage().clickBank();
//			customerProfilePage.externalBankAccountPage().verifyHeading(data.get("addBankHeading"));
//			customerProfilePage.externalBankAccountPage().clickLearnMore();
//			customerProfilePage.externalBankAccountPage().navigationComponent().clickClose();
//			customerProfilePage.externalBankAccountPage().clickNext();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Add External Bank Account Failed due to exception " + e);
//		}
//
//	}
//
//	// Ios M
//	@Test
//	@Parameters({ "strParams" })
//	public void testAddExternalBankAccountWithNavigateOption(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			customerProfilePage.clickPaymentMethods();
//			customerProfilePage.navigationComponent().clickClose();
//			customerProfilePage.clickPaymentMethods();
//			customerProfilePage.externalBankAccountPage().verifyHeading(data.get("addBankHeading"));
//			customerProfilePage.externalBankAccountPage().navigationComponent().clickBack();
//			customerProfilePage.externalBankAccountPage().clickLearnMore();
//			customerProfilePage.externalBankAccountPage().navigationComponent().clickClose();
//			customerProfilePage.externalBankAccountPage().clickNext();
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Add External Bank Account Failed due to exception " + e);
//		}
//	}
//
//	// Ios M
//	@Test
//	@Parameters({ "strParams" })
//	public void testAddExternalBankAccountWithUserHavePaymentMethods(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			customerProfilePage.externalBankAccountPage().clickNext();
//			customerProfilePage.externalBankAccountPage().verifyHeading(data.get("addBankHeading"));
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Add External Bank Account Failed due to exception " + e);
//		}
//	}

	// Ios M
	@Test
	@Parameters({ "strParams" })
	public void testDashboard(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			customerProfilePage.verifyUserName(data.get("userName"));
			customerProfilePage.verifyAvaliableBlc(data.get("avaliableBalance"));
			customerProfilePage.verifyRecentTransaction(data.get("recentHeading"));
			customerProfilePage.clickImg();
			customerProfilePage.verifyFirstAndLastName(data.get("firstAndLastName"));
			customerProfilePage.verifyAvaliableBlc(data.get("avaliableBalance"));
			customerProfilePage.navigationComponent().clickClose();
			customerProfilePage.clickPayRequest();
			customerProfilePage.verifyContactContent(data.get("conntactHeading"));
			customerProfilePage.navigationComponent().clickClose();
			customerProfilePage.viewTokenAccount();
			customerProfilePage.viewDashboard();
			customerProfilePage.viewCrypto();
			customerProfilePage.viewIssueCard();
			customerProfilePage.viewProfile();
			customerProfilePage.clickCrypto();
			customerProfilePage.verifyAssets(data.get("CryptoHeading"));
			customerProfilePage.navigationComponent().clickClose();
			customerProfilePage.clickTokenMenu();
			customerProfilePage.viewScan();
			customerProfilePage.viewPayRequest();
			customerProfilePage.viewBuyToken();
			customerProfilePage.viewWithdrawnToUSD();
			customerProfilePage.minimizePopupBySwipeDown();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Verify DashBoard Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAccountLimits(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.accountLimitsComponent().AccountLimits();
			customerProfilePage.accountLimitsComponent().clickAccountLimits();
			customerProfilePage.accountLimitsComponent().verifyLabelAccountLimits(data.get("expHeading"));
			customerProfilePage.accountLimitsComponent().verifyPayRequest(data.get("expPayRequestHeading"));
			customerProfilePage.accountLimitsComponent().getPayRequest();
			customerProfilePage.accountLimitsComponent().verifyBuyTokensHeading(data.get("expBuyTokenHeading"));
			customerProfilePage.accountLimitsComponent().getBankAccountAmount();
			customerProfilePage.accountLimitsComponent().verifyBuyTokenAmountLimit();
			customerProfilePage.accountLimitsComponent().VerifyWithdrawHeading(data.get("expWithdrawHeading"));
			customerProfilePage.accountLimitsComponent().getWithdrawBankAccountAmount();
			customerProfilePage.accountLimitsComponent().verifyWithdrawBankAccountAmountLimit();
			customerProfilePage.accountLimitsComponent().getInstantPayAccount();
			customerProfilePage.accountLimitsComponent().verifyWithdrawInstantPayAmountLimit();
			customerProfilePage.accountLimitsComponent().getGiftCardAmount();
			customerProfilePage.accountLimitsComponent().verifyWithdrawGiftCardAmountLimit();
			customerProfilePage.accountLimitsComponent().navigationComponent().clickBack();
			customerProfilePage.clickLogOut();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAccountLimits Failed due to exception " + e);

		}
	}

	@Test
	public void testAgreements() {
		try {
			tokenAccountPage.clickProfile();
			customerProfilePage.agreementComponent().Agreements();
			customerProfilePage.agreementComponent().clickOnAgreements();
			// tokenAccountPage.agreementComponent().clickPrivacyPolicy();
			// tokenAccountPage.agreementComponent().clickTermsOfService();
			customerProfilePage.agreementComponent().verifyPrivacyPolicy();
			customerProfilePage.agreementComponent().verifyTermsOfService();
			customerProfilePage.agreementComponent().clickBack();
			customerProfilePage.clickLogOut();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAgreements Failed due to exception " + e);

		}
	}

	@Test
	public void testLogOut() {
		try {
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyLogOut();
			customerProfilePage.clickLogOut();
			customerProfilePage.signUpPage().verifyGetStarted();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testLogOut failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddExternalBankAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.clickPaymentMethods();
			customerProfilePage.paymentMethodsPage().verifyHeading(data.get("paymentHeading"));
			customerProfilePage.paymentMethodsPage().clickAddNewPayment();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().verifyHeading(data.get("addPaymentHeading"));
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().clickExternalBankAcount();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().verifyHeading("addBankHeading");
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().clickNext();
			customerProfilePage.paymentMethodsPage().addNewPaymentComponent().addExternalBankAccountComponent().addAccountsComponent().verifyHeading(data.get("AccountHeading"));
			

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddExternalBankAccount  failed due to exception " + e);
		}

	}
	@Test
	@Parameters({ "strParams" })
	public void testChangePassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			tokenAccountPage.clickProfile();
			customerProfilePage.clickChangePassword();
			customerProfilePage.changePasswordPage().enterYourPINComponent().fillPin(data.get("pin"));
			// tokenAccountPage.customerProfilePage().changePasswordPage()
			// .verifyHeadingConfirmPassword(data.get("expConfirmPasswordHeading"));
			// tokenAccountPage.CustomerProfilePage().changePasswordPage().enterYourPINComponent().verifyEnterYourPinView(data.get("pinHeading"));
			customerProfilePage.changePasswordPage().fillCurrentPassword(data.get("currentPassword"));
			customerProfilePage.changePasswordPage().clickIconViewPassword();
			customerProfilePage.changePasswordPage().clickNext();
			customerProfilePage.changePasswordPage().verifyHeadingChangePassword(data.get("expChangePasswordHeading"));
			customerProfilePage.changePasswordPage().verifyChangePasswordContent(data.get("expChangePasswordContent"));
			customerProfilePage.changePasswordPage().fillNewPassword(data.get("newPassword"));
			customerProfilePage.changePasswordPage().clickIconViewPassword();
			customerProfilePage.changePasswordPage().fillConfirmPassword(data.get("confirmPassword"));
			customerProfilePage.changePasswordPage().clickIconViewPassword();
			customerProfilePage.changePasswordPage().verifyPassword();
			customerProfilePage.changePasswordPage().clickSave();
			customerProfilePage.changePasswordPage().verifySuccessFailureMessage(data.get("message"));
			customerProfilePage.changePasswordPage().clickLogout();
			tokenAccountPage.signUpPage().verifyGetStarted();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangePassword Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordWithNavigationOptions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			tokenAccountPage.clickProfile();
			customerProfilePage.clickChangePassword();
			customerProfilePage.navigationComponent().clickBack();

			customerProfilePage.clickChangePassword();
			customerProfilePage.changePasswordPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.changePasswordPage().navigationComponent().clickClose();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testChangePasswordWithNavigationOptions Failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordWithInvalidCurrentPassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);

			tokenAccountPage.clickProfile();
			customerProfilePage.clickChangePassword();
			customerProfilePage.changePasswordPage().enterYourPINComponent().fillPin(data.get("pin"));

			customerProfilePage.changePasswordPage().fillCurrentPassword(data.get("currentPassword"));
			customerProfilePage.changePasswordPage().clickIconViewPassword();
			customerProfilePage.changePasswordPage().clickNext();

			if (!data.get("errMessage").isEmpty()) {

				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("elementName"));

			}
			customerProfilePage.changePasswordPage().navigationComponent().clickClose();
			customerProfilePage.changePasswordPage().clickLogout();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangePasswordWithInvalid Failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testResetPinCode(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			tokenAccountPage.clickProfile();
			customerProfilePage.verifyResetPinCodeView();
			customerProfilePage.clickResetPinCode();
			customerProfilePage.enterYourPINComponent().verifyEnterYourPinView();
			customerProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			Thread.sleep(1000);
			customerProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyChoosePinHeading(data.get("heading1"));
			customerProfilePage.enterYourPINComponent().choosePinComponent().fillPin(data.get("resetPin"));
			customerProfilePage.enterYourPINComponent().choosePinComponent()
					.verifyConfirmPinHeading(data.get("heading2"));
			customerProfilePage.enterYourPINComponent().choosePinComponent().fillPin(data.get("resetPin"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test Reset Pin Code failed due to Exception " + e);
		}
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testResetPinCodeViewFlow(String strParams) {
		try {
			   Map<String, String> data = Runner.getKeywordParameters(strParams);
			   tokenAccountPage.clickProfile();
			   customerProfilePage.verifyResetPinCodeView();
			   customerProfilePage.clickResetPinCode();
			   customerProfilePage.enterYourPINComponent().verifyEnterYourPinView();
			   customerProfilePage.enterYourPINComponent().navigationComponent().verifyCloseView();
			   customerProfilePage.enterYourPINComponent().navigationComponent().clickClose();
			   customerProfilePage.clickResetPinCode();
			   customerProfilePage.enterYourPINComponent().verifyForgotPinView();
			   customerProfilePage.enterYourPINComponent().clickForgotPin();
		  //   customerProfilePage.enterYourPINComponent().navigationComponent().clickClose();
			   customerProfilePage.clickResetPinCode();
			   customerProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			   Thread.sleep(1000);
			   customerProfilePage.enterYourPINComponent().choosePinComponent().verifyChooseYourPinView();
			   customerProfilePage.enterYourPINComponent().navigationComponent().verifyBackView();
			   customerProfilePage.enterYourPINComponent().navigationComponent().clickBack();
			   customerProfilePage.clickResetPinCode();
			   customerProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			   customerProfilePage.enterYourPINComponent().choosePinComponent().verifyChoosePinHeading(data.get("heading1"));
			   customerProfilePage.enterYourPINComponent().choosePinComponent().fillPin(data.get("resetPin"));
			   customerProfilePage.enterYourPINComponent().choosePinComponent().verifyConfirmYourPinView();
			   customerProfilePage.enterYourPINComponent().navigationComponent().verifyBackView();
			   customerProfilePage.enterYourPINComponent().navigationComponent().clickBack();
			   customerProfilePage.clickResetPinCode();
			   customerProfilePage.enterYourPINComponent().fillPin(data.get("pin"));
			   customerProfilePage.enterYourPINComponent().choosePinComponent().fillPin(data.get("resetPin"));
			   customerProfilePage.enterYourPINComponent().choosePinComponent().verifyConfirmPinHeading(data.get("heading2"));
			   customerProfilePage.enterYourPINComponent().choosePinComponent().fillPin(data.get("resetPin"));	   
		}catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test ResetPinCodeView Flow failed due to Exception " + e);
			
		}
	}
	}
	
	
	
	
	


