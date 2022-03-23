package coyni.apibusiness.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.apibusiness.pages.BankAccountPage;
import coyni.apibusiness.pages.RegistrationBeneficialOwnersPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class BusinessApplicationTest {
	SideBarMenuComponent sideBarMenuComponent;
	RegistrationBeneficialOwnersPage registrationBeneficialOwnersPage;
	BankAccountPage bankAccountPage;

	@BeforeTest
	public void init() {
		registrationBeneficialOwnersPage = new RegistrationBeneficialOwnersPage();
		bankAccountPage = new BankAccountPage();
		sideBarMenuComponent = new SideBarMenuComponent();
	}

	@Test
	public void testBeneficialsOwnersFlow() {
		try {
			Map<String, String> data = Runner.getKeywordParameters(null);
//			sideBarMenuComponent.clickBusinessApplicationArrow();
//			sideBarMenuComponent.clickContinueApplication();
	//	sideBarMenuComponent.businessSettingsMenuComponent().clickBeneficialOwners();
			
			

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Beneficial Owners flow failed due to Exception " + e);
		}

	}

}
