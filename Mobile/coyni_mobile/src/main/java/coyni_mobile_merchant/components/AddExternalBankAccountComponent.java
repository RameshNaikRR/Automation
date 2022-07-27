package coyni_mobile_merchant.components;

import java.time.Duration;

import org.openqa.selenium.By;


import coyni_mobile.components.AddAccountsComponent;
import coyni_mobile.pages.AllDonePage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AddExternalBankAccountComponent extends MobileFunctions {
	private By heading = MobileBy.xpath("//*[@text='Add External Bank Account']");
	private By btnBankNext = MobileBy.xpath("//*[contains(@resource-id,'cvNext')]");
	private By lnkLearnMore = MobileBy.xpath("//*[contains(@resource-id,'tvLearnMore')]");
	private By txtBankName = MobileBy.xpath("//*[contains(@resource-id,'searchbar')]");
	private By btnBank = MobileBy.xpath("//*[contains(@resource-id,'ul-div-id-11')]");
	private By txtUserName = MobileBy.xpath("//*[contains(@resource-id,'acctForm:j_idt145:0:login_')]");
	private By txtPassword = MobileBy.xpath("//*[contains(@resource-id,'acctForm:j_idt149:0:password_')]");
	private By btnNext = MobileBy.xpath("//*[@text='Next']");
	private By chkbox = MobileBy.xpath("//*[contains(@resource-id,'acctForm:classifiList:1:accountCheckbox')]");

	public void verifyHeading(String expHeading) {
		if (getElementList(heading, "Heading").size() > 0) {
			new CommonFunctions().verifyLabelText(heading, "Heading", expHeading);

		}
		
	}
	public void clickLearnMore() {
		click(lnkLearnMore, "Learn More");
	}
	public void clickBankNext() {
		click(btnBankNext, "Next");
	}
	 public AddAccountsComponent addAccountsComponent() {
		   return new AddAccountsComponent();
    }
	 public void fillBankName(String bankName) {
//		 click(txtBankName, "Bank Name");
		 enterText(txtBankName, bankName,"Bank Name");
		 DriverFactory.getDriver().hideKeyboard();
		 
//		 new CommonFunctions().clickTab();
     }
	 public void ScrollToBank() {
	        while (getElementList(btnBank, "Bank").size() == 0) {
	            TouchAction touch = new TouchAction(DriverFactory.getDriver());
	            touch.press(PointOption.point(540, 1395)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
	                    .moveTo(PointOption.point(540, (int) (300))).release().perform();
	        }
	    }
	 public void selectBank() {
		 scrollDownToElement(btnBank, "Bank");
		 click(btnBank, "Bank");
	 }
	 public void clickBank() {
		 click(btnBank,"Bank");
	 }
	 public void fillUserName(String userName) {
		 enterText(txtUserName, userName,"User Name");
		 DriverFactory.getDriver().hideKeyboard();
	 }
	 public void fillPassword(String password) {
		 enterText(txtPassword, password,"Password");
	 }
	 public void clickNext() {
		 scrollDownToElement(btnNext, "Next");
		 click(btnNext, "Next");
	 }
	 public void clickCheckBox() {
			click(chkbox, "Check Box");
     }	
	 public AllDonePage allDonePage() {
		 return new AllDonePage();
	 }
	

}
