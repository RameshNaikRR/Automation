package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;

import ilabs.WebFramework.BrowserFunctions;

public class ExportSelectedTransactions extends BrowserFunctions {

	private By lblHeading = By.xpath("//h3[text()='Export Selected Transactions']");

	private By lblSubHeading = By.xpath("//h3[text()='Columns']");

	private By drpDwn = By.cssSelector(".absolute.transform.rotate-90.top-3");

	private By btnExport = By.xpath("//button[text()='Export']");

	private By lblColumnDetails = By
			.xpath("//div[contains(@class,'FormField_options_wrap__piK2v')]//div[contains(text(),'%s')]");

	public void verifyHeading(String expHeading) {

		new CommonFunctions().verifyLabelText(lblHeading, "expHeading", expHeading);
	}

	public void verifySubHeading(String expSubHeading) {

		new CommonFunctions().verifyLabelText(lblSubHeading, "expSubHeading", expSubHeading);
	}

	public void verifyColumnDetails(String expColumnDetails) {

		new CommonFunctions().verifyLabelText(lblColumnDetails, "expColumnDetails", expColumnDetails);
	}

	public void clickDropDown(String dropDown) {
		click(drpDwn, "Drop Down");
		new CommonFunctions().selectCustomDropDown(dropDown, "dropDown");

	}

	public ColumnsSelectedTransactions columnsSelectedTransactions() {
		return new ColumnsSelectedTransactions();
	}

	public void clickExport() {
		click(btnExport, "export");
	}
}
