package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SuccessFailureComponent extends BrowserFunctions {

	private By lblBankAddedSuccesful = By.xpath("//h1[contains(text(),'Bank Account Added')]");
	private By lblRemovedSuccesful = By.xpath("//h1[text()='Payment Method Removed Successfully']");
	private By btnClose = By.xpath("//button[text()='Close']");
	private By editHeading = By.xpath("//h1[text()='Payment Method Edited Successfully']");
	private By lblSignetAddedSuccessful1 = By.xpath("//h1[text()='Signet Account Added']");
	private By lblSignetAddedSuccessful2 = By.xpath("//h1[text()='Successfully']");

	public void verifyBankAddSuccesfulHeaading() {
		new CommonFunctions().elementView(lblBankAddedSuccesful, "Bank Added Succesful");
	}

	public void verifyPaymnetRemovedSuccessfulHeading(String expRemovedHeading) {
		new CommonFunctions().verifyLabelText(lblRemovedSuccesful, " Remove sucessful", expRemovedHeading);
	}

	public void verifyPaymentEditSuccess(String expEditHeading) {
		new CommonFunctions().verifyLabelText(editHeading, "Payment Method Edited Successfully", expEditHeading);
	}

	public void verifySignetSucessfulHeading(String expSignetHeading) {
		new CommonFunctions().verifyLabelText(lblSignetAddedSuccessful1, "Signet Account Added Successfully",
				expSignetHeading);
	}

	public void verifySignetSucessfulHeading2(String expSignetHeading) {
		new CommonFunctions().verifyLabelText(lblSignetAddedSuccessful2, "Signet Account Added Successfully",
				expSignetHeading);
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}