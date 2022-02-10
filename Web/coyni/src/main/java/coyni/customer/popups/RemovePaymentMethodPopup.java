package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.NavigationComponent;
import coyni.customer.components.SuccessFailurePopupCardComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class RemovePaymentMethodPopup extends BrowserFunctions {
	
	private By lblmsg = By.xpath("//h1[text()='Payment Method Removed Successfully']");
	private By btnRemove = By.xpath("//button[text()='Remove']");
	private By withdrawCoyni = By.xpath("//button[text()='Withdraw Coyni']");
	private By heading = By.xpath("//h1[contains(text(),'Remove Payment Method')]");
	
	public void clickWithdrawCoyni() {
		click(withdrawCoyni, "Withdraw Coyni");
	}

	public void verifyRemovePaymentHeading() {
		new CommonFunctions().elementView(heading, "Remove Payment Method Heading");
	}
	
	public void clickOnRemove() {
		click(btnRemove, "click Remove");
	}

	public String getRemoveMessage() {
		return getText(lblmsg, "Succesfully Removed");
	}

	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return new SuccessFailurePopupCardComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
