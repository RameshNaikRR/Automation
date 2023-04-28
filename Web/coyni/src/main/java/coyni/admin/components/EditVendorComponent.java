package coyni.admin.components;

import org.openqa.selenium.By;

public class EditVendorComponent extends AddVendorComponent {
	
	private By btnEditVendor=By.xpath("//button[text()='Edit Vendor']");
	
	public void clickEditVendor() {
		click(btnEditVendor, "EditVendor");
	}

}
