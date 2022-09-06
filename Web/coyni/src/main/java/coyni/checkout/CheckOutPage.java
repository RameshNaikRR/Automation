package coyni.checkout;

import org.openqa.selenium.By;
import ilabs.WebFramework.BrowserFunctions;

public class CheckOutPage extends BrowserFunctions {

	private By txtDomain = By.xpath("//input[@id='domain']");
	private By txtOrderId = By.xpath("//input[@id='order-id']");
	private By txtPublicKey = By.xpath("//input[@id='public-key']");
	private By txtSecretKey = By.xpath("//input[@id='secret-key']");

	public void fillDomain(String domain) {
		enterText(txtDomain, domain, "Domain");
	}

	public void fillOrderID(String orderId) {
		enterText(txtOrderId, orderId, "Order ID");
	}

	public void fillPublicKey(String publicKey) {
		enterText(txtPublicKey, publicKey, "Public Key");
	}

	public void fillSecretKey(String secretKey) {
		enterText(txtSecretKey, secretKey, "Secret Key");
	}

}
