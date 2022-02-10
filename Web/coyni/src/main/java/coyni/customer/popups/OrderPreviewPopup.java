package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.AuthyComponent;
import coyni.customer.components.NavigationComponent;
import coyni.customer.components.SuccessFailurePopupCardComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class OrderPreviewPopup extends BrowserFunctions {

	private By btnConfirm = By.xpath("//button[text()='Confirm']");
	private By lblEnteredMoney = By.xpath("//strong[contains(text(),'CYN')]");
	private By lblInstantPayHeading = By.xpath("//h1[text()='Withdraw via Instant Pay']");
	private By amount = By.xpath("//p[@class='BankInstantPayWithdrawModal_amount__3K9tq']");
	private By withDrawAmount = By.xpath("//span[text()='Withdraw Amount']");
	private By processingFee = By.xpath("(//div[@class='flex items-center justify-between py-1'])[2]");
	private By lblProcessinFee = By.xpath("//span[contains(text(),'Processing Fee')]");
	private By total = By.xpath("(//div[@class='flex items-center justify-between py-1'])[3]");
	private By heading = By.xpath("//h1[text()='Verify Your Identity']");
	private By lblOrderPreviewHeading = By.xpath("//h1[contains(text(),'Order Preview')]");
	private By lblPurchaseAmount = By.xpath("//span[contains(text(),'Purchase Amount')]");
	private By lblTotal = By.xpath("//span[contains(text(),'Total')]");
	private By lblBankName = By.xpath("//span[contains(text(),'Bank')]");
	private By btnBack = By.xpath("//button[@class='self-start']");
	private By btnClose = By.xpath("//button[@class='self-end']");

	public void clickConfirm() {
		click(btnConfirm, "Click Confirm");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Autentication Heading", expHeading);
	}

	public void verifyAuthy() {
		new CommonFunctions().verifyAutoFocus(heading, "Autentication Heading");
	}

	public void verifyOrderPreviewForWithdraw() {
		new CommonFunctions().elementView(withDrawAmount, "Withdraw Amount");
		new CommonFunctions().elementView(processingFee, "Processing Fee");
		new CommonFunctions().elementView(total, "Total");
	}

	public TransactionInProgessPopup transactionInProgessPopup() {
		return new TransactionInProgessPopup();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return new SuccessFailurePopupCardComponent();
	}
	public void orderPreviewBuyTokenWithBankView() {
		new CommonFunctions().elementView(lblEnteredMoney, "User Enter Amount");
		new CommonFunctions().elementView(lblPurchaseAmount, "Purchase Amount");
		new CommonFunctions().elementView(processingFee, "processing Fee");
		new CommonFunctions().elementView(lblTotal, "Total");
		new CommonFunctions().elementView(lblBankName, "Bank Name");
		new CommonFunctions().elementView(btnBack, "Back ");
		new CommonFunctions().elementView(btnClose, "Close");
		
	}
	public void verifyOrderViewHeading() {
		new CommonFunctions().elementView(lblOrderPreviewHeading, "Order Preview");
	}

}
