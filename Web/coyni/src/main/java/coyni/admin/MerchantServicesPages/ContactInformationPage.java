package coyni.admin.MerchantServicesPages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ContactInformationPage extends BrowserFunctions {

	private By lblContactInformation = By.xpath("");
	private By drpdwnBeneficialOwner1 = By.xpath("");

	public void verifyContactInformation(String expHeading) {
		new CommonFunctions().verifyLabelText(lblContactInformation, "Heading is: ", expHeading);
	}

	public void selectBeneficialOwner1(String beneficialOwner1) {
		selectDropdown(drpdwnBeneficialOwner1, beneficialOwner1, "Beneficial Owner 1");
	}

}
