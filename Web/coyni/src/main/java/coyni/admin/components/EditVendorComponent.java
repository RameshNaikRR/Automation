package coyni.admin.components;

import org.openqa.selenium.By;

public class EditVendorComponent extends AddVendorComponent {

	private By btnEditVendor = By.xpath("//button[text()='Edit Vendor']");
	private By btnSave=By.xpath("//button[text()='Save']");
	
	public void clickSave() {
		click(btnSave, "Save Button");
	}

	public void clickEditVendor() {
		click(btnEditVendor, "EditVendor");
	}

	// Search Component

	private By lblVendorName = By.xpath("(//p[contains(@class,'text-xl font-bold break-all text-cgy8')])[1]");

	private By btnSearch = By.cssSelector(".form-input");
	private By btnSearchIcon = By.xpath("//button[contains(@class,'icon-search')]");

	public String getVendorName() {
		String text = getText(lblVendorName, "Vendor Name");
		return text;
	}

	public void fillSearchBox() {
		enterText(btnSearch, getVendorName(), "Vendor Name");
		click(btnSearchIcon, "Search Icon");
		click(lblVendorName, "Vendor Name");
	}
	
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

}
