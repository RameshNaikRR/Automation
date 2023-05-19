package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.EntriesAndPaginationsComponent;
import coyni.admin.components.ExportComponent;
import coyni.admin.components.SideBarComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BankConfigurationPage extends BrowserFunctions {

	private By lblBankConfiguration = By.xpath("");
	private By txtSearch = By.xpath("");
	private By btnNewBank = By.xpath("");

	public void verifyBankConfiguration(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBankConfiguration, "Heading is: ", expHeading);
	}

	public void fillSearch(String search) {
		enterText(txtSearch, search, "Search");
	}

	public void clickNewBank() {
		click(btnNewBank, "New Bank");
	}

	public ExportComponent exportComponent() {
		return new ExportComponent();
	}

	public EntriesAndPaginationsComponent entriesAndPaginationsComponent() {
		return new EntriesAndPaginationsComponent();
	}

	public SideBarComponent sideBarComponent() {
		return new SideBarComponent();
	}
	public AddNewBankPage addNewBankPage() {
		return new AddNewBankPage();
	}

}