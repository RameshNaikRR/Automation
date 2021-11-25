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
			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().navigationComponent().verifyCloseView();
			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().verifyDoneView();
			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().clickImage();
			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().clickDone();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("userDetailsHeading"));
			// Navigation userDetailsPage - ChooseFromLibraryPopup
			customerProfilePage.userDetailsPage().clickEditUserImage();
			customerProfilePage.userDetailsPage().editUserImagePopup().clickChooseFromLibrary();
			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().navigationComponent().clickClose();
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
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyHeading(data.get("editEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyCurrentEmail(data.get("email"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyDontHaveAccessView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyContactUsView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().navigationComponent().verifyBackView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().navigationComponent().clickBack();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().fillNewEmail(data.get("newEmail"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().clickSave();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyCurrentEmailPage().verifyHeading(data.get("currentEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyCurrentEmailPage().verifyEmail(data.get("email"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyCurrentEmailPage().verifyPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyCurrentEmailPage().verifyResendView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyCurrentEmailPage().navigationComponent().clickBack();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyHeading(data.get("editEmailHeading"));
			
			
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
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyHeading(data.get("editEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().fillNewEmail(data.get("newEmail"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().clickSave();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyCurrentEmailPage().verifyHeading(data.get("currentEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyCurrentEmailPage().fillPin(data.get("pin"));
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
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().verifyHeading(data.get("editEmailHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().fillNewEmail(data.get("newEmail"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editEmailPage().clickSave();
			if (!data.get("errMessage").isEmpty()) {

			//	new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
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
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyHeading(data.get("editphoneNumberHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyCurrentPhoneNumber(data.get("phoneNumber"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyDontHaveAccessView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyContactUsView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().navigationComponent().verifyBackView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().navigationComponent().clickBack();
			customerProfilePage.userDetailsPage().enterYourPINComponent().verifyHeading(data.get("pinHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().fillPin(data.get("pin"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().fillPhoneNumber(data.get("newPhoneNumber"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().clickSave();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyCurrentPhoneNumber().verifyHeading(data.get("currentPhoneNumberHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyCurrentPhoneNumber().verifyPhoneNumber(data.get("PhoneNumber"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyCurrentPhoneNumber().verifyPinView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyCurrentPhoneNumber().verifyResendView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyCurrentPhoneNumber().navigationComponent().clickBack();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editPhoneNumberPage().verifyHeading(data.get("editphoneNumberHeading"));
			
			
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
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().verifyHeading(data.get("editAddrHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().verifyAddressLine1View();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().verifyAddressLine2View();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().verifyCityView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().verifyStateView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().verifyZipCodeView();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().navigationComponent().clickBack();
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
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().verifyHeading(data.get("editAddrHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().fillAddressLine1(data.get("addLine1"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().fillAddressLine2(data.get("addline2"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().fillCity(data.get("city"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().selectState();
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().fillZipCode(data.get("zipcode"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().verifyCountry(data.get("country"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().clickSave();
			//Toast Message
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
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().verifyHeading(data.get("editAddrHeading"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().fillAddressLine1(data.get("addLine1"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().fillAddressLine2(data.get("addline2"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().fillCity(data.get("city"));
			customerProfilePage.userDetailsPage().enterYourPINComponent().editAddressPage().mailingAddressComponent().fillZipCode(data.get("zipcode"));
			if (!data.get("errMessage").isEmpty()) {

			//	new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
			}
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Edit Address with invalid data failed due to exception " + e);
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

}
