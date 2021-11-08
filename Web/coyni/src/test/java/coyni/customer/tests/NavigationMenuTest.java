package coyni.customer.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.customer.pages.NavigationMenuPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;


public class NavigationMenuTest {
	NavigationMenuPage navigationMenuPage;
	
	@BeforeTest
	 public void init() {
       navigationMenuPage = new NavigationMenuPage();
       
   }
	@Test
	@Parameters({ "strParams" })
	public void testSideBarView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.verifyAccountIDView();
			navigationMenuPage.verifyUserImageView();
			navigationMenuPage.verifyQRCodeView();

		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("Test  " + e);
		}
	}
		
	
	

}
