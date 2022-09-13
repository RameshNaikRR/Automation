package coyni.api.business.popups;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.apibusiness.components.AuthyComponent;
import coyni.apibusiness.components.SuccessFailureComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class OrderPreviewPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[text()='Order Preview']");
//private By txtAmount=By.className("BuyTokenModal_order_amount_size__bppdA font-bold ");
	private By lblBankName = By.xpath("//span[text()='CashEdge Test Bank (Agg) ...']");
	private By lblWithdrawBalance = By.xpath("//div[@class='flex flex-row justify-between']");

	private By btnConfrim = By.xpath("//button[text()='Confirm']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "expHeading", expHeading);
	}

	public void verifyOrderPreviewForWithdraw() {
		List<WebElement> rows = getElementsList(lblWithdrawBalance, "Order Preview");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}

	public void clickConfrim() {
		click(btnConfrim, "confrim");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}
}