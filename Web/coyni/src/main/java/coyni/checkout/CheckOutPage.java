package coyni.checkout;

import java.math.BigInteger;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
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
	private By clkCardTwo = By.xpath("(//button[text()='Add To Cart'])[3]");

	public By getCard(String index) {
		return By.xpath(String.format("(//button[text()='Add To Cart'])[%s]", index));
	}

	public void fillOrderId(String orderID) {
		enterText(txtOrderId, orderID, "Order ID");
	}
	
	public void enterDomain(String text) {
		enterText(txtDomain, text, "Domain");
	}

	public void enterOrderId() {
		enterText(txtOrderId, genrearteRandomNumbers(), "Order ID");
	}
	public void enterOrderIdContent(String test) {
		enterText(txtOrderId, test, "Order ID");
	}
	
	
	public String genrearteRandomNumbers() {
		BigInteger maxLimit = new BigInteger("5000000000000");
		BigInteger minLimit = new BigInteger("25000000000");
		BigInteger bigInteger = maxLimit.subtract(minLimit);
		Random randNum = new Random();
		int len = maxLimit.bitLength();
		BigInteger res = new BigInteger(len, randNum);
		if (res.compareTo(minLimit) < 0)
	         res = res.add(minLimit);
		if (res.compareTo(bigInteger) >= 0)
	         res = res.mod(bigInteger).add(minLimit);
			/*
			 * BigInteger maxLimit1 = new BigInteger("5000000"); BigInteger minLimit1 = new
			 * BigInteger("25000"); BigInteger bigInteger1 = maxLimit1.subtract(minLimit1);
			 * Random randNum1 = new Random(); int len1 = maxLimit.bitLength(); BigInteger
			 * res1 = new BigInteger(len1, randNum1); if (res1.compareTo(minLimit1) < 0)
			 * res1 = res.add(minLimit1); if (res1.compareTo(bigInteger1) >= 0) res1 =
			 * res.mod(bigInteger1).add(minLimit);
			 */
		String d="SOT"+res;
		return d;
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
	private By lblAmountSecond = By.xpath("(//h6[text()='Price: $'])[4]");

	public int getTotalFirstCardAmount() {
		String text = getText(lblAmountFirst, "Amount ");
		int replaceAll = Integer.parseInt(text.replaceAll("[^0-9]", ""));
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
	
	public String percentageOfReserve(String reservePercentage) {
		int s = getTotalFirstCardAmount() + getTotalSecondCardAmount();
		ExtentTestManager.setPassMessageInReport("The Total cart amount is" + s);
		int k = Integer.parseInt(reservePercentage);
		ExtentTestManager.setPassMessageInReport("The given reserved percentage is " + k);
		int percentage = s/100 * k;
		ExtentTestManager.setPassMessageInReport("The Reserve percentage calaculation amount is " + percentage);
		String str = String.valueOf(percentage);
		return str;
	}

	public void switchToWindow() throws InterruptedException {
		new CommonFunctions().switchTodWindow();
		Thread.sleep(3000);
	}

	public ScanQRCodePayMerchantPage scanQRCodePayMerchantPage() {
		return new ScanQRCodePayMerchantPage();
	}

	public void verifyPopUp() {
	WebDriver driver = DriverFactory.getDriver();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		ExtentTestManager.setInfoMessageInReport(text + " text is present");
		alert.accept();
	}

}
