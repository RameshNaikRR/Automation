package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SuccessFailureComponent extends BrowserFunctions {

	private By lblBankAddedSuccesful = By.xpath("//h1[contains(text(),'Bank Account Added')]");
	private By lblRemovedSuccesful = By.xpath("//h1[text()='Payment Method Removed Successfully']");
	private By btnClose = By.xpath("//button[text()='Close']");
	private By editHeading = By.xpath("//h1[text()='Payment Method Edited Successfully']");
	private By lblSignetAddedSuccessful1 = By.xpath("//h1[text()='Cogent Account Added']");
	private By lblSignetAddedSuccessful2 = By.xpath("//h1[text()='Successfully']");
	private By lblSignetDeleted = By.xpath("//h1[text()='Payment Method Removed Successfully']");
	private By lblSignetDeleted1 = By.xpath("//h1[text()='Removed Successfully']");
	private By failedHeading = By.xpath("");
	private By btnDone = By.xpath("//button[text()='Done']");
	private By lblReferenceID = By.xpath("//span[text()='Reference ID']");
	private By referenceIdCopied = By.xpath("(//button[@class='copy-image icon-copy fontColor'])[2]");

	public void clickReferenceID() {
		click(referenceIdCopied, "Copied to ClipBoard");
	}

	public void verifyBankAddSuccesfulHeading() {
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

	public void verifySignetDeleteHeading(String expSignetHeading) {
		new CommonFunctions().verifyLabelText(lblSignetDeleted,"Payment method removed Successfully", expSignetHeading);
	}

	public void verifySignetDeleteHeading2(String expSignetHeading) {
		new CommonFunctions().verifyLabelText(lblSignetDeleted1, "Payment method removed Successfully", expSignetHeading);
	}

	public void verifyFailedHeadingView(String expSignetHeading) {
		new CommonFunctions().verifyLabelText(failedHeading, "Failed", expSignetHeading);
	}

	public void verifyDone(String expSignetHeading) {
		new CommonFunctions().verifyLabelText(btnDone, "Done", expSignetHeading);
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void verifyReferenceID() {
		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}