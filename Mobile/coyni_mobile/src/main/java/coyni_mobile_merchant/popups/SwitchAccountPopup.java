package coyni_mobile_merchant.popups;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class SwitchAccountPopup extends MobileFunctions{
	private By btnAddDBA = MobileBy.id("com.coyni.mapp:id/cvAction");
//	private By btnAddDBA = MobileBy.xpath("//*[contains(@resource-id,'addDbaText')]");
	private By lblDescription = MobileBy.id("com.coyni.mapp:id/tvMessage");
	private By lblCompanyName= MobileBy
			.id("com.coyni.mapp:id/tvCompany");
	private By lblTotalDBAs = MobileBy.id("com.coyni.mapp:id/tvDBACount");
	
	
	public void clickAddDBA() {
		click(btnAddDBA, "Add DBA");
	}

	public void verifyDescription(String expText) {
		new CommonFunctions().verifyLabelText(lblDescription, "Add DBA Description", expText);
	}

	public void verifyCompanyName() {
		new CommonFunctions().elementView(lblCompanyName, "Company Name");		
	}

	public void verifyTotalDBAs() {
		new CommonFunctions().elementView(lblTotalDBAs, "Total DBAs");
	}

//	private By btnNewDBA = MobileBy.xpath("//*[contains(@resource-id,'ll_new_dba')]");
//	private By btnNewCompany = MobileBy.xpath("//*[contains(@resource-id,'ll_new_company')]");
//	private By lnkSelectAccount = MobileBy.xpath("//*[contains(@resource-id,'title')]");
//	private By btnAddNewDBA = MobileBy.xpath("//*[contains(@text,'Add DBA')]");
//	private By btnViewMerchantTransactions = MobileBy.xpath("//*[contains(@resource-id,'tv_merchant_transactions')]");
//	private By btnSelectAccount = MobileBy.xpath("(//*[contains(@resource-id,'arrow')])[1]");
//	private By btnSelectAccount2 = MobileBy.xpath("(//*[contains(@resource-id,'arrow')])[2]");
//	private By btnChildAccount1 = MobileBy.xpath("(//*[contains(@resource-id,'ll_child_view')])[1]");
//	private By btnEnabledAcc = MobileBy.xpath("(//*[contains(@resource-id,'title')])[+ i +]");
}
