package coyni.apibusiness.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import coyni.apibusiness.components.BusinessSettingsSideBarMenuComponent;
import coyni.apibusiness.components.SideBarMenuComponent;
import ilabs.WebFramework.Runner;

public class BusinessSettingsTest {
	SideBarMenuComponent sideBarMenuComponent;
	BusinessSettingsSideBarMenuComponent businessSettingsSideBarMenuComponent;

	@BeforeTest
	public void init() {
		sideBarMenuComponent = new SideBarMenuComponent();
		businessSettingsSideBarMenuComponent = new BusinessSettingsSideBarMenuComponent();
	}

	@Test
	public void testBusinessSettingsSideBarView() {
	   Map<String, String> data = Runner.getKeywordParameters(null);
	   sideBarMenuComponent.clickBusinessSettings();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyHeading(data.get("heading"));
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyUserImageView();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAccountIdView();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().getAccountId(data.get("accountID"));
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyCompanyInformationView();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyDBAInformationView();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickDBAinformation();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyBeneficiaryOwnersView();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickBeneficiaryOwner();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyPaymentMethodsView();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickPaymentMethods();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyPreferencesView();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickPreferences();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAgreementsView();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickAgreements();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyFeesView();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickFees();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyAccountLimitsView();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickAccountLimits();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyTeamView();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickTeam();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyIpAddressesView();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickIpAddresses();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyApiKeyView();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickApiKey();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().verifyWebHooksView();
	   sideBarMenuComponent.businessSettingsSideBarMenuComponent().clickWebhooks();
	if(data.get("accountStatus").equalsIgnoreCase("Active")) {
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().getAccountStatus(data.get("accountStatus"));
	   }
	else if(data.get("accountStatus").equalsIgnoreCase("Scheduled")) {
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().getAccountStatus(data.get("accountStatus"));
	}
	else{
		sideBarMenuComponent.businessSettingsSideBarMenuComponent().getAccountStatus(data.get("accountStatus"));
	}
	   
	   
		
	}

}
