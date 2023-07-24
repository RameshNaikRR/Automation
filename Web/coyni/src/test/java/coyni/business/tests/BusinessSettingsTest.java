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

	@Test
	@Parameters({ "strParams" })
	public void testAccountFeeAndLimitsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickAccountFeeLimits();
			sideBarMenuComponent.businessSettingsPage().accountFeesAndLimitsPage()
					.verifyHeading(data.get("accountFeeHeading"));
			sideBarMenuComponent.businessSettingsPage().accountFeesAndLimitsPage().clickViewChange();
			sideBarMenuComponent.businessSettingsPage().accountFeesAndLimitsPage()
					.verifyFeeHeading(data.get("feeHeading"));
			sideBarMenuComponent.businessSettingsPage().accountFeesAndLimitsPage().close();
			sideBarMenuComponent.businessSettingsPage().accountFeesAndLimitsPage().clickHide();
			Thread.sleep(3000);
			sideBarMenuComponent.businessSettingsPage().accountFeesAndLimitsPage().viewAccountFeeLimits();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Account Fee and Limits view failed due to Exception " + e);

		}
	}

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
			sideBarMenuComponent.businessSettingsPage().businessInformation()
					.verifyHeading(data.get("businessHeading"));
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyBusinessName();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyBusinessEntity();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyAccountID();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyStartDate();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyStatus();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyCompanyEmail();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyCompanyPhone();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyDBAInfo();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyAddress();
			sideBarMenuComponent.businessSettingsPage().businessInformation().viewDBAName();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyApplication();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Business Information failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditBusinessInformationCompanyEmailInvalid(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickBusinessInformation();
			sideBarMenuComponent.businessSettingsPage().businessInformation()
					.verifyHeading(data.get("businessHeading"));
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyBusinessName();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyBusinessEntity();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyAccountID();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyStartDate();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyStatus();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyCompanyEmail();
			sideBarMenuComponent.businessSettingsPage().businessInformation().clickEditEmail();
			sideBarMenuComponent.businessSettingsPage().businessInformation()
					.fillCompanyEmail(data.get("emailAddress"));
			sideBarMenuComponent.businessSettingsPage().businessInformation().clickOutsideElement();
			Thread.sleep(4000);
			if (!data.get("errMessage").isEmpty()) {
				Thread.sleep(2000);
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("color"),
						data.get("elementName"));
			}
//			sideBarMenuComponent.businessSettingsPage().businessInformation().clickSaveEnabled();

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
			sideBarMenuComponent.businessSettingsPage().businessInformation()
					.verifyHeading(data.get("businessHeading"));
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyBusinessName();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyBusinessEntity();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyAccountID();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyStartDate();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyStatus();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyCompanyEmail();
			sideBarMenuComponent.businessSettingsPage().businessInformation().verifyCompanyPhone();
			sideBarMenuComponent.businessSettingsPage().businessInformation().clickEditPhone();
			sideBarMenuComponent.businessSettingsPage().businessInformation()
					.fillCompanyPhoneNumber(data.get("phoneNumber"));
			sideBarMenuComponent.businessSettingsPage().businessInformation().clickOutsideElement();
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
	public void testBusinessSettingsWallets(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickWalletSettings();
			sideBarMenuComponent.businessSettingsPage().walletsPage().verifyWalletsHeading(data.get("walletsHeading"));
			Thread.sleep(3000);
			sideBarMenuComponent.businessSettingsPage().walletsPage().clickFirstRow();
			sideBarMenuComponent.businessSettingsPage().walletsPage().viewWalletDetails();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Business Information  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingCancelWallet(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickWalletSettings();
			sideBarMenuComponent.businessSettingsPage().walletsPage().clickFirstRow();
			sideBarMenuComponent.businessSettingsPage().walletsPage().clickCancel();
			sideBarMenuComponent.businessSettingsPage().walletsPage().cancelWalletPopup()
					.verifyCancelHeading(data.get("cancelHeading"));
			sideBarMenuComponent.businessSettingsPage().walletsPage().cancelWalletPopup().verifyDescrption();
			sideBarMenuComponent.businessSettingsPage().walletsPage().cancelWalletPopup().clickCancel();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Business Settings cancel wallet  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingAddNewWallet(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickWalletSettings();
			sideBarMenuComponent.businessSettingsPage().walletsPage().clickNewWallet();
			sideBarMenuComponent.businessSettingsPage().walletsPage().newWalletPopup()
					.verifyNewWalletHeading(data.get("walletHeading"));
			sideBarMenuComponent.businessSettingsPage().walletsPage().newWalletPopup()
					.fillWalletName(data.get("walletName"));
			sideBarMenuComponent.businessSettingsPage().walletsPage().newWalletPopup().clickAdd();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Business settings Add new Wallet  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessSettingEditWallet(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.businessSettingsPage().clickWalletSettings();
			sideBarMenuComponent.businessSettingsPage().walletsPage().clickFirstRow();
			sideBarMenuComponent.businessSettingsPage().walletsPage().clickWalletEdit();
			sideBarMenuComponent.businessSettingsPage().walletsPage().walletname(data.get("walletNewName"));
			sideBarMenuComponent.businessSettingsPage().walletsPage().save();

		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("test Business settings Add new Wallet  Failed due to Exception " + e);
		}
	}
}
