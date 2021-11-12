package coyni_mobile.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni_mobile.pages.CustomerProfilePage;
import coyni_mobile.pages.UserDetailsPage;
import ilabs.MobileFramework.Runner;
import ilabs.mobile.reporting.ExtentTestManager;

public class CustomerProfileTest {

	CustomerProfilePage customerProfilePage;
	UserDetailsPage userDetailsPage;
	
	@BeforeTest
	public void init() {
		customerProfilePage =new CustomerProfilePage();
	    userDetailsPage =new UserDetailsPage();	
	}
	@Test
	@Parameters({"strParams"})
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
		
		}catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("Test user details view failed due to exception " + e );
		}
	}
	
	@Test
	@Parameters({"strParams"})
	public void testEditImageView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
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
			customerProfilePage.userDetailsPage().verifyHeading(data.get("heading"));
			//Navigation userDetailsPage - ChooseFromLibraryPopup
			customerProfilePage.userDetailsPage().clickEditUserImage();
			customerProfilePage.userDetailsPage().editUserImagePopup().clickChooseFromLibrary();
			customerProfilePage.userDetailsPage().editUserImagePopup().chooseFromLibraryPopup().navigationComponent().clickClose();
			customerProfilePage.userDetailsPage().verifyHeading(data.get("heading"));
			
			
			}catch(Exception e) {
				ExtentTestManager.setFailMessageInReport("Test user details view failed due to exception " + e );
			}
		}
}
