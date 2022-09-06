package coyni.checkout;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CheckOutPage extends BrowserFunctions {

	private By txtDomain = By.xpath("//input[@id='domain']");
	private By txtOrderId = By.xpath("//input[@id='order-id']");
	private By txtPublicKey = By.xpath("//input[@id='public-key']");
	private By txtSecretKey = By.xpath("//input[@id='secret-key']");
	private By clkSaveDetails = By.xpath("//button[text()='Save Details']");
	private By clkSaveClearDetails = By.xpath("//button[text()='Clear Details']");
	private By clkCheckOut = By.xpath("//button[text()='Checkout']");
	private By lblAmount = By.xpath("//h6[text()='Price: $']");

	private By lblCountItems = By.xpath("//span[contains(text(), 'Cart')]");

	private By lblTotalAmount = By.xpath("//span[contains(text(), 'Total Amount: ')]");

	private By clkCardOne = By.xpath("(//button[text()='Add To Cart'])[1]");
	private By clkCardTwo = By.xpath("(//button[text()='Add To Cart'])[2]");

	public By getCard(String index) {
		return By.xpath(String.format("(//button[text()='Add To Cart'])[%s]", index));
	}

	public void enterDomain(String text) {
		enterText(txtDomain, text, "Domain");
	}

	public void enterOrderId(String text) {
		enterText(txtOrderId, text, "Order ID");
	}

	public void enterPublicKey(String text) {
		enterText(txtPublicKey, text, "Public key");
	}

	public void enterSecretKey(String text) {
		enterText(txtSecretKey, text, "Secret Key");
	}

	public void clickSaveDetails() {
		click(clkSaveDetails, "Save Details");
	}

	public void clickClearDetails() {
		click(clkSaveClearDetails, "Clear Details");
	}

	public void clickCheckOut() {
		click(clkCheckOut, "CheckOut");
	}

	public void clickCardOne() {
		click(clkCardOne, "Card One");
	}

	public void clickCardTwo() {
		click(clkCardTwo, "Card One");
	}

	public String getItemCount() {
		String text = getText(lblCountItems, "");
		String replaceAll = text.replaceAll("[^0-9]", "");
		ExtentTestManager.setInfoMessageInReport("Total Item is : " + replaceAll);
		return replaceAll;
	}

	public String getTotalAmount() {
		String text = getText(lblTotalAmount, "");
		String replaceAll = text.replaceAll("[^0-9]", "");
		ExtentTestManager.setInfoMessageInReport("Total Amont is : " + replaceAll);
		return replaceAll;
	}

	public By getFirstCardAmount(String index) {
		return By.xpath(String.format("(//h6[text()='Price: $'])[%s]", index));
	}

	private By lblAmountFirst = By.xpath("(//h6[text()='Price: $'])[1]");
	private By lblAmountSecond = By.xpath("(//h6[text()='Price: $'])[2]");

	public int getTotalFirstCardAmount() {
		String text = getText(lblAmountFirst, "Amount ");
		int replaceAll =Integer.parseInt(text.replaceAll("[^0-9]", ""));
		ExtentTestManager.setInfoMessageInReport("First Card Amount is : " + replaceAll);
		return replaceAll;
	}

	public int getTotalSecondCardAmount() {
		String text = getText(lblAmountSecond, "Amount");
		int replaceAll = Integer.parseInt(text.replaceAll("[^0-9]", ""));
		ExtentTestManager.setInfoMessageInReport("Seccond Card Amount is : " + replaceAll);
		return replaceAll;

	}

	public int sumOfAmount() {
		int s = getTotalFirstCardAmount() + getTotalSecondCardAmount();
		return s;
	}

}
