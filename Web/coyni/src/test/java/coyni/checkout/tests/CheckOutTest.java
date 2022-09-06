package coyni.checkout.tests;

import java.util.Map;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import coyni.checkout.CheckOutPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class CheckOutTest {

	CheckOutPage checkOutPage;

	@BeforeMethod
	public void init() {
		checkOutPage = new CheckOutPage();

	}

	@Test
	@Parameters({ "strParams" })
	public void testCheckOut(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			checkOutPage.fillDomain(data.get("domain"));
			checkOutPage.fillOrderID(data.get("orderId"));
			checkOutPage.fillPublicKey(data.get("publicKey"));
			checkOutPage.fillSecretKey(data.get("secretKey"));
			

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login test view failed due to exception " + e);
		}
	}

}
