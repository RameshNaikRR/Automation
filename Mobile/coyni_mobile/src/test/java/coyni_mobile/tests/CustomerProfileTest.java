package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.pages.CustomerProfilePage;
import coyni_mobile.pages.TokenAccountPage;
import coyni_mobile.pages.UserDetailsPage;
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

			customerProfilePage.verifyUserDetailsView();
			customerProfilePage.clickUserDetails();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("heading"));
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
			customerProfilePage.userDetailsPage().verifyHeading(data.get("heading"));
			// Navigation userDetailsPage - ChooseFromLibraryPopup
			customerProfilePage.userDetailsPage().clickEditUserImage();
			customerProfilePage.userDetailsPage().editUserImagePopup().clickChooseFromLibrary();
			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().navigationComponent()
					.clickClose();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("heading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test user details view failed due to exception " + e);
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
