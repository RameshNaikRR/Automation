package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.AuthyComponent;
import coyni.apibusiness.components.SuccessFailureComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class OrderPreviewPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[text()='Order Preview']");
//private By txtAmount=By.className("BuyTokenModal_order_amount_size__bppdA font-bold ");
	private By lblBankName = By.xpath("//span[text()='CashEdge Test Bank (Agg) ...']");
	private By lblPurchaseAmount = By.xpath("//span[text()='Purchase Amount']/parent::div");
	private By lblProcessingFee = By.xpath("//span[text()='Processing Fee']/parent::div");
	private By lblTotal = By.xpath("//span[text()='Total']/parent::div");
	private By btnConfrim = By.xpath("//button[text()='Confirm']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "expHeading", expHeading);
	}

	public void verifyOrderPreviewForWithdraw() {
//new CommonFunctions().elementView(withDrawAmount, "Withdraw Amount");
		new CommonFunctions().elementView(lblProcessingFee, "ProcessingFee");
		new CommonFunctions().elementView(lblPurchaseAmount, "PurchaseAmount");
		new CommonFunctions().elementView(lblTotal, "Total");
		new CommonFunctions().elementView(lblBankName, "Bank Name");
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