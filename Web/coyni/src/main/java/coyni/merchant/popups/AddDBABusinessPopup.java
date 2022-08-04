package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddDBABusinessPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Add New Business']");

	private By btnNewCompany = By.xpath("//p[text()='New Company']");

	private By btnNewMerchantDBA = By.xpath("//p[text()='New Merchant / DBA']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Add DBA Business", expHeading);
	}

	public void clickNewCompany() {
		click(btnNewCompany, "New Company");
	}

	public void clickNewMerchantDBA() {
		click(btnNewMerchantDBA, "New Merchant DBA");
	}

	public AddDBAUnderNewCompanyPopup addDBAUnderNewCompanyPopup() {
		return new AddDBAUnderNewCompanyPopup();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
