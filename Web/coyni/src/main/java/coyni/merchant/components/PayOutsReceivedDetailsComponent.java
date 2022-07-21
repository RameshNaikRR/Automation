package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.merchant.pages.ExportfilesPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PayOutsReceivedDetailsComponent extends BrowserFunctions {

	private By lblPayOutsReceived = By.xpath("//span[contains(text(),'Payouts Received')]");

	private By lblPayOutsReceivedDetails = By.xpath("//h1[(text()='Payouts Received Details')]");

	private By lblTranscationsCount = By.cssSelector("");

	public String getTokensSent() {
		return getText(lblPayOutsReceived, "PayOuts Received");
	}

	public String getTransactionsCount() {
		return getText(lblTranscationsCount, "Transactions Count");
	}

	public void verifyLabelTransactionDetails(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayOutsReceivedDetails, "PayOuts Received Details", expHeading);
	}

	public DaysMonthsDropDownComponent daysMonthsDropDownComponent() {
		return new DaysMonthsDropDownComponent();
	}

	public DatePickerComponent datePickerComponent() {
		return new DatePickerComponent();
	}

	public TransactionsListComponent transactionsListComponent() {
		return new TransactionsListComponent();
	}

	public ExportfilesPage exportfilesPage() {
		return new ExportfilesPage();
	}

}
