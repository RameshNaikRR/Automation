package coyni.apibusiness.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class BeneficialOwnersPage extends BrowserFunctions {
	private By lblBeneficialOwners = By.xpath("(//span[text()='Beneficiary Owner(s)'])[2]");
	private By beneficialPartner = By.xpath("//div[@class='grid grid-cols-2 px-4 py-2']");
//	private By lblName = By.xpath("//div[@class='flex flex-row items-center BenificialOwnerAccordion_nameRow__RC1rU']");
//	private By lblDateOfBirth = By.xpath("");
	private By beneficialOwnerData = By.xpath("//div[contains(@class,'nameRow')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBeneficialOwners, "Beneficial Owner(s)", expHeading);
	}

	public void clickBeneficialOwner() {
		click(beneficialPartner, "Beneficial Owner");
	}

	public void viewBeneficialOwnerData() {
		List<WebElement> details = getElementsList(beneficialOwnerData, "beneficialOwnerData");
		for (WebElement data : details) {
			String replace = data.getText().replace("\n", ":");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");

		}
	}
}
