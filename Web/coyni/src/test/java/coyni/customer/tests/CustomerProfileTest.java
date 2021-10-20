package coyni.customer.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.customer.components.CustomerMenuComponent;
import coyni.customer.pages.CustomerProfilePage;
import coyni.customer.pages.NavigationMenuPage;
import coyni.customer.popups.EditEmailAddressPopup;
import coyni.customer.popups.EditPhoneNumberPopup;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class CustomerProfileTest {
	 CustomerProfilePage customerProfilePage;
	 NavigationMenuPage navigationMenuPage;
	 EditPhoneNumberPopup editPhoneNumberPopup;
	EditEmailAddressPopup editEmailAddressPopup;
	@BeforeTest
	public void init() {
		
		customerProfilePage = new CustomerProfilePage();
		navigationMenuPage = new NavigationMenuPage();
	    editPhoneNumberPopup = new EditPhoneNumberPopup();
	    editEmailAddressPopup = new EditEmailAddressPopup();	 
	}
   
	@Test
	@Parameters({"strParams"})
  public void testUserDetailsImage(String strParams) {
		
		   try {
			   Map<String, String> data = Runner.getKeywordParameters(strParams);
			   navigationMenuPage.customerMenuComponent().clickUserDetails();
			   customerProfilePage.userDetailsComponent().clickEditUserImage();
			   customerProfilePage.userDetailsComponent().clickUploadNewImage();
			   customerProfilePage.userDetailsComponent().clickSave();
			   customerProfilePage.userDetailsComponent().toastComponent().verifyToast(strParams, strParams);
			   	 
		   }catch (Exception e){
			   
		            ExtentTestManager.setFailMessageInReport("Test user details failed due to exception " + e);
		        }
		   }
	
	  @Test
	  @Parameters({"strParams"})
	public void testUserDetailsImageRemove(String strParams) {
		      try {
		    	    Map<String, String> data = Runner.getKeywordParameters(strParams);
		    	    navigationMenuPage.customerMenuComponent().clickUserDetails();
		    	    customerProfilePage.userDetailsComponent().clickRemoveImage();
		    	    customerProfilePage.userDetailsComponent().clickUploadNewImage();
		    	    customerProfilePage.userDetailsComponent().clickRemove();
		    	    customerProfilePage.userDetailsComponent().clickUploadNewImage();
		    	    customerProfilePage.userDetailsComponent().clickSave();
		      }catch (Exception e) {
		    	  ExtentTestManager.setFailMessageInReport("test User details failed due to exception " + e);
		    	  
		    	   }
		      }

	  @Test
	  @Parameters({"strParams"})
     public void testEditPhoneNumber(String strParams)	{
		   try {
		    Map<String, String> data = Runner.getKeywordParameters(strParams);
		     customerProfilePage.userDetailsComponent().clickIconEditPhNum();
		     String securityKey = data.get("securityKey");
		     customerProfilePage.changePasswordComponent().authyComponent().fillAuthyInput(securityKey);
		     String newNumber = data.get("newNumber");
		     editPhoneNumberPopup.fillNewNumber(newNumber);
		     editPhoneNumberPopup.clickSendCode();
		     
		    }catch (Exception e) {
		    	ExtentTestManager.setFailMessageInReport("test Edit Phone Number failed due to Exception"+ e);
			   
		   }
	 }

	 
	
	  
   	  
	  
	  
	  

}
