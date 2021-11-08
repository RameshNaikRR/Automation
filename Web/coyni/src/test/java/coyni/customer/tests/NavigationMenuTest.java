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
	@Parameters({"strParams"})
	public void testSideBarView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.verifyAccountHolderNameView();
			navigationMenuPage.verifyAccountIDView();
			navigationMenuPage.verifyAccountID(data.get("AccountID"));
			navigationMenuPage.verifyUserImageView();//
			navigationMenuPage.verifyQRCodeView();
			navigationMenuPage.verifyTokenAccountView();
			navigationMenuPage.verifyExportFilesView();
			navigationMenuPage.verifyGetHelpView();
		} catch (Exception e) {

			ExtentTestManager.setFailMessageInReport("Test Side Bar view is failed  due to exception " + e);
		}
	}
	
	
		
	@Test
	@Parameters({"strParams"})
	public  void testAccountDropdownView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickAccountDropdwn();
			navigationMenuPage.verifyBusinessAccountView();//DOUBT
			navigationMenuPage.verifyPersonalAccountView();
			navigationMenuPage.verifyAddNewBusinessAccountView();
			navigationMenuPage.verifyAddNewBusinessAccountLabel(data.get("message"));
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Account Drop down view is failed  due to exception " + e);
		}
	}
	
	@Test
	@Parameters({"strParams"})
	public  void testSideBarRouting(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			navigationMenuPage.clickTokenAccountMenu();
			navigationMenuPage.verifyTokenAccountHeadingView();
			navigationMenuPage.clickExportFilesMenu();
			navigationMenuPage.verifyExportFilesHeadingView();
			navigationMenuPage.clickGetHelpMenu();
			navigationMenuPage.verifyGetHelpHeadingView();
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Routing is failed  due to exception " + e);
		}
		
	}
	@Test
	@Parameters({"strParams"})
	public  void testProgressBar(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			
		}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("Test Progress Bar is failed  due to exception " + e);
		}
		
	}
		
	
	

}
