package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class PayingAccountHolderNamePopup extends BrowserFunctions {
       private By lnkCopy = By.cssSelector("");
       private By lblProcessingFee = By.cssSelector("");
       private By btnConfirmPay = By.cssSelector("");
       
       public void clickOnCopyLink() {
    	   click(lnkCopy, "click copy");
       }
       
       public String getProcessingFee() {
    	 return  getText(lblProcessingFee,"Processing Fee");
       }
       public void clickOnConfirmPay() {
    	   click(btnConfirmPay, "click confirm pay");
       }
}
