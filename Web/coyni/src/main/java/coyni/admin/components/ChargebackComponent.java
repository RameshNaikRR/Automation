package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ChargebackComponent extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[text()='Open New Chargeback']");
	private By btnChargeBack = By.cssSelector(".icon-refund-icon");
	private By txtCaseNumber = By.xpath("//input[@name='caseNumber']");
	private By btnReason = By.xpath("//div[text()='Select A Reason']/following-sibling::div");
	private By btnReasonTxt = By.xpath("//span[text()='10.1']");
	private By btnOpen = By.xpath("//button[text()='Open']");

	private By txtStartDate = By.xpath("(//span[text()='Select Date'])[1]");// span[text()='Select
																			// Date']/following-sibling::span
	private By txtEndDate = By.xpath(" (//span[text()='Select Date'])[2]/following-sibling::span");// span[text()='End
																			// Date']/following-sibling::span

	
	private By btnChargeBackLink = By.xpath("//p[contains(@class,'hover:underline text-cm3 cursor-pointer TransactionDetailBuyToken_caseNav__rSPGv')]");
	
	public int getChargeBackSize() {
		return getElementsList(btnChargeBackLink, "").size();
		
	}
	public void chargeBackLink() {
		click(btnChargeBackLink, "btnChargeBackLink");
		
	}
	
	public void clickStartDate() {
		click(txtStartDate, "Start Date");
	}

	public void clickEndDate() {
		click(txtEndDate, "End Date");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Open New Chargeback", expHeading);
	}

	public void clickChargeBack() {
		if (getElement(btnChargeBack, "chargeback").isEnabled()) {
			click(btnChargeBack, "Charge Back");
		} else {
			ExtentTestManager.setInfoMessageInReport("ChargeBack is disable");

		}
	}
	
	public int verifyElementChargeBackButton() {
		return getElementsList(btnChargeBack, "Button").size();
		
	}

	public void fillCaseNumber(String caseNumber) {
		enterText(txtCaseNumber, caseNumber, "CaseNumber");
	}

	public void clickReason() {
		click(btnReason, "Reason");
	}

	public void clickReasonText() {
		click(btnReasonTxt, "Reason");
	}

	public void clickOpen() {
		if (getElement(btnOpen, "open").isEnabled()) {
			click(btnOpen, "Open");
		} else {
			ExtentTestManager.setInfoMessageInReport("Open is disable");
		}
	}

	public DatePickerComponent datePickerComponent() {
		return new DatePickerComponent();
	}

	public CalenderComponent calenderComponent() {
		return new CalenderComponent();
	}
	public DisputesDetailsComponent disputesDetailsComponent() {
		return new DisputesDetailsComponent();
	}
}
