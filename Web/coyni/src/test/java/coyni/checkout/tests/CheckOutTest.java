package coyni.checkout.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.checkout.CheckOutPage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class CheckOutTest {

	CheckOutPage checkOutPage;

	@BeforeTest
	public void init() {

		checkOutPage = new CheckOutPage();
	}

	@Test
	@Parameters({ "strParams" })

	public void tesCheckOutTransaction(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			checkOutPage.enterDomain(data.get("domain"));
			checkOutPage.enterOrderId(data.get("orderId"));
			checkOutPage.enterPublicKey(data.get("publicKey"));
			checkOutPage.enterSecretKey(data.get("secretKey"));
			checkOutPage.clickSaveDetails();
			checkOutPage.clickCardOne();
			int totalFirstCardAmount = checkOutPage.getTotalFirstCardAmount();
			checkOutPage.clickCardTwo();
			int totalSecondCardAmount = checkOutPage.getTotalSecondCardAmount();
			int count = totalFirstCardAmount + totalSecondCardAmount;
			int sumOfAmount = checkOutPage.sumOfAmount();
			if (count == sumOfAmount) {
				ExtentTestManager.setInfoMessageInReport("Total Amount is : " + sumOfAmount);
				checkOutPage.clickCheckOut();

			} else {
				ExtentTestManager.setFailMessageInReport("Amount Is not matched");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(" test CheckOut transaction is failed due to Exception " + e);
		}

	}
}
