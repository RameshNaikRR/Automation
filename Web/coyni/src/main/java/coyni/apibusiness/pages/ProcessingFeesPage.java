package coyni.apibusiness.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ProcessingFeesPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//h4[text()='Processing Fees']");
	private By feeHeading = By.xpath("//div[@class='grid grid-cols-4 px-2 gap-10 ProcessingFee_topLabel__y8jhi']");
//	private By lblWithdraw = By.xpath("//p[text()='Withdraws']");
//	private By lblBankAccount = By.xpath("//div[text()='Bank Account']");
//	private By lblInstantPay = By.xpath("//div[text()='Instant Pay']");
//	private By lblSignet = By.xpath("//div[text()='Signet']");
//	private By lblGiftCard = By.xpath("//div[text()='Gift Card']");
//	private By lblFailedBankWithdraw = By.xpath("//div[text()='Failed Bank Withdraw']");
//	private By lblBuyTokens = By.xpath("//p[text()='Buy Token']");
	private By chckbox = By.xpath("//input[@type='checkbox']");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By txtYourFeesCharges = By.xpath("//div[@class='grid grid-cols-4 gap-10 mt-4']");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Processing Fee", Heading);
	}

	public void verifysubHeading() {
		new CommonFunctions().elementView(feeHeading, "Business Fee");

	}

	public void clickCheckBox() {
		click(chckbox,"check Box");
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next ");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is in disabled mode");
		}
	}

	public void verifyYourFeesCharges() {
		List<WebElement> rows = getElementsList(txtYourFeesCharges, "percentage");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}
}
