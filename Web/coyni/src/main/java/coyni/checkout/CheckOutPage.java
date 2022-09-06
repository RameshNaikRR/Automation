package coyni.checkout;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class CheckOutPage extends BrowserFunctions{
	
	private By txtDomain=By.xpath("//input[@id='domain']");
	private By txtOrderId=By.xpath("//input[@id='order-id']");
	private By txtPublicKey=By.xpath("//input[@id='public-key']");
	private By txtSecretKey=By.xpath("//input[@id='secret-key']");

}
