package coyni.business.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.MerchantServicescomponents.AccountLimitsComponent;
import coyni.business.components.SideBarMenuComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class BusinessSettingsTest {
	SideBarMenuComponent sideBarMenuComponent;
	AccountLimitsComponent accountLimitsComponent;

	@BeforeTest
	public void init() {

		sideBarMenuComponent = new SideBarMenuComponent();
		accountLimitsComponent = new AccountLimitsComponent();
	}

//	@Test
//	@Parameters({ "strParams" })
//	public void testAccountFeeAndLimitsView(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideBarMenuComponent.clickBusinessSettings();
//			sideBarMenuComponent.businessSettingsPage().clickAccountFeeLimits();
//			sideBarMenuComponent.businessSettingsPage().accountFeesAndLimitsPage()
//					.verifyHeading(data.get("accountFeeHeading"));
//			sideBarMenuComponent.businessSettingsPage().accountFeesAndLimitsPage().clickViewChange();
//			sideBarMenuComponent.businessSettingsPage().accountFeesAndLimitsPage()
//					.verifyFeeHeading(data.get("feeHeading"));
//			sideBarMenuComponent.businessSettingsPage().accountFeesAndLimitsPage().close();
//			sideBarMenuComponent.businessSettingsPage().accountFeesAndLimitsPage().clickHide();
//			Thread.sleep(3000);
//			sideBarMenuComponent.businessSettingsPage().accountFeesAndLimitsPage().viewAccountFeeLimits();
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("Account Fee and Limits view failed due to Exception " + e);
//
//		}
//	}

	@Test
	@Parameters({ "strParams" })
	public void testContactInformation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickContactInformation();
			sideBarMenuComponent.businessSettingsPage().contactInformation().verifyHeading(data.get("infoHeading"));
			sideBarMenuComponent.businessSettingsPage().contactInformation().verifyEditEmail(data.get("emailEdit"));
			sideBarMenuComponent.businessSettingsPage().contactInformation().verifyEditName(data.get("name"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Contact Information failed due to Exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditprimaryContact(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickContactInformation();
			sideBarMenuComponent.businessSettingsPage().contactInformation().verifyHeading(data.get("infoHeading"));
			sideBarMenuComponent.businessSettingsPage().contactInformation().verifyEditEmail(data.get("emailEdit"));
			sideBarMenuComponent.businessSettingsPage().contactInformation().verifyEditName(data.get("name"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Primary Contact Information failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditFinancialContact(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickContactInformation();
			sideBarMenuComponent.businessSettingsPage().contactInformation().verifyHeading(data.get("infoHeading"));
			sideBarMenuComponent.businessSettingsPage().contactInformation().verifyEditEmail(data.get("emailEdit"));
			sideBarMenuComponent.businessSettingsPage().contactInformation().verifyEditName(data.get("name"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" Financial Contact Information failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditTechnicalContact(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickContactInformation();
			sideBarMenuComponent.businessSettingsPage().contactInformation().verifyHeading(data.get("infoHeading"));
			sideBarMenuComponent.businessSettingsPage().contactInformation().verifyEditEmail(data.get("emailEdit"));
			sideBarMenuComponent.businessSettingsPage().contactInformation().verifyEditName(data.get("name"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Technical Contact Information failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessInformation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickBusinessInformation();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyBusinessInfo();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyBusinessName();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyAccountID();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyBusinessEntity();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyStartDate();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyCompanyEmail();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyCompanyPhone();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyDBAInfo();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyDBAName();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyAddress();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyApplication();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Technical Contact Information failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditBusinessInformationCompanyEmailInvalid(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickBusinessInformation();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyBusinessInfo();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyBusinessName();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyAccountID();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyBusinessEntity();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyStartDate();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyCompanyEmail();
			sideBarMenuComponent.businessSettingsPage().businessInformation().clickOutsideElement();
			Thread.sleep(4000);
			sideBarMenuComponent.businessSettingsPage().businessInformation().clickSaveEnabled();
			Thread.sleep(4000);
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(2000);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Business Information  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditBusinessInformationCompanyPhoneInvalid(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickBusinessInformation();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyBusinessInfo();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyBusinessName();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyAccountID();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyBusinessEntity();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyStartDate();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyCompanyEmail();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyCompanyPhone();
			sideBarMenuComponent.businessSettingsPage().businessInformation().clickOutsideElement();
			Thread.sleep(4000);
			sideBarMenuComponent.businessSettingsPage().businessInformation().clickSaveEnabled();
			Thread.sleep(4000);
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(2000);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Business Information  Failed due to Exception " + e);
		}
	}

}
