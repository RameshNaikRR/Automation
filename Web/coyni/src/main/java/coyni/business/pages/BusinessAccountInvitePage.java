package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BusinessAccountInvitePage extends BrowserFunctions {

	private By lblBusinessAccountHeading = By.xpath("");
	private By btnCreateNewAccount = By.xpath("");
	private By lblCreateNewAccountDes = By.xpath("");
	private By lblOR = By.xpath("");
	private By btnAddExistingAccount = By.xpath("");
	private By lblAddToExistingDes = By.xpath("");

	public void verifyBusinessAccountHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBusinessAccountHeading, "Heading is: ", expHeading);
	}

	public void clickCreateNewAccount(String backGround, String borderColor) {
		new CommonFunctions().verifyCursorAction(btnCreateNewAccount, "Create New Account");
		new CommonFunctions().verifyMouseHoverAction(btnCreateNewAccount, "Create New Account", backGround,
				borderColor);
		click(btnCreateNewAccount, "Create New Account");
	}

	public void verifyCreateAccountDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblCreateNewAccountDes, "Create Account Description is: ", expDes);
	}

	public void verifyOR(String expDes) {
		new CommonFunctions().verifyLabelText(lblOR, "OR Description is: ", expDes);
	}

	public void clickAddToExistingAccount(String backGround, String borderColor) {
		new CommonFunctions().verifyCursorAction(btnAddExistingAccount, "Add to Existing Account");
		new CommonFunctions().verifyMouseHoverAction(btnAddExistingAccount, "Add to Existing Account", backGround,
				borderColor);
		click(btnAddExistingAccount, "Add to Existing Account");
	}

	public void verifyExistingAccountDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblAddToExistingDes, "EXisting Account Description is: ", expDes);
	}
	
	public SignupPage signupPage() {
		return new SignupPage();
	}

}
