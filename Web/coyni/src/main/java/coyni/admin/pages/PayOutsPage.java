package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PayOutsPage extends BrowserFunctions {

	private By lblHeading = By.xpath("");

	private By lblPayOutHistory = By.xpath("");

	private By txtSearch = By.xpath("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyPayOutHistory(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayOutHistory, "Pay Out History", expHeading);
	}

	public void fillSearch(String search) {
		enterText(txtSearch, "Search", search);
	}

}
